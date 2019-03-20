package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	Set<String> setdict = new HashSet<String>();
	List<RichWord> parole = new ArrayList<RichWord>();
	
	
	public void loadDictionary(String language) {
		if(language.compareTo("English")==0) {
			try {
				FileReader fr = new FileReader("rsc/English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while((word = br.readLine()) != null) {
					setdict.add(word);
				}
				br.close();
			}catch(IOException e) {
				System.out.println("Errore nella lettura del file");
			}
		}else {
			try {
			FileReader fr = new FileReader("rsc/Italiano.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while((word = br.readLine()) != null) {
				setdict.add(word);
			}
			br.close();
		}catch(IOException e) {
			System.out.println("Errore nella lettura del file");
			}
		}
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		for(String b : inputTextList) {
			if(!setdict.contains(b)) {
				RichWord rw = new RichWord();
				rw.setParola(b);
				parole.add(rw);
			}
		}
		return parole;
	}

}
