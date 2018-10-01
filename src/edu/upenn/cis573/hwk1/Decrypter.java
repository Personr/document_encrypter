package edu.upenn.cis573.hwk1;

import java.util.ArrayList;

public abstract class Decrypter extends DocumentModifier {

	/**
	 * Attempts to decrypt a Document object using a corpus of other documents. 
	 * The text is decrypted but the name remains the same.
	 *
	 * @param  document the document to decrypt
	 * @param  corpus the corpus to help decrypt the document
	 * @return      the decrypted document
	 * @see         Document
	 */
	public abstract Document decrypt(Document document, ArrayList<Document> corpus);
	
}
