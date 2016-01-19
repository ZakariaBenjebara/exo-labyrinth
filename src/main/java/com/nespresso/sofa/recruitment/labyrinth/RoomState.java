package com.nespresso.sofa.recruitment.labyrinth;

import com.nespresso.sofa.recruitment.labyrinth.exception.DoorAlreadyClosedException;

public class RoomState {

    private enum State {
        CLOSED, OPENED
    }

    private State state = State.OPENED;

    public void close() {
        if (state == State.CLOSED)
            throw new DoorAlreadyClosedException("The room is already closed!");
        state = State.CLOSED;
    }

    public boolean isClosed() {
        return state == State.CLOSED;
    }
}
