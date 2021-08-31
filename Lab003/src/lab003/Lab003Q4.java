package lab003;

public class Lab003Q4 {

	public static void main(String[] args) {
		/*
		 * 4. Write a program to display first non repeated character of a string then
		 * the repeating characters. E.g. input morning should display morignn.
		 */
		String myString = "Mississippi";
		System.out.println(sortRepeatingChars(myString));

	}

	public static String sortRepeatingChars(String myString) {
		myString = myString.toLowerCase(); 
		String repeating = ""; 
		char[] charArray = myString.toCharArray(); 
		for (int i = 0; i < myString.length(); i++) {
			System.out.println("i is at" + i);
			for (int j = 0; j<i; j++) {
				System.out.println("j is at" + j);
				if (myString.charAt(i) == charArray[j]) {
					repeating += myString.charAt(j);
					repeating += myString.charAt(i);
					charArray[j] = '0';
					charArray[i] = '0';

				}
			}
		}
		//System.out.println(charArray);
		String lastString = new String(charArray); 
		//System.out.println(lastString);
		lastString = lastString.replace("0", ""); 
		lastString += repeating;
		return lastString;
	}

}
