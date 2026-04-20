package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Integer Number;
    public Date checkIn;
    public Date checkOut;

    public Reservation() {
    }

    public Reservation(Integer number, Date checkIn, Date checkOut) {
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

    public long duration(){

        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

   public void updateDate(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
   }

    @Override
    public String toString() {
        return "Reservation: " +
                "Number: " + Number +
                " checkIn:" + checkIn +
                " checkOut: " + checkOut +
                " Nights: " +
                duration();

    }
}
