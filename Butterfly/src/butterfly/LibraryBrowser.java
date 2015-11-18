package butterfly;

import audio.Album;
import audio.ArtistSongList;
import audio.ISongList;
import audio.PlayList;
import java.awt.Component;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import tools.ColorSelections;
import ui.IAudioUI;
import ui.LibraryBrowserUI;

/**
 *
 * @author natec
 */
public class LibraryBrowser implements IAudioController
{
    private final AudioPlayer player;
    private LibraryBrowserUI ui;
    private SongTreeCellRenderer renderer;
    
    public LibraryBrowser(AudioPlayer player)
    {
        this.player = player;
        this.renderer = new SongTreeCellRenderer();
    }
    
    public void update()
    {
        if (this.player.getLibrary() == null) return;
        
        TreeMap<String, ArtistSongList> map = this.player.getLibrary().getArtistMap();
        DefaultTreeModel model = (DefaultTreeModel)this.ui.LibraryTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        root.setUserObject("Library");
        DefaultMutableTreeNode artistnode = new DefaultMutableTreeNode();
        artistnode.setUserObject("Artists");
        
        map.entrySet().stream().map((artist) -> {
            SongListNode node = new SongListNode(artist);
            artist.getValue().getAlbums().entrySet().stream().forEach((album) -> {
                SongListNode child = new SongListNode(album);
                node.add(child);
            });
            return node;
        }).forEach((node) -> {
            artistnode.add(node);
        });        
        root.add(artistnode);
        
        TreeMap<String, PlayList> playlists = this.player.getLibrary().getPlayListMap();
        DefaultMutableTreeNode playlistnode = new DefaultMutableTreeNode();
        playlistnode.setUserObject("Playlists");
        
        playlists.entrySet().stream().forEach((playlist) -> {
            SongListNode node = new SongListNode(playlist);
            playlistnode.add(node);
        });
        root.add(playlistnode);
        
        model.reload(root);
    }

    @Override
    public void setUI(IAudioUI ui) {
        this.ui = (LibraryBrowserUI) ui;
        this.ui.LibraryTree.setCellRenderer(this.renderer);
    }
    
    public void displaySelection(int x, int y)
    {
        int row = this.ui.LibraryTree.getRowForLocation(x, y);
        if (row > -1)
        {
            TreePath path = this.ui.LibraryTree.getPathForLocation(x, y);
            DefaultMutableTreeNode pickednode = (DefaultMutableTreeNode) path.getLastPathComponent();
            switch(pickednode.getUserObject().toString())
            {
                case "Library" : 
                    if (this.player.getLibrary() != null)
                        this.player.displaySongs(this.player.getLibrary());
                    break;
                case "Artists" : 
                    this.player.displaySongs(this.player.getLibrary());
                    break;
                case "Playlists" : 
                    this.player.displaySongs(this.player.getLibrary().getAllPlaylists());
                    break;
                default : 
                    SongListNode node = (SongListNode) path.getLastPathComponent();
                    this.player.displaySongs(node.heldlist);
                    break;                
            }
        }
    }
    
    public void rightClick(int x, int y)
    {
        int row = this.ui.LibraryTree.getRowForLocation(x, y);
        if (row > -1)
        {
            new Thread(() -> {
                TreePath path = this.ui.LibraryTree.getPathForLocation(x, y);
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                String object = node.getUserObject().toString();
                if (object.equals("Artists") || object.equals("Playlists") || object.equals("Library")) return;
                
                switch (node.getParent().toString()) {
                    case "Artists":
                        this.player.artistRightClicked(object, x, y);
                        break;
                    case "Playlists":
                        this.player.playlistRightClicked(object, x, y);
                        break;
                    default:
                        this.player.albumRightClicked(object, x, y);
                        break;
                }
            }).start();
        }
    }
    
    private class SongListNode extends DefaultMutableTreeNode
    {
        ISongList heldlist;

        private SongListNode(Map.Entry data) {
            super(data.getKey());
            this.heldlist = (ISongList) data.getValue();
        }
    }
    
    private class SongTreeCellRenderer extends DefaultTreeCellRenderer
    {
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
        {
            JLabel cell = (JLabel) super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
            cell.setForeground(ColorSelections.getLibraryBrowserNodeFontColor());
            ImageIcon icon;
            if (value.getClass() == SongListNode.class)
            {
                if (((SongListNode) value).heldlist.getClass() == ArtistSongList.class)
                {
                    icon = new ImageIcon(getClass().getResource("/resources/artist.png"));
                }
                else if (((SongListNode) value).heldlist.getClass() == Album.class)
                {
                    icon = new ImageIcon(getClass().getResource("/resources/album.png"));
                }
                else if (((SongListNode) value).heldlist.getClass() == PlayList.class)
                {
                    icon = new ImageIcon(getClass().getResource("/resources/playlist.png"));
                }
                else
                {
                    icon = new ImageIcon(getClass().getResource("/resources/music.png"));
                }
                cell.setIcon(icon);
            }
            else
            {
                icon = new ImageIcon(getClass().getResource("/resources/music.png"));
            }
            cell.setIcon(icon);
            return cell;
        }
    }
}
