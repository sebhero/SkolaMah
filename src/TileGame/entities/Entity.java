/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.entities;

import TileGame.Game;

import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */

/**
 * The entiy on screen like creatures and players
 */
public abstract class Entity {

    protected final Game game;
    //position
    protected float x,y;
    //size
    protected int width, height;

    public Entity(Game game, float x, float y, int width, int height) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Movement handling
     */
    public abstract void tick();

    /**
     * Draw the entity to the screen
     * @param g
     */
    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
