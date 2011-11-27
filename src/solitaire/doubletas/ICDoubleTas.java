package solitaire.doubletas;

import java.util.Observer;
import solitaire.application.Carte;
import solitaire.pac.Controleur;

/**
 * Interface décrivant les opérations de la couche contrôleur du double tas.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see ICDoubleTas
 * 
 */
public interface ICDoubleTas extends Controleur {

	/**
	 * Ajout d'un observer sur le double tas (voir pattern Observer).
	 * 
	 * @param o
	 */
	public void addObserver(Observer o);

	/**
	 * Notifie le solitaire que l'on a double cliqué sur le tas, afin que le
	 * solitaire tente d'empiler la carte au sommet sur un tas de cartes
	 * colorées (si cela est possible).
	 */
	public void empilerCarteSurTasColore();

	/**
	 * Donne la carte à la base du double tas.
	 * 
	 * @return
	 * @throws Exception
	 */
	public Carte getBase() throws Exception;

	/**
	 * Dépile une carte du double tas et enlève sa présentation.
	 * 
	 * @throws Exception
	 */
	public void depiler() throws Exception;

}
