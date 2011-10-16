package solitaire.tasdecartes;

import java.util.List;

import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.carte.CCarte;
import solitaire.pac.Presentation;
import solitaire.usinedecontroleurs.UsineDeControleurs;

public class CTasDeCartes extends TasDeCartes implements ICTasDeCartes{

	private IPTasDeCartes pTasDeCartes_;
	private List<CCarte> listeCartes_;

	public CTasDeCartes(String nom, Usine usine) {
		super(nom, usine);
		pTasDeCartes_ = new PTasDeCartes(this);
	}

	@Override
	public Presentation getPresentation() {
		return pTasDeCartes_;
	}

	public CCarte getCCarte(int number){
		try {
			return (new UsineDeControleurs()).newCarte(super.getCarte(number));
		} catch (Exception e) {
			return null;
		}
	}
	
	public void empiler(Carte carte){
		
		if(super.isEmpilable(carte)){
			super.empiler(carte);
			pTasDeCartes_.add((new UsineDeControleurs()).newCarte(carte));
		}
				
		
	}
	
}
