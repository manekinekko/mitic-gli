package solitaire.sabot;

import solitaire.pac.Controleur;

public class PSabot implements IPSabot {

	private Controleur controleur_;

	public PSabot(Controleur controleur) {
		controleur_ = controleur;
	}
	
	@Override
	public Controleur getControleur() {
		return controleur_;
	}

}
