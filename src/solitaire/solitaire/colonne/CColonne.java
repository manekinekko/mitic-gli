package solitaire.colonne;

import solitaire.application.Colonne;
import solitaire.application.Usine;
import solitaire.pac.Presentation;

public class CColonne extends Colonne implements ICColonne {

	private Presentation pColonne_;

	public CColonne(String nom, Usine usine) {
		super(nom, usine);
		pColonne_ = new PColonne();
	}
	
	@Override
	public Presentation getPresentation(){
		return pColonne_;
	}

}
