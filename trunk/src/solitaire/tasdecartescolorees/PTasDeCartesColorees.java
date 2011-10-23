package solitaire.tasdecartescolorees;

import java.awt.Color;
import java.awt.Dimension;
import solitaire.carte.PCarte;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PTasDeCartesColorees extends PTasDeCartes implements IPTasDeCartesColorees{

	private static final long serialVersionUID = 1L;

	public PTasDeCartesColorees(ICTasDeCartesColorees controleur) {
		super((ICTasDeCartes) controleur);
		setPreferredSize(new Dimension(PCarte.largeur, PCarte.hauteur));
		setBackground(Color.blue);
	}
	
}
