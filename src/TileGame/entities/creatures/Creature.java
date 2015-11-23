/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.entities.creatures;


import TileGame.Handler;
import TileGame.entities.Entity;
import TileGame.tiles.Tile;

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

    public Creature(Handler handler,float x, float y, int width, int height) {
        super(handler,x, y, width, height);
        //set starting health
        xMove =0;
        yMove =0;
    }

    /**
     * Move the creature
     */
    public void move() {
        moveX();
        moveY();

    }

    public void moveX() {
        if (xMove > 0) { //move right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            //if not solid
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                !collisionWithTile(tx, (int) (y + bounds.y+bounds.height) / Tile.TILE_HEIGHT)
                    ) {
                x += xMove;
            }
            else {
                x = tx*Tile.TILE_WIDTH - bounds.x - bounds.width -1 ;
            }


        } else if(xMove < 0){ //move left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            //if not solid
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                !collisionWithTile(tx, (int) (y + bounds.y+bounds.height) / Tile.TILE_HEIGHT)
                ) {
                x += xMove;
            }
            else {
                x = tx*Tile.TILE_WIDTH+Tile.TILE_WIDTH-bounds.x;
            }
        }

    }

    public void moveY() {

        if (yMove < 0) {
            int ty = (int) (y+yMove+bounds.y)/Tile.TILE_HEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                !collisionWithTile((int) (x + bounds.x+ bounds.width) / Tile.TILE_WIDTH, ty)
                    ) {
                y += yMove;
            }
            else {
                y = ty * Tile.TILE_HEIGHT+Tile.TILE_HEIGHT-bounds.y;
            }

        }
        else if (yMove > 0) {
            int ty = (int) (y+yMove+bounds.height + bounds.y)/Tile.TILE_HEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x+ bounds.width) / Tile.TILE_WIDTH, ty)
                    ) {
                y += yMove;
            }
            else {
                y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height -1;
            }
        }

    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x,y).isSolid();
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
