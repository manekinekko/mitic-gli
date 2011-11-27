package solitaire.solitaire;

import java.util.Observable;

import solitaire.pac.Controleur;

/**
 * Interface décrivant les opérations de la couche contrôleur du solitaire.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see Controleur
 * 
 */
public interface ICSolitaire extends Controleur {

	/**
	 * On appelle cette methode avec en paramètre o, une carte destiné à être
	 * ajoutée sur un tas de cartes colorées.
	 */
	public void update(Observable o, Object arg);

}
