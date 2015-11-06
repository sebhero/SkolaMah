/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.tiles;

import TileGame.gfx.Assets;

import java.awt.image.BufferedImage;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */
public class FlowersTile extends Tile {

    public FlowersTile(int id) {
        super(id, Assets.flower);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}


