package LAB7Package;

import java.lang.Thread;
//"MY" account where I am sending payments into the shared account for my friend to withdraw
public class PersonalAccount extends Thread {
	private int dollars = 0;
	private int euros = 0;
	private int pounds = 0;
	private BankAccount accountBank;
	
	PersonalAccount(int dollarAmt, int euroAmt, int poundAmt, BankAccount r){
		this.accountBank = r;
		dollars = dollarAmt;
		euros = euroAmt;
		pounds = poundAmt;
	}
	
	@Override
	public void run() {
		//sends first payment and then waits for friend account to notify to continue
		 synchronized(accountBank) {
					accountBank.setAmountOfMoney(dollars);
					accountBank.setCurrencyType("dollars");
					System.out.println(accountBank.getAmountOfMoney()+ " " +accountBank.getCurrencyType() + " deposited to shared bank account.");
	            accountBank.notify();
		}
		 //Waits for friend account to notify and then sends second payment if shared account balance is at 0
		 synchronized(accountBank) {	
			 while(accountBank.getAmountOfMoney() != 0) {
		         try {
		             accountBank.wait();
		          } catch (InterruptedException ie) {
		             System.err.println(ie.getMessage());
		          }
		     }
					accountBank.setAmountOfMoney(euros);
					accountBank.setCurrencyType("euros");
					System.out.println(accountBank.getAmountOfMoney()+ " " + accountBank.getCurrencyType() + " deposited to shared bank account.");
	            accountBank.notify();
		}
		 //Waits for friend account to notify and then sends third payment if shared account balance is at 0
		 synchronized(accountBank) {
			 while(accountBank.getAmountOfMoney() != 0) {
		         try {
		             accountBank.wait();
		          } catch (InterruptedException ie) {
		             System.err.println(ie.getMessage());
		          }
		     }
					accountBank.setAmountOfMoney(pounds);
					accountBank.setCurrencyType("pounds");
					System.out.println(accountBank.getAmountOfMoney()+ " " + accountBank.getCurrencyType() + " deposited to shared bank account.");
	            accountBank.notify();
		}
		}
			
}
