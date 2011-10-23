package solitaire.colonne;

import java.awt.Color;
import java.awt.Dimension;

import solitaire.carte.PCarte;
import solitaire.doubletas.PDoubleTas;
import solitaire.pac.Controleur;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PColonne extends PDoubleTas implements IPColonne{
	
	private static final long serialVersionUID = 1L;
	private ICColonne controleur_;

	public PColonne(ICColonne controleur, ICTasDeCartes cachees, ICTasDeCartes visible) {
		super(controleur, cachees, visible);
		controleur_ = controleur;
		setPreferredSize(new Dimension(PCarte.largeur, PCarte.hauteur+PTasDeCartes.ecartEntreCartes*18));
		setBackground(Color.green);
	}
	
	@Override
	public Controleur getControleur() {
		return controleur_;
	}

}
