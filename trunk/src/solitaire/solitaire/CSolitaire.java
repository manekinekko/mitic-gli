package solitaire.solitaire;

import solitaire.application.Solitaire;
import solitaire.application.Usine;
import solitaire.pac.Presentation;

public class CSolitaire extends Solitaire implements ICSolitaire {

	private PSolitaire pSolitaire_;

	public CSolitaire(String nom, Usine usine) {
		super(nom, usine);
		pSolitaire_ = new PSolitaire(this);
	}
	
	@Override
	public Presentation getPresentation() {
		return pSolitaire_;
	}

}
