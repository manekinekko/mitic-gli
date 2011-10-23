package solitaire.tasdecartesalternees;

import solitaire.pac.Controleur;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PTasDeCartesAlternees extends PTasDeCartes implements IPTasDeCartesAlternees{

	private static final long serialVersionUID = 1L;
	private ICTasDeCartes controleur_;
	
	public PTasDeCartesAlternees(ICTasDeCartes controleur) {
		super(controleur);
		controleur_ = controleur;
	}
	
	public Controleur getControleur() {
		return controleur_;
	}

}
