package solitaire.colonne;

import solitaire.pac.Controleur;

public class PColonne implements IPColonne{
	
	private Controleur controleur_;

	public PColonne(Controleur controleur) {
		controleur_ = controleur;
	}
	
	@Override
	public Controleur getControleur() {
		return controleur_;
	}

}
