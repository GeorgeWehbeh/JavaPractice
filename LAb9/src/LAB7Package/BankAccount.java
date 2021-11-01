package LAB7Package;

public class BankAccount{
//shared account where I will be depositing and friend will be withdrawing
private int transactionNumber = 0;
private int amountOfMoney = 0;
private String currencyType = " ";

public int getTransactionNumber() {
	return transactionNumber;
}

public int getAmountOfMoney() {
	return amountOfMoney;
}

public String getCurrencyType() {
	return currencyType;
}

public void setAmountOfMoney(int value) {
	amountOfMoney = value;
}

public void setCurrencyType(String type) {
	currencyType = type;
}

}
