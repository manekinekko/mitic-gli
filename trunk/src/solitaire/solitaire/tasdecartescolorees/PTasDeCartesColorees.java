package solitaire.tasdecartescolorees;

import solitaire.pac.Controleur;

public class PTasDeCartesColorees implements IPTasDeCartesColorees{

	private Controleur controleur_;

	public PTasDeCartesColorees(Controleur controleur) {
		controleur_ = controleur;
	}
	
	@Override
	public Controleur getControleur() {
		return controleur_;
	}
	
}
