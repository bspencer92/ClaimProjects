package phoneBook;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenu {
 
	public static void main(String[] args) {
		menu();

	}

	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		int switchInt = 0;
		System.out.println("*********Main Menu*********");
		System.out.println("Press 1. to search for an exsisting entry");
		System.out.println("Press 2. to to remove an exsisting entry");
		System.out.println("Press 3. update an exsisting entry");
		System.out.println("Press 4. create a new entry");
		System.out.println("Press 5. to see all exsisting entries");
		System.out.println("Press 6. to exit.");
		try {

			switchInt = scanner.nextInt();
			scanner.nextLine();
			switch (switchInt) {
			case 1: {
				searchMenu();
				scanner.next();
				break;
			}
			case 2: {
				appLogic.deleteEntry();
				scanner.next();
				break;
			}
			case 3: {
				appLogic.updateRecord();
				break;
			}
			case 4: {
				appLogic.newEntry();
				scanner.next();
				break;
			}
			case 5: {
				appLogic.printPhoneBook();
				break;
			}
			case 6: {
				System.out.println("Goodbye");
				System.exit(0); 
			}
			default: {
				System.out.println("Error Please enter a number 1-6");
				menu();
				scanner.next();
				break; 
			}
			}
		} catch (InputMismatchException e) {

			System.out.println("Error Please enter a number 1-6");
			scanner.next();
			menu();
		}

	}

	public static void searchMenu() {
		Scanner searchMenuScanner = new Scanner(System.in);
		System.out.println("How would you like to search");
		System.out.println("Press 1. to search by first name.");
		System.out.println("Press 2. to search by last name.");
		System.out.println("Press 3. to search by full name.");
		System.out.println("Press 4. to search by phone number.");
		System.out.println("Press 5. to search by city.");
		System.out.println("Press 6. to search by state.");
		System.out.println("Press 7. to return to the Main Menu.");
		try {
			int switchInt = searchMenuScanner.nextInt();
			searchMenuScanner.nextLine();
			switch (switchInt) {
			case 1: {
				appLogic.firstNameSearch();
				searchMenuScanner.next();
				break;
			}
			case 2: {
				appLogic.lastNameSearch();
				searchMenuScanner.next();
				break;

			}
			case 3: {
				appLogic.fullNameSearch();
				searchMenuScanner.next();
				break;
			}
			case 4: {
				appLogic.phoneNumSearch();
				searchMenuScanner.next();
				break;
			}
			case 5: {
				appLogic.citySearch();
				searchMenuScanner.next();
				break;
			}
			case 6: {
				appLogic.stateSearch();
				searchMenuScanner.next();
				break;
			}
			case 7: {
				menu();
				searchMenuScanner.next();
				break;
			}
			case 8: {
				System.out.println("Goodbye.");
				searchMenuScanner.close();
				System.exit(0);
			}
			default: {
				System.out.println("Error Please enter a number 1-8 ");
				searchMenu();
				searchMenuScanner.next();
				break;
			}
			}
		} catch (InputMismatchException e) {

			System.out.println("Error Please enter a number 1-7 or type ");
			searchMenuScanner.next();
			searchMenu();
		}
	}
}
