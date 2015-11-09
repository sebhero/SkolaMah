/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.state;

import TileGame.Game;
import TileGame.entities.creatures.Player;
import TileGame.gfx.Assets;
import TileGame.tiles.Tile;
import TileGame.worlds.World;

import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */

/**
 * The game state
 */
public class GameState extends State{

    private Player player;
    private World world;

    public GameState(Game game) {
        super(game);

        //create player
        player = new Player(game,100, 100);
        world = new World(game,"/TileGame/res/world/world1.txt");


    }

    @Override
    public void tick() {
        world.tick();
        //move player
        player.tick();
        //move camera

    }

    @Override
    public void render(Graphics g) {
        world.render(g);

//        //draw board
//        Tile.tiles[0].render(g,0,0);
//        Tile.tiles[1].render(g,32,0);
//        Tile.tiles[2].render(g, 64, 0);
//        Tile.tiles[3].render(g, 0, 32);
        //draw player
        player.render(g);


    }
}
