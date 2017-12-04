import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class BaseFait extends Base {

	ArrayList<String> baseFait;
	
	public BaseFait () {
		super();
		baseFait = new ArrayList<String>();
	}
	
	public void checkPremisse () {
		BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("BaseFait.txt"));
            String line;
            while ((line = br.readLine()) != null) {
            	String[] tab = line.split(" ");
            	
            	if (tab.length == 1) {
            		if (testCaractere(tab[0].charAt(0))) {
            			baseFait.add(tab[0]);
            		}
            	} else if (tab.length == 3) {
            		char[] arrayChar = { tab[0].charAt(0), tab[2].charAt(0) };
            		
            		if (testCaractere(arrayChar) && testOperateur(tab[1])) {
            			addArray(baseFait, arrayChar);
            		}
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void getBaseFait () {
		for (String el : baseFait) {
			System.out.println(el);
		}
	}
}
