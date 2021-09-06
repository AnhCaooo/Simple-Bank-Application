package JavaBankApplication;

// ************************************************************************
// BankProgram.java	 Template created on 15.9.2016
// - The program class for the BankApplication exercise
// ************************************************************************
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class BankProgram {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Account> accountList = new ArrayList<Account>();

	// *** DO NOT change anything in the main method ***
	public static void main(String[] args) {
		int choice = -1;

		while (choice != 0) {

			switch (choice) {
			case 1:
				listAccounts();
				break;
			case 2:
				addAccount();
				break;
			case 3:
				depositMoney();
				break;
			case 4:
				withdrawMoney();
				break;
			case 5:
				deleteAccount();
				break;
			}

			displayMenu();
			choice = Integer.parseInt(input.nextLine());
		}

		System.out.println("\nThe program ends now. Bye!");
		input.close();
	}
	
	private static double readDouble(Scanner input) {
		 return Double.parseDouble(input.nextLine().replace(',', '.'));
		 }


	private static void displayMenu() {
		String line = "-----------------------------------------------------"
				+ "---------------------------------------------------------------";
		System.out.println(line);
		System.out.print(" 0 = Quit | 1 = List accounts | 2 = Add an account | " +
						 "3 = Deposit money | 4 = Withdraw money | 5 = Delete an account \n");
		System.out.println(line);
		System.out.print("Enter your choice: ");
	}

	// *** NB! Edit only the methods below. DO NOT add any other methods! ***

	private static void listAccounts() {
		System.out.print("\n*** Account list ***\n");

		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		
		for(Account accountObject : accountList ) {
			System.out.println("Number: " + accountObject.getAccountNumber() + " | Balance: " + twoDecimals.format(accountObject.getBalance())  + " euros");
		}
		
	}

	private static void addAccount() {
		System.out.print("\n*** Add an account ***\n");

		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		
		
		if(findAccount(accountNumber) == null ) {
			accountList.add(new Account(accountNumber));
			System.out.println();
			System.out.println("Account created successfully!");
		} else {
			System.out.println();
			System.out.println("Account not created. Account " + accountNumber + " exists already!");
		}
	}

	// Finds an account in accountList by given account number.
	// Returns either a reference to the account object
	// OR null if the account is not found in accountList.
	private static Account findAccount(String accountNumber) {
		Account myAccount = null;

		for(Account accountObject : accountList) {
			if( accountObject.getAccountNumber().equals(accountNumber)) {
				myAccount = accountObject; 		
			}
		} 
		return myAccount;
	}

	private static void depositMoney() {
		System.out.print("\n*** Deposit money to an account ***\n");

		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		
		
		if(findAccount(accountNumber) == (null) ) {
			System.out.println();
			System.out.println("Account " + accountNumber + " does not exist!");
		} else {
			System.out.print("Enter the amount to be deposited: ");
			double depositValue = readDouble(input);
			
			if(depositValue < 0 ) {
				System.out.println();
				System.out.println("Cannot deposit a negative amount!");
			} else {
				for(Account accountObject : accountList) {
					if(accountNumber.equals(accountObject.getAccountNumber())) {
						accountObject.deposit(depositValue);
					}
				}
				System.out.println();
				System.out.print("Deposit completed successfully!");
			}
		}
		
	}

	private static void withdrawMoney() {
		System.out.print("\n*** Withdraw money from an account ***\n");

		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		
		if(findAccount(accountNumber) == (null) ) {
			System.out.println();
			System.out.println("Account " + accountNumber + " does not exist!");
		} else {
			System.out.print("Enter the amount to be withdrawn: ");
			double withdrawAmount = readDouble(input);
			
			if(withdrawAmount < 0) {
				System.out.println();
				System.out.print("Cannot withdraw a negative amount!");
			} else {
				for(Account accountObject : accountList) {
					if(accountNumber.equals(accountObject.getAccountNumber())) {
						accountObject.withdraw(withdrawAmount);
					}
				}
			}	
		}
	}

	private static void deleteAccount() {
		System.out.print("\n*** Delete an account ***\n");

		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		
		if(findAccount(accountNumber) == (null) ) {
			System.out.println();
			System.out.println("Account " + accountNumber + " does not exist!");
		} else {
			for(Account accountObject : accountList) {
				if(accountObject.getAccountNumber().equals(accountNumber)) {
					accountList.remove(accountObject);
				}
			}	
			System.out.println();
			System.out.println("Account deleted successfully!");
		}
	}
}
// End
