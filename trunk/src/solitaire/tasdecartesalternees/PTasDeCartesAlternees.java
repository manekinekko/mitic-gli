package solitaire.tasdecartesalternees;

import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

/**
 * Présentation d'un tas de cartes alternées.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see PTasDeCartes
 */
public class PTasDeCartesAlternees extends PTasDeCartes implements IPTasDeCartesAlternees{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur d'un tas de cartes alternées.
	 * @param controleur
	 */
	public PTasDeCartesAlternees(ICTasDeCartes controleur) {
		super(controleur);
	}

}
