/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */
public class KeyManager implements KeyListener {

    //keys that exists
    private boolean[] keys;

    //
    public boolean up,down,left,right;

    public KeyManager() {
        //all keys
        keys = new boolean[256];
    }

    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed! "+e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
