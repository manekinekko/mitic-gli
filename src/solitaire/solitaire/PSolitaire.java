package solitaire.solitaire;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import solitaire.carte.CCarte;
import solitaire.pac.Controleur;
import solitaire.tasdecartes.CTasDeCartes;
import solitaire.tasdecartesalternees.CTasDeCartesAlternees;
import solitaire.usinedecontroleurs.UsineDeControleurs;

public class PSolitaire extends JFrame implements IPSolitaire{

	private static final long serialVersionUID = 1L;
	private Controleur controleur_;

	public PSolitaire( Controleur controleur) {
		
		controleur_ = controleur;
		
		setLayout(new FlowLayout());
		
		UsineDeControleurs monUsine = new UsineDeControleurs();
		CCarte carte1 = monUsine.newCarte(13, 1);
		CCarte carte2 = monUsine.newCarte(12, 2);
		CCarte carte3 = monUsine.newCarte(1, 1);
		CCarte carte4 = monUsine.newCarte(2, 4);
		CCarte carte5 = monUsine.newCarte(12, 3);
		CCarte carte6 = monUsine.newCarte(13, 2);
		CCarte carte7 = monUsine.newCarte(4, 2);
		CCarte carte8 = monUsine.newCarte(5, 2);		
		
		carte1.setFaceVisible(true);
		carte2.setFaceVisible(true);
		carte3.setFaceVisible(true);
		carte4.setFaceVisible(true);
		carte5.setFaceVisible(true);
		carte6.setFaceVisible(true);
		
		CTasDeCartesAlternees tas1 = monUsine.newTasDeCartesAlternees("1");
		CTasDeCartes tas2 = monUsine.newTasDeCartes("2");

		JPanel ptas1 = (JPanel)tas1.getPresentation();
		JPanel ptas2 = (JPanel)tas2.getPresentation();
		
		tas1.empiler(carte1);
		tas1.empiler(carte2);
		
		tas2.empiler(carte3);
		tas2.empiler(carte4);
		tas2.empiler(carte5);
		tas2.empiler(carte6);
		
		add(ptas1);
		add(ptas2);
		pack();
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	public final Controleur getControleur() {
		return controleur_;
	}

	
}
