package solitaire.tasdecartes;

import java.util.List;

import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.carte.CCarte;
import solitaire.pac.Presentation;

public class CTasDeCartes extends TasDeCartes implements ICTasDeCartes{

	private Presentation pTasDeCartes_;
	private List<CCarte> listeCartes_;

	public CTasDeCartes(String nom, Usine usine) {
		super(nom, usine);
		pTasDeCartes_ = new PTasDeCartes(this);
	}

	@Override
	public Presentation getPresentation() {
		return pTasDeCartes_;
	}

	public void empiler(Carte carte){
		
	}
	
	// TODO faire la methode pour récupérer la ccarte
	//private get
	
}
