/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */
public class Tile {

    //Static stuff here

    //TODO change to ArrayList
//    public static ArrayList<Tile> tiles = new ArrayList<>();
    //All the tiles that are avaible to show on screen
    public static final Tile[] tiles = new Tile[256];
    public static final Tile dirtTile = new DirtTile(0);
    public static final Tile boxTile = new BoxTile(1);
    public static final Tile bushTile = new BushTile(2);
    public static final Tile flowerTile = new FlowersTile(3);


    //CLASS

    public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;

    protected BufferedImage texture;

    protected final int id;

    public Tile(int id, BufferedImage texture) {
        this.id = id;
        this.texture = texture;

        //TODO change to useing Arraylist
        tiles[id] = this;
    }

    public void tick() {

    }

    /**
     * Render the tile and set where in the canvas
     * @param graphics
     * @param x
     * @param y
     */
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT,null);
    }

    public int getId() {
        return id;
    }

    /**
     * If the tile is solid, cant walkthrough
     * @return
     */
    public boolean isSolid() {
        return false;
    }
}
