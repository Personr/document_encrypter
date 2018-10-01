package edu.upenn.cis573.hwk1.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import edu.upenn.cis573.hwk1.*;
import org.junit.Test;

public class FrequencyTest {

	@Test
	public void test() {
		System.out.println("FrequencyTest");
		Document document = new Document("name", "aaabbc,".toCharArray());
		ArrayList<Document> corpus = new ArrayList<Document>();
		corpus.add(new Document("name", "xxxyyz".toCharArray()));
		Decrypter decrypter = new Frequency();
		char[] expectedOutput = "xxxyyz,".toCharArray();
		
	    assertEquals(String.valueOf(expectedOutput),String.valueOf(decrypter.decrypt(document, corpus).getText()));
	}
	
	@Test
	public void testAmbiguity() {
		System.out.println("FrequencyTest2");
		Document document = new Document("name", "aaabbcc,".toCharArray());
		ArrayList<Document> corpus = new ArrayList<Document>();
		corpus.add(new Document("name", "xxxyyzz".toCharArray()));
		Decrypter decrypter = new Frequency();
		char[] expectedOutput = "xxxyyzz,".toCharArray();
		
	    assertEquals(String.valueOf(expectedOutput),String.valueOf(decrypter.decrypt(document, corpus).getText()));
	}

}
