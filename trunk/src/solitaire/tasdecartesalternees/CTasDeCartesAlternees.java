package solitaire.tasdecartesalternees;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;
import solitaire.carte.ICCarte;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.PTasDeCartes;

public class CTasDeCartesAlternees extends TasDeCartesAlternees implements
		ICTasDeCartesAlternees {

	private IPTasDeCartesAlternees pTasDeCartesAlternees_;

	public CTasDeCartesAlternees(String nom, Usine usine) {
		super(nom, usine);
		pTasDeCartesAlternees_ = new PTasDeCartesAlternees(this);
	}

	public Presentation getPresentation() {
		return pTasDeCartesAlternees_;
	}

	@Override
	public void empiler(Carte carte) {
		super.empiler(carte);
		pTasDeCartesAlternees_.add((ICCarte) carte);
		for (int i = 1; i <= this.getNombre(); i++) {
			try {
				System.out.print("ctas:"+this.getCarte(i)+" ; ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	@Override
	public void compacter() {
		((PTasDeCartes) pTasDeCartesAlternees_).compacter();
	}

	@Override
	public void decompacter() {
		((PTasDeCartes) pTasDeCartesAlternees_).decompacter();
	}

}
