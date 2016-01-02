package com.vaadin.addon.charts.model.style;

import com.vaadin.addon.charts.model.AbstractConfigurationObject;

import java.util.Locale;

/**
 * Created by bpupadhyaya on 1/1/16.
 */
public class SolidColor extends AbstractConfigurationObject implements Color {
    public static final SolidColor ALICEBLUE = new SolidColor("#F0F8FF");
    public static final SolidColor ANTIQUEWHITE = new SolidColor("#FAEBD7");
    public static final SolidColor AQUA = new SolidColor("#00FFFF");
    public static final SolidColor AQUAMARINE = new SolidColor("#7FFFD4");
    public static final SolidColor AZURE = new SolidColor("#F0FFFF");
    public static final SolidColor BEIGE = new SolidColor("#F5F5DC");
    public static final SolidColor BISQUE = new SolidColor("#FFE4C4");
    public static final SolidColor BLACK = new SolidColor("#000000");
    public static final SolidColor BLANCHEDALMOND = new SolidColor("#FFEBCD");
    public static final SolidColor BLUE = new SolidColor("#0000FF");
    public static final SolidColor BLUEVIOLET = new SolidColor("#8A2BE2");
    public static final SolidColor BROWN = new SolidColor("#A52A2A");
    public static final SolidColor BURLYWOOD = new SolidColor("#DEB887");
    public static final SolidColor CADETBLUE = new SolidColor("#5F9EA0");
    public static final SolidColor CHARTREUSE = new SolidColor("#7FFF00");
    public static final SolidColor CHOCOLATE = new SolidColor("#D2691E");
    public static final SolidColor CORAL = new SolidColor("#FF7F50");
    public static final SolidColor CORNFLOWERBLUE = new SolidColor("#6495ED");
    public static final SolidColor CORNSILK = new SolidColor("#FFF8DC");
    public static final SolidColor CRIMSON = new SolidColor("#DC143C");
    public static final SolidColor CYAN = new SolidColor("#00FFFF");
    public static final SolidColor DARKBLUE = new SolidColor("#00008B");
    public static final SolidColor DARKCYAN = new SolidColor("#008B8B");
    public static final SolidColor DARKGOLDENROD = new SolidColor("#B8860B");
    public static final SolidColor DARKGRAY = new SolidColor("#A9A9A9");
    public static final SolidColor DARKGREY = new SolidColor("#A9A9A9");
    public static final SolidColor DARKGREEN = new SolidColor("#006400");
    public static final SolidColor DARKKHAKI = new SolidColor("#BDB76B");
    public static final SolidColor DARKMAGENTA = new SolidColor("#8B008B");
    public static final SolidColor DARKOLIVEGREEN = new SolidColor("#556B2F");
    public static final SolidColor DARKORANGE = new SolidColor("#FF8C00");
    public static final SolidColor DARKORCHID = new SolidColor("#9932CC");
    public static final SolidColor DARKRED = new SolidColor("#8B0000");
    public static final SolidColor DARKSALMON = new SolidColor("#E9967A");
    public static final SolidColor DARKSEAGREEN = new SolidColor("#8FBC8F");
    public static final SolidColor DARKSLATEBLUE = new SolidColor("#483D8B");
    public static final SolidColor DARKSLATEGRAY = new SolidColor("#2F4F4F");
    public static final SolidColor DARKSLATEGREY = new SolidColor("#2F4F4F");
    public static final SolidColor DARKTURQUOISE = new SolidColor("#00CED1");
    public static final SolidColor DARKVIOLET = new SolidColor("#9400D3");
    public static final SolidColor DEEPPINK = new SolidColor("#FF1493");
    public static final SolidColor DEEPSKYBLUE = new SolidColor("#00BFFF");
    public static final SolidColor DIMGRAY = new SolidColor("#696969");
    public static final SolidColor DIMGREY = new SolidColor("#696969");
    public static final SolidColor DODGERBLUE = new SolidColor("#1E90FF");
    public static final SolidColor FIREBRICK = new SolidColor("#B22222");
    public static final SolidColor FLORALWHITE = new SolidColor("#FFFAF0");
    public static final SolidColor FORESTGREEN = new SolidColor("#228B22");
    public static final SolidColor FUCHSIA = new SolidColor("#FF00FF");
    public static final SolidColor GAINSBORO = new SolidColor("#DCDCDC");
    public static final SolidColor GHOSTWHITE = new SolidColor("#F8F8FF");
    public static final SolidColor GOLD = new SolidColor("#FFD700");
    public static final SolidColor GOLDENROD = new SolidColor("#DAA520");
    public static final SolidColor GRAY = new SolidColor("#808080");
    public static final SolidColor GREY = new SolidColor("#808080");
    public static final SolidColor GREEN = new SolidColor("#008000");
    public static final SolidColor GREENYELLOW = new SolidColor("#ADFF2F");
    public static final SolidColor HONEYDEW = new SolidColor("#F0FFF0");
    public static final SolidColor HOTPINK = new SolidColor("#FF69B4");
    public static final SolidColor INDIANRED = new SolidColor("#CD5C5C");
    public static final SolidColor INDIGO = new SolidColor("#4B0082");
    public static final SolidColor IVORY = new SolidColor("#FFFFF0");
    public static final SolidColor KHAKI = new SolidColor("#F0E68C");
    public static final SolidColor LAVENDER = new SolidColor("#E6E6FA");
    public static final SolidColor LAVENDERBLUSH = new SolidColor("#FFF0F5");
    public static final SolidColor LAWNGREEN = new SolidColor("#7CFC00");
    public static final SolidColor LEMONCHIFFON = new SolidColor("#FFFACD");
    public static final SolidColor LIGHTBLUE = new SolidColor("#ADD8E6");
    public static final SolidColor LIGHTCORAL = new SolidColor("#F08080");
    public static final SolidColor LIGHTCYAN = new SolidColor("#E0FFFF");
    public static final SolidColor LIGHTGOLDENRODYELLOW = new SolidColor("#FAFAD2");
    public static final SolidColor LIGHTGRAY = new SolidColor("#D3D3D3");
    public static final SolidColor LIGHTGREY = new SolidColor("#D3D3D3");
    public static final SolidColor LIGHTGREEN = new SolidColor("#90EE90");
    public static final SolidColor LIGHTPINK = new SolidColor("#FFB6C1");
    public static final SolidColor LIGHTSALMON = new SolidColor("#FFA07A");
    public static final SolidColor LIGHTSEAGREEN = new SolidColor("#20B2AA");
    public static final SolidColor LIGHTSKYBLUE = new SolidColor("#87CEFA");
    public static final SolidColor LIGHTSLATEGRAY = new SolidColor("#778899");
    public static final SolidColor LIGHTSLATEGREY = new SolidColor("#778899");
    public static final SolidColor LIGHTSTEELBLUE = new SolidColor("#B0C4DE");
    public static final SolidColor LIGHTYELLOW = new SolidColor("#FFFFE0");
    public static final SolidColor LIME = new SolidColor("#00FF00");
    public static final SolidColor LIMEGREEN = new SolidColor("#32CD32");
    public static final SolidColor LINEN = new SolidColor("#FAF0E6");
    public static final SolidColor MAGENTA = new SolidColor("#FF00FF");
    public static final SolidColor MAROON = new SolidColor("#800000");
    public static final SolidColor MEDIUMAQUAMARINE = new SolidColor("#66CDAA");
    public static final SolidColor MEDIUMBLUE = new SolidColor("#0000CD");
    public static final SolidColor MEDIUMORCHID = new SolidColor("#BA55D3");
    public static final SolidColor MEDIUMPURPLE = new SolidColor("#9370DB");
    public static final SolidColor MEDIUMSEAGREEN = new SolidColor("#3CB371");
    public static final SolidColor MEDIUMSLATEBLUE = new SolidColor("#7B68EE");
    public static final SolidColor MEDIUMSPRINGGREEN = new SolidColor("#00FA9A");
    public static final SolidColor MEDIUMTURQUOISE = new SolidColor("#48D1CC");
    public static final SolidColor MEDIUMVIOLETRED = new SolidColor("#C71585");
    public static final SolidColor MIDNIGHTBLUE = new SolidColor("#191970");
    public static final SolidColor MINTCREAM = new SolidColor("#F5FFFA");
    public static final SolidColor MISTYROSE = new SolidColor("#FFE4E1");
    public static final SolidColor MOCCASIN = new SolidColor("#FFE4B5");
    public static final SolidColor NAVAJOWHITE = new SolidColor("#FFDEAD");
    public static final SolidColor NAVY = new SolidColor("#000080");
    public static final SolidColor OLDLACE = new SolidColor("#FDF5E6");
    public static final SolidColor OLIVE = new SolidColor("#808000");
    public static final SolidColor OLIVEDRAB = new SolidColor("#6B8E23");
    public static final SolidColor ORANGE = new SolidColor("#FFA500");
    public static final SolidColor ORANGERED = new SolidColor("#FF4500");
    public static final SolidColor ORCHID = new SolidColor("#DA70D6");
    public static final SolidColor PALEGOLDENROD = new SolidColor("#EEE8AA");
    public static final SolidColor PALEGREEN = new SolidColor("#98FB98");
    public static final SolidColor PALETURQUOISE = new SolidColor("#AFEEEE");
    public static final SolidColor PALEVIOLETRED = new SolidColor("#DB7093");
    public static final SolidColor PAPAYAWHIP = new SolidColor("#FFEFD5");
    public static final SolidColor PEACHPUFF = new SolidColor("#FFDAB9");
    public static final SolidColor PERU = new SolidColor("#CD853F");
    public static final SolidColor PINK = new SolidColor("#FFC0CB");
    public static final SolidColor PLUM = new SolidColor("#DDA0DD");
    public static final SolidColor POWDERBLUE = new SolidColor("#B0E0E6");
    public static final SolidColor PURPLE = new SolidColor("#800080");
    public static final SolidColor RED = new SolidColor("#FF0000");
    public static final SolidColor ROSYBROWN = new SolidColor("#BC8F8F");
    public static final SolidColor ROYALBLUE = new SolidColor("#4169E1");
    public static final SolidColor SADDLEBROWN = new SolidColor("#8B4513");
    public static final SolidColor SALMON = new SolidColor("#FA8072");
    public static final SolidColor SANDYBROWN = new SolidColor("#F4A460");
    public static final SolidColor SEAGREEN = new SolidColor("#2E8B57");
    public static final SolidColor SEASHELL = new SolidColor("#FFF5EE");
    public static final SolidColor SIENNA = new SolidColor("#A0522D");
    public static final SolidColor SILVER = new SolidColor("#C0C0C0");
    public static final SolidColor SKYBLUE = new SolidColor("#87CEEB");
    public static final SolidColor SLATEBLUE = new SolidColor("#6A5ACD");
    public static final SolidColor SLATEGRAY = new SolidColor("#708090");
    public static final SolidColor SLATEGREY = new SolidColor("#708090");
    public static final SolidColor SNOW = new SolidColor("#FFFAFA");
    public static final SolidColor SPRINGGREEN = new SolidColor("#00FF7F");
    public static final SolidColor STEELBLUE = new SolidColor("#4682B4");
    public static final SolidColor TAN = new SolidColor("#D2B48C");
    public static final SolidColor TEAL = new SolidColor("#008080");
    public static final SolidColor THISTLE = new SolidColor("#D8BFD8");
    public static final SolidColor TOMATO = new SolidColor("#FF6347");
    public static final SolidColor TURQUOISE = new SolidColor("#40E0D0");
    public static final SolidColor VIOLET = new SolidColor("#EE82EE");
    public static final SolidColor WHEAT = new SolidColor("#F5DEB3");
    public static final SolidColor WHITE = new SolidColor("#FFFFFF");
    public static final SolidColor WHITESMOKE = new SolidColor("#F5F5F5");
    public static final SolidColor YELLOW = new SolidColor("#FFFF00");
    public static final SolidColor YELLOWGREEN = new SolidColor("#9ACD32");
    private final String color;

    public SolidColor(String color) {
        this.color = color.replaceAll("[^0-9a-z,A-Z#]", "");
    }

    public SolidColor(int red, int green, int blue) {
        if(red >= 0 && red <= 255 && green >= 0 && green <= 255 && blue >= 0 && blue <= 255) {
            this.color = String.format(Locale.ENGLISH, "#%02X%02X%02X", new Object[]{Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue)});
        } else {
            throw new IllegalArgumentException("Invalid color values given.");
        }
    }

    public SolidColor(int red, int green, int blue, double opacity) {
        if(red >= 0 && red <= 255 && green >= 0 && green <= 255 && blue >= 0 && blue <= 255 && opacity >= 0.0D && opacity <= 1.0D) {
            this.color = String.format(Locale.ENGLISH, "rgba(%d,%d,%d,%.2f)", new Object[]{Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue), Double.valueOf(opacity)});
        } else {
            throw new IllegalArgumentException(String.format("Invalid color values given. Red: %s, green: %s blue: %s, opacity: %s", new Object[]{Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue), Double.valueOf(opacity)}));
        }
    }

    public String toString() {
        return this.color;
    }
}