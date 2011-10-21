package solitaire.tasdecartes;

import java.awt.Dimension;

import javax.swing.JPanel;

import solitaire.carte.ICCarte;
import solitaire.pac.Controleur;

public class PTasDeCartes extends JPanel implements IPTasDeCartes{

	private static final long serialVersionUID = 1L;
	private ICTasDeCartes controleur_;

	public PTasDeCartes(ICTasDeCartes controleur) {
		setLayout(null);
		setPreferredSize(new Dimension(80, 500));
		
		controleur_ = controleur;
	}

	@Override
	public void add(ICCarte carte) {
		
		JPanel pCarte = (JPanel)carte.getPresentation();
		pCarte.setLocation(0, (controleur_.getNombre()-1)*20);
		add(pCarte);
		setComponentZOrder(pCarte, 0);
		repaint();
	}

	@Override
	public Controleur getControleur() {
		return controleur_;
	}
	
}
