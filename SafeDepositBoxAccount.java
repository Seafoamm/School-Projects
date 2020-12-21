/*
 * TCSS143
 * Professor Schuessler
 * Programming 4
 * Due: 10/22/2019
 */
/**
 * Class to make a safe deposit box account with
 * A safe deposit box allows a customer to make an account
 * However, the bank can't know what's in it, only the 
 * owner associated with it
 * @author Brandon
 * @version 10/22/2019
 */
public class SafeDepositBoxAccount implements NamedAccount{
	/**
	 * myAccountHolder is used to store the owner's name in
	 */
	private String myAccountHolder;
	/**
	 * The constructor for this class allows the owner's name to be
	 * input
	 * @param theName the owner's name
	 */
	public SafeDepositBoxAccount(String theName)
	{
		setAccountHolderName(theName);
	}
	/**
	 * getter for myAccountHolder
	 * implemented from NamedAccount
	 * @return the owner's name
	 */
	public String getAccountHolderName()
	{
		return myAccountHolder;
	}
	/**
	 * the setter for myAccountHolder
	 * implemented from Named account
	 * @param theNewName the name to change owner to
	 */
	public void setAccountHolderName(final String theNewName)
	{
		myAccountHolder = theNewName;
	}
	/**
	 * this method allows for the owner of the safe deposit
	 * box account to be displayed by putting it in a string
	 * @return the string to be displayed
	 */
	public String toString()
	{
		return "[owner: " +
		myAccountHolder +
		"]";
	}
}
