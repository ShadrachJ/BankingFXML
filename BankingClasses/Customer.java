package BankingClasses;

public class Customer {

	protected String customerID;
	protected String customerName;
	public Customer(String customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		String output;
		output =  "\nCustomer Information\n";
		output+=  "\nCustomer Name: " + this.customerName;
		output+=  "\nCustomer ID: " + this.customerID;
		return output;
	}
	
	
}
