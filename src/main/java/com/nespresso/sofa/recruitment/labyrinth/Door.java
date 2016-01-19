package com.nespresso.sofa.recruitment.labyrinth;

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
