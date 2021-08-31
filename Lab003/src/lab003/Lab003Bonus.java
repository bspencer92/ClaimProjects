package lab003;

import java.util.Scanner;

public class Lab003Bonus {

	public static void main(String[] args) {
		// : Make me a big, beautiful Menu, using a Switch Case and a Do While
		// loop that will allow me to access each method, depending on the number
		// selected.
		/// Allow for the program to repeat and quit when requested
		menu();

	}

	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		boolean doWhile = true;
		int userSelection = 0;
		do {
			try {
				System.out.println("*******Select your favorite leisure activity to recieve a recommendatoin*********");
				System.out.println("Press 1) For reading \nPress 2) For Movies \nPress 3) For video games");
				userSelection = scanner.nextInt();
				switch (userSelection) {
				case 1:
					System.out.println("I recommend The Black Tower series by Stephen King.\n");
					break;
				case 2:
					System.out.println("I recommend The Lord of The Rings Trilogy Directed by Peter Jackson.\n");
					break;
				case 3:
					System.out.println("I recommend Total War: Warhammer 2 from Creative Assembly.\n");
					break;
				default:
					System.out.println("Error: Please enter a number 1-3\n");
					break;

				}
				System.out.println("Would you like to recieve another recommendation?\nY) for yes\nN) for no.\n");
				char endLoop = scanner.next().charAt(0);
				if (endLoop == 'n' || endLoop == 'N') {
					System.out.println("Goodbye!");
					doWhile = false;
				}

			} catch (Exception e) {
				System.out.println("Error: Incorrect input.\n");
				scanner.next();
			}

		} while (doWhile);

	}
}
