package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Integer Number;
    private Date checkIn;
    private Date checkOut;

    public Reservation() {
    }

    public Reservation(Integer number, Date checkIn, Date checkOut) {
        if (checkIn.after(checkOut)) {
            throw new DomainException("Invalid dates. Check-out date must be after check-in date.");
        }
        Number = number;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {

        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDate(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.after(checkOut)) {
            throw new DomainException("Invalid dates. Check-out date must be after check-in date.");
        }
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("These dates are not in the future. ");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    @Override
    public String toString() {
        return "Reservation: " +
                "Number: " + Number +
                ", check-in: " + sdf.format(checkIn) +
                ", check-out: " + sdf.format(checkOut) +
                ", nights: " + duration();
    }
}
