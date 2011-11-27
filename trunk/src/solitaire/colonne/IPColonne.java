package solitaire.colonne;

import solitaire.pac.Presentation;

/**
 * 
 * Interface décrivant les opérations de la couche présentation des colonnes.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see Presentation
 *
 */
public interface IPColonne extends Presentation{
	
	/**
	 * Permet de repositionner les cartes au sein d'une colonne, après un Drag & Drop par exemple.
	 */
	public void repositionner();
}
