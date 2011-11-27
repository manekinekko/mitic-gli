package solitaire.carte;

import javax.swing.ImageIcon;

import solitaire.pac.Presentation;

/**
 * 
 * Interface décrivant les opérations de la couche présentation des cartes.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see Presentation
 *
 */
public interface IPCarte extends Presentation {

	/**
	 * Permet de définir une face comme étant visible ou non.
	 * 
	 * @param faceVisible True définit une face visible, False une face cachée.
	 */
	public void setFaceVisible(boolean faceVisible);
	
	/**
	 * Récupère l'objet ImageIcon d'une PCarte.
	 * 
	 * @return ImageIcon l'image du fond de la PCarte.
	 */
	public ImageIcon getIcone();

}
