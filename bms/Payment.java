package interview.practise.lld.bms;

import interview.practise.lld.bms.enums.PaymentStatus;

import java.util.UUID;

public class Payment {
    String paymentId;
    PaymentStatus paymentStatus;
    public Payment() {
        this.paymentId = UUID.randomUUID().toString();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
