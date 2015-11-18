package tools;

import java.awt.Color;

/**
 *
 * @author natec
 */
public class ColorSelections 
{
    private static int compBGColor = 0x333333;
    private static int selecColor = 0x1ED760;
    private static int playColor = 0x216339;
    public static Color backGroundColor = Color.black;
    public static Color componentBackGroundColor = new Color (compBGColor);
    public static Color componentOffBackGroundColor = new Color(compBGColor + 0x202020);
    public static Color selectionColor = new Color(selecColor);
    public static Color playingColor = new Color(playColor);
}
