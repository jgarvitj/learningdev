package com.week4.synonyms;

import java.util.ArrayList;

public class Synonyms {
	private ArrayList<String> synonyms = new ArrayList<String>();
	
	public void addSynonym(String wordSynonym) {
		synonyms.add(wordSynonym);
	}

	public ArrayList<String> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(ArrayList<String> synonyms) {
		this.synonyms = synonyms;
	}

	
}
