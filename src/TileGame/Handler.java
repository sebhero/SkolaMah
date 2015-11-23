/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame;

import TileGame.gfx.GameCamera;
import TileGame.input.KeyManager;
import TileGame.worlds.World;

/**
 * Created by Sebastian Börebäck on 2015-11-22.
 */
public class Handler {


    private final Game game;
    private World world;

    public Handler(Game game) {
        this.game = game;
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }



    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }


    public Game getGame() {
        return game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
