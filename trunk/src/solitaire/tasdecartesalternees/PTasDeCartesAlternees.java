package solitaire.tasdecartesalternees;

import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PTasDeCartesAlternees extends PTasDeCartes implements IPTasDeCartesAlternees{

	private static final long serialVersionUID = 1L;
	
	public PTasDeCartesAlternees(ICTasDeCartes controleur) {
		super(controleur);
	}

}
