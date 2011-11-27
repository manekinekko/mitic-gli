package solitaire.pac;

/**
 * L'interface Presentation doit être implémentée par toutes les interface des
 * présentations. Elle sert à forcer l'implémentation de la méthode getControleur.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * 
 */
public interface Presentation {

	/**
	 * Retourne le contrôleur de la présentation.
	 * @return controleur le contrôleur.
	 */
	public Controleur getControleur();

}
