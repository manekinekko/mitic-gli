package solitaire.usinedecontroleurs;

import solitaire.application.Tas;
import solitaire.application.Usine;
import solitaire.carte.CCarte;
import solitaire.colonne.CColonne;
import solitaire.doubletas.CDoubleTas;
import solitaire.sabot.CSabot;
import solitaire.solitaire.CSolitaire;
import solitaire.tasdecartes.CTasDeCartes;
import solitaire.tasdecartesalternees.CTasDeCartesAlternees;
import solitaire.tasdecartescolorees.CTasDeCartesColorees;

/**
 * Redefinit l'usine du noyau applicatif. Toutes les methodes sont surchargées
 * afin de renvoyer un contrôleur, héritant de l'abstraction, au lieu de
 * l'habituelle abstraction.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * 
 */
public class UsineDeControleurs extends Usine {

	@Override
	public CCarte newCarte(int valeur, int couleur) {
		return new CCarte(valeur, couleur);
	}

	@Override
	public CColonne newColonne(String nom, Usine usine) {
		return new CColonne(nom, usine);
	}

	@Override
	public CDoubleTas newDoubleTas(Tas cachees, Tas visibles) {
		return new CDoubleTas(cachees, visibles);
	}

	@Override
	public CSabot newSabot(String nom, Usine usine) {
		return new CSabot(nom, usine);
	}

	@Override
	public CSolitaire newSolitaire(String nom, Usine usine) {
		return new CSolitaire(nom, usine);
	}

	@Override
	public CTasDeCartes newTasDeCartes(String nom, Usine usine) {
		return new CTasDeCartes(nom, usine);
	}

	@Override
	public CTasDeCartesAlternees newTasDeCartesAlternees(String nom, Usine usine) {
		return new CTasDeCartesAlternees(nom, usine);
	}

	@Override
	public CTasDeCartesColorees newTasDeCartesColorees(String nom, int couleur, Usine usine) {
		return new CTasDeCartesColorees(nom, couleur, usine);
	}
}
