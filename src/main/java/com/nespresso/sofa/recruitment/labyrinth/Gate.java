package com.nespresso.sofa.recruitment.labyrinth;

public class Gate {

    enum GateType {
        DEFAULT, SENSOR;

        public static GateType representationFromString(final String presentation) {
            if (presentation.equals("$")) {
                return SENSOR;
            } else {
                return DEFAULT;
            }
        }
    }

    private final GateType gateType;

    private final Room source;

    private final Room destination;

    public Gate(GateType gateType, Room source, Room destination) {
        this.gateType = gateType;
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
                : (sourceEquals(destination) ? (destinationEquals(source) && isClosedDoorFor(source)) : false);
    }

    public boolean isClosedDoorFor(final Room room) {
        if (room.isDoorClosed()) {
            throw new ClosedDoorException("The source room is closed");
        }
        return true;
    }

    public boolean isSensorType() {
        return gateType == GateType.SENSOR;
    }


    @Override
    public String toString() {
        return "Gate{" +
                "gateType=" + gateType +
                ", source=" + source +
                ", destination=" + destination +
                '}';
    }
}
