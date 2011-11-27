package solitaire.tasdecartes;

import java.util.Observer;
import solitaire.application.Carte;
import solitaire.application.Tas;
import solitaire.pac.Controleur;

/**
 * Interface décrivant les opérations de la couche contrôleur du tas de cartes.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see Controleur
 * 
 */
public interface ICTasDeCartes extends Controleur {

	/**
	 * Dépile la carte au sommet du tas de cartes et enlève la présentation.
	 * @throws Exception
	 */
	public void depiler() throws Exception;

	/**
	 * Empile une carte sur le tas de cartes.
	 * @param carte
	 */
	public void empiler(Carte carte);

	/**
	 * Empile un tas sur le tas de cartes.
	 * @param tas
	 */
	public void empiler(Tas tas);

	/**
	 * Donne la carte à la base du tas de cartes.
	 * @return
	 * @throws Exception
	 */
	public Carte getBase() throws Exception;

	/**
	 * Donne la carte en position n du tas de cartes.
	 * @param n
	 * @return
	 * @throws Exception
	 */
	public Carte getCarte(int n) throws Exception;

	/**
	 * Indique le nombre de cartes du tas de cartes.
	 * @return
	 */
	public int getNombre();

	/**
	 * Indique si le tas de cartes est un tas de cartes alternées.
	 * @return
	 */
	public boolean isAlterne();

	/**
	 * Indique si une carte est empilable sur le tas de cartes.
	 * @param carte
	 * @return
	 */
	public boolean isEmpilable(Carte carte);

	/**
	 * Indique si un tas est empilable sur le tas de cartes.
	 * @param tas
	 * @param nbCartes
	 * @return
	 */
	public boolean isEmpilable(Tas tas, int nbCartes);

	/**
	 * Indique si un tas de cartes est vide.
	 * @return
	 */
	public boolean isVide();

	/**
	 * Recopie d'un tas de cartes dans le tas de cartes courant.
	 * @param tas
	 */
	public void recopier(Tas tas);

	/**
	 * Appelle la méthode compacter de la présentation.
	 */
	public void compacter();

	/**
	 * Appelle la méthode decompacter de la présentation.
	 */
	public void decompacter();

	/**
	 * Appelle la méthode decompacterHorizontal de la présentation.
	 */
	public void decompacterHorizontal();

	/**
	 * Donne la carte au sommet du tas de cartes. 
	 * @return
	 * @throws Exception
	 */
	public Carte getSommet() throws Exception;

	/**
	 * Ajoute un observer à notre objet observable (voir pattern observer).
	 * @param o
	 */
	public void addObserver(Observer o);

	/**
	 * Appelle la méthode redessiner de la présentation.
	 */
	public void redessiner();

}
