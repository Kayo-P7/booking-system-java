package application;

import libs.Conexao;
import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Enter room Number: ");
            Integer number = sc.nextInt();
            System.out.println("Enter check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Enter check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Date now = new Date();

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();
            System.out.println("Update reservation: ");
            System.out.println("Enter check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Enter check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());


            reservation.updateDate(checkIn, checkOut);
            System.out.println(reservation);
            Conexao.salvarReserva(reservation);
        } catch (ParseException e) {
            System.out.println("Invalid date format! ");

        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");

        }

        sc.close();
    }
}
