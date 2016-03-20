package it.polito.tdp.spellchecker.model;


import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	protected List<String> termini=new LinkedList<String>();
	private List<RichWord> paroleSbagliate=new LinkedList<RichWord>();


	
	public Dictionary() {
	}


	public void loadDictionary(){		
	}
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		// ricerca con contains
		/*for(int i = 0;i<inputTextList.size();i++){
			    RichWord rw=new RichWord(inputTextList.get(i),termini.contains(inputTextList.get(i)));
			    if(termini.contains(inputTextList.get(i))==false)
			    	paroleSbagliate.add(rw);
			    */
	    //ricerca dicotomica
	    for(int j = 0;j<inputTextList.size();j++){
		    RichWord rw=new RichWord(inputTextList.get(j),termini.contains(inputTextList.get(j)));
	    	if(this.ricercaDicotominca(inputTextList.get(j),termini)==false)
		    	paroleSbagliate.add(rw);
	    	else{	
	    	}
			}
		return paroleSbagliate;
	}


public boolean ricercaDicotominca(String parola,List<String> termini){
    int i=termini.size()/2;
    if(i==1){
		if(termini.get(i).compareTo(parola)==0){
			return true;
		}
		else
	    	return false;

	}
    else{
    if(termini.get(i).compareTo(parola)==0){
    	return true;
    }
	else if(termini.get(i).compareTo(parola)>0){
		List<String> terminiTemp=new LinkedList<String>();
		for(int k = 0;k<i;k++){
			terminiTemp.add(termini.get(k));
			}
    	return ricercaDicotominca(parola,terminiTemp);
    	}
    
	else if(termini.get(i).compareTo(parola)<0){
		List<String> terminiTemp=new LinkedList<String>();
		for(int k = i+1;k<termini.size();k++){
			terminiTemp.add(termini.get(k));
			}
		return ricercaDicotominca(parola,terminiTemp);
    		
}
}
	return true;
}
}
	
	