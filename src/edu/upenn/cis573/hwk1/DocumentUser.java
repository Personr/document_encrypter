package edu.upenn.cis573.hwk1;

public abstract class DocumentUser {
	
	/**
	 * Checks if a character is a letter or not.
	 */
	protected boolean isLetter(char c) {
		return ((int)c >= (int)'a' && (int)c <= (int)'z') || 
				((int)c >= (int)'A' && (int)c <= (int)'Z');
	}
	
	/**
	 * Makes a letter lowercase.
	 */
	protected char toLower(char letter) {
		if ((int)letter <= (int)'Z') {
			return (char)((int)letter + (int)'a' - (int)'A');
		} else {
			return letter;
		}
	}
	
}
