/*
 * Brandon Lu
 * TCSS143
 * Professor Schuessler
 * 11/5/2019
 */
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * driver class to display library contents
 * reads information from 2 text files to make books
 * outputs to a file the library contents and various
 * tests
 * @author Brandon Lu
 * @version 5 November 2019
 */
public class LibraryDriver {

	/**
	 * main driver method to execute the program and tests
	 * @param theArgs the information to send in for commands
	 */
	public static void main(String[] theArgs) {
	
		//initiate scanner and printstream as 
		//null at first before we test if they 
		//use valid files
		Scanner inputFile = null;
		PrintStream outputFile = null;
		
		//try statement to test files
		try 
		{
			inputFile = new Scanner(new File("LibraryIn1.txt"));
			outputFile = new PrintStream(new File("LibraryOut.txt"));
		}
		//if the files are not valid throw exception
		//and exit program
		catch (Exception e)
		{
			System.out.println("Difficulties opening the file! " + e);
			System.exit(1);
		}
		
		//makes a list of authors to store each
		//line of authors read from the file
		ArrayList<String> authors = new ArrayList<String>();
		//list of books to store books from file to put into
		//library after reading
		ArrayList<Book> books = new ArrayList<Book>();
		
		//reads from first file and makes a list
		//of books from the first file
		while(inputFile.hasNext())
		{
			String title = inputFile.nextLine();

			for(String name : inputFile.nextLine().split("\\*", -1))
			{
				authors.add(name);
			}
			
			books.add(new Book(title, authors));
			
			authors.clear();
			
		}
		
		//adds the list of books into the library
		Library lib = new Library(books);
		
		//prints the contents of the library, unsorted
		outputFile.println("PRINTS INITIAL BOOK LIST: ");
		outputFile.println(lib);
		
		//sort the library
		lib.sort();
		
		//prints sorted list of books of the library
		outputFile.println("PRINTS SORTED BOOK LIST: ");
		outputFile.println(lib);
		
		//close the first input file
		inputFile.close();
		
		//reset input file to prepare
		//to set it to the 2nd file
		inputFile = null;
		
		//try to see if 2nd input file is valid
		try 
		{
			inputFile =  new Scanner(new File("LibraryIn2.txt"));
		}
		
		//throw error if file is not valid
		catch (Exception e)
		{
			System.out.println("Difficulties opening the file! " + e);
			System.exit(1);
		}
		
		//clear the books and authors
		//they will store the 2nd file's information now
		books.clear();
		authors.clear();		
		
		//read from the second file
		//authors list for author lines
		//add all information into book list
		while(inputFile.hasNext())
		{
			String title = inputFile.nextLine();
			
			for(String name : inputFile.nextLine().split("\\*", -1))
			{
				authors.add(name);
			}
			
			books.add(new Book(title, authors));
			
			authors.clear();
		}
		
		//add books from 2nd file into library
		for(Book book : books)
		{
			lib.add(book);
		}
		
		//print out new total list unsorted with new books
		outputFile.println("PRINTS WITH NEW BOOKS UNSORTED: ");
		outputFile.println(lib);
		
		//sort the library
		lib.sort();
		
		//print sorted book list
		outputFile.println("PRINTS ALL SORTED BOOK LIST: ");
		outputFile.println(lib);
		
		//make lists to find all books with specific titles test
		ArrayList<Book> findTitles1 = lib.findTitles("Acer Dumpling");
		ArrayList<Book> findTitles2 = lib.findTitles("The Bluff");
		
		//print all books with title: "Acer Dumpling"
		outputFile.println("PRINTS ALL \"ACER DUMPLINGS\"s: ");
		outputFile.println(displayBooks(findTitles1));
		
		//print all books with title: "The Bluff"
		outputFile.println("PRINTS ALL \"THE BLUFF\"s: ");
		outputFile.println(displayBooks(findTitles2));
		
		//close input and output files
		inputFile.close();
		outputFile.close();
		
	}
	
	/**
	 * method to display book list contents
	 * @param theBookList list to get books from
	 * @return the string to display with all the book contents
	 */
	public static String displayBooks(ArrayList<Book> theBookList)
	{
		String message = "";
		for(Book book : theBookList)
		{
			message += book + "\n";
		}
		return message;
	}

}
