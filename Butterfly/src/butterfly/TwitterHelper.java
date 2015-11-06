package butterfly;

import ui.IAudioUI;
import ui.TweetTemplate;
import ui.TwitterHelperUI;
/**
 *
 * @author natec
 */
public class TwitterHelper implements IAudioPlayerComponent, IAudioController
{    
    private AudioPlayer audioPlayer;
    private TweetTemplate tweetTemplate;
    private TwitterHelperUI ui;

    @Override
    public void setUI(IAudioUI ui) {
        this.ui = (TwitterHelperUI) ui;
    }
}
