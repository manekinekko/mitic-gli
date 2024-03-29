package solitaire.tasdecartes;

import java.util.Observer;
import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.carte.CCarte;
import solitaire.carte.ICCarte;
import solitaire.carte.PCarte;
import solitaire.observer.MyObservable;

/**
 * Contrôleur d'un tas de cartes.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @see ICTasDeCartes
 */
public class CTasDeCartes extends TasDeCartes implements ICTasDeCartes {

	private IPTasDeCartes pTasDeCartes_;
	private MyObservable observable_;

	public CTasDeCartes(String nom, Usine usine) {
		super(nom, usine);
		pTasDeCartes_ = new PTasDeCartes(this);
		observable_ = new MyObservable(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IPTasDeCartes getPresentation() {
		return pTasDeCartes_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void empiler(Carte carte) {
		super.empiler(carte);
		pTasDeCartes_.add((ICCarte) carte);
	}

	/**
	 * {@inheritDoc}
	 */
	public void compacter() {
		pTasDeCartes_.compacter();
	}

	/**
	 * {@inheritDoc}
	 */
	public void decompacter() {
		pTasDeCartes_.decompacter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addObserver(Observer o) {
		observable_.addObserver(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void redessiner() {
		observable_.setChanged();
		observable_.notifyObservers(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void depiler() {

		CCarte cCarte = null;
		try {
			cCarte = (CCarte) getSommet();
			super.depiler();
			pTasDeCartes_.remove((PCarte) (cCarte.getPresentation()));
		} catch (Exception ex) {
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void decompacterHorizontal() {
		pTasDeCartes_.decompacterHorizontal();
	}

}
