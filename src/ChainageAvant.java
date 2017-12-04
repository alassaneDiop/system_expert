
import java.util.ArrayList;
import java.util.Iterator;


public class ChainageAvant {
	
	ArrayList<Regle> listRegle;
	BaseFait basefait;
	ArrayList<String> listFaitsFinaux;
	
	public ChainageAvant (ArrayList<Regle> listRegle, BaseFait basefait) {
		this.listRegle = listRegle;
		this.basefait = basefait;
		this.listFaitsFinaux = new ArrayList<String>();
	}
	
	// ajouter une conclusion dans la BF et dans la liste des Faits finaux
	public void addConclusion (Regle regle) {
		this.basefait.baseFait.add(regle.conclusion);
		this.listFaitsFinaux.add(regle.conclusion);
	}
	
	// vérifie si un litteral existe dans la base des faits
	public boolean existFait (String lit) {
		if (this.basefait.baseFait.contains(lit) || this.listFaitsFinaux.contains(lit))
			return true;
		return false;
	}
	
	// prendre une régle et vérifier si elle est applicable
	public boolean checkLitteral (Regle regle) {
		if (regle.conjonctions.size() == 2) { // si ... alors ...
			return existFait(regle.litteraux.get(0));
		} else if (regle.conjonctions.size() == 3) { // si ... ou/et ... alors ...
			if (regle.conjonctions.get(1).equals("ou")) {
				if (existFait(regle.litteraux.get(0)) || existFait(regle.litteraux.get(1))) {
					System.out.println(regle.litteraux.get(0) + " " + regle.litteraux.get(0) + " exist");
					return true;
				}
			} else if (regle.conjonctions.get(1).equals("et")) {
				if (existFait(regle.litteraux.get(0)) && existFait(regle.litteraux.get(1))) {
					System.out.println(regle.litteraux.get(0) + " " + regle.litteraux.get(0) + " exist");
					return true;
				}
			}
		}
		return false;
	}
	
	public void moteur (String but) {
		
		if (this.basefait.baseFait.contains(but)) {
			System.out.println("But trouvé");
		} else {
			System.out.println("Taille de la liste des regles : " + this.listRegle.size());
			System.out.println("base des faits : " + this.basefait.baseFait);
			
			Iterator<Regle> it = this.listRegle.iterator();
			try {
				while (it.hasNext()) {
					Regle regle = it.next();
					if (checkLitteral(regle)) {
						System.out.println("La régle est applicable");
						addConclusion(regle);
						it.remove(); // supprimer la régle déjà utilisée
					
						if (this.basefait.baseFait.contains(but)) {
							System.out.println("But trouvé");
							break;
						} 

					} else {
						System.out.println("La régle n'est pas applicable");
					}
					
					if(!it.hasNext() && this.listRegle.size() > 0) 
						moteur(but);
					
					System.out.println("Taille de la liste des regles : " + this.listRegle.size());
					System.out.println("base des faits : " + this.basefait.baseFait);				
				}	
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
				
	}

}
