/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package A_Test;

        import javax.imageio.ImageIO;
        import java.awt.*;
        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;

/**
 * Omvandlar en bild med en char till en Matrix 7x7
 */
public class AsciiArt {

    public static void main(String[] args) {
        //bild som ar 7x7
        BufferedImage image = new BufferedImage(7, 7, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //font stil 11 ar storleken
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
        Graphics2D graphics = (Graphics2D) g;
//        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
//                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        //skapa bilden med bokstaven
        graphics.drawString("W", 0, 7);

        //rita ut bokstaven i ASCI
        for (int y = 0; y < 7; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < 7; x++)
                sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
            if (sb.toString().trim().isEmpty()) continue;
            System.out.println(sb);
        }
    }
}
