package edu.upenn.cis573.hwk1.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(CipherTest.class, FileReaderTest.class, 
    		  FrequencyTest.class, DocumentCheckerTest.class,
    		  SystemTest.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
}