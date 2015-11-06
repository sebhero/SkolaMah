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
public class BoxTile extends Tile {

    public BoxTile(int id) {
        super(id, Assets.box);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
