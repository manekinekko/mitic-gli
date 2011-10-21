package solitaire.tasdecartescolorees;

import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;
import solitaire.pac.Presentation;

public class CTasDeCartesColorees extends TasDeCartesColorees implements ICTasDeCartesColorees{

	private Presentation pTasDeCartesColorees_;

	public CTasDeCartesColorees(String nom, int couleur, Usine usine) {
		super(nom, couleur, usine);
		pTasDeCartesColorees_ = new PTasDeCartesColorees(this);
	}

	@Override
	public Presentation getPresentation() {
		return pTasDeCartesColorees_;
	}

}
