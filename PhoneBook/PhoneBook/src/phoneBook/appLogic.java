package phoneBook;

import java.util.*;

public class appLogic extends People {
	private static int count = 2;// used like a pointer to keep track of peopleMaxarr
	private static People p1 = new People("123 School Rd.", "Boston", "MA", 12345, "1231231234", "Brian Winters",
			"Brian", "Winters", "");
	private static People p2 = new People("5799 Washington St.", "Austin", "TX", 15347, "5453337898", "Dan Rogers",
			"Dan", "Rogers", "Ryan");
	private static People p3 = new People("454 Utah Lake Rd.", "Salt Lake City", "UT", 84678, "8015573241",
			"Kyle Jake West", "Kyle", "West", "Jake");
	private static People p4 = new People();
	private static People p5 = new People();
	private static People p6 = new People();
	private static People p7 = new People();
	private static People p8 = new People();
	private static People p9 = new People();
	private static People p10 = new People();
	private static People nullPeople = new People();// used to reset a person object back to null
	private static People[] peopleMaxArr = { p1, p2, p3, p4, p5, p6, p7, p8, p9, p10 };// max size of phone book

	private static void addEntry(People newEntry) {

		count++;
		peopleMaxArr[count] = newEntry;
	}

	public static void printPhoneBook() {
		if (count <= -1) {
			System.out.println("The phonebook is empty, let's go back to the Menu.");
			MainMenu.menu();
		} else {
			People[] filledEntries = new People[count + 1];
			for (int i = 0; i < filledEntries.length; i++) {
				filledEntries[i] = peopleMaxArr[i];
			}
			for (int i = 1; i < filledEntries.length; i++) {
				if (filledEntries[i - 1].getFullName().compareTo(filledEntries[i].getFullName()) > 0) {
					People temp = filledEntries[i - 1];
					filledEntries[i - 1] = filledEntries[i];
					filledEntries[i] = temp;
				}
			}

			for (int i = 0; i < filledEntries.length; i++) {
				System.out.println(i + 1 + ". " + filledEntries[i].toString());
			}
			System.out.println("******************************");
			int inputSelection;
			Scanner scanner = new Scanner(System.in);
			System.out.println("What would you like to do next?");
			System.out.println("Press 1. to return to the main menu.");
			System.out.println("Press 2. to exit.");
			System.out.println("*******************************");
			boolean doWhile = true;
			do {
				try {
					inputSelection = scanner.nextInt();
					scanner.nextLine();
					switch (inputSelection) {
					case 1: {
						MainMenu.menu();
						scanner.next();
						doWhile = false;
						break;
					}
					case 2: {

						System.out.println("Goodbye.");
						doWhile = false;
						System.exit(0);
					}
					default: {
						System.out.println("Please enter 1. or 2.");
						System.out.println();
						scanner.next();
					}
					}

				} catch (InputMismatchException e) {
					System.out.println("Please enter 1. or 2.");
					System.out.println();
					scanner.next();
				}
			} while (doWhile);
		}
	}

	public static void deleteEntry() {
		if (count < 0) {
			System.out.println("There are no more entrys to delete. Lets go back to the main menu. ");
			System.out.println();
			MainMenu.menu();
		}
		int inputSelection;
		Scanner deleteEntryScanner = new Scanner(System.in);
		System.out.println("Type phone number of the entry you would like to delete.");
		for (int i = 0; i <= count; i++) {
			System.out.println(i + 1 + ". " + peopleMaxArr[i].toString());
		}
		try {
			inputSelection = deleteEntryScanner.nextInt() - 1;
			if (inputSelection > count) {
				System.out.println("Error please enter a number between 1 and" + (count + 1));
				deleteEntry();
			} else {
				peopleMaxArr[inputSelection] = getNullPeople();
				count--;
				for (int i = inputSelection; i <= count; i++) {
					peopleMaxArr[i] = peopleMaxArr[i + 1];
				}
			}

		} catch (InputMismatchException e) {
			System.out.println("Error please enter a number between 1 and" + (count + 1));
			deleteEntryScanner.next();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error please enter a number between 1 and" + (count + 1));
			deleteEntryScanner.next();
		}
		System.out.println("The remaining Entries are. ");
		for (int i = 0; i <= count; i++) {
			System.out.println(i + 1 + ". " + peopleMaxArr[i].toString());
		}

		System.out.println("What would you like to do next?");
		System.out.println("Press 1. to delete another entry");
		System.out.println("Press 2. to return to the main menu.");
		System.out.println("Press 3. to exit.");
		boolean doWhile = true;
		do {
			try {
				inputSelection = deleteEntryScanner.nextInt();
				deleteEntryScanner.nextLine();
				switch (inputSelection) {
				case 1: {
					deleteEntry();
					deleteEntryScanner.next();
					doWhile = false;
					break;
				}
				case 2: {
					MainMenu.menu();
					deleteEntryScanner.next();
					doWhile = false;
					break;
				}
				case 3: {
					System.out.println("Goodbye.");
					doWhile = false;
					// deleteEntryScanner.close();
					System.exit(0);
				}
				default: {
					System.out.println("Please enter a number 1-3");
					deleteEntryScanner.next();
				}
				}

			} catch (InputMismatchException e) {
				System.out.println("Please enter a number 1-3");
				deleteEntryScanner.next();
			}
		} while (doWhile);

	}

	public static void updateRecord() {

		Scanner updateScanner = new Scanner(System.in);
		System.out.println("Please enter the phone number that belongs to the entry you would like to edit.");
		String pNum = updateScanner.next();
		updateScanner.nextLine();
		int index = 100;
		for (int i = 0; i <= count; i++) {
			if (peopleMaxArr[i].getPhoneNumber().equals(pNum)) {
				index = i;
			}
		}
		boolean doWhile = true;
		int conditionalInt = 0;
		if (index == 100) {
			do {
				try {
					System.out.println("A entry with " + pNum + " Doesn't exsit. Press 1. to search again. "
							+ "Press 2. to return to Main Menu.");
					conditionalInt = updateScanner.nextInt();
					updateScanner.nextLine();
					if (conditionalInt == 1) {
						phoneNumSearch();
						doWhile = false;
					} else if (conditionalInt == 2) {
						MainMenu.menu();
						doWhile = false;
					}
				} catch (InputMismatchException e) {

					System.out.println("Error: Please enter a 1 or a 2. ");
					updateScanner.next();
				}
			} while (doWhile);

		} else {
			System.out.println(peopleMaxArr[index].toString());

		}

		System.out.println("Is this the record you want to edit?");
		System.out.println("Press 1. to seach by phone number again");
		System.out.println("Press 2. to edit the phone number beloning to this entry.");
		System.out.println("Press 3. to edit the name beloning to this entry.");
		System.out.println("Press 4. to edit the Address beloning to this entry.");
		System.out.println("Press 5. to return to the main menu.");
		System.out.println("Press 6. to exit.");
		String newNumber = "";
		int inputInt;
		doWhile = true;
		do {
			try {
				inputInt = updateScanner.nextInt();
				updateScanner.nextLine();
				switch (inputInt) {
				case 1: {
					updateRecord();
					updateScanner.next();
					doWhile = false;
					break;
				}
				case 2: {
					System.out.println(
							"Enter the new phone number for this entry. (do not use any spaces or special characters.)");
					newNumber = updateScanner.next();
					peopleMaxArr[index].setPhoneNumber(newNumber);
					System.out.println("The entry has been updated");
					MainMenu.menu();
					updateScanner.next();
					doWhile = false;
					break;
				}
				case 3: {
					System.out
							.println("Please enter the new full name belonging to this entry. ex.(first middle last)");
					String fullName = updateScanner.nextLine();
					String[] nameArr = fullName.split(" ", 0);
					peopleMaxArr[index].setFirstName(nameArr[0]);
					int nameArrLen = nameArr.length;
					peopleMaxArr[index].setLastName(nameArr[nameArrLen - 1]);
					String middleNames = "";
					if (nameArrLen > 2) {
						for (int i = 1; i < nameArrLen - 1; i++) {
							middleNames += nameArr[i];
							middleNames += " ";
						}
					} else {
						middleNames = "";
					}
					peopleMaxArr[index].setFullName(fullName);
					middleNames = middleNames.trim();
					peopleMaxArr[index].setMiddleName(middleNames);
					System.out.println("The entry has been updated.");
					MainMenu.menu();
					updateScanner.next();
					break;
				}
				case 4: {
					System.out.println("Please enter the new address is this format. Address, City, State, Zip");
					String userInput = updateScanner.nextLine();
					String inputArr[] = userInput.split(", ", 0);
					peopleMaxArr[index].setAddress(inputArr[0]);
					peopleMaxArr[index].setCity(inputArr[1]);
					peopleMaxArr[index].setState(inputArr[2]);
					int zip = Integer.parseInt(inputArr[3]);
					peopleMaxArr[index].setZip(zip);
					System.out.println("The entry has been updated.");
					MainMenu.menu();
					updateScanner.next();
					break;
				}
				case 5: {
					MainMenu.menu();
					updateScanner.next();
					doWhile = false;
					break;
				}
				case 6: {
					System.out.println("Goodbye.");
					doWhile = false;
					updateScanner.close();
					System.exit(0);
				}
				default: {
					System.out.println("Please enter a number 1-4");
					updateScanner.next();
				}
				}

			} catch (InputMismatchException e) {
				System.out.println("Please enter a number 1-4");
				updateScanner.next();
			}
		} while (doWhile);

	}

	public static People getNullPeople() {

		return nullPeople;
	}

	public static void newEntry() {
		Scanner entryScanner = new Scanner(System.in);
		People addedPerson = new People();
		System.out.println("Please enter the new entry in this format: First Middle Last, "
				+ "Address, City, State (Abbreviated format), Zip, Phone Number");
		try {
			String userInput = entryScanner.nextLine();
			String inputArr[] = userInput.split(", ", 0);
			String fullName = inputArr[0];

			String[] nameArr = fullName.split(" ", 0);
			addedPerson.setFirstName(nameArr[0]);
			int nameArrLen = nameArr.length;
			addedPerson.setLastName(nameArr[nameArrLen - 1]);
			String middleNames = "";
			if (nameArrLen > 2) {
				for (int i = 1; i < nameArrLen - 1; i++) {
					middleNames += nameArr[i];
					middleNames += " ";
				}
			} else {
				middleNames = "";
			}
			addedPerson.setFullName(fullName);
			middleNames = middleNames.trim();
			addedPerson.setMiddleName(middleNames);
			addedPerson.setAddress(inputArr[1]);
			addedPerson.setCity(inputArr[2]);
			addedPerson.setState(inputArr[3]);
			int zip = Integer.parseInt(inputArr[4]);
			addedPerson.setZip(zip);
			String pNumber = inputArr[5];

			addedPerson.setPhoneNumber(pNumber);
			addEntry(addedPerson);
			System.out.println("Thank you. The entry has been added.");
			MainMenu.menu();
		} catch (NumberFormatException e) {
			System.out.println("Input format error: Check your input for missing spaces or commas.");
			System.out.println("Remember to use Abbreviated State format.");
			System.out.println("****************************************");	
			
			newEntry(); 
			}

		// entryScanner.close();
	}

	public static void phoneNumSearch() {
		Scanner phoneSearchScanner = new Scanner(System.in);
		System.out.println("Please enter the number you would like to search for.");
		String pNum = phoneSearchScanner.next();
		int index = 100;
		for (int i = 0; i <= count; i++) {
			if (peopleMaxArr[i].getPhoneNumber().equals(pNum)) {
				index = i;
			}
		}
		boolean doWhile = true;
		int conditionalInt = 0;
		if (index == 100) {
			do {
				try {
					System.out.println("A entry with " + pNum + " Doesn't exsit. Press 1. to search again. "
							+ "Press 2. to return to Main Menu.");
					conditionalInt = phoneSearchScanner.nextInt();
					phoneSearchScanner.nextLine();
					if (conditionalInt == 1) {
						phoneNumSearch();
						doWhile = false;
					} else if (conditionalInt == 2) {
						MainMenu.menu();
						doWhile = false;
					}
				} catch (InputMismatchException e) {

					System.out.println("Error: Please enter a 1 or a 2. ");
					phoneSearchScanner.next();
				}
			} while (doWhile);

		} else {
			System.out.println(peopleMaxArr[index].toString());

		}
		System.out.println("What would you like to do next?");
		System.out.println("Press 1. to seach by phone number again");
		System.out.println("Press 2. to return to the main menu.");
		System.out.println("Press 3. to exit.");
		doWhile = true;
		do {
			try {
				conditionalInt = phoneSearchScanner.nextInt();
				phoneSearchScanner.nextLine();
				switch (conditionalInt) {
				case 1: {
					phoneNumSearch();
					phoneSearchScanner.next();
					doWhile = false;
					break;
				}
				case 2: {
					MainMenu.menu();
					phoneSearchScanner.next();
					doWhile = false;
					break;
				}
				case 3: {
					System.out.println("Goodbye.");
					doWhile = false;
					phoneSearchScanner.close();
					System.exit(0);
				}
				default: {
					System.out.println("Please enter a number 1-3");
					phoneSearchScanner.next();
				}
				}

			} catch (InputMismatchException e) {
				System.out.println("Please enter a number 1-3");
				phoneSearchScanner.next();
			}
		} while (doWhile);

	}

	public static void firstNameSearch() {
		Scanner firstNameScanner = new Scanner(System.in);
		System.out.println("Please enter the First name of the person you are searching for.");
		String fName = firstNameScanner.next();
		int index = 0;
		for (int i = 0; i <= count; i++) {
			if (peopleMaxArr[i].getFirstName().equalsIgnoreCase(fName)) {
				index++;
			}
		}
		int fNameCount = 0;
		People[] fNameArr = new People[index];
		for (int j = 0; j <= count; j++) {
			if (peopleMaxArr[j].getFirstName().equalsIgnoreCase(fName)) {
				fNameArr[fNameCount] = peopleMaxArr[j];
				fNameCount++;

			}
		}
		boolean doWhile = true;
		int inputInt = 0;
		if (index == 0) {
			do {
				try {
					System.out.println("A entry with the first name " + fName
							+ " Doesn't exsit. Press 1. to search again. " + "Press 2. to return to Main Menu.");
					inputInt = firstNameScanner.nextInt();
					firstNameScanner.nextLine();
					if (inputInt == 1) {
						firstNameSearch();
						doWhile = false;
					} else if (inputInt == 2) {
						MainMenu.menu();
						doWhile = false;
					}
				} catch (InputMismatchException e) {

					System.out.println("Error: Please enter a 1 or a 2. ");
					firstNameScanner.next();
				}
			} while (doWhile);

		} else {
			for (int i = 0; i < fNameArr.length; i++) {
				System.out.println(fNameArr[i].toString());
			}

		}
		System.out.println("What would you like to do next?");
		System.out.println("Press 1. to seach by first name again");
		System.out.println("Press 2. to return to the main menu.");
		System.out.println("Press 3. to exit.");
		doWhile = true;
		do {
			try {
				inputInt = firstNameScanner.nextInt();
				firstNameScanner.nextLine();
				switch (inputInt) {
				case 1: {
					firstNameSearch();
					firstNameScanner.next();
					doWhile = false;
					break;
				}
				case 2: {
					MainMenu.menu();
					firstNameScanner.next();
					doWhile = false;
					break;
				}
				case 3: {
					System.out.println("Goodbye.");
					doWhile = false;
					firstNameScanner.close();
					System.exit(0);
				}
				default: {
					System.out.println("Please enter a number 1-3");
					firstNameScanner.next();
				}
				}

			} catch (InputMismatchException e) {
				System.out.println("Please enter a number 1-3");
				firstNameScanner.next();
			}
		} while (doWhile);

	}

	public static void lastNameSearch() {
		Scanner lastNameScanner = new Scanner(System.in);
		System.out.println("Please enter the Last name of the person you are searching for.");
		String lName = lastNameScanner.next();
		int index = 0;
		for (int i = 0; i <= count; i++) {
			if (peopleMaxArr[i].getLastName().equalsIgnoreCase(lName)) {
				index++;
			}
		}
		int lNameCount = 0;
		People[] lNameArr = new People[index];
		for (int j = 0; j <= count; j++) {
			if (peopleMaxArr[j].getLastName().equalsIgnoreCase(lName)) {
				lNameArr[lNameCount] = peopleMaxArr[j];
				lNameCount++;

			}
		}
		boolean doWhile = true;
		int inputInt = 0;
		if (index == 0) {
			do {
				try {
					System.out.println("A entry with the last name " + lName
							+ " Doesn't exsit. Press 1. to search again. " + "Press 2. to return to Main Menu.");
					inputInt = lastNameScanner.nextInt();
					lastNameScanner.nextLine();
					if (inputInt == 1) {
						lastNameSearch();
						doWhile = false;
					} else if (inputInt == 2) {
						MainMenu.menu();
						doWhile = false;
					}
				} catch (InputMismatchException e) {

					System.out.println("Error: Please enter a 1 or a 2. ");
					lastNameScanner.next();
				}
			} while (doWhile);

		} else {
			for (int i = 0; i < lNameArr.length; i++) {
				System.out.println(lNameArr[i].toString());
			}

		}
		System.out.println("What would you like to do next?");
		System.out.println("Press 1. to seach by last name again");
		System.out.println("Press 2. to return to the main menu.");
		System.out.println("Press 3. to exit.");
		doWhile = true;
		do {
			try {
				inputInt = lastNameScanner.nextInt();
				lastNameScanner.nextLine();
				switch (inputInt) {
				case 1: {
					lastNameSearch();
					lastNameScanner.next();
					doWhile = false;
					break;
				}
				case 2: {
					MainMenu.menu();
					lastNameScanner.next();
					doWhile = false;
					break;
				}
				case 3: {
					System.out.println("Goodbye.");
					doWhile = false;
					lastNameScanner.close();
					System.exit(0);
				}
				default: {
					System.out.println("Please enter a number 1-3");
					lastNameScanner.next();
				}
				}

			} catch (InputMismatchException e) {
				System.out.println("Please enter a number 1-3");
				lastNameScanner.next();
			}
		} while (doWhile);

	}

	public static void fullNameSearch() {
		Scanner fullNameScanner = new Scanner(System.in);
		System.out.println("Please enter the Full name of the person you are searching for.");
		String fullName = fullNameScanner.nextLine();
		int index = 0;
		for (int i = 0; i <= count; i++) {
			if (peopleMaxArr[i].getFullName().equalsIgnoreCase(fullName)) {
				index++;
			}
		}

		int fullNameCount = 0;
		People[] fullNameArr = new People[index];
		for (int j = 0; j <= count; j++) {
			if (peopleMaxArr[j].getFullName().equalsIgnoreCase(fullName)) {
				fullNameArr[fullNameCount] = peopleMaxArr[j];
				fullNameCount++;

			}
		}
		boolean doWhile = true;
		int inputInt = 0;
		if (index == 0) {
			do {
				try {
					System.out.println("A entry with the full name " + fullName
							+ " Doesn't exsit. Press 1. to search again. " + "Press 2. to return to Main Menu.");
					inputInt = fullNameScanner.nextInt();
					fullNameScanner.nextLine();
					if (inputInt == 1) {
						fullNameSearch();
						doWhile = false;
					} else if (inputInt == 2) {
						MainMenu.menu();
						doWhile = false;
					}
				} catch (InputMismatchException e) {

					System.out.println("Error: Please enter a 1 or a 2. ");
					fullNameScanner.next();
				}
			} while (doWhile);

		} else {
			for (int i = 0; i < fullNameArr.length; i++) {
				System.out.println(fullNameArr[i].toString());
			}

		}
		System.out.println("What would you like to do next?");
		System.out.println("Press 1. to seach by full name again");
		System.out.println("Press 2. to return to the main menu.");
		System.out.println("Press 3. to exit.");
		doWhile = true;
		do {
			try {
				inputInt = fullNameScanner.nextInt();
				fullNameScanner.nextLine();
				switch (inputInt) {
				case 1: {
					fullNameSearch();
					fullNameScanner.next();
					doWhile = false;
					break;
				}
				case 2: {
					MainMenu.menu();
					fullNameScanner.next();
					doWhile = false;
					break;
				}
				case 3: {
					System.out.println("Goodbye.");
					doWhile = false;
					fullNameScanner.close();
					System.exit(0);
				}
				default: {
					System.out.println("Please enter a number 1-3");
					fullNameScanner.next();
				}
				}

			} catch (InputMismatchException e) {
				System.out.println("Please enter a number 1-3");
				fullNameScanner.next();
			}
		} while (doWhile);

	}

	public static void stateSearch() {
		Scanner stateScanner = new Scanner(System.in);
		System.out.println("Please enter the State you would like to search in.");
		String state = stateScanner.next();
		int index = 0;
		for (int i = 0; i <= count; i++) {
			if (peopleMaxArr[i].getState().equalsIgnoreCase(state)) {
				index++;
			}
		}

		int stateCount = 0;
		People[] stateArr = new People[index];
		for (int j = 0; j <= count; j++) {
			if (peopleMaxArr[j].getState().equalsIgnoreCase(state)) {
				stateArr[stateCount] = peopleMaxArr[j];
				stateCount++;

			}
		}
		boolean doWhile = true;
		int inputInt = 0;
		if (index == 0) {
			do {
				try {
					System.out.println("A entry in " + state + " Doesn't exsit. Press 1. to search again. "
							+ "Press 2. to return to Main Menu.");
					inputInt = stateScanner.nextInt();
					stateScanner.nextLine();
					if (inputInt == 1) {
						stateSearch();
						doWhile = false;
					} else if (inputInt == 2) {
						MainMenu.menu();
						doWhile = false;
					}
				} catch (InputMismatchException e) {

					System.out.println("Error: Please enter a 1 or a 2. ");
					stateScanner.next();
				}
			} while (doWhile);

		} else {
			for (int i = 0; i < stateArr.length; i++) {
				System.out.println(stateArr[i].toString());
			}

		}
		System.out.println("What would you like to do next?");
		System.out.println("Press 1. to seach by state again");
		System.out.println("Press 2. to return to the main menu.");
		System.out.println("Press 3. to exit.");
		doWhile = true;
		do {
			try {
				inputInt = stateScanner.nextInt();
				stateScanner.nextLine();
				switch (inputInt) {
				case 1: {
					stateSearch();
					stateScanner.next();
					doWhile = false;
					break;
				}
				case 2: {
					MainMenu.menu();
					stateScanner.next();
					doWhile = false;
					break;
				}
				case 3: {
					System.out.println("Goodbye.");
					doWhile = false;
					stateScanner.close();
					System.exit(0);
				}
				default: {
					System.out.println("Please enter a number 1-3");
					stateScanner.next();
				}
				}

			} catch (InputMismatchException e) {
				System.out.println("Please enter a number 1-3");
				stateScanner.next();
			}
		} while (doWhile);

	}

	public static void citySearch() {
		Scanner cityScanner = new Scanner(System.in);
		System.out.println("Please enter the city you would like to search in.");
		String city = cityScanner.nextLine();
		int index = 0;
		for (int i = 0; i <= count; i++) {
			if (peopleMaxArr[i].getCity().equalsIgnoreCase(city)) {
				index++;
			}
		}

		int cityCount = 0;
		People[] cityArr = new People[index];
		for (int j = 0; j <= count; j++) {
			if (peopleMaxArr[j].getCity().equalsIgnoreCase(city)) {
				cityArr[cityCount] = peopleMaxArr[j];
				cityCount++;

			}
		}
		boolean doWhile = true;
		int inputInt = 0;
		if (index == 0) {
			do {
				try {
					System.out.println("A entry in " + city + " Doesn't exsit. Press 1. to search again. "
							+ "Press 2. to return to Main Menu.");
					inputInt = cityScanner.nextInt();
					cityScanner.nextLine();
					if (inputInt == 1) {
						citySearch();
						doWhile = false;
					} else if (inputInt == 2) {
						MainMenu.menu();
						doWhile = false;
					}
				} catch (InputMismatchException e) {

					System.out.println("Error: Please enter a 1 or a 2. ");
					cityScanner.next();
				}
			} while (doWhile);

		} else {
			for (int i = 0; i < cityArr.length; i++) {
				System.out.println(cityArr[i].toString());
			}

		}
		System.out.println("What would you like to do next?");
		System.out.println("Press 1. to seach by city again");
		System.out.println("Press 2. to return to the main menu.");
		System.out.println("Press 3. to exit.");
		doWhile = true;
		do {
			try {
				inputInt = cityScanner.nextInt();
				cityScanner.nextLine();
				switch (inputInt) {
				case 1: {
					citySearch();
					cityScanner.next();
					doWhile = false;
					break;
				}
				case 2: {
					MainMenu.menu();
					cityScanner.next();
					doWhile = false;
					break;
				}
				case 3: {
					System.out.println("Goodbye.");
					doWhile = false;
					cityScanner.close();
					System.exit(0);
				}
				default: {
					System.out.println("Please enter a number 1-3");
					cityScanner.next();
				}
				}

			} catch (InputMismatchException e) {
				System.out.println("Please enter a number 1-3");
				cityScanner.next();
			}
		} while (doWhile);

	}

	public static People getP1() {
		return p1;
	}

	public static void setP1(People p1) {
		appLogic.p1 = p1;
	}

	public static People getP2() {
		return p2;
	}

	public static void setP2(People p2) {
		appLogic.p2 = p2;
	}

	public static People getP3() {
		return p3;
	}

	public static void setP3(People p3) {
		appLogic.p3 = p3;
	}

	public static People getP4() {
		return p4;
	}

	public static void setP4(People p4) {
		appLogic.p4 = p4;
	}

	public static People getP5() {
		return p5;
	}

	public static void setP5(People p5) {
		appLogic.p5 = p5;
	}

	public static People getP6() {
		return p6;
	}

	public static void setP6(People p6) {
		appLogic.p6 = p6;
	}

	public static People getP7() {
		return p7;
	}

	public static void setP7(People p7) {
		appLogic.p7 = p7;
	}

	public static People getP8() {
		return p8;
	}

	public static void setP8(People p8) {
		appLogic.p8 = p8;
	}

	public static People getP9() {
		return p9;
	}

	public static void setP9(People p9) {
		appLogic.p9 = p9;
	}

	public static People getP10() {
		return p10;
	}

	public static void setP10(People p10) {
		appLogic.p10 = p10;
	}

	public static People[] getPeopleMaxArr() {
		return peopleMaxArr;
	}

	public static void setPeopleMaxArr(People[] peopleMaxArr) {
		appLogic.peopleMaxArr = peopleMaxArr;
	}
}
