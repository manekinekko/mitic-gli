package solitaire;

import solitaire.solitaire.CSolitaire;
import solitaire.usinedecontroleurs.UsineDeControleurs;

/**
 * 
 * Cette classe définit le point d'entrée du programme. Elle peremet d'éxecuter 
 * le controleur principal du Solitaire.
 *
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * 
 */
public class TestSolitaire {

	public static void main(String[] args) {
		new CSolitaire("My Solitaire", new UsineDeControleurs());
	}
	
}
