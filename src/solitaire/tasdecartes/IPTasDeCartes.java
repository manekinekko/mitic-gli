package solitaire.tasdecartes;

import solitaire.pac.Presentation;
import solitaire.carte.ICCarte;
import solitaire.carte.PCarte;

/**
 * Interface décrivant les opérations de la couche présentation d'un tas de
 * cartes.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see Presentation
 * 
 */
public interface IPTasDeCartes extends Presentation {

	/**
	 * Ajoute une carte au panel.
	 * 
	 * @param carte
	 */
	public void add(ICCarte carte);

	/**
	 * Permet d'organiser le tas de carte (utile pour les tas des colonnes).
	 * Chaque carte ayant un décalage vertical par rapport à la carte en
	 * dessous. La carte la plus en bas étant celle au sommet du tas.
	 */
	public void decompacter();

	/**
	 * Contraire de décompacter. Les cartes sont empilées les une sur les autres
	 * sans aucun décalage.
	 */
	public void compacter();

	/**
	 * Permet d'organiser les cartes avec un décalage horizontal. utilisé
	 * uniquement pour le tas visible du sabot.
	 */
	public void decompacterHorizontal();

	/**
	 * Effectue un repaint sur le jpanel.
	 */
	public void redessiner();

	/**
	 * 
	 * @param pCarte
	 */
	public void remove(PCarte pCarte);

}
