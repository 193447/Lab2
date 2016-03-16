package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.ItalianDictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	ItalianDictionary id=new ItalianDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextArea txtInsert;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea txtShow;

    @FXML
    private Label lblError;

    @FXML
    private Button btnClear;

    @FXML
    private Label lblTime;
    
    @FXML
    void doClear(ActionEvent event) {

    }

    @FXML
    void doSpell(ActionEvent event) {
    	List<String>lista=new LinkedList<String>();
    	if(comboBox.getValue()=="Italian"){
    		id.loadDictionary();
    		String[] s=txtInsert.getText().split(" ");
    		for(int i=0;i<s.length;i++){
    			lista.add(s[i]);
    		}
    		List<RichWord>list=id.spellCheckText(lista);
    		for(RichWord r:list){
    			if(r.isCorretto()==true)
    				list.remove(r);
    		}
    		for(RichWord r:list){
    			txtShow.setText(r.toString());
    		}
    		if(lista.size()==0){
    			lblError.setText("Your text don't contains errors!");
    		}
    		else
    			lblError.setText("Your text contains errors!");
    		comboBox.setDisable(true);
    		

    			
    	}

    }

    @FXML
    void initialize() {
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtShow != null : "fx:id=\"txtShow\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblError != null : "fx:id=\"lblError\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        
        comboBox.getItems().addAll("Italian","English");

    }
}

