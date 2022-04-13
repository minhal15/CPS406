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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// Tries to run program, if error occors, prints message
		try {

			// #################################################################
			// Declare Variables Here
			boolean member = false;
			boolean coach = false;
			boolean treasurer = false;
			ArrayList<List<String>> users = new ArrayList();
			// #################################################################

			// Makes 2D ArrayList of Users
			File file = new File("users.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String user = scan.nextLine();
				String userInfo[] = user.split(",");
				List<String> al = new ArrayList<String>();
				al = Arrays.asList(userInfo);
				users.add(al);
			}

			// Scanner
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
					} else if (treasurer) {
						System.out.println("\nHelp: \n\n");
					} else {
						System.out.println("\nAvailable Commands:\n\nlogin\nquit");
					}
										
				}


				// Quits Program
				else if (action.equalsIgnoreCase("quit")) {
					System.out.println("\nClosing Application");
					return;
				} //Quit End
					

				// Login Start
				else if (action.equalsIgnoreCase("LOGIN")) {

					if (member) {
						System.out.println("Already Logged In");
					} else if (coach) {
						System.out.println("Already Logged In");
					} else if (treasurer) {
						System.out.println("Already Logged In");
					} else {
						System.out.print("\nWelcome\nUsername: ");
						String username = scanner.nextLine();
						// System.out.println(username);
						System.out.print("Password: ");
						String password = scanner.nextLine();

						Boolean found = false;
						for (List<String> list : users) {
							if (list.get(0).equals(username) && list.get(1).equals(password)) {
								found = true;
								if (list.get(2).equals("member")) {
									member = true;
								} else if (list.get(2).equals("coach")){
									coach = true;
								} else if (list.get(2).equals("treasurer")){
									treasurer = true;
								} else {
									System.out.println("Type of User Not Found");
								}
								break;
							}
						}
						if (found) {
							System.out.println("Login Successful");
						} else {
							System.out.println("Login Failed");
						}
					}
				} // LOGIN End



				 // #################################################################

		







				System.out.print("\n>");
			}



		// Catch exeption that may occur.
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

	}

}
