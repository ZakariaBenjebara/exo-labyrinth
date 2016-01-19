package com.nespresso.sofa.recruitment.labyrinth;

import java.math.RoundingMode;

public class Gate {

    enum Representation {
        DEFAULT, SENSOR;

        public static Representation representationFromString(final String presentation) {
            if (presentation.equals("$")) {
                return SENSOR;
            } else {
                return DEFAULT;
            }
        }
    }

    private final Representation representation;

    private final Room source;

    private final Room destination;

    public Gate(Representation representation, Room source, Room destination) {
        this.representation = representation;
        this.source = source;
        this.destination = destination;
    }

    public boolean sourceEquals(final Room source) {
        return this.source.equals(source);
    }

    public boolean destinationEquals(final Room destination) {
        return this.destination.equals(destination);
    }

    public boolean canReach(final Room source, final Room destination) {
        return sourceEquals(source)
                ? destinationEquals(destination)
                : (sourceEquals(destination) ? destinationEquals(source) : false);
    }

    public void isClosedDoorFor(final Room room) {
        if (room.isDoorClosed()) {
            throw new ClosedDoorException("The source room is closed");
        }
    }

    @Override
    public String toString() {
        return "Gate{" +
                "representation=" + representation +
                ", source=" + source +
                ", destination=" + destination +
                '}';
    }
}
