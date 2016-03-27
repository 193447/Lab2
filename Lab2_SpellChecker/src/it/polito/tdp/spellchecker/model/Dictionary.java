package it.polito.tdp.spellchecker.model;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	protected List<String> termini;
	private List<RichWord> parole;


	
	public Dictionary() {
		termini=new LinkedList<String>();
		 parole=new LinkedList<RichWord>();
	}


	public void loadDictionary(){		
	}
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		// ricerca con contains
	/*	for(int i = 0;i<inputTextList.size();i++){
			    RichWord rw=new RichWord(inputTextList.get(i),termini.contains(inputTextList.get(i)));
			    parole.add(rw);
			    }
		return parole;
		}
		*/
			    
	    //ricerca dicotomica
		Collections.sort(termini);
	    for(int j = 0;j<inputTextList.size();j++){
	    	RichWord rw=new RichWord(inputTextList.get(j),this.ricercaDicotominca(inputTextList.get(j),0,termini.size()-1));
	    	parole.add(rw);
			    }
	    return parole;
	}


public boolean ricercaDicotominca(String parola,int a,int b){
	
	if(a<=b){
	if(termini.get((a+b)/2).equals(parola)){
		return true;
	}
	else {
		if(termini.get((a+b)/2).compareTo(parola)>0)
			return ricercaDicotominca(parola,a,((a+b)/2)-1);
		if(termini.get((a+b)/2).compareTo(parola)<0)
			return ricercaDicotominca(parola,((a+b)/2)+1,b);
	}
	
}
	return false;
}

	
		 		/*if(a<=b){
					if(el.equals(termini.get((a+b)/2)))
		 				return true;
		 			if(el.compareTo(termini.get((a+b)/2))>0)
		 				return ricercaDicotominca(el,1+(a+b)/2,b);
		 			else
		 				return ricercaDicotominca(el,a,(a+b)/2-1);
		 		}
		 		return false;
	}
	*/
}
	
	
	
	
	
	
	
  
 
	


	