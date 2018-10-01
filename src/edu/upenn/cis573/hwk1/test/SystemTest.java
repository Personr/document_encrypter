package edu.upenn.cis573.hwk1.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import edu.upenn.cis573.hwk1.Main;

public class SystemTest {
	
	ByteArrayOutputStream output = new ByteArrayOutputStream();
	PrintStream standardOut = System.out;

	@Test
	public void test() {
		System.out.println("SystemTest");
		System.setOut(new PrintStream(output));
		
		String[] path = {"src/edu/upenn/cis573/hwk1/test/corpus"};
		Main.main(path);
		String expectedOutput = "file2.txt: 7 correct, 3 incorrect\n" + 
				"file3.txt: 4 correct, 2 incorrect\n" + 
				"file1.txt: 9 correct, 0 incorrect\n" + 
				"\n" + 
				"Total: 20 correct, 5 incorrect\n" + 
				"Accuracy: 80%\n";
		
		System.setOut(standardOut);
		assertEquals(String.valueOf(expectedOutput), output.toString());
	}
	
}
