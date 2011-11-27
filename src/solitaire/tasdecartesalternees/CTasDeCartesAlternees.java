package solitaire.tasdecartesalternees;

import java.util.Observer;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;
import solitaire.carte.ICCarte;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

/**
 * Contrôleur d'un tas de cartes alternées.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see ICTasDeCartes
 */
public class CTasDeCartesAlternees extends TasDeCartesAlternees implements
		ICTasDeCartesAlternees {

	private PTasDeCartesAlternees pTasDeCartesAlternees_;

	/**
	 * Constructeur d'un tas de cartes alternées.
	 * @param nom
	 * @param usine
	 */
	public CTasDeCartesAlternees(String nom, Usine usine) {
		super(nom, usine);
		pTasDeCartesAlternees_ = new PTasDeCartesAlternees(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Presentation getPresentation() {
		return pTasDeCartesAlternees_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void empiler(Carte carte) {
		super.empiler(carte);
		pTasDeCartesAlternees_.add((ICCarte) carte);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void compacter() {
		((PTasDeCartes) pTasDeCartesAlternees_).compacter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void decompacter() {
		((PTasDeCartes) pTasDeCartesAlternees_).decompacter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void decompacterHorizontal() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addObserver(Observer o) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void redessiner() {
	}

}
