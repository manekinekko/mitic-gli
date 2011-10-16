package solitaire.tasdecartes;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import solitaire.carte.ICCarte;
import solitaire.pac.Controleur;

public class PTasDeCartes extends JLayeredPane implements IPTasDeCartes{

	private ICTasDeCartes controleur_;

	public PTasDeCartes(ICTasDeCartes controleur) {
		setLayout(null);
		setPreferredSize(new Dimension(80, 500));
		
		controleur_ = controleur;
	}

//	public void paint(Graphics g){
//		super.paint(g);
//		
//		for (int i = 0; i < controleur_.getNombre(); i++) {
//			add((JPanel)(controleur_.getCCarte(i).getPresentation()));
//		}
//		
//	}

	@Override
	public void add(ICCarte carte) {
		
		JPanel pCarte = (JPanel)carte.getPresentation();
		pCarte.setLocation(0, (controleur_.getNombre()-1)*20);
		add(pCarte, new Integer(controleur_.getNombre()), 0);
		System.out.println(controleur_.getNombre());
		
		repaint();
	}

	@Override
	public Controleur getControleur() {
		return controleur_;
	}
	
}
