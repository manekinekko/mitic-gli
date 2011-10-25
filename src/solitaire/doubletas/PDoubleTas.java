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
		super(null);
		
		controleur_ = controleur;
		cTasCache_ = cTasCache;
		cTasVisible_ = cTasVisible;
		
		JPanel pTasCache = (JPanel) cTasCache_.getPresentation();
		JPanel pTasVisible = (JPanel) cTasVisible_.getPresentation();
		
		add(pTasCache);
		add(pTasVisible);
		setComponentZOrder(pTasVisible, 0);
	
	}

	@Override
	public Controleur getControleur() {
		return controleur_;
	}

}
