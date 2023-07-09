package interview.practise.lld.movie.models;

import java.util.List;

public class Customer extends Person{
    public boolean makeBooking(Booking booking) {
        return false;
    }

    public List<Booking> getBookings() {
        return null;
    }
}
