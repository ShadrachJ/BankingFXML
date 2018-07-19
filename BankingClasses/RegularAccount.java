package BankingClasses;

import javax.swing.JOptionPane;

public class RegularAccount extends Account{
/* can't go negative
 * $10 monthly charge for upkeep
 * 6% interest
 * will withdraw all remaining on attempt to withdraw more than balance
 * 
 */
	private int fixedCharge = 10;
	private float interestRate = 6f;
	
	public RegularAccount(String accountNumber, Customer customer, double balance) {
		super(accountNumber, customer, balance);
	
	}

	public int getFixedCharge() {
		return fixedCharge;
	}

	public float getInterestRate() {
		return interestRate;
	}

	@Override
	public void makeDeposit(double depositAmount) {
		balance +=depositAmount;
		
	}

	@Override
	public void makeWithdrawal(double withdrawalAmount) {
		//fixed charge is included because you have to have at least $10 left to cover the cost of maintenance.
		if (balance ==10){
			JOptionPane.showMessageDialog(null,"Your balance is $10, additional funds are needed to make a withdrawal");
			
		}
		else if (withdrawalAmount > balance-fixedCharge){
				JOptionPane.showMessageDialog(null,"Your current balance is: $" + balance +
				"\nYou have tried to withdraw $" + withdrawalAmount + ", which is $" + Math.abs(balance-withdrawalAmount) + 
				"\n more than you can withdraw." +" We have withdrawn the remainder of your account, "
				+ "\nmaking your balance $10");
				balance=10;
			}
		else {
				balance-=withdrawalAmount;
			}
	}
	public void monthlyUpkeep() {
		balance-=fixedCharge;
		balance+=(balance/100)*interestRate;
		
	}
	public String toString() {
		String output;
		output =  "\nRegular Account Information\n";//Regular Account Information
		output+=  "\nAccount Holder: " + this.customer;//Account Holder
		output+=  "\nAccount Number : " + this.accountNumber;//Account Number
		output+=  "\nChecking Account Balance: " + this.balance;//Checking Account Balance
		output+=  "\nInterest Rate: " + this.interestRate;//Interest Rate
		output+=  "\nFixed Charge: " + this.fixedCharge + " per month";//Fixed Charge
		return output;
	}
	
}
