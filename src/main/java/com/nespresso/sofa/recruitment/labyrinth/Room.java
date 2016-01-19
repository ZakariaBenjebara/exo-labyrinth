package com.nespresso.sofa.recruitment.labyrinth;


public class Room {

    private final String id;

    private Door door = new Door();

    public Room(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return id != null ? id.equals(room.id) : room.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                '}';
    }

    public void closeDoor() {
        door.close();
    }
}
