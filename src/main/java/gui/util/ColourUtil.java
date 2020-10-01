package gui.util;

/**
 * This class provides some ordinary colours
 */

import java.awt.*;

public class ColourUtil {
    public static Color blueColor = Color.BLUE;
    public static Color grayColor = Color.GRAY;
    public static Color backgroundColor = Color.white;
    public static Color warningColor = Color.RED;

    public static Color getByPercentage(int per) {
        if (per > 100)
            per = 100;
        int r;
        int g;
        int b = 51;
        float rate = per / 100f;
        r = (int) ((255 - 51) * rate + 51);
        g = 255 - r + 51;
        Color color = new Color(r, g, b);
        return color;
    }
}
