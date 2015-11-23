/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame;

import TileGame.display.Display;
import TileGame.gfx.Assets;
import TileGame.gfx.GameCamera;
import TileGame.input.KeyManager;
import TileGame.state.GameState;
import TileGame.state.MenuState;
import TileGame.state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */
public class Game implements Runnable {

    private final String title;
    private Display display;
    private int width,height;
    private Thread thread;
    //is game running
    private boolean running=false;
    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;

    //Input
    private KeyManager keyManager;

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;

    public Game(String title,int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        //adds keymanager
        keyManager = new KeyManager();

    }

    @Override
    public void run() {
        //loads the graphixs
        init();

        //For setting update time FPS
        int fps = 60;
        double timePerTick = 1_000_000_000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        //for showing fps
        long timer = 0;
        int ticks = 0;

        //game loop
        while (running) {

            //current nanotime
            now = System.nanoTime();
            //when to call tick and render
            //so that it updates smoothly
            delta += (now - lastTime) / timePerTick;
            //Calc timer aka fps
            timer += now - lastTime;

            //update lastTime
            lastTime = now;

            //check if we need to update
            if (delta >= 1) {
                //tick the game movement
                tick();
                //redraw the game with updates
                render();
                //
                ticks++;
                //descresee deltas
                delta--;
            }

            //show FPS in console
            if (timer >= 1_000_000_000) {
                System.out.println("Tickes and Frames: "+ticks);
                ticks = 0;
                timer= 0;
            }
        }
    }

    private void tick() {

        //update check keypress
        keyManager.tick();

        //check if there is a state to print
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    /**
     * Render the game
     */
    private void render() {
        //buffer
        bs = display.getCanvas().getBufferStrategy();
        //if its first time running
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        //get the graphics drawer
        //for drawing things
        g= bs.getDrawGraphics();

        //Clear screen
        g.clearRect(0, 0, width, height);

        //Draw
        if (State.getState() != null) {
            State.getState().render(g);
        }



        //End Drawing
        bs.show();
        g.dispose();
        Toolkit.getDefaultToolkit().sync();

    }


    /**
     * Init game
     */
    private void init() {

        display = new Display(title,width,height);
        //connect the keymanager to the frame
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);

        //set The game state to the game
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(gameState);

    }


    /**
     * Gets the keymanager for player inputs
     */
    public KeyManager getKeyManager() {
        return keyManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    /**
     * Start the game thread
     */
    public synchronized void start() {

        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Stop the game thread
     */
    public synchronized void stop() {
        if (!running) {
            return;
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
