package solitaire.sabot;

import solitaire.doubletas.PDoubleTas;
import solitaire.pac.Controleur;
import solitaire.tasdecartes.ICTasDeCartes;

public class PSabot extends PDoubleTas implements IPSabot {

	private static final long serialVersionUID = 1L;
	private ICSabot controleur_;

	public PSabot(ICSabot controleur, ICTasDeCartes cTasCache, ICTasDeCartes cTasVisible) {
		super(cTasCache, cTasVisible);
		controleur_ = controleur;
	}

	@Override
	public Controleur getControleur() {
		return controleur_;
	}

}
