package solitaire.observer;

import java.awt.Point;
import java.util.Observable;
import javax.swing.JPanel;

/**
 * 
 * Cette classe permet de centraliser la gestion du retour sémantique.<br/>
 * Elle repose sur l'interface {@link Feedbackable} qui permet d'offrir les différentes méthodes
 * nécessaires au retour sémantique.<br/>
 * A noter que pour ajouter un retour sémantique à un composant, cette classe doit être déclarée au sein de ce dernier. 
 * De plus, il doit implémenter l'interface {@link Feedbackable} afin de décrir son propre retour sémantique à traver 
 * les méthodes disponibles.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see Observable
 *
 */
public class Feedback extends Observable implements Feedbackable {

	private JPanel jPanel_;

	/**
	 * Initiliser le mécanisque du retour sémantique
	 * @param jPanel Le composant auquel on souhaite ajouter un retour sémantique
	 */
	public Feedback(JPanel jPanel) {
		jPanel_ = jPanel;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void highlightValideDrop(Point location) {
		( (Feedbackable)jPanel_).highlightValideDrop(location);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void highlightInvalideDrop(Point location) {
		( (Feedbackable)jPanel_).highlightInvalideDrop(location);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clearFeedback() {
		( (Feedbackable)jPanel_).clearFeedback();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void highlightDraggable() {
		( (Feedbackable)jPanel_).highlightDraggable();
	}
	
	/**
	 * Permet de mettre en évidence l'état <i>déplacable</i> d'un composant {@link Feedbackable}
	 * @param component
	 */
	public static void highlightDraggableState(Feedbackable component) {
		component.highlightDraggable();
	}

	public static void clearDraggableState(Feedbackable component) {
		component.clearFeedback();
	}

}
