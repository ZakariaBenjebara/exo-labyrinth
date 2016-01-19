package com.nespresso.sofa.recruitment.labyrinth;

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

    @Override
    public String toString() {
        return "Gate{" +
                "representation=" + representation +
                ", source=" + source +
                ", destination=" + destination +
                '}';
    }
}
