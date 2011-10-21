package solitaire.usinedecontroleurs;

import solitaire.application.Carte;
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

public class UsineDeControleurs extends Usine {

	@Override
	public CCarte newCarte(int valeur, int couleur) {
		Carte carte = super.newCarte(valeur, couleur);
		return new CCarte(carte);
		
	}

	public CCarte newCarte() {
		return new CCarte(super.newCarte(10, 1));
	}
	
	public CCarte newCarte(Carte carte) {
		return new CCarte(carte);
	}
	
	public CColonne newColonne(String nom) {
		return new CColonne(nom, this);
	}

	public CTasDeCartes newTasDeCartes(String nom) {
		return new CTasDeCartes(nom, this);
	}

	public CTasDeCartesColorees newTasDeCartesColorees(String nom, int couleur) {
		return new CTasDeCartesColorees(nom, couleur, this);
	}

	public CTasDeCartesAlternees newTasDeCartesAlternees(String nom) {
		return new CTasDeCartesAlternees(nom, this);
	}

	@Override
	public CDoubleTas newDoubleTas(Tas cache, Tas visible) {
		return new CDoubleTas(cache, visible);
	}
	

	public CSabot newSabot(String nom) {
		return new CSabot(nom, this);
	}
	
	public CSolitaire newSolitaire(String nom) {
		return new CSolitaire(nom, this);
	}
}
