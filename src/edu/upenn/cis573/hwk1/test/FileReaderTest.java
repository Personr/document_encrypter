package edu.upenn.cis573.hwk1.test;

import edu.upenn.cis573.hwk1.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class FileReaderTest {
		
	@Test
	public void testRelative() {
		System.out.println("FileReaderTest");
		String path = "src/edu/upenn/cis573/hwk1/test";
		DataDownloader fileReader = new FileReader();
		ArrayList<Document> corpus = fileReader.getCorpus(path);
		char[] expectedOutput = "eZGQGQGDFD\nsdfdsfs\nd5767\n!!;:,".toCharArray();
		
		assertEquals(String.valueOf(expectedOutput),String.valueOf(corpus.get(0).getText()));
	}

}
