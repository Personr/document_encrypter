package edu.upenn.cis573.hwk1;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Frequency extends Decrypter {

	private Map<Character, Integer> corpusFrequencies;	
	private Map<Character, Integer> documentFrequencies;	
	private Map<Character, Character> associatedLetters;

	public Frequency() {
		corpusFrequencies = new HashMap<Character, Integer>();
		documentFrequencies = new HashMap<Character, Integer>();
		associatedLetters = new HashMap<Character, Character>();
	}
	
	/**
	 * Sorts the letters using their frequency.
	 *
	 * @param  frequencies the map associating each letter with it frequency
	 * @return a sorted ArrayList of <Map.Entry<Character, Integer>>
	 */
	private ArrayList<Map.Entry<Character, Integer>> sortLetters(Map<Character, Integer> frequencies) {
		Set<Map.Entry<Character, Integer>> set = frequencies.entrySet();
		ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(set);
		list.sort((elt1, elt2) -> elt1.getValue().compareTo(elt2.getValue()));
		return list;
	}
	
	/**
	 * Updates the frequencies counting the letters of the text.
	 *
	 * @param  text the text from which the letters are counted
	 * @param  frequencies the frequencies to update
	 */
	private void updateFrequencies(char[] text, Map<Character, Integer> frequencies) {
		for (char c: text) {
			if (isLetter(c)) {
				char letter = toLower(c);
				if (frequencies.containsKey(letter)) {
					frequencies.put(letter, frequencies.get(letter) + 1);
				} else {
					frequencies.put(letter, 1);
				}
			}				
		}
	}
	
	/**
	 * Builds a model to decrypt the letters of a document, using letter frequency analysis.
	 *
	 * @param  document the document to decrypt
	 * @param  corpus the corpus to help decrypt the document
	 */
	private void buildModel(Document document, ArrayList<Document> corpus) {
		/* Count the letters in the corpus */
		for (Document doc: corpus) {
			updateFrequencies(doc.getText(), this.corpusFrequencies);
		}
		/* Count the letters in the document */
		updateFrequencies(document.getText(), this.documentFrequencies);
		
		/* Associate each encrypted letter to another one using the frequencies */
		ArrayList<Map.Entry<Character, Integer>> corpusLetters = sortLetters(corpusFrequencies);
		ArrayList<Map.Entry<Character, Integer>> documentLetters = sortLetters(documentFrequencies);
		for (int i = 0; i < documentLetters.size(); i++) {
			associatedLetters.put(documentLetters.get(i).getKey(), corpusLetters.get(i).getKey());
		}
	}
	
	@Override
	protected char modifyChar(char c) {
		/* Replace a letter by its associated one */
		if (isLetter(c)) {
			return associatedLetters.get(c);
		} else {
			return c;
		}
	}

	@Override
	public Document decrypt(Document document, ArrayList<Document> corpus) {
		buildModel(document, corpus);	
		return new Document(document.getName(), modifyText(document.getText()));		
	}
	
}
