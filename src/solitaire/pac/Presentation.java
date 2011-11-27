package solitaire.pac;

/**
 * L'interface Presentation doit être implémentée par toutes les interfaces des
 * présentations. Elle sert à forcer l'implémentation de la méthode getControleur.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * 
 */
public interface Presentation {

	/**
	 * Retourne le contrôleur associé à la présentation courante.
	 * @return controleur Le contrôleur à l'origine de la présentation courante.
	 */
	public Controleur getControleur();

}
