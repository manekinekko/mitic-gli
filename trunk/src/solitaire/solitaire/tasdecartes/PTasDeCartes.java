package solitaire.tasdecartes;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.RepaintManager;

import solitaire.pac.Controleur;

public class PTasDeCartes extends JPanel implements IPTasDeCartes{

	private CTasDeCartes controleur_;

	public PTasDeCartes(ICTasDeCartes controleur) {
		controleur_ = controleur;
	}

	public void paint(Graphics g){
		super.paint(g);
		
		for (int i = 0; i < controleur_.getNombre(); i++) {
			//add(controleur_.getCarte(i));
			// TODO ajouter la ccarte récupérer du controleur.
		}
		
	}
	
}
