package edu.upenn.cis573.hwk1.test;

import edu.upenn.cis573.hwk1.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CipherTest {

	@Test
	public void test() {
		System.out.println("CipherTest");
		Document document = new Document("name", "amezijmlvnwbMHLcpvovha;,:;!64513".toCharArray());
		Encrypter encrypter = new Cipher();
		char[] expectedOutput = "bnfajknmwoxcnimdqwpwib;,:;!64513".toCharArray();
		
	    assertEquals(String.valueOf(expectedOutput),String.valueOf(encrypter.encrypt(document).getText()));
	}

}
