/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/5/2019
 */
import java.util.ArrayList;
import java.util.Collections;
/**
 * library class that can contain or add a list of books
 * or individual books
 * has methods to work with the library such as
 * returning books with certain titles
 * @author Brandon Lu
 * @version 5 November 2019
 */
public class Library {
	/**
	 * book list field to contain books in the library
	 */
	private ArrayList<Book> myBooks;
	
	/**
	 * constructor for library
	 * initializes list of books first by instantiating
	 * field as new book list object, then adding books
	 * from the list passed in
	 * throws exception if book list is null 
	 * @param theOther book to be passed in
	 */
	public Library(final ArrayList<Book> theOther)
	{
		if(theOther == null)
		{
			throw new NullPointerException("Book list cannot be null");
		}
		myBooks = new ArrayList<Book>();
		for(Book book : theOther)
		{
			myBooks.add(book);
		}
	}
	/**
	 * method to add individual books to library
	 * if book is null or author or titles are empty, throw error
	 * returns add method of book list, since it returns
	 * a boolean
	 * @param theBook book to be added in
	 * @return if the operation was successful or not
	 */
	public boolean add(final Book theBook)
	{
		if(theBook == null)
		{
			throw new NullPointerException("Book cannot be null");
		}
		if(theBook.getTitle() == "" || theBook.getAuthors().get(0) == "")
		{
			throw new IllegalArgumentException("Title and authors" +
																		" cannot be empty");
		}
		
		return myBooks.add(theBook);
		
	}
	
	/**
	 * returns a list of books with specific title
	 * @param theTitle title to look for
	 * @return all books with title to look for
	 */
	public ArrayList<Book> findTitles(final String theTitle)
	{
		ArrayList<Book> returnList = new ArrayList<Book>();
		for(Book book : myBooks)
		{
			if(book.getTitle().compareTo(theTitle) == 0)
			{
				returnList.add(book);
			}
		}
		
		return returnList;
	}
	
	/**
	 * sorts books in list by using collection's method
	 * sorts it by ascending alphabetical title order
	 */
	public void sort()
	{
		Collections.sort(myBooks);
	}
	
	/**
	 * to string method to display all the book's in the library
	 * it displays the titles and authors of each book
	 * it utilizes the to string method of the book class
	 * @return the string message to display
	 */
	public String toString()
	{
		String message = "";
		for(Book book : myBooks)
		{
			message += book + "\n";
		}
		return message;
	}
	
	
}
