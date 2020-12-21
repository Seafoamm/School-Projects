/*
 * TCSS143
 * Professor Schuessler
 * Programming 4
 * Due: 10/22/2019
 */
/**
 * This class inherits from BankAccount
 * It is basically a more specific class
 * This class can incur monthly service charges and
 * it has an active or inactive status depending on the balance
 * @author Brandon Lu
 * @version 10/22/2019
 *
 */
public class SavingsAccount extends BankAccount {
	/**
	 * this field is used to store the status of the account
	 * (is it active or not)
	 */
	private boolean myStatusIsActive;

	/**
	 * constructor allows for owner name and interest rate to be 
	 * input
	 * @param theNameOfOwner owner's name
	 * @param theInterestRate interest rate for this account
	 */
	public SavingsAccount(final String theNameOfOwner, final double theInterestRate)
	{
		//calls the bank account constructor to initialize all fields
		super(theNameOfOwner, theInterestRate);
		
		//if the balance is at least 25, this is an active savings account
		myStatusIsActive = getBalance() >= 25;
		
		
	}
	
	/**
	 * method to process deposits into account
	 * @param theAmount amount to be deposited
	 * @return if deposit was successful
	 */
	public boolean processDeposit(final double theAmount)
	{
		//since balance can't be below 0
		//if you deposit 25, the balance will be at least 25
		//so the status should be active
		if(theAmount >= 25)
		{
			myStatusIsActive = true;
		}
		//process the deposit, all rules and conditions are
		//defined in the superclass's method
		//true if legal, false if not
		return super.processDeposit(theAmount);
		
	}
	/**
	 * method to process withdrawals
	 * @param theAmount amount to be withdrawn
	 * @return if withdrawal was successful
	 */
	public boolean processWithdrawal(final double theAmount)
	{
		boolean legalWithdrawal = false;
		//if saving account status is active process withdrawal
		if(myStatusIsActive)
		{
			//use superclass's method, with all rules defined already
			legalWithdrawal = super.processWithdrawal(theAmount);
			//if, after withdrawal, balance is below 25
			//set account status to inactive
			if(getBalance() < 25)
			{
				myStatusIsActive = false;
			}
		}
		//if this is more than the 5th withdrawal, add to 
		//monthly service charges to be subtracted
		//in monthly process
		if(myMonthlyWithdrawCount > 5)
		{
			myMonthlyServiceCharges++;
		}
		
		return legalWithdrawal;
	}
	/**
	 * performs monthly duties defined in superclass's method
	 * checks if balance is at least 25, and sets account
	 * active status accordingly
	 */
	public void performMonthlyProcess()
	{
		super.performMonthlyProcess();
		myStatusIsActive = true;
		
		if(getBalance() < 25)
		{
			myStatusIsActive = false;
		}
	}
	/**
	 * makes a string to display info for this account
	 * uses the super's string, however the status of this account
	 * is added to the end, something that doesn't apply to a
	 * non-SavingsAccount
	 */
	public String toString()
	{
		String message =
				super.toString().substring(0, super.toString().length() - 1) +
				", myStatusIsActive: " +
				myStatusIsActive +
				"]";
		return message;
				
	}
}
