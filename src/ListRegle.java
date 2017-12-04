import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ListRegle {

	Regle regle;
	ArrayList<Regle> listRegle;
	
	public ListRegle () {
		regle = new Regle();
		listRegle = new ArrayList<Regle>();
	}
	
	// lit les regles une par une et determine celles applicables
	public void readRegle () {
		BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("BaseRegle.txt"));
            String line;
            
            while ((line = br.readLine()) != null) {
        		setListRegle(regle.checkRegle(line));
            }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void setListRegle (Regle regle) {
		listRegle.add(listRegle.size(), regle);
	}
	
	public void getListRegle () {
		for (Regle regle : listRegle) {
			System.out.println("litteraux : " + regle.litteraux);
			System.out.println("conjonction : " + regle.conjonctions);
			System.out.println("conclusion : " + regle.conclusion);
		}
	}
}
