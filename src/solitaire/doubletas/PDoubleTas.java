package solitaire.doubletas;

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
		controleur_ = controleur;
		cTasCache_ = cTasCache;
		cTasVisible_ = cTasVisible;
		add((JPanel) cTasCache_.getPresentation());
		add((JPanel) cTasVisible_.getPresentation());
	}

	@Override
	public Controleur getControleur() {
		return controleur_;
	}

}
