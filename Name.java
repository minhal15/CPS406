
/**
 * Project MEM
 * 
 * @author CPS406 Group 68
 * 
 * Group Members:
 * 
 * Ahmad, Ammar
 * Ali, Mohamed Minhal
 * Kothari, Hitarthi
 * Pajkic, Bosko
 * Sharma, Anmol
 * 
 * 
 * Description:
 * 
 * Main class reads commands from console and calls appropriate functions.
 * 
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Tries to run program, if error occors, prints message
		try {

			Scanner scanner = new Scanner(System.in);
			System.out.print(">");

			while (scanner.hasNextLine()) {
				// Puts input into inputLine
				String inputLine = scanner.nextLine();
				if (inputLine == null || inputLine.equals("")) {
					System.out.print("\n>");
					continue;
				}

				// The command line is a scanner that scans the inputLine string
				Scanner commandLine = new Scanner(inputLine);
				// The action string is the command to be performed (e.g. help, login etc)
				String action = commandLine.next();

				if (action == null || action.equals("")) {
					System.out.print("\n>");
					continue;
				}

				// Quits Program
				else if (action.equals("Q") || action.equals("QUIT"))
					return;

				// Prints list of all available commands
				else if (action.equalsIgnoreCase("HELP")) {
					System.out.println("Help: \n\n");
				}









				// #################################################################
				// EXAMPLE
				else if (action.equalsIgnoreCase("RES")) {
					try {
						String flightNum = null;
						String passengerName = "";
						String passport = "";
						String seat = "";

						if (commandLine.hasNext()) {
							flightNum = commandLine.next();
						} else {
							throw new IllegalArgumentException("Enter flight number");
						}
						if (commandLine.hasNext()) {
							passengerName = commandLine.next();
						} else {
							throw new IllegalArgumentException("Enter passenger name");
						}
						if (commandLine.hasNext()) {
							passport = commandLine.next();
						} else {
							throw new IllegalArgumentException("Enter passport number");
						}
						if (commandLine.hasNext()) {

							seat = commandLine.next();

							Reservation res = manager.reserveSeatOnFlight(flightNum, passengerName, passport, seat);
							// Adds reservation to myReservation Array
							myReservations.add(res);
							res.print();

						} else {
							throw new IllegalArgumentException("Enter seat number");
						}
						// Catches any Exceptions when Creating a reservation/ When not enough info was
						// entered for input.
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				// #################################################################	
				} else if (action.equalsIgnoreCase("CRAFT")) {
					
				}

				// #################################################################

				






				
				System.out.print("\n>");
			}


		// Catch IOException if .txt file doesn't exist
		} catch (IOException e) {
			System.out.println(e.getMessage());
		// Catch any other exeption that may occur.
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

	}

}
