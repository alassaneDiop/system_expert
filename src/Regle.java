
import java.util.ArrayList;


public class Regle {

	ArrayList<String> litteraux, conjonctions;
	String conclusion;
	
	public Regle () {
		litteraux = new ArrayList<String>(); 
		conjonctions = new ArrayList<String>();
	}
	
	// vérifier si une régle est correcte et la retourne sinon null
	public Regle checkRegle (String line) {
		Regle reg = new Regle();
    	String[] tab = line.split(" ");
    	char[] arrayLit = null;
		String[] arrayConj = null;
			
    	if (tab.length == 4) {
    		char[] arrayL = { tab[1].charAt(0), tab[3].charAt(0) };
			String[] arrayC = { tab[0], tab[2] };
			arrayLit = arrayL; arrayConj = arrayC;
    	} else if (tab.length == 6) {
    		char[] arrayL = { tab[1].charAt(0), tab[3].charAt(0), tab[5].charAt(0) };
			String[] arrayC = { tab[0], tab[2], tab[4] };
			arrayLit = arrayL; arrayConj = arrayC;
		} else if (tab.length == 8) {
    		char[] arrayL = {tab[1].charAt(0), tab[3].charAt(0), tab[5].charAt(0), tab[7].charAt(0)};
			String[] arrayC = {tab[0], tab[2], tab[4], tab[6]};
			arrayLit = arrayL; arrayConj = arrayC;
    	} else if (tab.length == 12) {
    		char[] arrayL = {tab[1].charAt(0), tab[3].charAt(0), tab[5].charAt(0), 
    							tab[7].charAt(0), tab[9].charAt(0), tab[11].charAt(0)};
			String[] arrayC = {tab[0], tab[2], tab[4], tab[6], tab[8], tab[10]};
			arrayLit = arrayL; arrayConj = arrayC;
    	}
    	
    	if (Base.testCaractere(arrayLit) && Base.testOperateur(arrayConj)) {
			reg.setLitteraux(arrayLit);
			reg.setConjonctions(arrayConj);
			return reg;
		}
    	
		return null;    
	}
	
	public void getLitteraux () {
		System.out.println("Litteraux");
		for (String el : litteraux) {
			System.out.println(el);
		}
	}
	
	public void getConjonctions () {
		System.out.println("Conjonctions");
		for (String el : conjonctions) {
			System.out.println(el);
		}
	}
	
	public void setLitteraux (char[] array) {
		for (int i=0; i<array.length - 1; i++) {
			litteraux.add(String.valueOf(array[i]));
		}
		conclusion = String.valueOf(array[array.length - 1]);
	}
	
	public void setConjonctions (String[] array) {
		for (int i=0; i<array.length; i++) {
			conjonctions.add(array[i]);
		}
	}
	
}
