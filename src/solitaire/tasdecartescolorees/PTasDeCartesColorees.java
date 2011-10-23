package solitaire.tasdecartescolorees;

import java.awt.Dimension;

import javax.swing.JPanel;

import solitaire.carte.ICCarte;
import solitaire.pac.Controleur;

public class PTasDeCartesColorees extends JPanel implements IPTasDeCartesColorees{

	private static final long serialVersionUID = 1L;
	private ICTasDeCartesColorees controleur_;

	public PTasDeCartesColorees(ICTasDeCartesColorees controleur) {
		setLayout(null);
		setPreferredSize(new Dimension(77, 121));
		controleur_ = controleur;
	}
	
	@Override
	public void add(ICCarte carte) {
		JPanel pCarte = (JPanel)carte.getPresentation();
		pCarte.setLocation(0, 0);
		add(pCarte);
		setComponentZOrder(pCarte, 0);
		repaint();
	}
	
	@Override
	public Controleur getControleur() {
		return controleur_;
	}
	
}
