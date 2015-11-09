/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.entities.creatures;

import TileGame.Game;
import TileGame.gfx.Assets;

import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */

/**
 * Player entity
 */
public class Player extends Creature
{


    public Player(Game game,float x, float y) {
        super(game, x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void tick() {

        //get input for the movement
        getInput();
        //move the player
        move();

        game.getGameCamera().centerOnEntity(this);

    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up){
            yMove = -speed;
        }
        if(game.getKeyManager().down){
            yMove = speed;
        }
        if(game.getKeyManager().left){
            xMove = -speed;
        }
        if(game.getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        //draws the player
        g.drawImage(Assets.player, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
    }
}
