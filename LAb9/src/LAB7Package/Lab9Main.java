package LAB7Package;
public class Lab9Main {
	
	public static void main(String[] args) {
	//Creates our shared account object to be accessed
	BankAccount account = new BankAccount();
		
	//Creates our 2 threads	
	Thread myThread = new PersonalAccount(1,2,3, account);
	Thread friendThread = new FriendAccount(0,0,0,account);
	
	//Runs our 2 threads
	myThread.start();
	friendThread.start();
	
	}
}
