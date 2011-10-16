package solitaire.tasdecartesalternees;

import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;
import solitaire.pac.Presentation;

public class CTasDeCartesAlternees extends TasDeCartesAlternees implements ICTasDeCartesAlternees{

	private Presentation pTasDeCartesAlternees_;

	public CTasDeCartesAlternees(String nom, Usine usine) {
		super(nom, usine);
		pTasDeCartesAlternees_ = new PTasDeCartesAlternees(this);
	}

	@Override
	public Presentation getPresentation() {
		return pTasDeCartesAlternees_;
	}
}
