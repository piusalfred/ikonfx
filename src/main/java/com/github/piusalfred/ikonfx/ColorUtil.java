package com.github.piusalfred.ikonfx;

import javafx.scene.paint.Color;

public class ColorUtil {

    public static String generateHexString(Color color){

        String greenValue = format(color.getGreen());
        String redValue = format(color.getRed());
        String blueValue = format(color.getBlue());
        return "#" + (redValue + greenValue + blueValue).toUpperCase();
    }

    public static String format(double value){
        String in = Integer.toHexString((int) Math.round(value*255));

        return in.length() == 1 ? "0" + in : in;
    }
}
