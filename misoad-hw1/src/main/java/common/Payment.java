package common;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by naman on 2/11/15.
 */
public class Payment implements java.io.Serializable, Entity {

    private static final long serialVersionUID = 1L;

    private Integer paymentId;
    private Integer customerId;
    private Integer staffId;
    private Integer rentalId;
    private Double amount;
    private Date paymentDate;
    private Timestamp lastUpdated;

    public Payment() {
    }

    public Payment(Integer paymentId, Integer customerId, Integer staffId, Integer rentalId, Double amount,
                   Date paymentDate, Timestamp lastUpdated) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.lastUpdated = lastUpdated;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public Integer getEntityId() {
        return paymentId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}

