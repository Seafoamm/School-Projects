/*
 * TCSS143
 * Professor Schuessler
 * Programming 4
 * Due: 10/22/2019
 */
/**
 * This class allows a bank account to be created, with functions such
 * as withdrawing, depositing, and performing bank processes, as well
 * as getting the information of the bank.
 * This also implements the interface: "NamedAccount", which
 * requires this class to have a way to set and get the owner's name. 
 * @author Brandon
 * @version 10/22/2019
 */
public class BankAccount implements NamedAccount {
	/**
	 * this constant (APR) is to define the "annual percentage rate",
	 * which is used to calculate interest
	 */
	public static final double APR = 12.0;
	/**
	 * myAccountHolder is used to hold the name of the owner of
	 * this bank account
	 */
	private String myAccountHolder;
	/**
	 * myAccountBalance is used to hold the balance of the account
	 */
	private double myAccountBalance;
	/**
	 * myInterestRate is used to hold the interest rate this bank
	 * account has, to be later used to calculate interest
	 */
	private double myInterestRate;
	
	/**
	 * myMonthlyWithdrawCount is used to keep track of how many
	 * times this account has been withdrawn from this month.
	 * Since it is protected, the SavingsAccount class, which
	 * inherits from this class inherits this field as well.
	 */
	protected int myMonthlyWithdrawCount;
	/**
	 * myMonthlyServiceCharges is used when a SavingsAccount has 5
	 * or more withdrawals. It, like myMonthlyWithdrawCount, gets
	 * inherited by SavingsAccount. 
	 */
	protected double myMonthlyServiceCharges;
	
	/**
	 * Constructor for BankAccount class.
	 * Allows for the account owner's name to be input
	 * Also allows for interest rate of account to be input
	 * @param theNameOfOwner to initialize the account holder field
	 * @param theInterestRate to initialize interest rate field
	 */
	public BankAccount(final String theNameOfOwner, final double theInterestRate)
	{
		//method implemented from NamedAccount to set name
		setAccountHolderName(theNameOfOwner);
		
		myInterestRate = theInterestRate;
		
		//if illegal interest rate (negative) is input
		//just set interest rate to 0
		if(theInterestRate < 0)
		{
			myInterestRate = 0;
		}
		
		//set balance, withdraw count, and service charges to 0
		//default values
		myAccountBalance = 0;
		myMonthlyWithdrawCount = 0;
		myMonthlyServiceCharges = 0;	
	}
	
	
	/**
	 * Getter (accessor) for myAccountBalance
	 * @return returns the value of myAccountBalance
	 */
	public double getBalance()
	{
		return myAccountBalance;
	}
	
	/**
	 * Method used to deposit money into the BankAccount
	 * @param theAmount the amount of money to be deposited
	 * @return returns if the deposit was successful or not
	 */
	public boolean processDeposit(final double theAmount)
	{
		boolean legalDeposit = false; //by default, not legal
		//if amount is not 0 or negative, the deposit is legal
		//(you can't withdraw money by depositing negative amount)
		if(theAmount > 0) 
		{
			myAccountBalance += theAmount;
			legalDeposit = true;
		}
		
		return legalDeposit;
	}
	
	/**
	 * Method used to withdraw money from the BankAccount
	 * @param theAmount amount to be withdrawn
	 * @return if withdrawal was successful or not
	 */
	public boolean processWithdrawal(final double theAmount)
	{
		boolean legalWithdrawal = false;
	  //same logic as deposit
		//(doesn't make sense to deposit money by withdrawing
		// negative amount)
		if(theAmount > 0 && theAmount <= myAccountBalance)
		{
			myAccountBalance -= theAmount;
			//since this is legal, add count this as a withdrawal
			myMonthlyWithdrawCount++; 
			legalWithdrawal = true;
		}
		
		return legalWithdrawal;
	}
	
	/**
	 * method used to calculate interest
	 * @return returns the amount of interest to be added to balance
	 */
	public double calculateInterest()
	{
		//calculates based on the interest rate input in constructor
		//and also the APR
		return myAccountBalance * (myInterestRate / APR);
	}
	
	/**
	 * Performs monthly processes. Cleans up. Ties up loose ends.
	 */
	public void performMonthlyProcess() 
	{
		  //if there are any service charges incurred, take them from
		  //the balance
			myAccountBalance -= myMonthlyServiceCharges;
			//if, after subtracting the monthly service charges, the 
			//balance is negative, set balance to 0
			if(myAccountBalance <= 0)
			{
				myAccountBalance = 0;
			}
			//adds the interest to the balance
			myAccountBalance += calculateInterest();
		
		
	  //resets the count and service charges since this is a new month
		myMonthlyWithdrawCount = 0;
		myMonthlyServiceCharges = 0;		
	}
	
	/**
	 * accessor method for the owner's name
	 * implemented from interface NamedAccount
	 * @return returns the name of bank account
	 */
	public String getAccountHolderName()
	{
		return myAccountHolder;
	}
	
	/**
	 * mutator method for owner's name
	 * allows the owner's name to be changed
	 * implemented from interface NamedAccount
	 */
	public void setAccountHolderName(final String theNewName)
	{
		myAccountHolder = theNewName;
	}
	
	/**
	 * displays all the information about the bank account
	 * in a string to be displayed
	 */
	public String toString()
	{
		
		return getClass().getName() +
				"[owner: " +
				myAccountHolder +
				", balance: " +
				String.format("%.2f", myAccountBalance) +
				", interest rate: " +
				String.format("%.2f", myInterestRate) +
				",\n\tnumber of withdrawals this month: " + 
				myMonthlyWithdrawCount +
				", service charges for this month: " +
				String.format("%.2f", myMonthlyServiceCharges) +
				"]";
				
	}
}
