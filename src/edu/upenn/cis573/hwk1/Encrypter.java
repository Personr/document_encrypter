package edu.upenn.cis573.hwk1;

public abstract class Encrypter extends DocumentModifier {
	
	/**
	 * Returns an encrypted version of a Document object. 
	 * The text is encrypted but the name remains the same.
	 *
	 * @param  document the document to encrypt
	 * @return      the encrypted document
	 * @see         Document
	 */
    public abstract Document encrypt(Document document);
	
}
