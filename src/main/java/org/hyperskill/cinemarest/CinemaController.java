package org.hyperskill.cinemarest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaController {

    private final Room room = new Room(9,9);
    private Statistics statistics = new Statistics();

    @GetMapping("/seats")
    public Room getRoom(){
        return room;
    }

    @PostMapping("/purchase")
    public Ticket postSeat(@RequestBody Seat seat) {
        int index = room.getAvailableSeats().indexOf(seat);
        if (index != -1) {
            Seat roomSeat = room.getAvailableSeats().get(index);
            if (roomSeat.isPurchased() == false) {
                roomSeat.setPurchased(true);
                Ticket ticket =  new Ticket(roomSeat);
                roomSeat.setToken(ticket.getToken());
                return ticket;
            } else throw new RoomSeatException("The ticket has been already purchased!");
        } else throw new RoomSeatException("The number of a row or a column is out of bounds!");
    }

    @PostMapping("/return")
    public ReturnedTicket refundTicket(@RequestBody Ticket ticket) {
        if (ticket == null || ticket.getToken() == null) throw new RoomSeatException("Wrong token!");
        Seat seat = room.refundSeatByUUID(ticket.getToken().toString());
        if (seat == null) throw new RoomSeatException("Wrong token!");

        return new ReturnedTicket(seat);
    }

    @PostMapping("/stats")
    public Statistics getStatistics(@RequestParam(required = false) String password) {
        if (!"super_secret".equals(password)) throw new AuthorizationException("The password is wrong!");
        statistics.calculateStatistics(room);
        return statistics;
    }

    @ExceptionHandler(RoomSeatException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleRoomSeatException(RoomSeatException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getError());
        return exceptionResponse;
    }

    @ExceptionHandler(AuthorizationException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ExceptionResponse handleAuthorizationException(AuthorizationException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getError());
        return exceptionResponse;
    }
}
