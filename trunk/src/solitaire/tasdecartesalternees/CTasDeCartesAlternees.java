package solitaire.tasdecartesalternees;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;
import solitaire.carte.ICCarte;
import solitaire.pac.Presentation;

public class CTasDeCartesAlternees extends TasDeCartesAlternees implements ICTasDeCartesAlternees{

	private IPTasDeCartesAlternees pTasDeCartesAlternees_;
	
	public CTasDeCartesAlternees(String nom, Usine usine) {
		super(nom, usine);
		pTasDeCartesAlternees_ = new PTasDeCartesAlternees(this);
	}

	public Presentation getPresentation() {
		return pTasDeCartesAlternees_;
	}
	
	@Override
	public void empiler(Carte carte){
		if(super.isEmpilable(carte)){
			super.empiler(carte);
			pTasDeCartesAlternees_.add((ICCarte)carte);
		}
		else{
			System.out.println("Ne peux pas empiler :)");
		}
	}

	@Override
	public ICCarte getCCarte(int number) {
		return null;
	}

	@Override
	public void compacter() {
	}

	@Override
	public void decompacter() {
	}
	
}
