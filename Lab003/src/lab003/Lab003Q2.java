package lab003;

public class Lab003Q2 {

	public static void main(String[] args) {
		String duplicateLetters = "jojojotototot"; 
		// Write a method to remove duplicate characters from a string.
		System.out.println(removeDuplicates(duplicateLetters));

	}

	public static StringBuilder removeDuplicates(String duplicateLetters) {
		StringBuilder sb = new StringBuilder(duplicateLetters); 
		for (int i = 0; i <sb.length(); i++) {
			for (int a = 0; a < sb.length(); a++) {
				if (sb.charAt(i) == sb.charAt(a) && i!=a) {
					sb.deleteCharAt(a); 
				}
			}

		}
		  
		return sb;
	}

}
