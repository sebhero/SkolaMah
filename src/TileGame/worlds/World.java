/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.worlds;

import TileGame.Game;
import TileGame.tiles.Tile;
import TileGame.utils.Utils;

import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */

public class World {

    private final Game game;
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
    public World(Game game, String path) {

        this.game = game;
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
        //saves the offset
        float xOffset = game.getGameCamera().getxOffset();
        float yOffset = game.getGameCamera().getyOffset();

        //only show tiles in camera
        int xStart = (int) Math.max(0,xOffset / Tile.TILE_WIDTH);
        int yStart = (int) Math.max(0, yOffset / Tile.TILE_HEIGHT);
        int xEnd = (int) Math.min(width, ((xOffset+game.getWidth())/ Tile.TILE_WIDTH+1));
        int yEnd = (int) Math.min(height, ((yOffset+game.getHeight())/ Tile.TILE_HEIGHT+1));



        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                t = getTile(x, y);
                t.render(g,
                        (int)(x*Tile.TILE_WIDTH - xOffset),
                        (int)(y*Tile.TILE_HEIGHT - yOffset)
                );
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
