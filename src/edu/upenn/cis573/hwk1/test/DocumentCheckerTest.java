package edu.upenn.cis573.hwk1.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import edu.upenn.cis573.hwk1.Document;
import edu.upenn.cis573.hwk1.DocumentChecker;

public class DocumentCheckerTest {
	
	DocumentChecker documentChecker = new DocumentChecker();
	ByteArrayOutputStream output = new ByteArrayOutputStream();
	PrintStream standardOut = System.out;

	@Test
	public void testMatch() {
		System.out.println("DocumentCheckerTest1");
		System.setOut(new PrintStream(output));
		
		Document document = new Document("name", "azertyuiop,".toCharArray());
		Document decryptedDoc = new Document("name", "azertyuiop,".toCharArray());		
		documentChecker.checkDoc(document, decryptedDoc);
		String expectedOutput = "name: 10 correct, 0 incorrect\n"; 
		
		System.setOut(standardOut);
		assertEquals(expectedOutput, output.toString());
	}
	
	@Test
	public void testErrors() {
		System.out.println("DocumentCheckerTest2");
		System.setOut(new PrintStream(output));
		
		Document document = new Document("name", "azertyuiopqsd,".toCharArray());
		Document decryptedDoc = new Document("name", "azertyuiopfgh,".toCharArray());		
		documentChecker.checkDoc(document, decryptedDoc);
		String expectedOutput = "name: 10 correct, 3 incorrect\n"; 
		
		System.setOut(standardOut);
		assertEquals(expectedOutput, output.toString());
	}
	
	@Test
	public void testTotal() {
		System.out.println("DocumentCheckerTest3");
		System.setOut(new PrintStream(output));
		
		Document document = new Document("name", "azertyuiop,".toCharArray());
		Document decryptedDoc = new Document("name", "azertyuiop,".toCharArray());		
		documentChecker.checkDoc(document, decryptedDoc);
		document = new Document("name", "azertyuiopqsd,".toCharArray());
		decryptedDoc = new Document("name", "azertyuiopfgh,".toCharArray());		
		documentChecker.checkDoc(document, decryptedDoc);
		
		output.reset();
		documentChecker.getFinalResult();
		String expectedOutput = "\nTotal: 20 correct, 3 incorrect\n" + 
				"Accuracy: 86,96%\n"; 
		
		System.setOut(standardOut);
		assertEquals(expectedOutput, output.toString());
	}
	
}
