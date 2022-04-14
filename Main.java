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
import java.io.FileWriter;
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
			String UserName = "";
			ArrayList<List<String>> users = new ArrayList();
			ArrayList<List<String>> messageBoard = new ArrayList();
			// #################################################################

			// Makes 2D ArrayList of Users
			File file = new File("users.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String user = scan.nextLine();
				String userInfo[] = user.split("`");
				List<String> al = new ArrayList<String>();
				al = Arrays.asList(userInfo);
				users.add(al);
			}

			// Makes 2D ArrayList of MessageBoard
			File file2 = new File("messageboard.txt");
			Scanner scan2 = new Scanner(file2);
			while (scan2.hasNextLine()) {
				String message = scan2.nextLine();
				String MessageList[] = message.split("`");
				List<String> al2 = new ArrayList<String>();
				al2 = Arrays.asList(MessageList);
				messageBoard.add(al2);
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









				// ######################################################################
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
						System.out.println("\nAvailable Commands:\n\nlogin\nquit\nregister");
					}					
				} //HELP End

				// Quits Program
				else if (action.equalsIgnoreCase("quit")) {
					System.out.println("\nClosing Application");
					return;
				} //Quit End
					
				// Login Start
				else if (action.equalsIgnoreCase("LOGIN")) {
					if (member || coach || treasurer) {
						System.out.println("Already Logged In");
					} else {
						System.out.print("\nWelcome\nUsername: ");
						String username1 = scanner.nextLine();
						System.out.print("Password: ");
						String password = scanner.nextLine();

						Boolean found = false;
						for (List<String> list : users) {
							if (list.get(0).equals(username1) && list.get(1).equals(password)) {
								found = true;
								UserName = list.get(0);
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

				// Logout
				else if (action.equalsIgnoreCase("logout")) {
					if (member || coach || treasurer) {
						member = false;
						coach = false;
						treasurer = false;
						UserName = "";
						System.out.println("Logout Successful");
					} else {
						System.out.println("Already Logged Out");
					}
					
				} //Logout End

				// Member Register
				else if (action.equalsIgnoreCase("REGISTER")) {
					if (member || coach || treasurer) {
						System.out.println("Please Log Out First");
					} else {
						System.out.print("\nWelcome, Please Type In the Following\nUsername: ");
						String username2 = scanner.nextLine();
						System.out.print("Password: ");
						String password = scanner.nextLine();
						String newUser[] = {username2, password, "member"};
						List<String> newUserList = new ArrayList<String>();
						newUserList = Arrays.asList(newUser);
						users.add(newUserList);
						try {
							String filename= "users.txt";
							FileWriter fw = new FileWriter(filename,true); //the true will append the new data
							fw.write("\n" + username2 + "`" + password + "`" + "member");//appends the string to the file
							fw.close();
						} catch(IOException ioe) {
							System.err.println("IOException: " + ioe.getMessage());
						}
					}
				} // REGISTER End

				// Reading Message
				else if (action.equalsIgnoreCase("MESSAGES")) {
					if (member || coach || treasurer) {
						for (List<String> list : messageBoard) {
							if (list.get(0).equals("public")) {
								System.out.println("Public Message: " + list.get(1));
							} else if (list.get(0).equals("private") && list.get(1).equals(UserName)) {
								System.out.println("Private Message: " + list.get(2));
							}
						}
					} else {
						System.out.println("Please Login to View Messages");
					}
				} // Messages End

				// Sending Messages
				else if (action.equalsIgnoreCase("SEND")){
					if (coach) {
						System.out.print("\"public\" or \"private\": ");
						String publicOrPrivate = scanner.nextLine();
						if (publicOrPrivate.equalsIgnoreCase("public")) {
							System.out.print("Message: ");
							String message = scanner.nextLine();
							String messageList[] = {publicOrPrivate, message};
							List<String> newMessageList = new ArrayList<String>();
							newMessageList = Arrays.asList(messageList);
							messageBoard.add(newMessageList);
							try {
								String filename= "messageboard.txt";
								FileWriter fw = new FileWriter(filename,true); //the true will append the new data
								fw.write("\n" + publicOrPrivate + "`" + message);//appends the string to the file
								fw.close();
							} catch(IOException ioe) {
								System.err.println("IOException: " + ioe.getMessage());
							}
						} else if (publicOrPrivate.equalsIgnoreCase("private")) {
							System.out.print("Recipient: ");
							String recipient = scanner.nextLine();
							System.out.print("Message: ");
							String message = scanner.nextLine();
							String messageList[] = {publicOrPrivate, recipient, message};
							List<String> newMessageList = new ArrayList<String>();
							newMessageList = Arrays.asList(messageList);
							messageBoard.add(newMessageList);
							try {
								String filename= "messageboard.txt";
								FileWriter fw = new FileWriter(filename,true); //the true will append the new data
								fw.write("\n" + publicOrPrivate + "`" + recipient + "`" + message);//appends the string to the file
								fw.close();
							} catch(IOException ioe) {
								System.err.println("IOException: " + ioe.getMessage());
							}
						} else {
							System.out.println("Invalid Argument");
						}
					} else {
						System.out.println("Not Allowed");
					}
				} // SEND End









				 // ######################################################################

		




				else {
					System.out.println("Invalid Command");
				}


				System.out.print("\n>");
			} // End of Input Reciever

			

		// Catch exeption that may occur.
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		

	}

}
