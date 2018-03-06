import java.util.Scanner;

/**
 * Obtains user input choice for one of the six operations.
 * 
 *
 */
public class UserInput {
	Scanner scanner = new Scanner(System.in);
	/**
	 * Stores the choice of the user.
	 */
	String option;
	/**
	 * Flag used for looping the user input process if choice entered by user is
	 * invalid.
	 */
	boolean invalid = false;

	/**
	 * Obtains a input from user corresponding to a particular operation.
	 * 
	 * @return The one of 6 choices entered by the user
	 */
	public int getUserInput() {

		do {
			System.out.println("\nPlease enter an option..\n" + "1 - Add Contact\n" + "2 - List contacts\n"
					+ "3 - Update contact\n" + "4 - Search contacts\n" + "5 - Delete contact\n"
					+ "6 - Exit contacts manager");
			option = scanner.next();
		} while (!isChoiceValid(option));

		return Integer.parseInt(option);

	}

	/**
	 * Checks if the choice entered by the user is valid .
	 * 
	 * @param option
	 *            choice entered by the user
	 * @return true if choice is valid, else false
	 */
	private boolean isChoiceValid(String option) {
		if (option.matches("[1-6]"))// regex
			return true;
		else {
			System.out.println("\nInvalid choice!\n");
			return false;
		}
	}

}