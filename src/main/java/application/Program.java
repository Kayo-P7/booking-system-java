package application;

import entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter room Number: ");
        Integer number = sc.nextInt();
        System.out.println("Enter check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Enter check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        Date now = new Date();
        if (checkIn.after(checkOut)) {
            System.out.println("Error: Invalid dates. Check-out date must be after check-in date.");

        } else if (checkIn.before(now) || checkOut.before(now)) {
            System.out.println("Error: These dates are not in the future. ");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();
            System.out.println("Update reservation: ");
            System.out.println("Enter check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Enter check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            now = new Date();
            if (checkIn.after(checkOut)) {
                System.out.println("Error: Invalid dates. Check-out date must be after check-in date.");
            } else if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error: These dates are not in the future. ");
            } else {
                reservation.updateDate(checkIn, checkOut);
                System.out.println(reservation);
            }
        }


        sc.close();
    }
}
