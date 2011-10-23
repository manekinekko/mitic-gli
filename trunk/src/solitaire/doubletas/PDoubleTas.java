package solitaire.doubletas;

import java.awt.Component;

import javax.swing.JPanel;

import solitaire.pac.Controleur;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;

public class PDoubleTas extends JPanel implements IPDoubleTas, Presentation{

	private static final long serialVersionUID = 1L;
	protected ICTasDeCartes cTasCache_;
	protected ICTasDeCartes cTasVisible_;
	protected ICDoubleTas controleur_;

	public PDoubleTas(ICDoubleTas controleur, ICTasDeCartes cTasCache, ICTasDeCartes cTasVisible){
		super(null);
		controleur_ = controleur;
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
