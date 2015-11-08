package ui;

import audio.Song;
import butterfly.AudioPlayer;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author natec
 */
public class RightClickMenu extends JPopupMenu
{
    private final AudioPlayer player;
    
    private final HashMap<String, String> map = new HashMap<>();
    
    public RightClickMenu(AudioPlayer player, Song song)
    {
        this.player = player;
        
        
        if (this.player.getCurrentQueue().getList().contains(song))
            map.put("Remove From Queue", "removeSongFromQueue");
        else
            map.put("Add To Queue", "addSongToQueue");
        map.put("Remove From Library", "removeSongFromLibrary");
        map.put("Edit Info", "editSongInfo");
        
        map.entrySet().forEach(key -> {
            JMenuItem item = new JMenuItem(key.getKey());
            item.setOpaque(true);
            item.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    try {
                    String methodName = map.get(item.getActionCommand());
                    Method method = player.getClass().getMethod(methodName, Song.class);
                    method.invoke(player, song);
                    dispose();
                    } catch (Exception ex) {
                        Logger.getLogger(RightClickMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    item.setBackground(Color.lightGray);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    item.setBackground(getBackground());
                }
            });
            this.add(item);
        });
        
        this.addMouseListener(new MouseListener() {

            Runnable run = () -> {
                Timer time = new Timer();
                int delay = 350;
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
    
    public void dispose()
    {
        this.setVisible(false);
    }
}
