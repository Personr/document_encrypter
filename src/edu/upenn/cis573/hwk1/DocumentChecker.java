package edu.upenn.cis573.hwk1;

public class DocumentChecker extends DocumentUser {
	
	static private OutputWriter outputWriter;
	private int correct;
	private int incorrect;
	
	public DocumentChecker() {
		outputWriter = new ConsoleWriter();
		correct = 0;
		incorrect = 0;
	}

	/**
	 * Compares a decrypted document to the original one and displays the results.
	 *
	 * @param  document the original document
	 * @param  decryptedDoc the decrypted document
	 */
	public void checkDoc(Document document, Document decryptedDoc) {
		int docCorrect = 0;
		int docIncorrect = 0;
		char[] text = document.getText();
		char[] decryptedText = decryptedDoc.getText();
		final int length = document.getText().length;
		for (int i = 0; i < length; i++) {
			if (isLetter(text[i])) {
				if (toLower(text[i]) == decryptedText[i]) {
					correct++;
					docCorrect++;
				} else {
					incorrect++;
					docIncorrect++;
				}
			}
		}
		outputWriter.displayDocument(document.getName(), docCorrect, docIncorrect);
	}
	
	/**
	 * Displays the final result of cross-validation
	 */
	public void getFinalResult() {
		outputWriter.displayTotal(correct, incorrect);
	}
	
}
