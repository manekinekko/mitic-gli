package solitaire.tasdecartescolorees;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;
import solitaire.carte.ICCarte;
import solitaire.pac.Presentation;

public class CTasDeCartesColorees extends TasDeCartesColorees implements ICTasDeCartesColorees{

	private PTasDeCartesColorees pTasDeCartesColorees_;

	public CTasDeCartesColorees(String nom, int couleur, Usine usine) {
		super(nom, couleur, usine);
		pTasDeCartesColorees_ = new PTasDeCartesColorees(this);
	}

	@Override
	public Presentation getPresentation() {
		return pTasDeCartesColorees_;
	}

	@Override
	public void empiler(Carte carte){
		if(super.isEmpilable(carte)){
			super.empiler(carte);
			pTasDeCartesColorees_.add((ICCarte)carte);
		}
		else{
			System.out.println("Ne peux pas empiler :)");
		}
	}
	
}
