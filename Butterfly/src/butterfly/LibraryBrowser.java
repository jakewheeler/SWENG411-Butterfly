package butterfly;

import audio.ArtistSongList;
import audio.ISongList;
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
        TreeMap<String, ArtistSongList> map = this.player.getLibrary().getLibraryMap();
        DefaultTreeModel model = (DefaultTreeModel)this.ui.LibraryTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        root.setUserObject("Library");
        
        map.entrySet().stream().map((artist) -> {
            SongListNode node = new SongListNode(artist);
            artist.getValue().getAlbums().entrySet().stream().forEach((album) -> {
                SongListNode child = new SongListNode(album);
                node.add(child);
            });
            return node;
        }).forEach((node) -> {
            root.add(node);
        });
        model.reload(root);
    }

    @Override
    public void setUI(IAudioUI ui) {
        this.ui = (LibraryBrowserUI) ui;
    }
    
    public void displaySelection(int x, int y)
    {
        int row = this.ui.LibraryTree.getRowForLocation(x, y);
        TreePath path = this.ui.LibraryTree.getPathForLocation(x, y);
        if (row == 0)
        {
            this.player.displaySongs(this.player.getLibrary());
        }
        else if (row > 0)
        {
            SongListNode node = (SongListNode) path.getLastPathComponent();
            this.player.displaySongs(node.heldlist);
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
