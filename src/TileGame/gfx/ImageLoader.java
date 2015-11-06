/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.gfx;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */
public class ImageLoader {

    public static BufferedImage loadImage(String path)
    {

        try {
            URL imgPath = ImageLoader.class.getResource(path);
            return ImageIO.read(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }
}
