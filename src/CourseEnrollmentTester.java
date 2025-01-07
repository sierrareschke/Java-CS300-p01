//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Course Enrollment System Tester to test methods within Course
//           Enrollment file that create, add to, modify, and print
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
import java.util.Arrays;

/**
 * This utility class implements unit tests to check the correctness of methods defined in the
 * CourseEnrollment class of the Course Enrollment System program.
 *
 */
public class CourseEnrollmentTester {


	/**
	 * Ensures the correctness of the createEmptyList() method
	 * 
	 * @return true if the tester verifies a correct functionality and false if at least 
	 * 		   one bug is detected
	 */
	public static boolean createEmptyListTester() {
		String errMsg = "Bug detected: createEmptyList did not return the expected array.";
		// Create an empty list String[][] whose capacity is 5
		String[][] actual = CourseEnrollment.createEmptyList(5);
		String[][] expected = new String[5][];
		// same as expected = new String[][]{null, null, null, null, null}

		if (!Arrays.deepEquals(actual, expected)) {
			// Recommended: descriptive error messages to help locating the bug
			System.out.println(errMsg);
			System.out.println("Expected: " + Arrays.deepToString(expected));
			System.out.println("Actual: " + Arrays.deepToString(actual));
			return false;
		}


		// Try a different capacity: create an empty list String[][] whose capacity is 8
		actual = CourseEnrollment.createEmptyList(8);
		expected = new String[8][];
		// same as expected = new String[][]{null, null, null, null, null}

		if (!Arrays.deepEquals(actual, expected)) {
			// descriptive error messages to help locating the bug
			System.out.println(errMsg);
			System.out.println("Expected: " + Arrays.deepToString(expected));
			System.out.println("Actual: " + Arrays.deepToString(actual));
			return false;
		}

		return true; // expected behavior verified, no bugs detected!
	}

	/**
	 * Ensures the correctness of the indexOf(String, String[][]) method
	 * 
	 * Expected behavior to be verified:<BR>
	 * (+) Correct index returned for multiple cases (normal and edge cases)<BR>
	 * (+) No changes made to the contents of the input list<BR>
	 * 
	 * @return true if the tester verifies a correct functionality and false if at 
	 *         least one bug is detected
	 */
	public static boolean indexOfPerfectSizeArrayTester() {
		// complete the implementation of this method

		// Define four test cases
		// (1) edge case: match found at index 0
		// (2) edge case: match found at index length-1 considering a full input array
		// (3) normal case: match found at the middle of the input array
		// (4) normal case: no match found, -1 should be returned

		String errMsg = "Bug detected: indexOf did not return the expected perfect size array.";

		{
			// (1) edge case: match found at index 0
			String[][] testList = new String[5][];
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student1 = {"student1", "student1@wisc.edu", "1111111111"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};
			String[] student3 = {"student3", "student3@wisc.edu", "3333333333"};
			String[] student4 = {"student4", "student4@wisc.edu", "4444444444"};


			testList[0] = student0;
			testList[1] = student1;
			testList[2] = student2;
			testList[3] = student3;
			testList[4] = student4;

			int expected = 0;
			int actual = CourseEnrollment.indexOf("0000000000", testList);

			if (actual!= expected) {
				System.out.println(errMsg);
				System.out.println("indexOfPerfectSizeArrayTester failed in case 1");
				System.out.println("Expected: " + expected);
				System.out.println("Actual: " + actual);
				return false;

			}

		}

		{
			// (2) edge case: match found at index length-1 considering a full input array
			String[][] testList = new String[5][];
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student1 = {"student1", "student1@wisc.edu", "1111111111"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};
			String[] student3 = {"student3", "student3@wisc.edu", "3333333333"};
			String[] student4 = {"student4", "student4@wisc.edu", "4444444444"};


			testList[0] = student0;
			testList[1] = student1;
			testList[2] = student2;
			testList[3] = student3;
			testList[4] = student4;


			int expected = testList.length - 1; // should be 4
			int actual = CourseEnrollment.indexOf("4444444444", testList);

			if (actual!= expected) {
				System.out.println(errMsg);
				System.out.println("indexOfPerfectSizeArrayTester failed in case 2");
				System.out.println("Expected: " + expected);
				System.out.println("Actual: " + actual);
				return false;

			}

		}

		{
			// (3) normal case: match found at the middle of the input array
			String[][] testList = new String[5][];
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student1 = {"student1", "student1@wisc.edu", "1111111111"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};
			String[] student3 = {"student3", "student3@wisc.edu", "3333333333"};
			String[] student4 = {"student4", "student4@wisc.edu", "4444444444"};


			testList[0] = student0;
			testList[1] = student1;
			testList[2] = student2;
			testList[3] = student3;
			testList[4] = student4;


			int expected = 2;
			int actual = CourseEnrollment.indexOf("2222222222", testList);

			if (actual!= expected) {
				System.out.println(errMsg);
				System.out.println("indexOfPerfectSizeArrayTester failed in case 3");
				System.out.println("Expected: " + expected);
				System.out.println("Actual: " + actual);
				return false;

			}

		}


		{
			// (4) normal case: no match found, -1 should be returned
			String[][] testList = new String[5][];
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student1 = {"student1", "student1@wisc.edu", "1111111111"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};
			String[] student3 = {"student3", "student3@wisc.edu", "3333333333"};
			String[] student4 = {"student4", "student4@wisc.edu", "4444444444"};


			testList[0] = student0;
			testList[1] = student1;
			testList[2] = student2;
			testList[3] = student3;
			testList[4] = student4;


			int expected = -1;
			int actual = CourseEnrollment.indexOf("1234567890", testList);

			if (actual!= expected) {
				System.out.println(errMsg);
				System.out.println("indexOfPerfectSizeArrayTester failed in case 4");
				System.out.println("Expected: " + expected);
				System.out.println("Actual: " + actual);
				return false;

			}

		}

		return true; // return true if all cases within this test pass
	}

	/**
	 * Ensures the correctness of the indexOf(String, String[][], int) method
	 * 
	 * Expected behavior to be verified:<BR>
	 * (+) Correct index returned for multiple cases (normal and edge cases)<BR>
	 * (+) No changes made to the contents of the input list<BR>
	 * 
	 * @return true if the tester verifies a correct functionality and false if at 
	 *         least one bug is detected
	 */
	public static boolean indexOfOversizeSizeArrayTester() {
		// complete the implementation of this method

		// Define four test cases
		// (1) edge case: match found at index 0
		// (2) edge case: match found at index size-1 
		// (3) normal case: match found outside of size, -1 should be returned
		// (4) normal case: match found at the middle of the input array
		// (5) normal case: no match found, -1 should be returned


		String errMsg = "Bug detected: indexOf did not return the expected oversize size array.";

		{
			// (1) edge case: match found at index 0
			String[][] testList = new String[10][];
			int testListSize = 5; // only students at indices 0-4 are part of the array
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};
			String[] student4 = {"student4", "student4@wisc.edu", "4444444444"};
			String[] student6 = {"student6", "student6@wisc.edu", "6666666666"};
			String[] student8 = {"student8", "student8@wisc.edu", "8888888888"};


			testList[0] = student0;
			testList[2] = student2;
			testList[4] = student4;
			testList[6] = student6;
			testList[8] = student8;

			int expected = 0;
			int actual = CourseEnrollment.indexOf("0000000000", testList, testListSize);

			if (actual!= expected) {
				System.out.println(errMsg);
				System.out.println("indexOfOversizeSizeArrayTester failed in case 1");
				System.out.println("Expected: " + expected);
				System.out.println("Actual: " + actual);
				return false;

			}

		}

		{
			// (2) edge case: match found at index size-1
			String[][] testList = new String[10][];
			int testListSize = 5; 
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};
			String[] student4 = {"student4", "student4@wisc.edu", "4444444444"};
			String[] student6 = {"student6", "student6@wisc.edu", "6666666666"};
			String[] student8 = {"student8", "student8@wisc.edu", "8888888888"};


			testList[0] = student0;
			testList[2] = student2;
			testList[4] = student4;
			testList[6] = student6;
			testList[8] = student8;


			int expected = testListSize - 1; // should be 4
			int actual = CourseEnrollment.indexOf("4444444444", testList, testListSize);

			if (actual!= expected) {
				System.out.println(errMsg);
				System.out.println("indexOfOversizeSizeArrayTester failed in case 2");
				System.out.println("Expected: " + expected);
				System.out.println("Actual: " + actual);
				return false;

			}

		}

		{
			// (3) normal case: match found outside of size, -1 should be returned
			String[][] testList = new String[10][];
			int testListSize = 5; 
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};
			String[] student4 = {"student4", "student4@wisc.edu", "4444444444"};
			String[] student6 = {"student6", "student6@wisc.edu", "6666666666"};
			String[] student8 = {"student8", "student8@wisc.edu", "8888888888"};


			testList[0] = student0;
			testList[2] = student2;
			testList[4] = student4;
			testList[6] = student6;
			testList[8] = student8;


			int expected = -1;
			int actual = CourseEnrollment.indexOf("6666666666", testList, testListSize);

			if (actual!= expected) {
				System.out.println(errMsg);
				System.out.println("indexOfOversizeSizeArrayTester failed in case 3");
				System.out.println("Expected: " + expected);
				System.out.println("Actual: " + actual);
				return false;

			}

		}

		{
			// (4) normal case: match found at the middle of the input array
			String[][] testList = new String[10][];
			int testListSize = 5; 
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};
			String[] student4 = {"student4", "student4@wisc.edu", "4444444444"};
			String[] student6 = {"student6", "student6@wisc.edu", "6666666666"};
			String[] student8 = {"student8", "student8@wisc.edu", "8888888888"};


			testList[0] = student0;
			testList[2] = student2;
			testList[4] = student4;
			testList[6] = student6;
			testList[8] = student8;


			int expected = 2;
			int actual = CourseEnrollment.indexOf("2222222222", testList, testListSize);

			if (actual!= expected) {
				System.out.println(errMsg);
				System.out.println("indexOfOversizeSizeArrayTester failed in case 4");
				System.out.println("Expected: " + expected);
				System.out.println("Actual: " + actual);
				return false;

			}

		}


		{
			// (5) normal case: no match found, -1 should be returned
			String[][] testList = new String[10][];
			int testListSize = 5; 
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};
			String[] student4 = {"student4", "student4@wisc.edu", "4444444444"};
			String[] student6 = {"student6", "student6@wisc.edu", "6666666666"};
			String[] student8 = {"student8", "student8@wisc.edu", "8888888888"};


			testList[0] = student0;
			testList[2] = student2;
			testList[4] = student4;
			testList[6] = student6;
			testList[8] = student8;


			int expected = -1;
			int actual = CourseEnrollment.indexOf("1234567890", testList, testListSize);

			if (actual!= expected) {
				System.out.println(errMsg);
				System.out.println("indexOfOversizeSizeArrayTester failed in case 5");
				System.out.println("Expected: " + expected);
				System.out.println("Actual: " + actual);
				return false;

			}

		}


		return true; // return true if all cases within this test pass
	}


	// Helper method to compare actual and expected oversize roster arrays
	/**
	 * Helper method defined to help verifying the actual roster and waitlist arrays with 
	 * respect to the expected ones
	 * 
	 * @param methodName     name of the method being tested
	 * @param actualRoster   actual roster
	 * @param expectedRoster expected roster
	 * @param actualSize     actual roster size
	 * @param expectedSize   expected roster size
	 * 
	 * @return true if expected behavior satisfied, false if any bug is detected
	 */
	private static boolean assessDeepEqualOversizeArraysHelper(String methodName,
			String[][] actualRoster, String[][] expectedRoster, int actualSize, int expectedSize) {
		// error messages
		String errMsgBadSize =
				"Bug detected: Your " + methodName + "() method did not return the expected size.";
		String errMsgBadRoster = "Bug detected: The contents of the roster array was not as expected "
				+ "after " + "your " + methodName + "() method returned.";

		// check roster size
		if (actualSize != expectedSize) {
			System.out.println(errMsgBadSize);
			System.out.println("Expected size: " + expectedSize + ". Actual size: " + actualSize);
			return false;
		}

		// compare roster contents
		if (!Arrays.deepEquals(actualRoster, expectedRoster)) {
			System.out.println(errMsgBadRoster);
			System.out.println("Expected Roster: " + Arrays.deepToString(expectedRoster));
			System.out.println("Actual Roster: " + Arrays.deepToString(actualRoster));
			return false;
		}

		return true; // expected behavior satisfied, no bugs detected
	}

	// Helper method to compare actual and expected oversize roster arrays
	/**
	 * Helper method defined to help verifying the actual roster and waitlist arrays with respect to
	 * the expected ones
	 * 
	 * @param methodName       name of the method being tested
	 * @param actualWaitlist   actual waitlist
	 * @param expectedWaitlist expected waitlist
	 * 
	 * @return true if expected behavior satisfied, false if any bug is detected
	 */
	private static boolean assessDeepEqualPerfectSizeArraysHelper(String methodName,
			String[][] actualWaitlist, String[][] expectedWaitlist) {
		// error message
		String errMsgBadWaitlist =
				"Bug detected: The contents of the waitlist array was not as expected after " + "your "
						+ methodName + "() method returned";

		// compare waitlist contents
		if (!Arrays.deepEquals(actualWaitlist, expectedWaitlist)) {
			System.out.println(errMsgBadWaitlist);
			System.out.println("Expected Waitlist: " + Arrays.deepToString(expectedWaitlist));
			System.out.println("Actual Waitlist: " + Arrays.deepToString(actualWaitlist));
			return false;
		}
		return true; // expected behavior satisfied, no bugs detected
	}

	/**
	 * Ensures the correctness of the enrollOneStudent() method when called to enroll one student
	 * record in the course. The course did not reach its capacity and the course pre-requisites are
	 * satisfied.
	 * 
	 * Expected behavior to be verified:<BR>
	 * (+) Student record correctly added to the end of the roster array<BR>
	 * (+) No changes made to the waitlist array<BR>
	 * (+) Correct size returned
	 * 
	 * @return true if the tester verifies a correct functionality and false if at least one bug is
	 *         detected
	 */
	public static boolean enrollOneStudentTester() {
		// You do not need to make changes to this method
		// create a waitlist array. We can consider a normal case: not-empty and not-full waitlist)
		String[][] actualWaitlist = new String[][] {{"Andy", "andy@wisc.edu", "9087654321"},
			{"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};

		// No changes to the waitlist are expected
		String[][] expectedWaitlist = new String[][] {{"Andy", "andy@wisc.edu", "9087654321"},
		{"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};

		// This method considers three test cases:
		// (1) edge case: adding to an empty roster
		// (2) normal case: adding to the end of a non-empty roster
		// (3) edge case: after adding the student record, the roster is full

		// To avoid code redundancy, we defined a helper method named verifyCorrectBehaviorHelper()
		// to help verifying the expected behavior for each of the above test cases.

		// --------------------------------------------------------------------------
		// (1) edge case Enroll a student considering an empty roster oversize array
		// enroll one student satisfying prerequisites
		// Create an empty roster
		String[][] actualRoster = new String[3][];
		int actualSize = 0;

		// Try to enroll George
		actualSize = CourseEnrollment.enrollOneStudent("George", "george@wisc.edu", "9780563421",
				true, actualRoster, actualSize, actualWaitlist);
		// expected roster and its size
		String[][] expectedRoster =
				new String[][] {{"George", "george@wisc.edu", "9780563421"}, null, null};
		int expectedSize = 1;
		boolean resultCase1 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", 
				actualRoster, expectedRoster, actualSize, expectedSize);

		// --------------------------------------------------------------------------
		// (2) normal case: adding to the end of a non-empty roster
		actualRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
		{"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};
		actualSize = 2;

		// Try to enroll Matt
		actualSize = CourseEnrollment.enrollOneStudent("Matt", "matt@wisc.edu", "9745632180", true,
				actualRoster, actualSize, actualWaitlist);
		// expected roster and its size
		expectedRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
			{"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"}, null};
		expectedSize = 3;
		boolean resultCase2 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
				expectedRoster, actualSize, expectedSize);

		// --------------------------------------------------------------------------
		// (3) edge case: after adding the student record, the roster is full
		actualRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
		{"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"}, null};
		actualSize = 3;

		// Try to enroll Lisa
		actualSize = CourseEnrollment.enrollOneStudent("Lisa", "lisa@wisc.edu", "9784563211", true,
				actualRoster, actualSize, actualWaitlist);
		// expected roster and its size
		expectedRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
			{"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"},
			{"Lisa", "lisa@wisc.edu", "9784563211"}};
		expectedSize = 4;
		boolean resultCase3 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
				expectedRoster, actualSize, expectedSize);

		// Verify that all the above enrollOneStudent() method calls did not make any changes to the
		// contents of the input waitlist
		boolean assessWaitlistContents = assessDeepEqualPerfectSizeArraysHelper("enrollOneStudent",
				actualWaitlist, expectedWaitlist);

		// test passes only if each of the defined test scenarios passes
		return resultCase1 && resultCase2 && resultCase3 && assessWaitlistContents;
	}


	/**
	 * Ensures the correctness of the enrollOneStudent() method when called to enroll one student
	 * record in the course. The student record is in the waitlist, course pre-requisites are
	 * satisfied, and there is room in the roster to enroll the student in the course.
	 * 
	 * Expected behavior to be verified:<BR>
	 * (+) Student record correctly added to the end of the roster array<BR>
	 * (+) Matching student correctly record removed off the waitlist<BR>
	 * (+) Correct size returned
	 * 
	 * @return true if the tester verifies a correct functionality and false if at least one bug is
	 *         detected
	 */
	public static boolean enrollOneStudentMoveFromWaitlistTester() {
		// complete the implementation of this method
		// (1) Edge case: Student is at index 0 of waitlist
		// (2) Edge case: Student is at index length-1 of waitlist
		// (3) Normal case: Student is at index in middle of waitlist
		// (4) Edge case: Student is already enrolled in course, waitlist should remain unchanged


		{
			// (1) Edge case: Student is at index 0 of waitlist
			String[][] waitlist = new String[][] {{"Andy", "andy@wisc.edu", "9087654321"},
				{"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};

			// Andy should be removed and null should be at index 0, Lilly should still be at index 1
			String[][] expectedWaitlist = new String[][] {null,
				{"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};

			// enroll one student satisfying prerequisites and already on waitlist
			// Create an empty roster
			String[][] actualRoster = new String[3][];
			int actualSize = 0;

			// Try to enroll Andy
			actualSize = CourseEnrollment.enrollOneStudent("Andy", "andy@wisc.edu", "9087654321", true,
					actualRoster, actualSize, waitlist);

			// check to see if actual roster and size are same as expected
			String[][] expectedRoster =
					new String[][] {{"Andy", "andy@wisc.edu", "9087654321"}, null, null};
			int expectedSize = 1;
			boolean resultCase1 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
					expectedRoster, actualSize, expectedSize);

			// see if expectedWaitlist is same as the updated waitlist
			boolean assessWaitlistContents = 
			    assessDeepEqualPerfectSizeArraysHelper("enrollOneStudentMoveFromWaitlist",
					waitlist, expectedWaitlist);

			if (assessWaitlistContents == false) {	
				System.out.println("enrollOneStudent failed in waitlist case 1");
				return false;
			}
		}

		{
			// (2) Edge case: Student is at index length-1 of waitlist
			String[][] waitlist = new String[][] {null,
				{"Lilly", "lilly@wisc.edu", "9807645321"}, null, {"Andy", "andy@wisc.edu", "9087654321"}};

			// Andy should be removed, null should be at index length-1, Lilly should still be at index 1
			String[][] expectedWaitlist = new String[][] {null,
				{"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};

			// enroll one student satisfying prerequisites and already on waitlist
			// Create an empty roster
			String[][] actualRoster = new String[3][];
			int actualSize = 0;

			// Try to enroll Andy
			actualSize = CourseEnrollment.enrollOneStudent("Andy", "andy@wisc.edu", "9087654321", true,
					actualRoster, actualSize, waitlist);

			// check to see if actual roster and size are same as expected
			String[][] expectedRoster =
					new String[][] {{"Andy", "andy@wisc.edu", "9087654321"}, null, null};
				int expectedSize = 1;
				boolean resultCase1 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
						expectedRoster, actualSize, expectedSize);

				// see if expectedWaitlist is same as the updated waitlist
				boolean assessWaitlistContents = 
				    assessDeepEqualPerfectSizeArraysHelper("enrollOneStudentMoveFromWaitlist",
						waitlist, expectedWaitlist);

				if (assessWaitlistContents == false) {	
					System.out.println("enrollOneStudent failed in waitlist case 2");
					return false;
				}
		}

		{
			// (3) Normal case: Student is at index in middle of waitlist
			String[][] waitlist = new String[][] {null,
				{"Lilly", "lilly@wisc.edu", "9807645321"}, {"Andy", "andy@wisc.edu", "9087654321"}, null};

			// Andy should be removed and null should be at index 2, Lilly should still be at index 1
			String[][] expectedWaitlist = new String[][] {null,
				{"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};

			// enroll one student satisfying prerequisites and already on waitlist
			// Create an empty roster
			String[][] actualRoster = new String[3][];
			int actualSize = 0;

			// Try to enroll Andy
			actualSize = CourseEnrollment.enrollOneStudent("Andy", "andy@wisc.edu", "9087654321", true,
					actualRoster, actualSize, waitlist);

			// check to see if actual roster and size are same as expected
			String[][] expectedRoster =
					new String[][] {{"Andy", "andy@wisc.edu", "9087654321"}, null, null};
			int expectedSize = 1;
			boolean resultCase1 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
					expectedRoster, actualSize, expectedSize);

			// see if expectedWaitlist is same as the updated waitlist
			boolean assessWaitlistContents = 
			    assessDeepEqualPerfectSizeArraysHelper("enrollOneStudentMoveFromWaitlist",
					waitlist, expectedWaitlist);

			if (assessWaitlistContents == false) {	
				System.out.println("enrollOneStudent failed in waitlist case 3");
				return false;
			}
		}

		{
			// (4) Edge case: Student is already enrolled in course, waitlist should remain unchanged
			String[][] waitlist = new String[][] {null,
				{"Lilly", "lilly@wisc.edu", "9807645321"}, {"Andy", "andy@wisc.edu", "9087654321"}, null};

			// waitlist should remain unchanged
			String[][] expectedWaitlist = new String[][] {null,
				{"Lilly", "lilly@wisc.edu", "9807645321"}, {"Andy", "andy@wisc.edu", "9087654321"}, null};

			// student already enrolled, already in roster
			String[][] actualRoster = new String[3][];
			int actualSize = 0;

			String[] andyStudent = {"Andy", "andy@wisc.edu", "9087654321"};
			actualRoster[0] = andyStudent;
			actualSize = 1;

			// Try to enroll Andy
			actualSize = CourseEnrollment.enrollOneStudent("Andy", "andy@wisc.edu", "9087654321", true,
					actualRoster, actualSize, waitlist);

			// check to see if actual roster and size are same as expected
			String[][] expectedRoster =
					new String[][] {{"Andy", "andy@wisc.edu", "9087654321"}, null, null};
			int expectedSize = 1;
			boolean resultCase1 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
					expectedRoster, actualSize, expectedSize);

			// see if expectedWaitlist is same as the updated waitlist
			boolean assessWaitlistContents = 
			    assessDeepEqualPerfectSizeArraysHelper("enrollOneStudentMoveFromWaitlist",
					waitlist, expectedWaitlist);

			if (assessWaitlistContents == false) {	
				System.out.println("enrollOneStudent failed in waitlist case 4");
				return false;
			}
		}

		return true; // return true if all test cases passed
	}

	/**
	 * Ensures the correctness of the dropCourse() method when called to remove an existing student
	 * record from a course enrollment roster of the class.
	 * 
	 * Expected behavior to be verified:<BR>
	 * (+) Matching student record correctly removed off the input roster array. Order of precedence
	 * of the student records must be preserved.<BR>
	 * (+) Correct size returned
	 * 
	 * @return true if the tester verifies a correct functionality and false if at least one bug is
	 *         detected
	 */
	public static boolean successfulDropCourseTester() {
		// complete the implementation of this method
		// (1) Normal case: student found at an index in the middle of the roster 
		// (2) Edge case: student found at index 0 of the roster
		// (3) Edge case: student found at index size-1 of the roster

		{
			// (1) Normal case: student found at an index in the middle of the roster 
			String[][] actualRoster = new String[5][];
			int actualSize = 3;
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student1 = {"student1", "student1@wisc.edu", "1111111111"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};

			actualRoster[0] = student0;
			actualRoster[1] = student1;
			actualRoster[2] = student2;

			// remove student1
			String[][] expectedRoster = new String[][] {{"student0", "student0@wisc.edu", "0000000000"},
				{"student2", "student2@wisc.edu", "2222222222"}, null, null, null};

			int expectedSize = 2;
			actualSize = CourseEnrollment.dropCourse("1111111111", actualRoster, actualSize);

			boolean resultCase1 = assessDeepEqualOversizeArraysHelper("dropCourse", actualRoster,
					expectedRoster, actualSize, expectedSize);

			if (resultCase1 == false) {	
				System.out.println("dropCourse failed in case 1");
				return false;
			}
		}

		{
			// (2) Edge case: student found at index 0 of the roster
			String[][] actualRoster = new String[5][];
			int actualSize = 3;
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student1 = {"student1", "student1@wisc.edu", "1111111111"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};

			actualRoster[0] = student0;
			actualRoster[1] = student1;
			actualRoster[2] = student2;

			// remove student0
			String[][] expectedRoster = new String[][] {{"student1", "student1@wisc.edu", 
				"1111111111"}, {"student2", "student2@wisc.edu", "2222222222"}, null, null, null};

			int expectedSize = 2;
			actualSize = CourseEnrollment.dropCourse("0000000000", actualRoster, actualSize);

			boolean resultCase2 = assessDeepEqualOversizeArraysHelper("dropCourse", actualRoster,
					expectedRoster, actualSize, expectedSize);

			if (resultCase2 == false) {	
				System.out.println("dropCourse failed in case 2");
				return false;
			}
		}

		{
			// (3) Edge case: student found at index size-1 of the roster
			String[][] actualRoster = new String[5][];
			int actualSize = 3;
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student1 = {"student1", "student1@wisc.edu", "1111111111"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};

			actualRoster[0] = student0;
			actualRoster[1] = student1;
			actualRoster[2] = student2;

			// remove student2
			String[][] expectedRoster = new String[][] {{"student0", "student0@wisc.edu", 
				"0000000000"}, {"student1", "student1@wisc.edu", "1111111111"}, null, null, null};

			int expectedSize = 2;
			actualSize = CourseEnrollment.dropCourse("2222222222", actualRoster, actualSize);

			boolean resultCase3 = assessDeepEqualOversizeArraysHelper("dropCourse", actualRoster,
					expectedRoster, actualSize, expectedSize);

			if (resultCase3 == false) {	
				System.out.println("dropCourse failed in case 3");
				return false;
			}
		}


		return true; // return true if all test cases passed
	}

	/**
	 * Ensures the correctness of the dropCourse() method when called to remove a non-existing 
	 * student record from a course enrollment roster of the class.
	 * 
	 * Expected behavior to be verified:<BR>
	 * (+) No changes made to the input roster array: Fail to find a matching student record .<BR>
	 * (+) Correct size returned (same size passed as input to the method)
	 * 
	 * @return true if the tester verifies a correct functionality and false if at least one bug is
	 *         detected
	 */
	public static boolean unsuccessfulDropCourseTester() {
		// complete the implementation of this method
		// (1) Normal case: student is not enrolled in the class


		{
			// (1) Normal case: student is not enrolled in the class
			String[][] actualRoster = new String[5][];
			int actualSize = 3;
			String[] student0 = {"student0", "student0@wisc.edu", "0000000000"};
			String[] student1 = {"student1", "student1@wisc.edu", "1111111111"};
			String[] student2 = {"student2", "student2@wisc.edu", "2222222222"};

			actualRoster[0] = student0;
			actualRoster[1] = student1;
			actualRoster[2] = student2;

			// student is not found so no change to roster
			String[][] expectedRoster = new String[][] {{"student0", "student0@wisc.edu", "0000000000"},
				{"student1", "student1@wisc.edu", "1111111111"}, {"student2", "student2@wisc.edu", 
				"2222222222"}, null, null};

			int expectedSize = 3;
			actualSize = CourseEnrollment.dropCourse("1234567890", actualRoster, actualSize);

			boolean resultCase4 = assessDeepEqualOversizeArraysHelper("dropCourse", actualRoster,
					expectedRoster, actualSize, expectedSize);

			if (resultCase4 == false) {	
				System.out.println("dropCourse failed in unsuccessfulDropCourseTester case 1");
				return false;
			}
		}

		return true; // return true if the tester verifies a correct functionality
	}


	/**
	 * Runs all the tester methods defined in this class.
	 * 
	 * @return true if no bugs are detected.
	 */
	public static boolean runAllTests() {
		boolean createEmptyListTesterResult = createEmptyListTester();
		System.out
		.println("createEmptyListTester: " + (createEmptyListTesterResult ? "Pass" : "Failed!"));

		System.out.println("-----------------------------------------------");
		boolean indexOfOversizeSizeArrayTesterResult = indexOfOversizeSizeArrayTester();
		System.out.println("indexOfOversizeSizeArrayTester: "
				+ (indexOfOversizeSizeArrayTesterResult ? "Pass" : "Failed!"));

		System.out.println("-----------------------------------------------");
		boolean indexOfPerfectSizeArrayTesterResult = indexOfPerfectSizeArrayTester();
		System.out.println("indexOfPerfectSizeArrayTester: "
				+ (indexOfPerfectSizeArrayTesterResult ? "Pass" : "Failed!"));

		System.out.println("-----------------------------------------------");
		boolean enrollOneStudentTesterResult = enrollOneStudentTester();
		System.out
		.println("enrollOneStudentTester: " + (enrollOneStudentTesterResult ? "Pass" : "Failed!"));

		System.out.println("-----------------------------------------------");
		boolean enrollOneStudentMoveFromWaitlistTesterResult = enrollOneStudentMoveFromWaitlistTester();
		System.out.println("enrollOneStudentMoveFromWaitlistTester: "
				+ (enrollOneStudentMoveFromWaitlistTesterResult ? "Pass" : "Failed!"));

		System.out.println("-----------------------------------------------");
		boolean successfulDropCourseTesterResult = successfulDropCourseTester();
		System.out.println(
				"successfulDropCourseTester: " + (successfulDropCourseTesterResult ? "Pass" : "Failed!"));

		System.out.println("-----------------------------------------------");
		boolean unsuccessfulDropCourseTesterResult = unsuccessfulDropCourseTester();
		System.out.println("unsuccessfulDropCourseTester: "
				+ (unsuccessfulDropCourseTesterResult ? "Pass" : "Failed!"));

		System.out.println("-----------------------------------------------");

		return createEmptyListTesterResult && indexOfOversizeSizeArrayTesterResult
				&& indexOfPerfectSizeArrayTesterResult && enrollOneStudentTesterResult
				&& enrollOneStudentMoveFromWaitlistTesterResult && successfulDropCourseTesterResult
				&& unsuccessfulDropCourseTesterResult;
	}

	/**
	 * Main method to run this tester class.
	 * 
	 * @param args list of input arguments if any
	 */
	public static void main(String[] args) {
		System.out.println("-----------------------------------------------");
		System.out.println("runAllTests: " + (runAllTests() ? "Pass" : "Failed!"));
	}

}
