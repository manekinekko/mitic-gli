package solitaire.tasdecartes;

import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.carte.ICCarte;

public class CTasDeCartes extends TasDeCartes implements ICTasDeCartes{

	private IPTasDeCartes pTasDeCartes_;

	public CTasDeCartes(String nom, Usine usine) {
		super(nom, usine);
		pTasDeCartes_ = new PTasDeCartes(this);
	}

	public IPTasDeCartes getPresentation() {
		return pTasDeCartes_;
	}

	public ICCarte getCCarte(int number){
		try {
			return (ICCarte)super.getCarte(number);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public void empiler(Carte carte){
			super.empiler(carte);
			pTasDeCartes_.add((ICCarte)carte);
	}
	
	public void compacter(){
		pTasDeCartes_.compacter();
	}
	
	public void decompacter(){
		pTasDeCartes_.decompacter();
	}
	
}
