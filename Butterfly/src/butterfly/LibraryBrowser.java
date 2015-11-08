package butterfly;

import audio.ArtistSongList;
import audio.ISongList;
import audio.PlayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
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
    
    public LibraryBrowser(AudioPlayer player)
    {
        this.player = player;
    }
    
    public void update()
    {
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
    
    private class SongListNode extends DefaultMutableTreeNode
    {
        ISongList heldlist;

        private SongListNode(Map.Entry data) {
            super(data.getKey());
            this.heldlist = (ISongList) data.getValue();
        }
    }
}
