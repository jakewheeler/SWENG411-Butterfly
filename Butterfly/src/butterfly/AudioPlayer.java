package butterfly;

import audio.SongList;
import ui.AudioPlayerUI;

/**
 *
 * @author natec
 */
public class AudioPlayer 
{
    private AudioPlayerUI ui;
    private AudioControl audiocontrol;
    private SearchHelper searchhelper;
    private SongBrowser songbrowser;
    
    public void initializeMain()
    {
        
    }
        
    public void setSearchHelper(SearchHelper helper)
    {
        this.searchhelper = helper;
    }
    
    public SongList search(String words)
    {
        return this.searchhelper.search(words);
    }
}
