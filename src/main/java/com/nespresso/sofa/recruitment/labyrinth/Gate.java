package com.nespresso.sofa.recruitment.labyrinth;

import com.nespresso.sofa.recruitment.labyrinth.exception.ClosedDoorException;

public class Gate {

    private final GateType gateType;

    private final Room source;

    private final Room destination;

    public Gate(final Builder builder) {
        this.gateType = GateType.gateTypeFromString(builder.gateType);
        this.source = builder.source;
        this.destination = builder.destination;
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
            throw new ClosedDoorException("The withSource room is closed");
        }
        return true;
    }

    public boolean isSensorType() {
        return gateType == GateType.SENSOR;
    }

    public static Builder builder() {
        return new Builder();
    }
    private enum GateType {
        DEFAULT, SENSOR;

        static GateType gateTypeFromString(final String presentation) {
            if (presentation.equals("$")) {
                return SENSOR;
            } else {
                return DEFAULT;
            }
        }
    }

    public static class Builder {

        private String gateType;

        private Room source;

        private Room destination;

        public Builder() {
        }

        public Builder withGateType(String gateType) {
            this.gateType = gateType;
            return this;
        }

        public Builder withSource(Room source) {
            this.source = source;
            return this;
        }

        public Builder withDestination(Room destination) {
            this.destination = destination;
            return this;
        }

        public Gate build() {
            return new Gate(this);
        }
    }
}
