package butterfly;

import ui.BreadCrumbTrailUI;
import ui.IAudioUI;

/**
 *
 * @author natec
 */
public class BreadCrumbTrail implements IAudioController
{
    private BreadCrumbTrailUI ui;
    public BreadCrumbTrail()
    {
        
    }
    
    @Override
    public void setUI(IAudioUI ui)
    {
        this.ui = (BreadCrumbTrailUI) ui;
    }
}
