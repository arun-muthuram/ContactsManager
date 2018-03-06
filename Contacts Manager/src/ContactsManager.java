import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Performs operations on the collection object containing contacts.
 */
public class ContactsManager {
	/**
	 * Collection object that stores the contact objects.
	 */
	ArrayList<Contact> contactsList = new ArrayList<Contact>();
	Scanner scanner = new Scanner(System.in);

	/**
	 * Performs one of the 6 operations based on the user input using a switch case.
	 */
	public void selectChoice() {
		UserInput userInput = new UserInput();
		int option;
		/**
		 * Infinite loop that continuously asks for userinput to perform operation on
		 * the contacts.
		 */
		while (true) {
			option = userInput.getUserInput();
			switch (option) {
			/**
			 * adds new contact to the contacts' list.
			 */
			case 1:
				addContact();
				break;
			/**
			 * Lists the contacts in the contacts' list.
			 */
			case 2:
				listContacts();
				break;
			/**
			 * Searches and Updates the fields of a contact object.
			 */
			case 3:
				updateContact();
				break;
			/**
			 * Searches and displays the details of a contact object.
			 */
			case 4:
				viewContact();
				break;
			/**
			 * Searches and deletes a contact object.
			 */
			case 5:
				deleteContact();
				break;
			/**
			 * Ends the while loop and terminates the program.
			 */
			case 6:
				System.out.println("Exiting...");
				System.exit(0);

			}
		}
	}

	/**
	 * Creates a new contact object, initializes it's fields using the data entered
	 * by the user and adds the contact object to the contacts' list
	 */
	private void addContact() {
		String name = "", phoneNumber = "", email = "", address = "";
		String choice = "";
		do {

			System.out.println("\nEnter the name of the contact");
			name = scanner.nextLine();
			System.out.println("Enter the phone number of the contact");
			while (true) {// validates the phone number.
				phoneNumber = scanner.nextLine();
				if (!phoneNumber.matches("[0-9]{10}"))
					System.out.println("please enter a valid 10 digit phonenumber");
				else
					break;
			}
			System.out.println("Enter the email of the contact");
			email = scanner.nextLine();
			System.out.println("Enter the address of the contact");
			address = scanner.nextLine();
			Contact newContact = new Contact(name, phoneNumber, email, address);
			contactsList.add(newContact);
			Collections.sort(contactsList);
			System.out.println("\n" + name + " successfully added to contacts!\n" + newContact
					+ "\nDo you want to add another contact? enter Y/N");
			choice = scanner.nextLine().toUpperCase();
		} while (choice.equals("Y"));
	}

	/**
	 * Lists and displays the details of all the contacts in the contacts' list.
	 */
	private void listContacts() {
		if (contactsList.isEmpty())
			System.out.println("\nNo contacts available.");
		for (Contact x : contactsList)
			System.out.println(x);
	}

	/**
	 * Updates one or more fields of a contact object.
	 */
	private void updateContact() {
		if (contactsList.isEmpty()) {
			System.out.println("\nNo contacts available.");
			return;
		}
		String choice = "";
		Contact updateContact = findContact();// Performs search operation.
		System.out.println(updateContact.getName() + " selected");
		while (true) {
			System.out.println("\nchoose a field to update contact:" + updateContact.getName() + " \n"
					+ "1 - Name\n2 - PhoneNumber\n3 - Email\n4 - Address");
			choice = scanner.nextLine();
			switch (choice) {
			case "1":
				System.out.println("Enter the new name");
				updateContact.setName(scanner.nextLine());
				System.out.println("Name Updated-" + updateContact.getName());
				break;
			case "2":
				System.out.println("Enter the new phone number");
				updateContact.setPhoneNumber(scanner.nextLine());
				System.out.println("Phone number updated-" + updateContact.getPhoneNumber());
				break;
			case "3":
				System.out.println("Enter the new email");
				updateContact.setEmail(scanner.nextLine());
				System.out.println("email updated-" + updateContact.getEmail());
				break;
			case "4":
				System.out.println("Enter the new address");
				updateContact.setAddress(scanner.nextLine());
				System.out.println("Address updated-" + updateContact.getAddress());
				break;
			default:
				System.out.println("Invalid choice");
				continue;
			}
			System.out.println("Do you want to update another field? Y/N");
			if (!scanner.nextLine().toUpperCase().equals("Y")) {
				System.out.println("Contact " + updateContact.getName() + " updated successfully\n" + updateContact);
				break;
			}
		}
	}

	/**
	 * Displays the details of a contact object.
	 */
	private void viewContact() {
		if (contactsList.isEmpty()) {
			System.out.println("\nNo contacts available.");
			return;
		}
		System.out.println(findContact());// performs search operation
	}

	/**
	 * Deletes the contact object from the contacts' list.
	 */
	private void deleteContact() {
		if (contactsList.isEmpty()) {
			System.out.println("\nNo contacts available.");
			return;
		}
		Contact deleteContact = findContact();// performs search operation
		System.out.println("\n" + deleteContact.getName() + " Successfully deleted from contacts\nContacts List:");
		contactsList.remove(deleteContact);
		listContacts();
	}

	/**
	 * Checks if all characters present in the search term matches with the
	 * contact's name.
	 * 
	 * @param name
	 *            name of the contact
	 * @param searchTerm
	 *            search term entered by the user
	 * @return true if search term matches contact's name, else false
	 */
	private boolean searchTermMatcher(String name, String searchTerm) {
		name = name.toLowerCase();
		searchTerm = searchTerm.toLowerCase();
		HashSet<Character> nameCharList = new HashSet<Character>();
		HashSet<Character> searchTermCharList = new HashSet<Character>();
		/**
		 * adds each character in the name and search term to it's respective HashSet
		 * for matching the search term with contacts' names.
		 */
		for (int i = 0; i < name.length(); i++)
			nameCharList.add(new Character(name.charAt(i)));
		for (int i = 0; i < searchTerm.length(); i++)
			searchTermCharList.add(new Character(searchTerm.charAt(i)));
		if (nameCharList.containsAll(searchTermCharList))
			return true;
		else
			return false;
	}

	/**
	 * performs search operation and returns the object used in update, delete and
	 * view contact operations.
	 * 
	 * @return the contact object after searching
	 */
	private Contact findContact() {
		String searchTerm = "";// search term entered by the user
		String choice = "";
		int searchResultCount;// keeps track of number of search results.
		while (true) {
			searchResultCount = 0;
			System.out.println("\nEnter the search term for contact");
			searchTerm = scanner.nextLine();
			System.out.println("ID\tName");
			/**
			 * checks and matches every contact in contacts' list with search term
			 */
			for (Contact x : contactsList) {
				if (searchTermMatcher(x.getName(), searchTerm))// method for matching name and search term strings.
				{
					System.out.println(contactsList.indexOf(x) + "\t" + x.getName());// lists the contact objects
																						// matching the search term
																						// along with their ids
					searchResultCount++;// increments the searchResultCount for each matching result
				}
			}
			if (searchResultCount == 0) {
				System.out.println("\nNo match found!...search again");
				continue;// if no contact objects match search term, continues asking user to enter
							// search term
			}
			System.out.println("\nPlease enter the ID to select a contact or press Y to refine your search");
			choice = scanner.nextLine().toUpperCase();
			if (choice.equals("Y"))
				continue;// if the user wants to refine the search, a new search term can be entered
			else if (choice.matches("[^0-9]"))// checks if user input is not a number
			{
				System.out.println("\ninvalid input");
				continue;
			} // asks user to enter search term again if input by user is invalid.
			else if (Integer.parseInt(choice) < 0 || Integer.parseInt(choice) >= contactsList.size())// checks if the id
																										// entered by
																										// the user is a
																										// valid index
																										// in
																										// contactsList.
			{
				System.out.println("invalid id..please try again");
				continue;
			}
			break;// breaks out of infinite while loop when the user selects a contact object to
					// modify.

		}
		return contactsList.get(Integer.parseInt(choice));// contact object selected by user matching the search term.

	}

}
