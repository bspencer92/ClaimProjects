package lab003;

import java.util.Scanner;

public class Lab003Q1 {

	public static void main(String[] args) {
		// Write a method to remove a given character form a string. Eg. remove all 'Aa' from 
		//Averange should re turn vernge 
		System.out.println("Please enter a word to modify");
		Scanner scanner = new Scanner(System.in); 
		String vernge = scanner.next();
		System.out.println("Enter a letter to remove");
		String remove = scanner.next(); 
		remove.toLowerCase(); 
		System.out.println(removeChar(vernge, remove)); 
		

	}
	
	public static String removeChar (String vernge, String remove) {
		vernge.toLowerCase(); 
		vernge = vernge.replace(remove, ""); 
		 
		
		return vernge; 
	}

}
