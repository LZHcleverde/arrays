package com;

public class Room {

    String roomId;
    String type;
    boolean state;

    public Room() {
    }

    public Room(String roomId, String type, boolean state) {
        this.roomId = roomId;
        this.type = type;
        this.state = state;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", type='" + type + '\'' +
                ", state=" + state +
                '}';
    }
}
