package org.hyperskill.cinemarest;

public class Statistics {

    private int currentIncome;
    private int numberOfAvailableSeats;
    private int numberOfPurchasedTickets;

    public Statistics() {
    }

    public void calculateStatistics(Room room) {
        currentIncome = 0;
        numberOfAvailableSeats = 81;
        numberOfPurchasedTickets = 0;

        for (Seat seat : room.getAvailableSeats()) {
            if (seat.isPurchased()) {
                currentIncome += seat.getPrice();
                numberOfPurchasedTickets++;
                numberOfAvailableSeats--;
            }
        }
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }
}
