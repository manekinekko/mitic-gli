package solitaire.solitaire;

import java.awt.GridBagConstraints;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import solitaire.carte.CCarte;
import solitaire.pac.Controleur;
import solitaire.tasdecartes.CTasDeCartes;
import solitaire.usinedecontroleurs.UsineDeControleurs;
import sun.awt.VerticalBagLayout;

public class PSolitaire extends JFrame implements IPSolitaire{

	private Controleur controleur_;

	public PSolitaire( Controleur controleur) {
		
		controleur_ = controleur;
		
		UsineDeControleurs monUsine = new UsineDeControleurs();
		CCarte carte = monUsine.newCarte();
		
		CTasDeCartes tas = monUsine.newTasDeCartes("A");
		
		// TODO demander au prof comment eviter le type cast
		JPanel pcarte  = (JPanel)carte.getPresentation();
		JLayeredPane ptas = (JLayeredPane)tas.getPresentation();
		
		tas.empiler(carte);
		tas.empiler(carte);
		tas.empiler(carte);
		tas.empiler(carte);
		tas.empiler(carte);
		tas.empiler(carte);
		tas.empiler(carte);
		
//		add(pcarte);
		add(ptas);
		pack();
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	@Override
	public final Controleur getControleur() {
		return controleur_;
	}

	
}
