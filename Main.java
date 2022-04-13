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

			// #################################################################
			// Declare Variables Here
			boolean member = false;
			boolean coach = false;
			boolean tresauer = false;
			// #################################################################



			Scanner scanner = new Scanner(System.in);
			System.out.print("\n>");

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








				// #################################################################
				// Declare Functions Here


				// Prints list of all available commands
				else if (action.equalsIgnoreCase("HELP")) {

					if (member) {
						System.out.println("\nHelp: \n\n");
					} else if (coach) {
						System.out.println("\nHelp: \n\n");
					} else if (tresauer) {
						System.out.println("\nHelp: \n\n");
					} else {
						System.out.println("\nHelp:\n\nlogin\nquit");
					}
										
				}


				// Quits Program
				else if (action.equalsIgnoreCase("quit")) {
					System.out.println("\nClosing Application");
					return;

				}
					


				else if (action.equalsIgnoreCase("LOGIN")) {

					if (member) {
						System.out.println("Already Logged In");
					} else if (coach) {
						System.out.println("Already Logged In");
					} else if (tresauer) {
						System.out.println("Already Logged In");
					} else {
						System.out.print("\nWelcome\nUsername: ");
						String username = scanner.nextLine();
						// System.out.println(username);
						System.out.print("Password: ");
						String password = scanner.nextLine();

						if (username.equals("Member") && password.equals("Password")) {
							System.out.println("Login Successful");
							member = true;
						} else if (username.equals("Coach") && password.equals("Password")) {
							System.out.println("Login Successful");
							coach = true;
						} else if (username.equals("Treasurer") && password.equals("Password")) {
							System.out.println("Login Successful");
							tresauer = true;
						} else {
							System.out.println("Login Failed");
						}
					}

					
				}



				 // #################################################################

		







				System.out.print("\n>");
			}


		
		// Catch exeption that may occur.
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

	}

}
