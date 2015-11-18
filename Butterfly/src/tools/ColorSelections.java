package tools;

import java.awt.Color;

/**
 *
 * @author natec
 */
public class ColorSelections 
{
    // Song Browser colors
    private final static Color tableBackgroundColor = new Color(51, 51, 51);
    private final static Color tablePrimaryRowColor = new Color(51, 51, 51);
    private final static Color tableSecondaryRowColor = new Color(71, 71, 71);
    private final static Color tableRowSelectedColor = new Color(0x1ED760);     // Spotify green
    private final static Color tableRowSongPlayingColor = new Color(0x216339);     // Slightly darker Spotify green
    
    private final static Color tableRowUnselectedFontColor = Color.white;
    private final static Color tableRowSelectedFontColor = Color.black;
    private final static Color tableRowSongPlayingFontColor = Color.white; // This font will also be bold
    
    // Library Browser colors
    private final static Color libraryBrowserBackgroundColor = new Color(51, 51, 51);
    private final static Color libraryBrowserNodeFontColor = Color.white;
    
    // Twitter Template colors
    private final static Color twitterTemplateWithinLimitLabelColor = Color.white;
    private final static Color twitterTemplateOutsideLimitLabelColor = Color.red;

    
    // Generic UI elements
    private final static Color UIBackgroundColor = Color.black;
    private final static Color UIButtonColor = new Color(51, 51, 51);
    private final static Color UIButtonFontColor = Color.white;
    private final static Color UILabelColor = Color.white;
    private final static Color UITextFieldColor = new Color(51, 51, 51);
    private final static Color UITextFieldFontColor = Color.white;
    
    // Song Browser getters
    public static Color getTableBackgroundColor()
    {
        return tableBackgroundColor;
    }
    
    public static Color getTablePrimaryRowColor()
    {
        return tablePrimaryRowColor;
    }
    
    public static Color getTableSeconaryRowColor()
    {
        return tableSecondaryRowColor;
    }
    
    public static Color getTableRowSelectedColor()
    {
        return tableRowSelectedColor;
    }
    
    public static Color getTableRowSongPlayingColor()
    {
        return tableRowSongPlayingColor;
    }
    
    public static Color getTableRowUnselectedFontColor()
    {
        return tableRowUnselectedFontColor;
    }
    
    public static Color getTableRowSelectedFontColor()
    {
        return tableRowSelectedFontColor;
    }
    
    public static Color getTableRowSongPlayingFontColor()
    {
        return tableRowSongPlayingFontColor;
    }
    
    
    // Library Browser getters
    public static Color getLibraryBrowserBackgroundColor()
    {
        return libraryBrowserBackgroundColor;
    }
    
    public static Color getLibraryBrowserNodeFontColor()
    {
        return libraryBrowserNodeFontColor;
    }
    
    
    // Twitter Template getters
    public static Color getTwitterTemplateWithinLimitLabelColor()
    {
        return twitterTemplateWithinLimitLabelColor;
    }
    
    public static Color getTwitterTemplateOutsideLimitLabelColor()
    {
        return twitterTemplateOutsideLimitLabelColor;
    }
    
    
    // Other UI element getters
    public static Color getUIBackgroundColor()
    {
        return UIBackgroundColor;
    }
    
    public static Color getUIButtonColor()
    {
        return UIButtonColor;
    }
    
    public static Color getUIButtonTextColor()
    {
        return UIButtonFontColor;
    }
    
    public static Color getUILabelColor()
    {
        return UILabelColor;
    }
    
    public static Color getUITextFieldColor()
    {
        return UITextFieldColor;
    }
    
    public static Color getUITextFieldFontColor()
    {
        return UITextFieldFontColor;
    }
}
