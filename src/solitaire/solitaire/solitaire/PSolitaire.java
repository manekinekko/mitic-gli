package solitaire.solitaire;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import solitaire.carte.CCarte;
import solitaire.usinedecontroleurs.UsineDeControleurs;

public class PSolitaire extends JFrame implements IPSolitaire{

	public PSolitaire() {
		
		UsineDeControleurs monUsine = new UsineDeControleurs();
		CCarte carte = monUsine.newCarte();
		
		// TODO demander au prof comment eviter le type cast
		JPanel pcarte  = (JPanel)carte.getPresentation();
		// 
		
		add(pcarte);
		pack();
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	
}
