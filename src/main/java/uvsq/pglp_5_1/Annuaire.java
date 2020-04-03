package uvsq.pglp_5_1;

import java.io.Serializable;
import java.util.Iterator;

import uvsq.pglp_5_1.TypePersonnelIterator;

public class Annuaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Annuaire ANNUAIRE;
	private CompositePersonnel  head;
	
	
	private Annuaire() {
		head = new CompositePersonnel(1);
	}
	
	
	public static Annuaire getInstance() {
		if (ANNUAIRE == null)
			ANNUAIRE = new Annuaire();
		return ANNUAIRE;
	}
	
	
	
	public void addGroupe(CompositePersonnel  c) {
      head.add(c);
	}
	public void removeGroupe(CompositePersonnel  c) {
	      head.remove(c);
   }
	public GroupeIteration getIterator(){
		return ANNUAIRE.head.groupeIteration();
	}

  
}
