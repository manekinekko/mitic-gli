package solitaire.solitaire;

import solitaire.application.Solitaire;
import solitaire.application.Usine;
import solitaire.colonne.CColonne;
import solitaire.colonne.ICColonne;
import solitaire.pac.Presentation;
import solitaire.sabot.CSabot;
import solitaire.sabot.ICSabot;
import solitaire.tasdecartescolorees.CTasDeCartesColorees;
import solitaire.tasdecartescolorees.ICTasDeCartesColorees;

public class CSolitaire extends Solitaire implements ICSolitaire {

	private PSolitaire pSolitaire_;

	public CSolitaire(String nom, Usine usine) {
		super(nom, usine);
		initialiser();
	}
	
	@Override
	public Presentation getPresentation() {
		return pSolitaire_;
	}

	@Override
	public void initialiser() {
		super.initialiser();

		ICSabot cSabot = (CSabot) this.sabot;

        ICTasDeCartesColorees[] cTasDeCartesColorees = new CTasDeCartesColorees[4];
        for(int i=0;i<4;i++){
        	cTasDeCartesColorees[i] = (ICTasDeCartesColorees) super.pilesColorees[i];
        }
        
		ICColonne[] cColonnes = new CColonne[7];
        for(int i=0;i<7;i++){
            cColonnes[i] = (ICColonne) super.pilesAlternees[i];
        }

		pSolitaire_ = new PSolitaire(this, cSabot, cTasDeCartesColorees, cColonnes);
       
	}
	
}
