package JavaBankApplication;

// ************************************************************************
// Account.java	  Template created on15.9.2016
// - The class for Account objects
// ************************************************************************
public class Account {

	// Fields

	private String accountNumber; 
	private double balance; 
	
	// Constructor

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
		balance = 0;
	}
	
	// Methods

	public void deposit(double amount) {
		balance += amount ;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean withdraw(double amount) {
		
		if(balance > amount ) {
			balance -= amount; 
			System.out.println();
			System.out.print("Withdrawal completed successfully!");
		} else {
			balance -= 0; 
			System.out.println();
			System.out.print("Withdrawal not completed. Available balanced is too low.");
		}
		return true;
	}
}
// End