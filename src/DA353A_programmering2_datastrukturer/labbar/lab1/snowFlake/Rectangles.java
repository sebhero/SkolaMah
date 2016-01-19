/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab1.snowFlake;
import java.awt.*;

public class Rectangles {
    private Color[] colors = {Color.yellow, Color.red, Color.cyan, Color.green, Color.magenta, Color.white, Color.orange};

    private void paintRectangles(PaintWindow frame, int level, int x, int y, int width, int height, int delay) {
        if (level > 0) {
            PaintWindow.pause(delay);
            int halfWidth = width / 2;
            int halfHeight = height / 2;
            frame.drawRect(x - halfWidth, y - halfHeight, width, height, colors[level-1], 2);
            paintRectangles(frame, level - 1, x - halfWidth, y - halfHeight, halfWidth, halfHeight, delay);
            paintRectangles(frame, level - 1, x - halfWidth, y + halfHeight, halfWidth, halfHeight, delay);
            paintRectangles(frame, level - 1, x + halfWidth, y + halfHeight, halfWidth, halfHeight, delay);
            paintRectangles(frame, level - 1, x + halfWidth, y - halfHeight, halfWidth, halfHeight, delay);
        }
    }

    public void paint(PaintWindow frame, int level, int delay) {
        int width = frame.getBackgroundWidth() / 2,
            height = frame.getBackgroundHeight() / 2,
            x = width,
            y = height;
        level = Math.min(Math.max(level, 0), 6);    
        paintRectangles(frame, level, x, y, width, height, delay);
    }

    public static void main(String[] args) {
        PaintWindow frame = new PaintWindow(400,400,Color.BLACK);
        Rectangles rekt = new Rectangles();
        rekt.paint(frame, 4, 500);
    }
}