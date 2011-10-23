package solitaire.colonne;

import solitaire.application.Colonne;
import solitaire.application.Usine;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;

public class CColonne extends Colonne implements ICColonne {

	private IPColonne pColonne_;

	public CColonne(String nom, Usine usine) {
		super(nom, usine);
        pColonne_ = new PColonne(this, (ICTasDeCartes) cachees, (ICTasDeCartes) visibles);
	}
	
	@Override
	public Presentation getPresentation(){
		return pColonne_;
	}

}
