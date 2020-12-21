/*
 * TCSS143
 * Professor Schuessler
 * Programming 4
 * Due: 10/22/2019
 */
/**
 * This interface forces the accounts that implement it
 * to have a way to set and get the owner for the account
 * @author Brandon
 * @version 10/22/2019
 */
public interface NamedAccount {
	/**
	 * abstract method for getting owner's name
	 * @return returns the owner's name
	 */
	String getAccountHolderName();
	/**
	 * abstract method for setting the owner's name
	 * @param theNewName the name to change to
	 */
	void setAccountHolderName(final String theNewName);
}
