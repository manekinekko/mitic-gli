package solitaire.tasdecartescolorees;

import java.util.Observer;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;
import solitaire.carte.ICCarte;
import solitaire.pac.Presentation;

/**
 * Contrôleur d'un tas de cartes colorées.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see ICTasDeCartesColorees
 */
public class CTasDeCartesColorees extends TasDeCartesColorees implements
		ICTasDeCartesColorees {

	private PTasDeCartesColorees pTasDeCartesColorees_;

	public CTasDeCartesColorees(String nom, int couleur, Usine usine) {
		super(nom, couleur, usine);
		pTasDeCartesColorees_ = new PTasDeCartesColorees(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Presentation getPresentation() {
		return pTasDeCartesColorees_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void empiler(Carte carte) {
		super.empiler(carte);
		pTasDeCartesColorees_.add((ICCarte) carte);
		pTasDeCartesColorees_.compacter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void compacter() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void decompacter() {
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
