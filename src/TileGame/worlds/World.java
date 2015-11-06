/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.worlds;

import TileGame.tiles.Tile;
import TileGame.utils.Utils;

import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */

public class World {

    //map size
    private int width,height;
    //player start pos
    private int spawnX, spawnY;
    //map x y
    private int[][] mapTiles;

    /**
     * A world for the player to run around in
     * @param path to file with the data for the world.
     */
    public World(String path) {

        loadWorld(path);
    }

    /**
     * Load the world
     * @param path
     */
    private void loadWorld(String path) {

        String file = Utils.loadFileAsString(path);

        //create a array of the file to map
        String[] tokens = file.split("[,]|[\\r\\n]+");

        //first 2 values in world1.txt
        width = Utils.parseInt(tokens[0]);
        height= Utils.parseInt(tokens[1]);

        //second line
        this.spawnX = Utils.parseInt(tokens[2]);
        this.spawnY = Utils.parseInt(tokens[3]);

        mapTiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // +4 is because the first 4 values in tokens
                // are widht, heigh, spawnX,Y
                mapTiles[x][y] = Utils.parseInt(tokens[(x + y * width)+4]);
            }
        }



    }

    public void tick(){

    }

    public void render(Graphics g) {

        Tile t;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                t = getTile(x, y);
                t.render(g,x*Tile.TILE_WIDTH,y*Tile.TILE_HEIGHT);
            }
        }
    }

    private Tile getTile(int x, int y) {
        int tileId = mapTiles[x][y];
        Tile t =Tile.tiles[tileId];
        if (t == null) {
            System.out.println("Didnt find tile");
            return Tile.dirtTile;
        }
        return t;
    }


}
