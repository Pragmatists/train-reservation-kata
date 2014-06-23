package pragmatists.ticketoffice.rest;

import java.util.List;

public class ReservationResponse {
    public final String trainId;
    public final String bookingReference;
    public final List<String> seats;

    public ReservationResponse(String trainId, String bookingReference, List<String> seats) {
        this.trainId = trainId;
        this.bookingReference = bookingReference;
        this.seats = seats;
    }
}
