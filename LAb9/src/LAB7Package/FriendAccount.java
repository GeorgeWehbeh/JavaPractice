package LAB7Package;

import java.lang.Thread;
//Friend account which withdraws after my account has made a deposit
public class FriendAccount  extends Thread {

	private int dollars = 0;
	private int euros = 0;
	private int pounds = 0;
	private BankAccount accountBank;
	
	FriendAccount(int dollarAmt, int euroAmt, int poundAmt, BankAccount r){
		this.accountBank = r;
		dollars = dollarAmt;
		euros = euroAmt;
		pounds = poundAmt;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
		//waits for notification from my account then checks what currency type has been put into the shared account and
			//withdraws it into the correct currency type for this account, afterwards it will notify my account so 
			//that it continues with the next deposit
		synchronized(accountBank) {
		    while(accountBank.getAmountOfMoney() == 0) {
		         try {
		             accountBank.wait();
		          } catch (InterruptedException ie) {
		             System.err.println(ie.getMessage());
		          }
		     }
		    System.out.println(accountBank.getAmountOfMoney() + " " + accountBank.getCurrencyType() + " now in shared account.");
			if(accountBank.getCurrencyType().equals("dollars")) {
				this.dollars += accountBank.getAmountOfMoney();
				System.out.println(this.dollars + " dollars in friend account after withdrawing.");
				accountBank.setAmountOfMoney(0);

			}
			else if(accountBank.getCurrencyType().equals("euros")) {
				this.euros += accountBank.getAmountOfMoney();
				System.out.println(this.euros + " euros in friend account after withdrawing");
				accountBank.setAmountOfMoney(0);
			}
			else if(accountBank.getCurrencyType().equals("pounds")) {
				this.pounds += accountBank.getAmountOfMoney();
				System.out.println(this.pounds + " pounds in friend account after withdrawing");
				accountBank.setAmountOfMoney(0);
			}
		    System.out.println(accountBank.getAmountOfMoney() + " " + accountBank.getCurrencyType() + " now in shared account.");
			accountBank.notify();
		}
		}
		printAccount();
	}
	
	public int getDollars() {
		return dollars;
	}
	public int getEuros() {
		return euros;
	}
	public int getPounds() {
		return pounds;
	}
	public void printAccount() {
		System.out.println(dollars + " dollars, " + euros + " euros, " + pounds + " pounds in friend account once all transactions completed. ");
	}
}
