package edu.upenn.cis573.hwk1;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReader extends DataDownloader {

	/**
	 * Reads a local file.
	 *
	 * @param  path the path to the file
	 * @return the text of the file in a char[]
	 */
	private char[] readFile(String path) {
		Path file = FileSystems.getDefault().getPath(path);
		byte[] fileArray;
		try {
			fileArray = Files.readAllBytes(file);
			String fileString = new String(fileArray);
			return fileString.toCharArray();
		} catch (IOException e) {
			System.out.println("File can't be opened (check permissions) : " + file);
			System.exit(0);
			return null;
		}
	}
	
	@Override
	public ArrayList<Document> getCorpus(String path) {
		/* Builds the corpus reading the files of a local directory */
		File[] files = new File(path).listFiles();
		if (files == null) {
			System.out.println("The specified directory does not exist : " + path);
			System.exit(0);
		} else if (files.length == 0) {
			System.out.println("The specified directory does not contain any file : " + path);
			System.exit(0);
		}
		ArrayList<Document> corpus = new ArrayList<Document>();
		
		for (File file: files) {
			if (file.getName().contains(".txt")) {
				corpus.add(new Document(file.getName(), readFile(file.getAbsolutePath())));
			}
		}
		return corpus;
	}

}
