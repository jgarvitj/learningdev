package com.week4.synonyms;

import java.util.*;

public class InterlangSynonyms {
	
	static Map<String, Synonyms> interlangDict = new HashMap<String, Synonyms>();
	static Scanner sc = new Scanner(System.in);
	
	public static void insertWord(String word) {
		
		System.out.println(word + " not in the dictionary");
		System.out.println("Type i to insert entry to dictionay, else enter anything else to proceed");
		
		String choice = sc.nextLine();
		
		//case where user shall enter new word
		if(choice.equals("i")) {
			
			String wordSynonyms;
			Synonyms newitem = new Synonyms();
			
			System.out.println("Enter synonyms, or press enter on empty line to finish:");
			do {
				wordSynonyms = sc.nextLine();
				if(wordSynonyms.length() > 0)
					newitem.addSynonym(wordSynonyms);
			}while(wordSynonyms.length() > 0);
			
			interlangDict.put(word,newitem);
		}
	}
	
	public static void main(String[] args) {
			
		Synonyms dictItem = new Synonyms();
		
		dictItem.addSynonym("Shubhodaya");
		dictItem.addSynonym("Shubhoday");
		dictItem.addSynonym("Bonjour");
		interlangDict.put("goodmorning", dictItem);
		
		Synonyms dictItem1 = new Synonyms();
		dictItem1.addSynonym("Susandhya");
		dictItem1.addSynonym("Bonsoir");
		dictItem1.addSynonym("Shubhasange");
		interlangDict.put("goodevening", dictItem1);
	
	
		
		String word1;
		
		while(true) {
			System.out.println("Enter word:");
			word1 = sc.nextLine();
			
			//exit condition
			if(word1.length() < 1) {
				System.out.println("Bye");
				break;
			}
			
			else {
				word1.toLowerCase();
				
				//case where word exists in the dictionary
				if(interlangDict.containsKey(word1)) {
					Synonyms item = interlangDict.get(word1);
					System.out.println(word1);
					ArrayList <String> item_translation = item.getSynonyms();
					for(String translation:item_translation) {
						System.out.println(translation);
					}
				}
				
				//case where no entries in the dictionary are found
				else {
					insertWord(word1);
				}
			}
		}
	}
}
