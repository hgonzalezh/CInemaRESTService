package org.hyperskill.cinemarest;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.UUID;

public class Seat {
    private Integer row;
    private Integer column;
    private Integer price;
    @JsonIgnore
    private boolean purchased;
    @JsonIgnore
    private UUID token;

    public Seat() {

    }

    public Seat(Integer row, Integer column) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
        this.purchased = false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Seat seat = (Seat) obj;
        return this.row == seat.row && this.column == seat.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.row, this.column);
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
