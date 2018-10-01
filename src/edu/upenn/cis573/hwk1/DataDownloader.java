package edu.upenn.cis573.hwk1;

import java.util.ArrayList;

public abstract class DataDownloader {

	/**
	 * Builds a corpus of documents using a path.
	 *
	 * @param  path the path to get the documents from
	 * @return an ArrayList of Document objects
	 * @see Document
	 */
	public abstract ArrayList<Document> getCorpus(String path);
	
}
