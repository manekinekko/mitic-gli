package solitaire.solitaire;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import solitaire.colonne.ICColonne;
import solitaire.pac.Controleur;
import solitaire.sabot.ICSabot;
import solitaire.tasdecartescolorees.ICTasDeCartesColorees;

public class PSolitaire extends JFrame implements IPSolitaire{

	private static final long serialVersionUID = 1L;
	private Controleur controleur_;

	public PSolitaire(CSolitaire controleur) {
		super("Solitaire");
		controleur_ = controleur;
		
		ICSabot cSabot = controleur.getCSabot();
		ICTasDeCartesColorees[] cTasDeCartesColorees = controleur.getCTasDeCartesColorees();
		ICColonne[] cColonnes = controleur.getCColonnes();
		
		Box row = Box.createVerticalBox();
		
		JPanel line1 = new JPanel();
		JPanel line2 = new JPanel();
		line1.setLayout(new FlowLayout());
		line2.setLayout(new FlowLayout());
		
		line1.add((JPanel)cSabot.getPresentation());
		cSabot.compacter();
		
		for (ICTasDeCartesColorees tasDeCartesColorees : cTasDeCartesColorees) {
			line1.add((JPanel)tasDeCartesColorees.getPresentation());
		}
		
		for (ICColonne colonne : cColonnes) {
			line2.add((JPanel)colonne.getPresentation());
			colonne.decompacter();
			colonne.repositionner();
		}
		
		row.add(line1);
		row.add(line2);
		add(row);
		
		setVisible(true);
		setResizable(false);
		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	public final Controleur getControleur() {
		return controleur_;
	}

	
}
