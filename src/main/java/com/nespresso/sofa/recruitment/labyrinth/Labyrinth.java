package com.nespresso.sofa.recruitment.labyrinth;

import com.nespresso.sofa.recruitment.labyrinth.exception.IllegalMoveException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Labyrinth {

    private final List<Gate> gates;

    private final Map<String, Room> rooms;

    private final Path path = new Path();

    public Labyrinth(final String... roomsAndGates) {
        rooms = createRooms(roomsAndGates);
        gates = createGates(roomsAndGates);
    }

    private Map<String, Room> createRooms(final String... roomsAndGates) {
        final Map<String, Room> rooms = new HashMap<>();
        for (final String roomsAndGate : roomsAndGates) {
            final String roomSourceId = String.valueOf(roomsAndGate.charAt(0));
            final String roomDestinationId = String.valueOf(roomsAndGate.charAt(2));
            final Room roomSource = new Room(roomSourceId);
            final Room roomDestination = new Room(roomDestinationId);
            createRoom(rooms, roomSourceId, roomSource);
            createRoom(rooms, roomDestinationId, roomDestination);
        }
        return rooms;
    }

    private void createRoom(Map<String, Room> rooms, String roomSourceId, Room roomSource) {
        if (!rooms.containsKey(roomSourceId))
            rooms.put(roomSourceId, roomSource);
    }

    private List<Gate> createGates(String[] roomsAndGates) {
        final List<Gate> gates = new ArrayList<>();
        for (final String roomsAndGate : roomsAndGates) {
            final String roomSourceId = String.valueOf(roomsAndGate.charAt(0));
            final String roomDestinationId = String.valueOf(roomsAndGate.charAt(2));
            final Gate.GateType gateGateType = Gate.GateType.representationFromString(String.valueOf(roomsAndGate.charAt(1)));
            final Room roomSource = rooms.get(roomSourceId);
            final Room roomDestination = rooms.get(roomDestinationId);
            gates.add(createGate(gateGateType, roomSource, roomDestination));
        }
        return gates;
    }

    public void popIn(final String roomId) {
        path.popIn(rooms.get(roomId));
    }

    public void walkTo(final String roomId) {
        if (!rooms.containsKey(roomId))
            throw new IllegalMoveException("Room not found!");

        final Room destination = rooms.get(roomId);
        if (!path.canReachDestination(destination, gates))
            throw new IllegalMoveException("Can not reach the destination!");

        path.walkTo(rooms.get(roomId));
    }

    public void closeLastDoor() {
        path.closeLastDoor();
    }

    public String readSensors() {
        return path.readSensors();
    }

    private Gate createGate(final Gate.GateType gateType, Room roomSource, final Room roomDestination) {
        return new Gate(gateType, roomSource, roomDestination);
    }

}
