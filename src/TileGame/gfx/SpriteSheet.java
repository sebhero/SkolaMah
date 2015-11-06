/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    /**
     * Create a spritesheet
     * @param sheet the image holding the tileset (spritesheet)
     */
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    /**
     * Crop out a sprite from image sheet
     * @param x x pos
     * @param y y pos
     * @param width width of sprite
     * @param height height of sprite
     * @return a sprite from image
     */
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}

