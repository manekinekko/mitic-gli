package solitaire.carte;

import solitaire.application.Carte;
import solitaire.pac.Presentation;

/**
 * 
 * Cette classe implémente les opérations déclarées dans l'interface {@link ICCarte}.
 * Elle définit également le comportement des cartes.<br/>
 * De plus, cette classe hérite de la couche abstraction {@link Carte} qui contient 
 * l'implémentation du code métier des cartes.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see Carte
 *
 */
public class CCarte extends Carte implements ICCarte{

	private IPCarte pCarte_;

	public CCarte(int valeur, int couleur) {
		super(valeur, couleur);
		pCarte_ = new PCarte(valeurs[valeur-1]+couleurs[couleur-1], this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Presentation getPresentation() {
		return pCarte_;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setFaceVisible(boolean faceVisible) {
		super.setFaceVisible(faceVisible);
		pCarte_.setFaceVisible(faceVisible);
	}
	
}

