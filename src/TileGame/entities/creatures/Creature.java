/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.entities.creatures;

import TileGame.Game;
import TileGame.entities.Entity;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */

/**
 * Creatures or sprites
 */
public abstract class Creature extends Entity{

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 32;
    public static final int DEFAULT_CREATURE_HEIGHT = 32;

    protected int health = DEFAULT_HEALTH;
    protected float speed = DEFAULT_SPEED;
    protected float xMove, yMove;

    public Creature(Game game,float x, float y, int width, int height) {
        super(game,x, y, width, height);
        //set starting health
        xMove =0;
        yMove =0;
    }

    /**
     * Move the creature
     */
    public void move() {
        x += xMove;
        y += yMove;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
