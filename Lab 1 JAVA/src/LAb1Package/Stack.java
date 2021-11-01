package LAb1Package;

public class Stack {
	//declare our array of characters that we will be working with
	private char[] charArray;
	
	/**
	 * constructor that builds our stack object using the char array passed to it
	 * @param charArray an array passed into our constructor to be copied into our array
	 */
	public Stack(char[] charArray){
			this.charArray = charArray;
	}
	
	/**
	 * check if array is empty (important for pop function because we don's want to attempt
	 * removing an array element that isn't there)
	 * @return returns true or false if empty, or not empty
	 */
	public boolean isEmpty() {		
		return (charArray.length == 0);	
	}
	
	/**
	 * take input character, create new array of size 1 larger than our original array and add 
	 * the character to the end of array
	 * @param newElement is the new character to be pushed into the end of our array
	 */
	public void push(char newElement) {	
		char[] tempArray = new char[charArray.length + 1];
		System.arraycopy(charArray, 0, tempArray, 0, charArray.length);	
		tempArray[tempArray.length -1] = newElement;
		charArray = tempArray;	
	}
	
	/**
	 * check if array is empty, if not then remove the last element from it and return that element
	 * for later use
	 * @return returns our popped character or empty character
	 */
	public char pop() {
		if(!isEmpty()) {
			char tempChar = charArray[charArray.length -1];
			char[] tempArray = new char[charArray.length - 1];
			System.arraycopy(charArray, 0, tempArray, 0, charArray.length - 1);	
			charArray = tempArray;
			return tempChar;		
		}
		else {
			return '\u0000';
		}
	}
	
	/**
	 * gets our array and returns it
	 * @return returns our array 
	 */
	public char[] getArray() {	
		return charArray;
	}	
}


