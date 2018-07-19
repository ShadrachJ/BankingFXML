package BankingClasses;

public abstract class Account {

	protected String accountNumber;
	protected Customer customer;
	protected double balance;
	public Account(String accountNumber, Customer customer, double balance) {
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public abstract void makeDeposit(double depositAmount);
	
	public abstract void makeWithdrawal(double withdrawalAmount);
	
	public abstract void monthlyUpkeep();
}
