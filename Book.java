/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/4/2019
 */

import java.util.ArrayList;

/**
 * book class to make books
 * books contain a title
 * and a list of authors
 * there are methods to manipulate
 * and display books
 * @author Brandon Lu
 * @version 4 November 2019
 */
public class Book implements Comparable<Book>{
	/**
	 * title field
	 * final because title shouldn't change once set
	 * (book titles don't change)
	 */
	private final String myTitle;
	/**
	 * author list
	 * final because authors don't change
	 * can contain one author for the book
	 * or multiple authors
	 */
	private final ArrayList<String> myAuthors;
	
	/**
	 * constructor for Book
	 * accepts a title and authors to initialize
	 * to fields
	 * if either author or title are empty or null
	 * error will be thrown
	 * authors is first initialized, then added to
	 * @param theTitle the title to put into book
	 * @param theAuthors the author list to put into book
	 */
	public Book(final String theTitle, final ArrayList<String> theAuthors)
	{
		if(theTitle == "" ||
				theTitle == null ||
				theAuthors.get(0) == "" ||
				theAuthors.get(0) == null)
		{
			throw new IllegalArgumentException("Title and authors" +
																" cannot be empty or null");
		}
		myTitle = theTitle;
		myAuthors = new ArrayList<String>();
		for(String author : theAuthors)
		{
			myAuthors.add(author);
		}
	}
	
	/**
	 * getter for title
	 * @return the title name (the title field)
	 */
	public String getTitle()
	{
		return myTitle;
	}
	
	/**
	 * getter for authors list
	 * returns another arraylist that is a copy
	 * of the authors list
	 * (defensive copy)
	 * this is done since if you return the original list
	 * the user can alter it, since it will still reference
	 * the original list
	 * @return copy of authors list
	 */
	public ArrayList<String> getAuthors()
	{
		ArrayList<String> cloneAuthors = new ArrayList<String>();
		cloneAuthors.addAll(myAuthors);
		return cloneAuthors;
	}
	
	/**
	 * method to reverse author names to be used later
	 * in the to string method
	 * separates first and last name from each author
	 * in author list
	 * then adds them in first name last name
	 * order without comma to new list
	 * with all the names
	 * @return author list with reverse names
	 */
	public ArrayList<String> getReverseAuthorNames()
	{
		ArrayList<String> reverseAuthors = new ArrayList<String>();
		
		for(int i = 0; i < myAuthors.size(); i++)
		{
			String lastName = 
					myAuthors.get(i).substring(0, myAuthors.get(i).indexOf(','));
			String firstName =
					myAuthors.get(i).substring(myAuthors.get(i).indexOf(',') +
							2, myAuthors.get(i).length());
			reverseAuthors.add(firstName + " " + lastName);
		}
		
		return reverseAuthors;
	}
	
	/**
	 * method to display books' authors and titles
	 * @return title and authors of books with correct formatting
	 */
	public String toString()
	{
		ArrayList<String> reverseAuthors = getReverseAuthorNames();
		String message = "\"" + myTitle + ",\" by ";
		for(String author : reverseAuthors)
		{
			message += author + "; ";
		}
		
		message = message.substring(0, message.length() - 2);
		return message;
	}
	
	/**
	 * compareTo method to see if books are equal or not
	 * they are only equal if the title and authors are the same
	 * (in the case of authors, only checks first author of
	 * each book as specified in the assignment)
	 * @param theOther the book to compare to
	 * @return if this book and other book are same
	 */
	public int compareTo(final Book theOther)
	{
		int result = myTitle.compareTo(theOther.getTitle());
		if(result == 0)
		{
			result = myAuthors.get(0).compareTo(theOther.getAuthors().get(0));
		}
		return result;
	}
	
	/**
	 * checks if this book and another object are equal
	 * if the other object is a book and
	 * has the same title and authors
	 * they are equal
	 * @param theOther the object to check if equal
	 * @return if the object is equal to this book
	 */
	public boolean equals(final Object theOther)
	{
		boolean equals = false;
		if(theOther instanceof Book)
		{
			if(myTitle == ((Book)theOther).myTitle &&
					compareAuthors(((Book) theOther).getAuthors()))
			{
				equals = true;
			}
		}
		return equals;
		
	}
	
	/**
	 * compare author lists to see if they are equal
	 * @param theOtherList the list to compare authors with
	 * @return if the author lists are equal
	 */
	public boolean compareAuthors(final ArrayList<String> theOtherList)
	{
		boolean equal = true;
		int maxSize = myAuthors.size();
		if(theOtherList.size() > myAuthors.size())
		{
			maxSize = theOtherList.size();
		}
		
		for(int i = 0; i < maxSize; i++)
		{
			if(i < myAuthors.size() && i < theOtherList.size())
			{
				if(myAuthors.get(i).compareTo(theOtherList.get(i)) != 0)
				{
					equal = false;
				}
			}
			else
			{
				equal = false;
			}
			
		}
		return equal;
	}
}
