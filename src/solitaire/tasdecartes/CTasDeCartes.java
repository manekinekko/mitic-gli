package solitaire.tasdecartes;

import java.util.Observer;

import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.carte.CCarte;
import solitaire.carte.ICCarte;
import solitaire.carte.PCarte;
import solitaire.observer.MyObservable;

public class CTasDeCartes extends TasDeCartes implements ICTasDeCartes {

	private IPTasDeCartes pTasDeCartes_;
	private MyObservable observable_;

	public CTasDeCartes(String nom, Usine usine) {
		super(nom, usine);
		pTasDeCartes_ = new PTasDeCartes(this);
		observable_ = new MyObservable(this);
	}

	public IPTasDeCartes getPresentation() {
		return pTasDeCartes_;
	}

	@Override
	public void empiler(Carte carte) {
		super.empiler(carte);
		pTasDeCartes_.add((ICCarte) carte);
	}

	public void compacter() {
		pTasDeCartes_.compacter();
	}

	public void decompacter() {
		pTasDeCartes_.decompacter();
	}

	public void addObserver(Observer o) {
		observable_.addObserver(o);
	}

	@Override
	public void depiler(){
		
		observable_.setChanged();
		observable_.notifyObservers();
		
		CCarte cCarte = null;
		try {
			cCarte = (CCarte) getSommet();
			super.depiler();
			pTasDeCartes_.remove((PCarte)(cCarte.getPresentation()));
		} catch (Exception ex) {
		}
	}

}
