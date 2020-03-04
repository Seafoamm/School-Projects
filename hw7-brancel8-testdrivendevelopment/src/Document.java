import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/*********************************************************************
 * A representation of a simple text document without punctuation or
 * formatting (apart from line breaks). 
 * 
 * @author Nathan Sprague
 * @version V1.0, 02/2012
 *********************************************************************/
public class Document {

    // A two dimensional array of words. Each row in the array
    // represents a single line of text. Lines with no words are represented
    // as arrays of length 0.
    private String[][] words;

    /***********************************************************
     * Construct an empty document.
     ***********************************************************/
    public Document() 
    {
        words = new String[0][0];
    }

    /***********************************************************
     * Construct a document from a text file. 
     * 
     * @param fileName The name of the text file.
     * @throws FileNotFoundException
     ***********************************************************/
    public Document(String fileName) throws FileNotFoundException 
    {
    	File file;
      Scanner docScanner = null;

      String curLine;
      int numLines = 0;
      
      file = new File(fileName);

      	docScanner = new Scanner(file);
      
      

      // count lines...
      while (docScanner.hasNext()) {
          docScanner.nextLine();
          numLines++;
      }


      	docScanner = new Scanner(file);
      
      
      words = new String[numLines][];

      for (int i = 0; i < words.length; i++) {
          curLine = docScanner.nextLine();
          if(!curLine.equals(""))
          {
          	words[i] = curLine.trim().split("\\s+");
          }
          else
          {
          	words[i] = curLine.split("\\s+");
          }
          //splitting an empty string results in an array with a single
          //Empty string.  We want an empty array... 
          if (words[i][0].equals(""))
              words[i] = new String[0];
      }
      System.out.println(this);
        
    }

    /*********************************************************
     * Check to see if two document objects are equal.
     * 
     * @param otherDoc
     *            The other document
     * @return true if equal, false otherwise.
     ********************************************************/
    public boolean equals(Document otherDoc)
    {
        boolean areEqual = true;

        if (otherDoc == null || otherDoc.words.length != words.length)
        {
            areEqual = false;
        }
        else
        {
            for (int i = 0; i < words.length; i++)
            {
                if (words[i].length != otherDoc.words[i].length)
                {
                    areEqual = false;
                    break;
                }
                else
                {
                    for (int j = 0; j < words[i].length; j++)
                    {
                        if (!words[i][j].equals(otherDoc.words[i][j]))
                        {
                            areEqual = false;
                            break;
                        }
                    }
                }
            }
        }

        return areEqual;
    }


    /***********************************************************
     * Return the number of lines of text in this document, 
     * including empty lines.
     * 
     * @return Number of lines.
     ***********************************************************/
    public int numLines() 
    {
    	return words.length;
    }

    /***********************************************************
     * Return the number of words in this document.
     * 
     * @return Number of words.
     ***********************************************************/
    public int numWords() 
    {
    	int result = 0;
    	
    	for(String[] row : words)
    	{
    		for(String word : row)
    		{
    			result++;
    		}
    	}
    	
    	return result;
    }

    /***********************************************************
     * Return the indicated line of text as a string in which
     * each word is followed by a single space.  Returned strings
     * will not end with a newline. Lines with no words will be 
     * returned as empty strings.
     * 
     * @param lineNum  The (0-indexed) line of text to return.
     * @return The requested line.
     * @throws NoSuchLineException  If the indicated line does 
     *                              not exist in this document.
     ***********************************************************/
    public String getLine(int lineNum) throws NoSuchLineException 
    {
    	String result = "";
    	
    	if(lineNum <= words.length && lineNum > 0)
    	{
		    	for(String word : words[lineNum - 1])
		    	{
		    		result += word + " ";
		    	}
    	}
	    	
    	else
    	{
    			throw new NoSuchLineException("Line does not exist");
    	}
    	
    	return result;
    }

    /***********************************************************
     * Return the entire document as a string. There will be a 
     * a single space after each word. Each line will be terminated 
     * with a newline character.
     * 
     * @return The entire document in a String. 
     ***********************************************************/
    public String toString() 
    {
    	String result = "";
    	
    	for(String[] row : words)
    	{
    		
    		for(String word : row)
    		{
    			result += word + " ";
    		}
    		
    		result += "\n";
    	}
    	
    	return result;
    }

    /***********************************************************
     * Save this document to a file.  The format is exactly the 
     * same as that described in the toString method (hint).
     * If the file already exists, it will be overwritten.  
     * If the file cannot be written, this method returns false.
     * 
     * @param fileName   Name of the file to be written.
     * @return  true if the file was written, false otherwise
     ***********************************************************/
    public boolean saveDocument(String fileName) 
    {
    	PrintStream printer = null;
    	boolean result = true;
    	try
    	{
    		File saveFile = new File(fileName);
    		printer = new PrintStream(saveFile);
    		
    		printer.print(this.toString());
    	}
    	
    	catch(Exception e)
    	{
    		result = false;
    	}

    	
    	
    	return result;
    	
    }
}

class NoSuchLineException extends RuntimeException {

		/***********************************************************
     * Construct a new NoSuchLineException.
     * 
     * @param message  Error message. 
     ***********************************************************/
    public NoSuchLineException(String message)
    {
        super(message);
    }

}
