package solitaire.tasdecartes;

import java.awt.Dimension;

import javax.swing.JPanel;

import solitaire.carte.ICCarte;
import solitaire.carte.PCarte;
import solitaire.pac.Controleur;

public class PTasDeCartes extends JPanel implements IPTasDeCartes{

	private static final long serialVersionUID = 1L;
	protected ICTasDeCartes controleur_;
	public static int ecartEntreCartes = 20;

	public PTasDeCartes(ICTasDeCartes controleur) {
		super(null);
		setPreferredSize(new Dimension(PCarte.largeur, PCarte.hauteur+ecartEntreCartes*18));	
		controleur_ = controleur;
	}

	@Override
	public void add(ICCarte carte) {
		JPanel pCarte = (JPanel)carte.getPresentation();
		pCarte.setLocation(0, (controleur_.getNombre()-1)*ecartEntreCartes);
		add(pCarte);
		setComponentZOrder(pCarte, 0);
		repaint();
	}

	@Override
	public Controleur getControleur() {
		return controleur_;
	}
	
}
