/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.gfx;

import TileGame.Game;
import TileGame.entities.Entity;

/**
 * Created by Sebastian Börebäck on 2015-11-08.
 */
public class GameCamera {

    private final Game game;
    private float yOffset;
    private float xOffset;

    public GameCamera(Game game, float xOffset, float yOffset) {
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnEntity(Entity entity) {
        xOffset = entity.getX() - game.getWidth() / 2 + entity.getWidth() / 2;
        yOffset = entity.getY() - game.getHeight() / 2 + entity.getHeight() / 2;
    }

    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
    }

    public float getyOffset() {
        return yOffset;
    }

    public float getxOffset() {
        return xOffset;
    }
}
