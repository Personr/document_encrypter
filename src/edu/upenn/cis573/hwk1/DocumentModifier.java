package edu.upenn.cis573.hwk1;

public abstract class DocumentModifier extends DocumentUser {
	
	/**
	 * Modifies a character.
	 *
	 * @param c the character to be modified
	 * @return the modified character
	 */
	protected abstract char modifyChar(char c);
	
	/**
	 * Modifies a text applying the modifyChar method on every character of the text.
	 *
	 * @param  text the text to be modified
	 * @return the modified text
	 */
	public char[] modifyText(char[] text) {
		final char[] newText = text.clone();
		final int length = newText.length;
		for (int i = 0; i < length; i++) {
			newText[i] = modifyChar(newText[i]);
		}
		return newText;
	}

}
