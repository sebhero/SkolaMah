/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p3;

public enum theChoice{
    STEN(0),SAX(1),POSE(2);

    private final int choiceId;

    theChoice(int number) {
         this.choiceId = number;
    }

    public int getChoiceId()
    {
        return this.choiceId;
    }


}
