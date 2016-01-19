package com.nespresso.sofa.recruitment.labyrinth;

import com.nespresso.sofa.recruitment.labyrinth.exception.IllegalMoveException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Labyrinth {

    private final List<Gate> gates = new ArrayList<>();

    private final Map<String, Room> rooms = new HashMap<>();

    private final Path path = new Path();

    public Labyrinth(final String... roomsAndGates) {
        createRoomsAndGates(roomsAndGates);
    }

    private void createRoomsAndGates(final String... roomsAndGates) {
        for (final String roomsAndGate : roomsAndGates) {
            final String roomSourceId = String.valueOf(roomsAndGate.charAt(0));
            final String gateType = String.valueOf(roomsAndGate.charAt(1));
            final String roomDestinationId = String.valueOf(roomsAndGate.charAt(2));
            final Room source = createRoomIfNotExistOrReturnRef(roomSourceId);
            final Room destination = createRoomIfNotExistOrReturnRef(roomDestinationId);
            gates.add(Gate.builder().withGateType(gateType).withSource(source).withDestination(destination).build());
        }
    }

    private Room createRoomIfNotExistOrReturnRef(final String roomId) {
        if (!rooms.containsKey(roomId)) {
            final Room room = new Room(roomId);
            rooms.put(roomId, room);
            return room;
        }
        return rooms.get(roomId);
    }

    public void popIn(final String roomId) {
        path.popIn(rooms.get(roomId));
    }

    public void walkTo(final String roomId) {
        if (!rooms.containsKey(roomId))
            throw new IllegalMoveException("Room not found!");

        final Room destination = rooms.get(roomId);
        if (!path.canReachDestination(destination, gates))
            throw new IllegalMoveException("Can not reach the withDestination!");

        path.walkTo(rooms.get(roomId));
    }

    public void closeLastDoor() {
        path.closeLastDoor();
    }

    public String readSensors() {
        return path.readSensors();
    }
}
