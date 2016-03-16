package it.polito.tdp.spellchecker.model;

import java.util.LinkedList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		//ItalianDictionary id =new ItalianDictionary();
		EnglishDictionary ed =new EnglishDictionary();

		
		//id.loadDictionary();
		ed.loadDictionary();
		
		List<String> parole=new LinkedList<String>();
		 
		/*parole.add("abbacchiamento");
		parole.add("abbacchiando");
		parole.add("fegojheuwhyqwugfh");*/
		
		parole.add("hello");
		parole.add("you");
		parole.add("fegojheuwhyqwugfh");
		
		/*parole.add("read");
		parole.add("art");
		parole.add("or");*/
		
		List<RichWord> paroleSbagliate=new LinkedList<RichWord>();
		
		//paroleSbagliate.addAll(id.spellCheckText(parole));
		paroleSbagliate.addAll(ed.spellCheckText(parole));

		
		for(RichWord r:paroleSbagliate){
			if(r.isCorretto()==false)
				System.out.println(r.toString());
		}





	}

}
