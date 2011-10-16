package solitaire.tasdecartesalternees;

import solitaire.pac.Controleur;

public class PTasDeCartesAlternees implements IPTasDeCartesAlternees{

	private Controleur controleur_;

	public PTasDeCartesAlternees(Controleur controleur) {
		controleur_ = controleur;
	}
	
	@Override
	public Controleur getControleur() {
		return controleur_;
	}

	
}
