package solitaire.sabot;

import solitaire.application.Sabot;
import solitaire.application.Usine;
import solitaire.pac.Presentation;

public class CSabot extends Sabot implements ICSabot{

	private Presentation pSabot_;

	public CSabot(String nom, Usine usine) {
		super(nom, usine);
		pSabot_ = new PSabot();
	}

	@Override
	public Presentation getPresentation() {
		return pSabot_;
	}

}
