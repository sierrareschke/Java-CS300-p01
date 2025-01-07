//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Course Enrollment System Driver control file to interact
// 			 with the user and allow for choice input to control the 
//			 Course Enrollment file to create, add to, modify, and print
//			 enrollment and waitlist rosters
// Course:   CS 300 Fall 2023
//
// Author:   Sierra Reschke
// Email:    sgreschke@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         N/A
// Online Sources:  Utilized zyBooks to remind myself how to declare arrays,
//					split up user input, add elements to arrays, and the
//					differences between perfect and oversized arrays
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

/**
 * This class implements the Driver Application for cs300 Fall 2023 p01 Course Enrollment System
 *
 */
public class CourseEnrollmentDriver {

	// welcome, good bye, and syntax error messages
	private static final String WELCOME_MSG = "--- Welcome to the Course Enrollment System! ----";
	private static final String GOOD_BYE_MSG = "---------- BYE! Thanks for using our App! ----------";
	private static final String SYNTAX_ERROR_MSG = "Syntax Error: Please enter a valid command!";
	private static final String NO_COURSE_ENROLLMANT_MSG =
			"Error: Create a new course enrollment first!";


	/**
	 * Main method that launches this driver application
	 * 
	 * @param args list of input arguments if any
	 */
	public static void main(String[] args) {
		// run application
		System.out.println(WELCOME_MSG); // display welcome message
		// Create a scanner to read the user inputs
		Scanner scanner = new Scanner(System.in);
		// read and process user command lines
		processUserCommands(scanner);
		scanner.close();// close the scanner
		System.out.println(GOOD_BYE_MSG);// display good bye message
	}


	/**
	 * Prints out the menu of this application
	 */
	private static void displayMenu() {
	  System.out.println("\n================================ MENU ===============================");
		System.out.println("Enter one of the following options:");
		System.out.println("[1 <roster_capacity> <waitlist_capacity>] Create a new course enrollment");
		System.out.println("[2 <name>:<wisc_email>:<campus_ID>:boolean(true/false)] Enroll student");
		System.out.println("[3 <name>:<wisc_email>:<campus_ID>:boolean] Add student to waitlist");
		System.out.println("[4 <campus_ID>] Drop the course");
		System.out.println("[5] Print roster");
		System.out.println("[6] Print waitlist");
		System.out.println("[7] Logout and EXIT");
		System.out.println("-----------------------------------------------------------------------");
	}


	/**
	 * Reads and processes user command lines
	 */
	private static void processUserCommands(Scanner scanner) {

		String promptCommandLine = "ENTER COMMAND: ";    
		String command = null; // variable to save the user command line

		// define a roster and a waitlist variables for the course enrollment, not yet initialized
		String[][] roster = null;
		int size = 0; // size of roster

		String[][] waitlist = null; // waitlist of the course

		// read and process user command lines until the user quits the application
		do{

			displayMenu(); // display the main menu
			// read user command line
			System.out.print(promptCommandLine);
			command = scanner.nextLine();
			// blank command
			if(command == null || command.isBlank()) {
				System.out.println(SYNTAX_ERROR_MSG); // syntax error message
				continue; // go to the next iteration
			}

			// Exit the loop if the user command is 7 for Quit
			if(command.charAt(0) == '7') {
				break; // exit the loop
			}

			// Create new course enrollment lists
			if (command.charAt(0) == '1') {
				// [1 <roster_capacity> <waitlist_capacity>] Create a new course enrollment
				String[] parts = command.split(" ");
				if (parts.length != 3) {// syntax error
					System.out.println(SYNTAX_ERROR_MSG);
					continue;
				}
				// valid syntax: create lists
				roster = CourseEnrollment.createEmptyList(Integer.parseInt(parts[1]));
				waitlist = CourseEnrollment.createEmptyList(Integer.parseInt(parts[2]));
				continue;
			}

			else { // any other type of command.
				// Check whether the course enrollment lists were created
				if (roster == null || waitlist == null) {
					System.out.println(NO_COURSE_ENROLLMANT_MSG);
					continue;
				}
				// process the user command line for the other options
				switch (command.charAt(0)) {
				// Enroll student
				case '2': // [2 <name>:<wisc_email>:<campus_ID>:boolean(true/false)] Enroll student
					// The boolean indicates whether the pre-requisites of the course are satisfied or
					// not process and execute the user command line to enroll a student in the course
					//String input = scanner.nextLine();
					String[] enrollInput = command.split(" ");
					String[] enrollStudentInfo = enrollInput[1].split(":");
					String enrollName = enrollStudentInfo[0];
					String enrollEmail = enrollStudentInfo[1];
					String enrollCampusId = enrollStudentInfo[2];

					boolean enrollPrerequisiteSatisfied = Boolean.parseBoolean(enrollStudentInfo[3].trim());

					size = CourseEnrollment.enrollOneStudent(enrollName, enrollEmail, enrollCampusId,
							enrollPrerequisiteSatisfied, roster, size, waitlist);

					break;

				case '3': // [3 <name>:<wisc_email>:<campus_ID>:boolean] Add student to waitlist
					// process and execute the user command line to add a student record to the waitlist

					String[] waitlistInput = command.split(" ");
					String[] waitlistStudentInfo = waitlistInput[1].split(":");
					String waitlistName = waitlistStudentInfo[0];
					String waitlistEmail = waitlistStudentInfo[1];
					String waitlistCampusId = waitlistStudentInfo[2];

					boolean waitlistPrerequisiteSatisfied = 
					    Boolean.parseBoolean(waitlistStudentInfo[3].trim());

					boolean successfullyAddedToWaitlist = CourseEnrollment.addWaitlist(waitlistName, 
							waitlistEmail, waitlistCampusId, waitlistPrerequisiteSatisfied,waitlist);

					break;

				case '4': // [4 <campus_ID>] Drop the course
					// process and execute the user command line to drop the course

					String[] dropInput = command.split(" ");
					String[] dropStudentInfo = dropInput[1].split(":");
					String dropCampusId = dropStudentInfo[0];

					size = CourseEnrollment.dropCourse(dropCampusId, roster, size);

					break;

				case '5': // [5] Print roster
					CourseEnrollment.printRoster(roster, size);
					break;

				case '6': // [6] Print waitlist
					CourseEnrollment.printWaitlist(waitlist);
					break;

				default:
					System.out.println(SYNTAX_ERROR_MSG); // Syntax Error

				}
			}

		}while(command.charAt(0) != '7');

	}

}

