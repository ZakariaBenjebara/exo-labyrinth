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
            if (gate.canReach(pathRooms.get(pathRooms.size() - 1), destination)) {
                return true;
            }
        }
        return false;
    }
}
