package butterfly;

import ui.FileMenuUI;
import ui.IAudioUI;

/**
 *
 * @author natec
 */
public class FileMenu implements IAudioController
{
    private FileMenuUI ui;
    
    public FileMenu()
    {
        
    }
    
    @Override
    public void setUI(IAudioUI ui)
    {
        this.ui = (FileMenuUI) ui;
    }
}
