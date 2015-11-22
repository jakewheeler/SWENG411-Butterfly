package tools;

import audio.Album;
import audio.ArtistSongList;
import audio.ISongList;
import audio.PlayList;
import audio.Song;
import butterfly.AudioPlayer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author natec
 */
public class RightClickMenu extends JPopupMenu
{
    private static RightClickMenu menu;
    private final AudioPlayer player;
    private final HashMap<String, String> map = new HashMap<>();
    
    private final int delay = 350;
    
    public static RightClickMenu getInstance(AudioPlayer player, ISongList list)
    {
        if (menu != null) return null;
        
        switch (list.getClass().getSimpleName())
        {
            case "ArtistSongList":
                menu = new RightClickMenu(player, (ArtistSongList) list);
                break;
            case "Album":
                menu = new RightClickMenu(player, (Album) list);
                break;
            case "PlayList":
                menu = new RightClickMenu(player, (PlayList) list);
                break;
        }
        return menu;
    }
    
    public static RightClickMenu getInstance(AudioPlayer player, Song song)
    {
        if (menu != null) return null;
        
        menu = new RightClickMenu(player, song);
        return menu;
    }
    
    private RightClickMenu(AudioPlayer player, Song song)
    {
        this.player = player;
        this.setBackground(ColorSelections.getUIBackgroundColor());
        init(song);
        setMouseEvents();
    }
    
    private RightClickMenu(AudioPlayer player, ArtistSongList artist)
    {
        this.player = player;
        init(artist);
        setMouseEvents();
    }
    
    private RightClickMenu(AudioPlayer player, Album album)
    {
        this.player = player;
        init(album);
        setMouseEvents();
    }
    
    private RightClickMenu(AudioPlayer player, PlayList playlist)
    {
        this.player = player;
        init(playlist);
        setMouseEvents();
    }
    
    private void init(ArtistSongList artist)
    {
        map.put("Add Songs To Queue", "addSongListToQueue");
        map.put("Remove Artist From Library", "removeSongListFromLibrary");
        map.put("Edit Artist Info", "editArtistInfo");
        map.put("Add Songs To Playlist", "addSonglistToPlaylist");
        
        map.entrySet().forEach(key -> {
            JMenuItem item = this.getItem(key.getKey(), artist);
            this.add(item);
        });
    }
    
    private void init(Album album)
    {
        map.put("Add Album To Queue", "addSongListToQueue");
        map.put("Remove Album From Library", "removeSongListFromLibrary");
        map.put("Edit Album Info", "editAlbumInfo");
        map.put("Add Album To Playlist", "addSonglistToPlaylist");
        
        map.entrySet().forEach(key -> {
            JMenuItem item = this.getItem(key.getKey(), album);
            this.add(item);
        });
    }      
    
    private void init(PlayList list)
    {
        map.put("Add Playlist To Queue", "addSongListToQueue");
        map.put("Remove Playlist From Library", "removePlaylistFromLibrary");
        map.put("Edit Playlist Info", "editPlaylistInfo");
        
        map.entrySet().forEach(key -> {
            JMenuItem item = this.getItem(key.getKey(), list);
            this.add(item);
        });
    }
    
    private void init(Song song)
    {                
        if (this.player.getCurrentQueue().getList().contains(song))
            map.put("Remove Song From Queue", "removeSongFromQueue");
        else
            map.put("Add Song To Queue", "addSongToQueue");
        map.put("Remove Song From Library", "removeSongFromLibrary");
        map.put("Edit Song Info", "editSongInfo");
        map.put("Add Song To Playlist", "addSongToPlayList");
        
        map.entrySet().forEach(key -> {
            JMenuItem item = this.getItem(key.getKey(), song);
            this.add(item);
        });
    }
    
    private void setMouseEvents()
    {
        this.addMouseListener(new MouseListener() {

            Runnable run = () -> {
                Timer time = new Timer();
                try {
                    time.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            dispose();
                            time.cancel();
                        }
                    }, delay);
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    time.cancel();
                }
            };
            Thread t = new Thread(run);
            
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                t.interrupt();
                t = new Thread(run);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!contains(e.getPoint()) && !t.isAlive())
                    t.start();
            }
        });
    }
    
    private JMenuItem getItem(String text, Object object)
    {
        JMenuItem item = new JMenuItem(text);
        item.setBackground(ColorSelections.getTablePrimaryRowColor());
        item.setForeground(ColorSelections.getTableRowUnselectedFontColor());
        item.setOpaque(true);
        item.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) return;
                try {
                    String methodName = map.get(item.getActionCommand());
                    Method method;
                    if (object.getClass() == Song.class)
                        method = player.getClass().getMethod(methodName, Song.class);
                    else
                        method = player.getClass().getMethod(methodName, ISongList.class);
                    method.invoke(player, object);
                    dispose();
                } catch (Exception ex) {
                    AudioPlayer.HandleException(ex);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                item.setBackground(ColorSelections.getTableRowSelectedColor());
                item.setForeground(ColorSelections.getTableRowSelectedFontColor());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                item.setBackground(ColorSelections.getTablePrimaryRowColor());
                item.setForeground(ColorSelections.getTableRowUnselectedFontColor());
            }
        });
        item.setSize(this.getWidth()-10, item.getHeight());
        return item;
    }
    
    public void dispose()
    {
        this.setVisible(false);
        menu = null;
    }
}
