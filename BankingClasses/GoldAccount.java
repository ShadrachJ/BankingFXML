package BankingClasses;

import javax.swing.JOptionPane;

public class GoldAccount extends Account{
	/*can go negative
	 * 5% interest
	 * no charges
	 * 
	 */
	private float interestRate = 5f;

	public GoldAccount(String accountNumber, Customer customer, double balance) {
		super(accountNumber, customer, balance);
	}

	public float getInterestRate() {
		return interestRate;
	}

	@Override
	public void makeDeposit(double depositAmount) {
		balance += depositAmount;
		
	}

	@Override
	public void makeWithdrawal(double withdrawalAmount) {
		balance -= withdrawalAmount;
		if(balance<0){
			JOptionPane.showMessageDialog(null,"\nYour current balance is negative: $" + balance);
		}
	
		
	}
	public void monthlyUpkeep() {
		balance+=(balance/100)*interestRate;
	}

	public String toString() {
		String output;
		output =  "\nGold Account Information\n";
		output+=  "\nAccount Holder: " + this.customer;
		output+=  "\nAccount Number : " + this.accountNumber;
		output+=  "\nGold Account Balance: " + this.balance;
		output+=  "\nInterest Rate: " + this.interestRate;
		return output;
	}
	
}
