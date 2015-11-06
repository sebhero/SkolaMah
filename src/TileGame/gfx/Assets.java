/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */
public class Assets {

    private static final int width = 32, height = 32;
    public static BufferedImage player,dirt,box, flower,tree;
    public static BufferedImage bush;

    public static void init(){

        BufferedImage bfImage = ImageLoader.loadImage("/TileGame/res/textures/farm_tiles3c.png");
        SpriteSheet sheet = new SpriteSheet(bfImage);

        player = sheet.crop(0,0,width,height);
        box = sheet.crop(width, 0, width, height);
        flower = sheet.crop(width*2,0,width, height);
        dirt = sheet.crop(width*3, 0, width, height);
        bush = sheet.crop(width*4, 0, width, height);


    }

}
