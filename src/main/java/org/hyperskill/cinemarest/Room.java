package org.hyperskill.cinemarest;

import java.util.ArrayList;
import java.util.UUID;

public class Room {

    private Integer totalRows;
    private Integer totalColumns;
    private ArrayList<Seat> availableSeats;

    public Room(Integer rows, Integer seats) {
        this.totalRows = rows;
        this.totalColumns = seats;
        this.availableSeats = createSeats(rows, seats);
    }

    private ArrayList<Seat> createSeats(Integer rows, Integer seats) {
        ArrayList<Seat> arrayList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                arrayList.add(new Seat(i + 1, j + 1));
            }

        }
        return arrayList;
    }

    public Seat refundSeatByUUID(String uuid) {
        for (Seat seat : availableSeats) {
            if (seat.getToken() == null) continue;
            if (uuid.equals(seat.getToken().toString())) {
                seat.setPurchased(false);
                seat.setToken(null);
                return seat;
            }
        }
        return null;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(Integer totalColumns) {
        this.totalColumns = totalColumns;
    }

    public ArrayList<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(ArrayList<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
