package com.nespresso.sofa.recruitment.labyrinth;

/**
 * Created by user on 19/01/2016.
 */
public class Door {

    private enum State {
        CLOSED, OPENED
    }

    private State state = State.OPENED;

    public void close() {
        if (state == State.CLOSED)
            throw new DoorAlreadyClosedException("Door already closed!");
        state = State.CLOSED;
    }

    public boolean isColsed() {
        return state == State.CLOSED;
    }
}
