package butterfly;

import ui.IAudioUI;

/**
 *
 * @author natec
 */
public class SongBrowser implements IAudioController
{
    private SongBrowser ui;
    public SongBrowser()
    {
        
    }
        
    @Override
    public void setUI(IAudioUI ui)
    {
        this.ui = (SongBrowser) ui;
    }
}
