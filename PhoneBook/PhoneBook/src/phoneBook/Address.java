package phoneBook;

public class Address {
	private String address;
	private String city;
	private String state;
	private int zip;
	private String phoneNumber;

	public Address() {
	}

	public String getAddress() {
		return address;
	}

	public Address(String address, String city, String state, int zip, String phoneNumber) {

		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getFmtPhoneNumber() {
		String pNum;
		java.text.MessageFormat phoneNum = new java.text.MessageFormat("({0})-{1}-{2}");
		String[] phoneNumArr = { phoneNumber.substring(0, 3), phoneNumber.substring(3, 6), phoneNumber.substring(6) };
		pNum = phoneNum.format(phoneNumArr);
		return pNum;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
