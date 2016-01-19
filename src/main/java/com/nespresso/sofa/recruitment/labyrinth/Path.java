package com.nespresso.sofa.recruitment.labyrinth;

import java.util.LinkedList;
import java.util.List;

public class Path {

    private final List<Room> pathRooms;

    private final StringBuilder walkingFollower = new StringBuilder();

    public Path() {
        this.pathRooms = new LinkedList<>();
    }

    public void popIn(final Room room) {
        pathRooms.clear();
        pathRooms.add(room);
    }

    public void walkTo(final Room room) {
        pathRooms.add(room);
    }

    public boolean canReachDestination(final Room destination, List<Gate> gates) {
        for (Gate gate : gates) {
            final Room source = pathRooms.get(pathRooms.size() - 1);
            if (gate.canReach(source, destination)) {
                if (gate.isSensorType()) {
                    appendToWalkingFollower(destination, source);
                }
                return true;
            }
        }
        return false;
    }

    private void appendToWalkingFollower(final Room destination, final Room source) {
        if (!walkingFollower.toString().isEmpty())
            walkingFollower.append(";");
        walkingFollower.append(source.printRoom()).append(destination.printRoom());
    }

    public void closeLastDoor() {
        pathRooms.get(pathRooms.size() -1 ).closeDoor();
    }

    public String readSensors() {
        return walkingFollower.toString();
    }
}
