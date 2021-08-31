package lab003;

public class Lab003Q3 {

	public static void main(String[] args) {
		//
		String java = "This is fun"; 
		System.out.println("The number of consonants is: " + countConsonants(java) +" The number of vowels is: " + countVowels(java));

	}
	
	public static int countConsonants (String myString) {
		int numConsonants = 0; 
		String consonants = "bcdfghjklmnpqrstvwxz";
		 
		for(int i = 0; i < myString.length(); i++) {
			for(int j = 0; j < consonants.length(); j++) {
				if(myString.charAt(i) == consonants.charAt(j)){
					numConsonants++; 
				}
			}
		}
		return numConsonants; 
	}
	
	public static int countVowels (String myString) {
		int numVowels = 0; 
		String vowels = "aeiouy";
		 
		for(int i = 0; i < myString.length(); i++) {
			for(int j = 0; j < vowels.length(); j++) {
				if(myString.charAt(i) == vowels.charAt(j)){
					numVowels++; 
				}
			}
		}
		return numVowels; 
	}

}
