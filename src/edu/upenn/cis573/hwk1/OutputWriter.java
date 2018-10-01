package edu.upenn.cis573.hwk1;

public abstract class OutputWriter {
	
	/**
	 * Displays the results of the decryption of a document.
	 *
	 * @param  name the name of the document
	 * @param correct the number of letters correctly decrypted
	 * @param incorrect the number of letters incorrectly decrypted
	 */
	public abstract void displayDocument(String name, int correct, int incorrect);
	
	/**
	 * Displays the final results of the cross-validation.
	 *
	 * @param  correct the overall number of letters correctly decrypted
	 * @param  correct the overall number of letters incorrectly decrypted
	 */
	public abstract void displayTotal(int correct, int incorrect);

}
