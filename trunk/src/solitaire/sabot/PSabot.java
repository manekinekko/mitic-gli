package solitaire.sabot;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import solitaire.carte.PCarte;
import solitaire.doubletas.PDoubleTas;
import solitaire.tasdecartes.ICTasDeCartes;

public class PSabot extends PDoubleTas implements IPSabot {

	private static final long serialVersionUID = 1L;

	public PSabot(ICSabot controleur, ICTasDeCartes cTasCache, ICTasDeCartes cTasVisible) {
		super(controleur, cTasCache, cTasVisible);
		
		JPanel pCache = (JPanel)cTasCache.getPresentation();
		pCache.setLocation(0, 0);
		JPanel pVisible = (JPanel)cTasVisible.getPresentation();
		pVisible.setLocation(PCarte.largeur+5, 0);

		setPreferredSize(new Dimension(PCarte.largeur*3,PCarte.hauteur));
		setBackground(Color.red);
	}

}
