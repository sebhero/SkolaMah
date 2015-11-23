/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.entities.creatures;


import TileGame.Handler;
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


    public Player(Handler handler,float x, float y) {
        super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 6;
        bounds.y = 18;
        bounds.width = 16;
        bounds.height= 13;

    }

    @Override
    public void tick() {

        //get input for the movement
        getInput();
        //move the player
        move();

        handler.getGameCamera().centerOnEntity(this);

    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = -speed;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        //draws the player
        g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        g.setColor(Color.RED);
        int bx = (int) (x+bounds.x-handler.getGameCamera().getxOffset());
        int by = (int) (y+bounds.y-handler.getGameCamera().getyOffset());
        g.fillRect(bx,by,(int) bounds.getWidth(),(int) bounds.getHeight());
    }
}
