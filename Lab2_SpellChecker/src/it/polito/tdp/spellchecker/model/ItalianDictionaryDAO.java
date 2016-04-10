package it.polito.tdp.spellchecker.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItalianDictionaryDAO extends Dictionary{
	
	
	public ItalianDictionaryDAO() {
	}
	
	public void loadDictionary(){
		try {
			
			String jdbcURL= "jdbc:mysql://localhost/dizionario?user=root&password=";

			Connection conn = DriverManager.getConnection(jdbcURL);

			Statement st = conn.createStatement();

			String sql = "select nome from  parola";

			ResultSet res = st.executeQuery(sql);

			while(res.next()){
				super.termini.add(res.getString("nome"));
			}			
			res.close();
			conn.close();			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
