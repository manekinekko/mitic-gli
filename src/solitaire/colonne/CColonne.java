package solitaire.colonne;

import java.util.Observer;
import solitaire.observer.MyObservable;
import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Usine;
import solitaire.carte.CCarte;
import solitaire.carte.ICCarte;
import solitaire.carte.PCarte;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

/**
 * 
 * Cette classe implémente les opérations déclarées dans l'interface {@link ICColonne}.
 * Elle définit également le comportement des colonnes.<br/>
 * De plus, cette classe hérite de la couche abstraction {@link Colonne} qui contient 
 * l'implémentation du code métier des colonnes.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see Colonne
 *
 */
public class CColonne extends Colonne implements ICColonne{

	private IPColonne pColonne_;
	private MyObservable observable_;
	private ICTasDeCartes visibles_;
	private ICTasDeCartes cachees_;

	/**
	 * Ce constructeur initialise la couche abstraction et présentation
	 * des colonnes.<br/>
	 * @param nom Le nom de la colonne
	 * @param usine Une usine de contrôleurs
	 */
	public CColonne(String nom, Usine usine) {
		super(nom, usine);
		visibles_ = (ICTasDeCartes) super.visibles;
		cachees_ = (ICTasDeCartes) super.cachees;
		pColonne_ = new PColonne(this, cachees_, visibles_);
		observable_ = new MyObservable(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Presentation getPresentation() {
		return pColonne_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void decompacter() {
		cachees_.decompacter();
		visibles_.decompacter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void repositionner() {
		pColonne_.repositionner();
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
	public void empilerCarteSurTasColore() {
		observable_.setChanged();
		observable_.notifyObservers();
	}

	/**
	 * {@inheritDoc}
	 */
	public void depiler() throws Exception {
		CCarte cCarte = (CCarte) super.getSommet();
		PTasDeCartes pVisible = ((PTasDeCartes) visibles_.getPresentation());
		pVisible.remove((PCarte) cCarte.getPresentation());
		pVisible.redessiner();
		super.depiler();
	}
}
