package edu.upenn.cis573.hwk1;

public class Cipher extends Encrypter {
	
	@Override
	protected char modifyChar(char c) {
		/* If the character is a letter, makes it lowercase and shifts it to the right */
		if (isLetter(c)) {
			if ((int)c <= (int)'Z') {
				c = toLower(c);
			}
			return (char)((c + 1 - (int)'a') % 26 + (int)'a');
		} else {
			return c;
		}
	}

	@Override
	public Document encrypt(Document document) {
		return new Document(document.getName(), modifyText(document.getText()));
	}

}
