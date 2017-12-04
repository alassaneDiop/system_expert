import java.util.ArrayList;


public class Base {
	
	public Base () {}

	// tester si un caractére est compris entre a et c
	public static boolean testCaractere (char c) {
		if ((int)c >= 97 && (int)c <= 122)
			return true;
		
		return false;
	}
	
	// tester si tous les caracteres d'un tableau sont compris entre a et c
	public static boolean testCaractere (char[] c) {
		boolean rep = true;
		for (int i=0; i<c.length; i++) {
			if (!testCaractere(c[i]))
				rep = false;
			
			if (!rep)
				break;
		}
		
		return rep;
	}
	
	// tester si l'opérateur est ==
	public static boolean testOperateur (String op) {
		if (op.equals("==")		||
			op.equals("si") 	||
			op.equals("alors") 	||
			op.equals("et") 	||
			op.equals("ou"))
			return true;
		
		return false;
	}

	// tester tous les opérateurs d'un tableau
	public static boolean testOperateur (String[] op) {
		boolean rep = true;
		for (int i=0; i<op.length; i++) {
			if (!testOperateur(op[i]))
				rep = false;
			
			if (!rep)
				break;
		}
		
		return rep;
	}
	
	public void addArray (ArrayList<String> base, char[] array) {
		for (int i=0; i<array.length; i++) {
			base.add(String.valueOf(array[i]));
		}
	}
}
