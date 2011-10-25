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
	private ICSabot cSabot_;
	private ICTasDeCartesColorees[] cTasDeCartesColorees_;
	private ICColonne[] cColonnes_;

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

		cSabot_ = (CSabot) super.sabot;

        cTasDeCartesColorees_ = new CTasDeCartesColorees[4];
        for(int i=0;i<4;i++){
        	cTasDeCartesColorees_[i] = (ICTasDeCartesColorees) super.pilesColorees[i];
        }
        
		cColonnes_ = new CColonne[7];
        for(int i=0;i<7;i++){
            cColonnes_[i] = (ICColonne) super.pilesAlternees[i];
        }

		pSolitaire_ = new PSolitaire(this);
       
	}

	public ICSabot getCSabot() {
		return cSabot_;
	}

	public ICTasDeCartesColorees[] getCTasDeCartesColorees() {
		return cTasDeCartesColorees_;
	}

	public ICColonne[] getCColonnes() {
		return cColonnes_;
	}
	
}
