package solitaire.tasdecartesalternees;

import javax.swing.JPanel;
import solitaire.carte.ICCarte;
import solitaire.pac.Controleur;

public class PTasDeCartesAlternees extends JPanel implements IPTasDeCartesAlternees{

	private static final long serialVersionUID = 1L;
	private ICTasDeCartesAlternees controleur_;
	
	public PTasDeCartesAlternees(ICTasDeCartesAlternees controleur) {
		controleur_ = controleur;
	}
	
	public Controleur getControleur() {
		return controleur_;
	}

	public void add(ICCarte carte) {
		JPanel pCarte = (JPanel)carte.getPresentation();
		pCarte.setLocation(0, (controleur_.getNombre()-1)*20);
		add(pCarte);
		setComponentZOrder(pCarte, 0);
		repaint();
	}

	
}
