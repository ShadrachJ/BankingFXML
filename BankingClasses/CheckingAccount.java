package BankingClasses;

import javax.swing.JOptionPane;

public class CheckingAccount extends Account{
	/*can't go negative
	 * $3 charge per transaction
	 * 2 free transactions
	 * no interest
	 * will withdraw all remaining on attempt to withdraw more than balance
	 * 
	 */
	private int numTransactions = 0;
	private int transactionFee = 3;
	
	public CheckingAccount(String accountNumber, Customer customer, double balance) {
		super(accountNumber, customer, balance);
	}

	public int getNumTransactions() {
		return numTransactions;
	}

	public int getTransactionFee() {
		return transactionFee;
	}

	@Override
	public void makeDeposit(double depositAmount) {
		numTransactions++;
		if (numTransactions>2){
			if (depositAmount<transactionFee){
				JOptionPane.showMessageDialog(null,"You would lose money on this transaction. Deposit not made");
			}
		}
		else {
			balance+=depositAmount;
			}
		}
	

	@Override
	public void makeWithdrawal(double withdrawalAmount) {
		//the balance line on withdrawal is because technically the user has to have enough money to clear the fee
		//for transactions at the end of the month. We check this here, without applying the fee.
		numTransactions++;
		if (numTransactions>2){
			if (withdrawalAmount > (balance-Math.abs(2-numTransactions)*transactionFee)){
				JOptionPane.showMessageDialog(null,"Your current balance is: $" + balance +
				"\nYou have tried to withdraw $" + withdrawalAmount + ", which is $" + Math.abs(balance-withdrawalAmount) + 
				"\n more than you have in your account currently." +
				"\nWe have withdrawn the remainder of your account, making your balance $0");
				balance = 0;
			}
			else{
				balance-=withdrawalAmount;
			}
		}
		else if (withdrawalAmount > balance){
				JOptionPane.showMessageDialog(null,"Your current balance is: $" + balance +
						"\nYou have tried to withdraw $" + withdrawalAmount 
						+ "\n, which is $"+ Math.abs(balance-withdrawalAmount) + " more than you have in your account."
						+ "\nWe have withdrawn the remainder of your account, making your balance $0");
						balance=0;
			}
		
		else{
			balance-=withdrawalAmount;
			}
		}

	
	public void monthlyUpkeep() {
		if (numTransactions>2){
			balance-=Math.abs(2-numTransactions)*transactionFee;
		}
		numTransactions=0;
	}

	@Override
	public String toString() {
		String output;
		output =  "\nChecking Account Information\n";
		output+=  "\nAccount Holder: " + this.customer;
		output+=  "\nAccount Number : " + this.accountNumber;
		output+=  "\nChecking Account Balance: " + this.balance;
		output+=  "\nNumber of Transactions: " + this.numTransactions;
		output+=  "\nFee: " + this.transactionFee;
		return output;
	}
	
	
}
