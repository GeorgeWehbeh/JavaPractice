package LAb1Package;


public class PalindromeChecker {
	
	public static void main(String[] args) {
		
		//copy our argument into a character array and create a second empty character array
		char[] palindromeCheck = args[0].toCharArray();
		char[] backwardPalindrome = new char[0];
		//temporary character to store our 'popped' element
		char tempChar = ' ';
		
		//create 2 instances of stack, one for the original word one for the word we will 
		//reconstruct backwards
		Stack a = new Stack(palindromeCheck) ; 
		Stack b = new Stack(backwardPalindrome) ; 
	
		//loop through array pop an element from array a and push it into array b reconstructing
		//the array backwards
		for(int i = 0; i < palindromeCheck.length; i++) {
		tempChar = a.pop();
		b.push(tempChar);
		
		}
		
		//save our backwards array using stack b
		backwardPalindrome = b.getArray();
		
		
		//outputs used for checking
		System.out.println(backwardPalindrome);
		System.out.println(palindromeCheck);
		
		
		//loop through our palindromeCheck and compare each element against our backwardsPalindrome
		//if both are equal than our original word was in fact a palindrome
		for(int i = 0; i < palindromeCheck.length; i++ ) 		
		if(palindromeCheck[i] != backwardPalindrome[i]) {
			System.out.println("Not a palindrome");
			i = palindromeCheck.length;
		}
		else if(palindromeCheck[i] == backwardPalindrome[i] && i == palindromeCheck.length -1) {
			
			System.out.println("Is a palindrome");

		}
	}	
}
