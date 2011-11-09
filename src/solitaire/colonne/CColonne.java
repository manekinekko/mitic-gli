package solitaire.colonne;

import java.util.Observable;
import java.util.Observer;

import solitaire.application.Colonne;
import solitaire.application.Usine;
import solitaire.carte.CCarte;
import solitaire.carte.PCarte;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.CTasDeCartes;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.IPTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;
import Observer.MyObservable;

public class CColonne extends Colonne implements ICColonne, Observer {

	private IPColonne pColonne_;
	private MyObservable observable_;
	private ICTasDeCartes visibles_;
	private ICTasDeCartes cachees_;

	public CColonne(String nom, Usine usine) {
		super(nom, usine);
		visibles_ = (ICTasDeCartes) super.visibles;
		cachees_ = (ICTasDeCartes) super.cachees;

		pColonne_ = new PColonne(this, cachees_, visibles_);
		observable_ = new MyObservable(this);
		((CTasDeCartes)cachees_).addObserver(this);
	}

	@Override
	public Presentation getPresentation() {
		return pColonne_;
	}

	public void decompacter() {
		cachees_.decompacter();
		visibles_.decompacter();
	}

	public void repositionner() {
		pColonne_.repositionner();
	}

	public void addObserver(Observer o) {
		observable_.addObserver(o);
	}

	public void empilerCarteSurTasColore() {
		observable_.setChanged();
		observable_.notifyObservers();
	}

	public void depiler() throws Exception {
		CCarte cCarte = (CCarte) super.getSommet();
		PTasDeCartes pVisible = ((PTasDeCartes) visibles_.getPresentation());
		pVisible.remove((PCarte) cCarte.getPresentation());
		pVisible.redessiner();
		super.depiler();
	}

	@Override
	public void update(Observable o, Object arg) {
		((IPTasDeCartes)cachees_.getPresentation()).redessiner();
	}

}
