package it.polito.tdp.spellchecker.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	protected List<String>termini;
	private List<RichWord> parole;
	
	//private Set<RichWord> parole;



	
	public Dictionary() {
		 termini=new LinkedList<String>();
		 parole=new LinkedList<RichWord>();
		//parole=new HashSet<RichWord>();

	}


	public void loadDictionary(){		
	}
	
	
	 public List<RichWord>/*Set<RichWord>*/ spellCheckText(List<String> inputTextList){
		// ricerca con contains
		/*for(int i = 0;i<inputTextList.size();i++){
			    RichWord rw=new RichWord(inputTextList.get(i),termini.contains(inputTextList.get(i)));
			    parole.add(rw);
			    }
		return parole;
		}*/
		
			    
	    //ricerca dicotomica
/*		Collections.sort(termini);
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
		} */
	 
	 
	 
	 //ricerca dicotomica su database
	    for(int j = 0;j<inputTextList.size();j++){
	    	RichWord rw=new RichWord(inputTextList.get(j),this.ricercaDB(inputTextList.get(j)));
	    	parole.add(rw);
			    }
	    return parole;
}


	private boolean ricercaDB(String termine) {
		boolean flag=false;
		try {

			String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=";
			
			Connection conn = DriverManager.getConnection(jdbcURL);

			Statement st = conn.createStatement();

			String sql = "select nome from parola";

			ResultSet res = st.executeQuery(sql);
			
			while(res.next()){
				String nome = res.getString("nome");
				if(nome.compareTo(termine)==0)
					flag= true;
			}
			res.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return flag;
	}
}
       
	
	
	
	
	
	
  
 
	


	