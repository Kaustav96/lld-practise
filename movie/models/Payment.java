package interview.practise.lld.movie.models;

import interview.practise.lld.movie.enums.PaymentStatus;

import java.util.Date;

public class Payment {
    private double amount;
    private Date createdOn;
    private int transactionId;
    private PaymentStatus status;
}
