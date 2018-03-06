/**
 * Represents a Contact that implements Comparable to facilitate sorting.
 * 
 *
 */
public class Contact implements Comparable<Contact> {
	private String name;
	private String phoneNumber;
	private String email;
	private String address;

	/**
	 * Creates a contact object and initializes it.
	 * 
	 * @param name
	 *            Name of the contact
	 * @param phoneNumber
	 *            PhoneNumber of the contact
	 * @param email
	 *            Email of the contact
	 * @param address
	 *            Address of the contact
	 */
	public Contact(String name, String phoneNumber, String email, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	/**
	 * Retrieves the name of a contact.
	 * 
	 * @return the name of the contact
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the contact.
	 * 
	 * @param name
	 *            new name of the contact
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the phonenumber of a contact.
	 * 
	 * @return the phonenumber of the contact
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Changes the phone number of the contact.
	 * 
	 * @param phoneNumber
	 *            new phone number of the contact
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Retrieves the email of the contact.
	 * 
	 * @return the email of the contact
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Changes the email of the contact.
	 * 
	 * @param email
	 *            new email of the contact.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieves the address of the contact.
	 * 
	 * @return the address of the contact
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Changes the address of the contact.
	 * 
	 * @param address
	 *            the new address of the contact
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Prints a string representation of the contact object containing it's
	 * name,phonenumber,email and address.
	 */
	public String toString() {
		String contact = "\t\t--Name: " + this.getName() + "\n" + "\t\t  PhoneNumber: " + this.getPhoneNumber() + "\n"
				+ "\t\t  Email: " + this.getEmail() + "\n" + "\t\t  Address: " + this.getAddress() + "\n";
		return contact;
	}

	/**
	 * Implemented abstract method from Comparable interface that is used in sorting
	 * the contact objects based on their field, "name".
	 */
	public int compareTo(Contact other) {
		return name.compareTo(other.name);
	}

}
