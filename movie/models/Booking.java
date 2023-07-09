package interview.practise.lld.movie.models;

import interview.practise.lld.movie.enums.BookingStatus;

import java.util.Date;
import java.util.List;

public class Booking {
    private String bookingNumber;
    private int numberOfSeats;
    private Date createdOn;
    private BookingStatus status;

    private Show show;
    private List<ShowSeat> seats;
    private Payment payment;

}
