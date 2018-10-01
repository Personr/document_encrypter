package edu.upenn.cis573.hwk1;

public class Document {
	private String name;
	private char[] text;
	
	public Document(String name, char[] text) {
		this.name = name;
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public char[] getText() {
		return text;
	}
	
}
