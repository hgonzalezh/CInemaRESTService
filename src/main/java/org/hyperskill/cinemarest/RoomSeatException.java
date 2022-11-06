package org.hyperskill.cinemarest;

public class RoomSeatException extends RuntimeException {

    private String error;

    public RoomSeatException() {
    }
    public RoomSeatException(String msg) {
        super(msg);
        this.error = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
