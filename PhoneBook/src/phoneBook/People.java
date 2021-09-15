package phoneBook;

import java.util.*;

public class People extends Address {
	// Address address = new Address();
	private String firstName;
	private String lastName;
	private String middleName;
	private String fullName;

	public People(String address, String city, String state, int zip, String phoneNumber, String fullName,
			String firstName, String lastName, String middleName) {
		super(address, city, state, zip, phoneNumber);
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}

	// @Override
	public String toString() {
		return getFirstName() + " " + getMiddleName() + " " + getLastName() + ", " + getAddress() + ", " + getCity()
				+ ", " + getState() + ", " + getZip() + ", " + getFmtPhoneNumber();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public People() {
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;

	}

	public String getFullName() {
		return fullName;
	}

}
