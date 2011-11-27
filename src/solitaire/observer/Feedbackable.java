package solitaire.observer;

import java.awt.Point;

import solitaire.pac.Presentation;

/**
 * 
 * Interface décrivant les opérations du retour sémantique.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 *
 */
public interface Feedbackable {
	
	/**
	 * Permet de mettre en évidence la validité de la zone de dépot définit par les coordonnées passées en paramètre. 
	 * @param location Les coordonnées X et Y peremttant de récupèrer la zone de dépôt.<br/>
	 */
	public void highlightValideDrop(Point location);
	
	/**
	 * Permet de mettre en évidence l'invalidité de la zone de dépot définit par les coordonnées passées en paramètre. 
	 * @param location Les coordonnées X et Y peremttant de récupèrer la zone de dépôt.<br/>
	 */
	public void highlightInvalideDrop(Point location);
	
	/**
	 * Permet de mettre en évidence l'état <i>déplaçable</i> d'un composant.
	 */
	public void highlightDraggable();
	
	/**
	 * Permet de retirer un ou tout retour sémantique définis préalablement.
	 */
	public void clearFeedback();
}
