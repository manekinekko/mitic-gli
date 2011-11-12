package solitaire.tasdecartesalternees;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import solitaire.application.Carte;
import solitaire.carte.CCarte;
import solitaire.carte.PCarte;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PTasDeCartesAlternees extends PTasDeCartes implements IPTasDeCartesAlternees{

	private static final long serialVersionUID = 1L;
	
	public PTasDeCartesAlternees(ICTasDeCartes controleur) {
		super(controleur);
	}

}
