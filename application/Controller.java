package application;

import java.util.ArrayList;


import javax.swing.JOptionPane;
import BankingClasses.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
	int accountTotal = 0;
	static ArrayList<Account> accountList = new ArrayList<>();
    @FXML
    private TextField txtCheckingName;

    @FXML
    private TextField txtCheckingBalance;

    @FXML
    private Button btnCreateChecking;

    @FXML
    private TextField txtGoldName;

    @FXML
    private TextField txtGoldBalance;

    @FXML
    private Button btnCreateGold;

    @FXML
    private TextField txtRegularName;

    @FXML
    private TextField txtRegularBalance;

    @FXML
    private Button btnCreateRegular;
    
    @FXML
    private TextField txtDepositID;
    
    @FXML
    private Button btnDeposit;

    @FXML
    private TextField txtDepositAmount;

    @FXML
    private Button btnWithdraw;
    
    @FXML
    private TextField txtWithdrawalID;
    
    @FXML
    private TextField txtWithdrawalAmount;

    @FXML
    private Button btnDisplayAccount;

    @FXML
    private TextField txtDisplayAccountID;

    @FXML
    private Button btnRemoveAccount;

    @FXML
    private Button btnUpkeep;

    @FXML
    private TextField txtRemoveAccountID;
    
    @FXML
    private TextField txtAverageBalance;

    @FXML
    private Button btnDisplayStatistics;

    @FXML
    private TextField txtZeroBalance;

    @FXML
    private TextField txtTotalBalance;

    @FXML
    private TextField txtIndividualBalance;

    @FXML
    void conductUpkeep() {
    	
    		for(Account c : accountList){
    			c.monthlyUpkeep();
    		}
    	};
    
    @FXML
    void createChecking() {
    	
    		accountTotal++;
    		
    		String customerName = txtCheckingName.getText();
    		String customerID;
    		String accountID;
    		double balance = Double.parseDouble(txtCheckingBalance.getText());
    		customerID = String.valueOf(accountTotal);
    		Customer customer = new Customer(customerID,customerName);
    		accountID = String.valueOf(accountTotal);
    		CheckingAccount checkingAccount = new CheckingAccount(accountID,customer,balance);
    		accountList.add(checkingAccount);
    		txtCheckingName.clear();
    		txtCheckingBalance.clear();
    		JOptionPane.showMessageDialog(null, "Account created successfully! Your ID is "+ accountID);
    	};
   
    @FXML
    void createGold() {
    	
    		accountTotal++;
    		
    		String customerName = txtGoldName.getText();
    		String customerID;
    		String accountID;//this is going to be changed to increment every time an account is made
    		double balance = Double.parseDouble(txtGoldBalance.getText());
    		customerID = String.valueOf(accountTotal);
    		Customer customer = new Customer(customerID,customerName);
    		accountID = String.valueOf(accountTotal);
    		GoldAccount goldAccount = new GoldAccount(accountID,customer,balance);
    		accountList.add(goldAccount);
    		txtGoldName.clear();
    		txtGoldBalance.clear();
    		JOptionPane.showMessageDialog(null, "Account created successfully! Your ID is "+ accountTotal);
    	};
   
    @FXML
    void createRegular() {
    	
    		accountTotal++;
    		String customerName = txtRegularName.getText();
    		String customerID;
    		String accountID;//this is going to be changed to increment every time an account is made
    		double balance = Double.parseDouble(txtRegularBalance.getText());
    		customerID = String.valueOf(accountTotal);
    		Customer customer = new Customer(customerID,customerName);
    		accountID = String.valueOf(accountTotal);
    		RegularAccount regularAccount = new RegularAccount(accountID,customer,balance);
    		accountList.add(regularAccount);
    		txtRegularName.clear();
    		txtRegularBalance.clear();
    		JOptionPane.showMessageDialog(null, "Account created successfully! Your ID is "+ accountTotal);
    	};
    
    @FXML
    void deposit() {
    	
    		String accountNum;
    		double depositAmt=Double.parseDouble(txtDepositAmount.getText());
    	
    		accountNum=txtDepositID.getText();
    		if (validateID(accountNum)==true){
    			for(Account c : accountList){
    				if (c.getAccountNumber().equalsIgnoreCase(accountNum)){
    					c.makeDeposit(depositAmt);
    					JOptionPane.showMessageDialog(null,"Your new balance is " + c.getBalance());
    				}
    			}
    		}
    		txtDepositID.clear();
    		txtDepositAmount.clear();
    	};
    
    @FXML
    void displayAccount() {
    	
    		String accountNum=txtDisplayAccountID.getText();
    		if(validateID(accountNum)==true){
    			for(Account c : accountList){
    				if (c.getAccountNumber().equalsIgnoreCase(accountNum)){
    					JOptionPane.showMessageDialog(null,c);
    				}
    			}
    		}
    		txtDisplayAccountID.clear();
    }

    @FXML
    void displayStatistics() {
    	int numZeroBalance = 0;
    	double totalBalance = 0;
    	double maxBalance = 0;	//wants the account
    	int numAccounts=0;
    	String userWithMaxBalance="";
    	
    	for(Account c : accountList){
    		numAccounts++;
    		totalBalance+=c.getBalance();

    		if (c.getBalance()>maxBalance){
    			maxBalance=c.getBalance();
    			userWithMaxBalance=c.getCustomer().getCustomerName();
    		}
    		if (c.getBalance()<=0){
    			numZeroBalance++;
    		}
    	}
    	txtZeroBalance.setText(String.valueOf(numZeroBalance));
    	txtTotalBalance.setText(String.valueOf(totalBalance));
    	txtIndividualBalance.setText(userWithMaxBalance);
    	txtAverageBalance.setText(String.valueOf(totalBalance/numAccounts));
    }

    @FXML
    void removeAccount() {
    	String accountNum = txtRemoveAccountID.getText();
		int accountIndex=-1;
		if (validateID(accountNum)==true){
			for(Account c : accountList){
				if(c.getAccountNumber().equalsIgnoreCase(accountNum)){
					//obtains the index of the account the user wished to remove
				  accountIndex=accountList.indexOf(c);
				}
			}
			accountList.remove(accountIndex);
			JOptionPane.showMessageDialog(null, "Account removed successfully");
		}
		txtRemoveAccountID.clear();
    }

    @FXML
    void withdraw() {

		String accountNum;
		double withdrawalAmt=Double.parseDouble(txtWithdrawalAmount.getText());
	
		accountNum=txtWithdrawalID.getText();
		if (validateID(accountNum)==true){
			for(Account c : accountList){
				if (c.getAccountNumber().equalsIgnoreCase(accountNum)){
					c.makeWithdrawal(withdrawalAmt);
					JOptionPane.showMessageDialog(null,"Your new balance is " + c.getBalance());
				}
			}
		}
		txtWithdrawalAmount.clear();
		txtWithdrawalID.clear();
	};
    public static boolean validateID(String accountID){
    	boolean validationCheck=false;
    	for(Account a:accountList){
    		if(a.getAccountNumber().equalsIgnoreCase(accountID)){
    			validationCheck=true;
    		}
    	}
    	if(validationCheck==false){
    		JOptionPane.showMessageDialog(null,"No account with such an ID exists");
    	}
    	return validationCheck;
    }

}
