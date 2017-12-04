import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BaseFait basefait = new BaseFait();
		basefait.checkPremisse();
		basefait.getBaseFait();
		System.out.println(basefait.baseFait);
		
		ListRegle listRegle = new ListRegle();
		listRegle.readRegle();
		listRegle.getListRegle();
	
		ChainageAvant ch = new ChainageAvant(listRegle.listRegle, basefait);
		System.out.println("Donner un but");
		Scanner scan = new Scanner(System.in);
		//String but = scan.next();
		ch.moteur("e");
		System.out.println(ch.listFaitsFinaux);
		System.out.println("Nouvelle base des faits " + ch.basefait.baseFait);		
		
		
		
	}

}
