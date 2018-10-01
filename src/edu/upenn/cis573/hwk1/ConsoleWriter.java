package edu.upenn.cis573.hwk1;

import java.text.DecimalFormat;

public class ConsoleWriter extends OutputWriter {
	
	@Override
	public void displayDocument(String name, int correct, int incorrect) {
		System.out.println(name + ": " + correct + " correct, " + incorrect + " incorrect");
	}
	
	@Override
	public void displayTotal(int correct, int incorrect) {
		System.out.println("");
		System.out.println("Total: " + correct + " correct, " + incorrect + " incorrect");
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		System.out.println("Accuracy: " + df.format((double)correct * 100 / (correct + incorrect)) + "%");
	}

}
