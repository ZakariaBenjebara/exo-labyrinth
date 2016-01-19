package com.nespresso.sofa.recruitment.labyrinth;

import java.util.LinkedList;
import java.util.List;

public class Path {

    private final List<Room> pathRooms;

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
                gate.isClosedDoorFor(source);
                return true;
            }
        }
        return false;
    }

    public void closeLastDoor() {
        pathRooms.get(pathRooms.size() -1 ).closeDoor();
    }
}
