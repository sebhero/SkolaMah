/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package TileGame.state;

import TileGame.Game;

import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-11-06.
 */

/**
 * The state, menu, config or game m.m.
 */
public abstract class State {

    //TODO move maybe to own class
    private static State currentState = null;

    public static State getState() {
        return currentState;
    }

    public static void setState(State currentState) {
        State.currentState = currentState;
    }
    //TODO move maybe to own class end

    //CLASS

    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void tick();

    //TODO Only for Swing
    public abstract void render(Graphics graphics);

}
