/*
 * Brandon Lu
 * TCSS 305 - Winter 2020
 * Professor Dincer
 * 2/29/2020
 */

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * JUnit class to test methods of Document class
 * @author Brandon Lu
 * @version 29 February 2020
 */
@DisplayName ("Document Test Class")
class DocumentTest {

	/*
	 * make new document with empty line
	 * make document with equal number of words and lines, just different word
	 */
	static Document docRefX;
	static Document docRef0;
	static Document docRef11;
	static Document docRef1n;
	static Document docRefmn;
	static Document docExtra1;
	static Document docExtra2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		docRefX = null;
		docRef0 = new Document("infile_empty.txt");
		docRef11 = new Document("infile_11.txt");
		docRef1n = new Document("infile_1n.txt");
		docRefmn = new Document("infile_mn.txt");
		docExtra1 = new Document("infile_blankLines.txt");
		docExtra2 = new Document("infile_1m.txt");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		docRefX = null;
		docRef0 = null;
		docRef11 = null;
		docRef1n = null;
		docRefmn = null;
		docExtra1 = null;
		docExtra2 = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		docRefX = null;
		docRef0 = new Document("infile_empty.txt");
		docRef11 = new Document("infile_11.txt");
		docRef1n = new Document("infile_1n.txt");
		docRefmn = new Document("infile_mn.txt");
		docExtra1 = new Document("infile_blankLines.txt");
		docExtra2 = new Document("infile_1m.txt");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		docRefX = null;
		docRef0 = null;
		docRef11 = null;
		docRef1n = null;
		docRefmn = null;
		docExtra1 = null;
		docExtra2 = null;
	}

	/**
	 * Test method for {@link Document#Document()}.
	 */
	@Test
	@DisplayName ("Document no arg constructor test")
	@Tag ("Constructor")
	void testDocument() {
		
		assertNotNull("1.1 Testing new document equals new document",
				new Document());
	}

	/**
	 * Test method for {@link Document#Document(java.lang.String)}.
	 */
	@Test
	@DisplayName ("Document constructor accepting string arg for filename test")
	@Tag ("Constructor")
	void testDocumentString() throws FileNotFoundException {

			assertThrows(Exception.class,
					() -> new Document("nofile.txt"),
					"2.1 Testing null document with string arg throws "
					+ "FileNotFoundException error");
			assertEquals("2.2 Testing document with string arg makes correct document",
					docRef0, docRef0);
			assertEquals("2.3 Testing document with string arg makes correct document",
					docRef11, docRef11);
			assertEquals("2.4 Testing document with string arg makes correct document",
					docRef1n, docRef1n);
			assertEquals("2.5 Testing document with string arg makes correct document",
					docRefmn, docRefmn);
			assertEquals("2.6 Testing document with blank line", docExtra1, docExtra1);
	}


	/**
	 * Test method for {@link Document#numLines()}.
	 */
	@Test
	@DisplayName ("Test for getting total line number from document")
	@Tag ("TotalLines")
	void testNumLines() {
		
		assertThrows(NullPointerException.class, () -> docRefX.numLines(), 
				"3.1 Test null document to throw NullPointerException");
		assertEquals("3.2 Test that empty document has 0 lines",
				docRef0.numLines(), 0);
		assertEquals("3.3 Test that 1 line 1 word document has 1 line",
				docRef11.numLines(), 1);
		assertEquals("3.4 Test that 1 line n words document has 1 line",
				docRef1n.numLines(), 1);
		assertEquals("3.5 Test that 5 lines document has 5 lines",
				docRefmn.numLines(), 5);
	}

	/**
	 * Test method for {@link Document#numWords()}.
	 */
	@Test
	@DisplayName ("Test for getting total number of words from document")
	@Tag ("TotalWords")
	void testNumWords() {
		
		assertThrows(NullPointerException.class, () -> docRefX.numWords(), 
				"4.1 Test null document to throw NullPointerException");
		assertEquals("4.2 Test that empty document has 0 words",
				docRef0.numWords(), 0);
		assertEquals("4.3 Test that 1 line 1 word document has 1 word",
				docRef11.numWords(), 1);
		assertEquals("4.4 Test that 1 line 12 words document has 12 words",
				docRef1n.numWords(), 12);
		assertEquals("4.5 Test that 5 lines document has 11 words",
				docRefmn.numWords(), 11);
		

	}

	/**
	 * Test method for {@link Document#getLine(int)}.
	 */
	@Test
	@DisplayName ("Test for getting certain line from document")
	@Tag ("GetLine")
	void testGetLine() {
		assertThrows(NullPointerException.class, () -> docRefX.getLine(1), 
				"5.1 Test null document to throw NullPointerException");
		assertThrows(NoSuchLineException.class, () -> docRef0.getLine(1),
				"5.2 Test getting positive number line from empty document");
		assertTrue("5.3 Test getting line 1 from 1 line document",
					docRef11.getLine(1).equals("Mary "));
		assertThrows(NoSuchLineException.class, () -> docRef11.getLine(2),
				"5.3 getting positive number more than 1 from 1 line document");
		assertThrows(NoSuchLineException.class, () -> docRef11.getLine(0),
				"5.4 getting line zero from 1 line document");
		assertThrows(NoSuchLineException.class, () -> docRef11.getLine(-1),
				"5.5 getting negative number line from 1 line document");
		assertThrows(NoSuchLineException.class, () -> docRef1n.getLine(0),
				"5.6 getting line zero from 1 line document");
		assertTrue("5.7 Test getting line 1 from 1 line document",
				docRef1n.getLine(1).equals("This is a long line of text"
							+ " just one line not two "));
		assertThrows(NoSuchLineException.class, () -> docRef1n.getLine(-1),
				"5.8 getting negative number line from 1 line document");
		assertTrue("5.9 Test getting positive line <= line count"
				+ " from multi-line document",
				docRefmn.getLine(1).equals("Mary had "));
		assertThrows(NoSuchLineException.class, () -> docRef1n.getLine(99),
				"5.10 getting positive line > line count from multi-line document");
		
	}

	/**
	 * Test method for {@link Document#equals(Document)}.
	 */
	@Test
	@DisplayName ("Equals test")
	@Tag ("Equals")
	void testEqualsDocument() {
			assertNull("6.1 Test null document equals null document", docRefX);
			assertThrows(NullPointerException.class,
					() -> docRefX.equals(docRef0),
					"6.2 Test null document does not equal empty document");
			assertFalse("6.3 1 line 1 word document does not equal empty doc",
					docRef11.equals(docRef0));
			assertFalse("6.4 1 line 1 word document does not equal 1 line multi-word doc",
					docRef11.equals(docRef1n));
			assertFalse("6.5 multi-lines and words document does not equal "
					+ "1 line multi-word doc",
					docRef1n.equals(docRefmn));
			assertTrue("6.6 multi-line doc equals itself",
					docRefmn.equals(docRefmn));
			assertFalse("6.7 same amount of lines and words, but different words",
					docRef1n.equals(docExtra2));
	}
	
	/**
	 * Test method for {@link Document#toString()}.
	 */
	@Test
	@DisplayName ("Test for string representation of document")
	@Tag ("toString")
	void testToString() {
		assertThrows(NullPointerException.class, () -> docRefX.toString(),
				"7.1 Test toString of null doc throws exception");
		assertTrue("7.2 toString of empty document",
				docRef0.toString().contentEquals(""));
		assertTrue("7.3 toString of 1 line 1 word doc",
				docRef11.toString().equals("Mary \n"));
		assertTrue("7.4 toString of 1 line multi-word doc",
				docRef1n.toString().equals("This is a long line of "
						+ "text just one line not two \n"));
		System.out.println(docRefmn.toString());
		System.out.println(docRefmn.toString());
		System.out.println(docRefmn.toString());
		assertTrue("7.5 toString of multi word and line doc",
				docRefmn.toString().equals("Mary had \na little lamb \nIts fleece "
						+ "was \nwhite \nas snow \n"));
	}

	/**
	 * Test method for {@link Document#saveDocument(java.lang.String)}.
	 */
	@Test
	@DisplayName ("Test for saving document to file/overwriting")
	@Tag("Save")
	void testSaveDocument() {
		assertThrows(NullPointerException.class, 
				() -> docRefX.saveDocument("outfile.txt"), 
				"8.1 Test saving a null document");
		assertTrue("8.2 Test saving empty document",
				docRef0.saveDocument("outfile.txt"));
		assertTrue("8.3 Test saving 1 line 1 word document",
				docRef11.saveDocument("outfile_11.txt"));
		assertTrue("8.4 Test saving 1 line mult-word document",
				docRef1n.saveDocument("outfile_1n.txt"));
		assertTrue("8.5 Test saving multi lines and words doc",
				docRefmn.saveDocument("outfile_mn.txt"));
		assertFalse("8.6 Test saving to invalid file",
				docRef0.saveDocument(""));
	}

}
