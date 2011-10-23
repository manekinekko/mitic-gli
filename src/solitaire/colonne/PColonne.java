package solitaire.colonne;

import solitaire.doubletas.PDoubleTas;
import solitaire.pac.Controleur;
import solitaire.tasdecartes.ICTasDeCartes;

public class PColonne extends PDoubleTas implements IPColonne{
	
	private static final long serialVersionUID = 1L;
	private Controleur controleur_;

	public PColonne(Controleur controleur, ICTasDeCartes cachees, ICTasDeCartes visible) {
		super(cachees, visible);
		controleur_ = controleur;
	}
	
	@Override
	public Controleur getControleur() {
		return controleur_;
	}

}
