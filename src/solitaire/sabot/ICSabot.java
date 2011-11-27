package solitaire.sabot;

import solitaire.doubletas.ICDoubleTas;

/**
 * Interface décrivant les opérations de la couche contrôleur du sabot.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see ICDoubleTas
 * 
 */
public interface ICSabot extends ICDoubleTas {

	/**
	 * Appelle de la méthode compacter sur le tas visible et caché.
	 */
	public void compacter();

	/**
	 * Transfert 3 cartes du tas caché au tas visible. Si le tas caché est vide,
	 * recopie le tas visible dans le tas caché. Appelle de la méthode
	 * decompacterHorizontal sur la présentation du tas visible.
	 */
	public void distribuer();

}
