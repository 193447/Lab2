package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.EnglishDictionary;
import it.polito.tdp.spellchecker.model.ItalianDictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SpellCheckerController {
	
	ItalianDictionary id=new ItalianDictionary();
	EnglishDictionary ed=new EnglishDictionary();

	List<String>lista=new LinkedList<String>();


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
    private TextFlow txtShow;

    @FXML
    private Label lblError;

    @FXML
    private Button btnClear;

    @FXML
    private Label lblTime;
    
    @FXML
    void doClear(ActionEvent event) {
    	int i=0;
    	while(i!=txtShow.getChildren().size()){
    		txtShow.getChildren().remove(i);
    	}
    	txtInsert.setText("");
		comboBox.setDisable(false);
		lista.removeAll(lista);
		id.spellCheckText(lista).removeAll(id.spellCheckText(lista));
		ed.spellCheckText(lista).removeAll(ed.spellCheckText(lista));

    }

    @FXML
    void doSpell(ActionEvent event) {
    	if(comboBox.getValue()=="Italian"){
    		id.loadDictionary();
    		this.calcolo();
    		id.spellCheckText(lista).removeAll(id.spellCheckText(lista));
    		ed.spellCheckText(lista).removeAll(ed.spellCheckText(lista));

    	}
    	else if(comboBox.getValue()=="English"){
    		ed.loadDictionary();
    		this.calcolo();
    		ed.spellCheckText(lista).removeAll(ed.spellCheckText(lista));
    		id.spellCheckText(lista).removeAll(id.spellCheckText(lista));
    		}
    		

    }
    
    public void calcolo(){
    	int j=0;
    	String[] s=txtInsert.getText().toLowerCase().replaceAll("[\\p{Punct}]","").split(" ");
		for(int i=0;i<s.length;i++){
			lista.add(s[i]);
		}
    	long t0 = System.nanoTime();
    	if(comboBox.getValue()=="Italian"){
    		for(RichWord r:id.spellCheckText(lista)){
    			if(r.isCorretto()==false){
    		        Text text1 = new Text(r.toString()+" ");
    		        text1.setFill(Color.RED);
    		    	txtShow.getChildren().add(text1);
    				j++;
    			}
    			else{
    				Text text1 = new Text(r.toString()+" ");
    		    	txtShow.getChildren().add(text1);
    			}
    		}
		}
    	else if(comboBox.getValue()=="English"){
    			for(RichWord r:ed.spellCheckText(lista)){
    				if(r.isCorretto()==false){
        		        Text text1 = new Text(r.toString()+" ");
        		        text1.setFill(Color.RED);
        		    	txtShow.getChildren().add(text1);
        				j++;
        			}
        			else{
        				Text text1 = new Text(r.toString()+" ");
        		    	txtShow.getChildren().add(text1);
        			}
    			}
    			}
    	long t1 = System.nanoTime();
		if(j==0){
			lblError.setText("Your text don't contains errors!");
		}
		else
			lblError.setText("Your text contains errors!");
		lblTime.setText("Spell check completed in "+(double)((t1-t0)/1000000000.0)+" seconds");
		comboBox.setDisable(true);
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

