/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	private Dictionary model;
	List<String> list = new ArrayList<String>();
	List<RichWord> sbagliate = new ArrayList<RichWord>();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnScelta"
    private ComboBox<String> btnScelta; // Value injected by FXMLLoader

    @FXML // fx:id="txtArea1"
    private TextArea txtArea1; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpellCheck"
    private Button btnSpellCheck; // Value injected by FXMLLoader

    @FXML // fx:id="txtArea2"
    private TextArea txtArea2; // Value injected by FXMLLoader

    @FXML // fx:id="label1"
    private Label label1; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML // fx:id="label2"
    private Label label2; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	txtArea1.clear();
    	txtArea2.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	String a = txtArea1.getText();
    	a = a.trim();
    	a = a.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	a.toLowerCase();
    	model.loadDictionary(btnScelta.getValue());
    	String[] par = a.split(" ");
    	for(int i=0; i<par.length; i++) {
    		par[i].trim();
    		list.add(par[i]);
    	}
    	
    	sbagliate = model.spellCheckText(list);
    	for(RichWord r : sbagliate) {
    		txtArea2.setText(r.getParola()+"\n");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnScelta != null : "fx:id=\"btnScelta\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtArea1 != null : "fx:id=\"txtArea1\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtArea2 != null : "fx:id=\"txtArea2\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'SpellChecker.fxml'.";
    }
    
    public void setModel(Dictionary model) {
    	this.model = model;
    	btnScelta.getItems().addAll("English", "Italiano");
    }
}

