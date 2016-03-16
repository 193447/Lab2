package it.polito.tdp.spellchecker.model;


import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	List<String> termini=new LinkedList<String>();
	private List<RichWord> paroleSbagliate=new LinkedList<RichWord>();


	
	public Dictionary() {
	}


	public void loadDictionary(){		
	}
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		for(int i = 0;i<inputTextList.size();i++){
			    RichWord rw=new RichWord(inputTextList.get(i),termini.contains(inputTextList.get(i)));
			    paroleSbagliate.add(rw);
			}
		return paroleSbagliate;
}
}


