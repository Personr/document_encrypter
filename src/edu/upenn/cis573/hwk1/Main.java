package edu.upenn.cis573.hwk1;

import java.util.ArrayList;

public class Main {
	
	static DataDownloader dataDownloader = new FileReader();
	static Encrypter encrypter = new Cipher();
	static Decrypter decrypter = new Frequency();
	static DocumentChecker documentChecker = new DocumentChecker();

	public static void main(String []args) {
		if (args.length != 1) {
			System.out.println("Wrong number of argument : 1 expected, " + args.length + " found");
			System.exit(0);
		}
		ArrayList<Document> corpus = dataDownloader.getCorpus(args[0]);
		
		/* Perform cross-validation on the corpus */
		for (Document document: corpus) {
			ArrayList<Document> newCorpus = (ArrayList<Document>) corpus.clone();
			newCorpus.remove(document);
			Document encryptedDoc = encrypter.encrypt(document);
			Document decryptedDoc = decrypter.decrypt(encryptedDoc, newCorpus);
			documentChecker.checkDoc(document, decryptedDoc);
		}
		
		documentChecker.getFinalResult();
	}

}
