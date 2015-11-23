/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.gfx;

import TileGame.Game;
import TileGame.Handler;
import TileGame.entities.Entity;
import TileGame.tiles.Tile;

/**
 * Created by Sebastian Börebäck on 2015-11-08.
 */
public class GameCamera {

    private final Handler handler;
    private float yOffset;
    private float xOffset;

    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnEntity(Entity entity) {
        xOffset = entity.getX() - handler.getWidth() / 2 + entity.getWidth() / 2;
        yOffset = entity.getY() - handler.getHeight() / 2 + entity.getHeight() / 2;
        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }

    public float getyOffset() {
        return yOffset;
    }

    public float getxOffset() {
        return xOffset;
    }

    public void checkBlankSpace() {

        if (xOffset < 0) {
            xOffset = 0;
        }
        else
            if (xOffset > handler.getWorld().getWidth()*Tile.TILE_WIDTH- handler.getWidth()) {
                xOffset = handler.getWorld().getWidth()*Tile.TILE_WIDTH- handler.getWidth();
        }

        if (yOffset < 0) {
            yOffset = 0;
        }
        else
        {
            int yWorldView =handler.getWorld().getHeight()*Tile.TILE_WIDTH - handler.getHeight();
            if (yOffset > yWorldView) {
                yOffset = yWorldView;
            }
        }

    }
}
