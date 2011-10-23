package solitaire.doubletas;

import java.awt.Component;

import javax.swing.JPanel;

import solitaire.pac.Controleur;
import solitaire.tasdecartes.ICTasDeCartes;

public class PDoubleTas extends JPanel implements IPDoubleTas{

	private static final long serialVersionUID = 1L;
	protected ICTasDeCartes cTasCache_;
	protected ICTasDeCartes cTasVisible_;

	public PDoubleTas(ICTasDeCartes cTasCache, ICTasDeCartes cTasVisible){
		setLayout(null);
		cTasCache_ = cTasCache;
		cTasVisible_ = cTasVisible;
		add((Component) cTasCache_.getPresentation());
		add((Component) cTasVisible_.getPresentation());
	}

	@Override
	public Controleur getControleur() {
		return null;
	}
	
}
