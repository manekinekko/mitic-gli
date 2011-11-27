package solitaire.colonne;

import solitaire.doubletas.ICDoubleTas;
import solitaire.pac.Controleur;
import solitaire.pac.Presentation;

/**
 * 
 * Interface décrivant les opérations de la couche contrôleur des colonnes.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see {@link Controleur}, {@link ICDoubleTas}
 *
 */
public interface ICColonne extends ICDoubleTas, Controleur{

	/**
	 * Permet de décompacter les cartes au sein d'une colonne; autrement-dit, 
	 * elle permet de placer les cartes verticalement, les unes après les autres.
	 */
	public void decompacter();

	/**
	 * Permet de repositionner les cartes au sein d'une colonne, après un Drag & Drop par exemple.
	 */
	public void repositionner();
	
}
