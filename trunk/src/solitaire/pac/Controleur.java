package solitaire.pac;

/**
 * L'interface Controleur doit être implémentée par toutes les interfaces des
 * contrôleurs. Elle sert à forcer l'implémentation de la méthode getPresentation.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * 
 */
public interface Controleur {
	
	/**
	 * Retourne la présentation associée au contrôleur courant.
	 * @return presentation La présentation initialisée par le contrôleur courant.
	 */
	public Presentation getPresentation();
	
}
