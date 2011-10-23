package solitaire.colonne;

import solitaire.doubletas.PDoubleTas;
import solitaire.pac.Controleur;
import solitaire.tasdecartes.ICTasDeCartes;

public class PColonne extends PDoubleTas implements IPColonne{
	
	private static final long serialVersionUID = 1L;
	private ICColonne controleur_;

	public PColonne(ICColonne controleur, ICTasDeCartes cachees, ICTasDeCartes visible) {
		super(controleur, cachees, visible);
		controleur_ = controleur;
	}
	
	@Override
	public Controleur getControleur() {
		return controleur_;
	}

}
