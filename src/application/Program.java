package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		try {
			System.out.println("Room Number: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyy):");
			Date checkout = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.print("Enter data to update reservation: ");
			System.out.print("Check-in date (dd/MM/yyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyy):");
			checkout = sdf.parse(sc.next());
	
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		} catch(ParseException e) {
			System.out.println("Invalid date format");
		} catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
		
	}

}
