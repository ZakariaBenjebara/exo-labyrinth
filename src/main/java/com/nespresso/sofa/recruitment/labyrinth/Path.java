package com.nespresso.sofa.recruitment.labyrinth;

import java.util.LinkedList;
import java.util.List;

public class Path {

    private final List<Room> pathRooms;

    private final StringBuilder walkerFollower = new StringBuilder();

    public Path() {
        this.pathRooms = new LinkedList<>();
    }

    public void popIn(Room room) {
        pathRooms.clear();
        pathRooms.add(room);
    }

    public void walkTo(Room room) {
        pathRooms.add(room);
    }

    public boolean canReachDestination(final Room destination, List<Gate> gates) {
        for (Gate gate : gates) {
            final Room source = pathRooms.get(pathRooms.size() - 1);
            if (gate.canReach(source, destination)) {
                if (gate.)
                return true;
            }
        }
        return false;
    }

    public void closeLastDoor() {
        pathRooms.get(pathRooms.size() -1 ).closeDoor();
    }
}
