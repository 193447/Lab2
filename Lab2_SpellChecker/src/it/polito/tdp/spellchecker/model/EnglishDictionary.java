package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EnglishDictionary extends Dictionary {
	


	public EnglishDictionary() {
	}

	public void loadDictionary(){	
		try {
			FileReader fr = new FileReader("rsc/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				super.termini.add(word);
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
	}

}
