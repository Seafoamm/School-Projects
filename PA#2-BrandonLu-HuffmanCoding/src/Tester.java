/*
 * Brandon Lu
 * TCSS 342 - Spring 2020
 * Professor Sakpal
 * 5/15/2020
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * test class to test encoding and decoding a string
 * as well as the huffman table and tree
 * @author Brandon Lu
 * @version 15 May 2020
 */
public class Tester {

	/**
	 * constructs a tester object which: 
	 * prints to console and an output file
	 * the huffman frequency table, the encoded bit stream, 
	 * stats about the compression, and the decoded string
	 * @param theInput
	 */
	public Tester(String theInput)
	{
		HuffmanTree ht = new HuffmanTree(new HuffmanFrequencyTable(theInput));
		System.out.println("% java Tester " + theInput);
		System.out.println("================================");
		System.out.print(ht.getPrintableTable());
		System.out.println("================================");
		System.out.println("Encoded bit stream: ");
		Encoder e = new Encoder(ht, theInput);
		System.out.println(e.getEncoded());
		System.out.println();
		System.out.println("Total number of bits without Huffman coding " + 
				"(8-bits per character): " +
				ht.getHuffmanTree().getFrequency() * 8);
		System.out.println("Total number of bits with Huffman coding: " + 
		e.getEncoded().length());
		System.out.println("Compression Ratio: " +
		((double) (ht.getHuffmanTree().getFrequency() * 8) / e.getEncoded().length()));
		Decoder d = new Decoder(ht, e.getEncoded());
		System.out.println("Decoded String: " + d.getDecoded());
//		ht.printNodes(ht.getHuffmanTree());
		
		PrintStream printer = null;
		try
		{
			printer = new PrintStream(new File("output.txt"));
		}
		
		catch(FileNotFoundException fnfe)
		{
			System.out.println(fnfe);
		}
		printer.println("% java Tester " + theInput);
		printer.println("================================");
		printer.print(ht.getPrintableTable());
		printer.println("================================");
		printer.println("Encoded bit stream: ");
		printer.println(e.getEncoded());
		printer.println();
		printer.println("Total number of bits without Huffman coding " + 
				"(8-bits per character): " +
				ht.getHuffmanTree().getFrequency() * 8);
		printer.println("Total number of bits with Huffman coding: " + 
		e.getEncoded().length());
		printer.println("Compression Ratio: " +
		((double) (ht.getHuffmanTree().getFrequency() * 8) / e.getEncoded().length()));
		printer.println("Decoded String: " + d.getDecoded());
	}

}
