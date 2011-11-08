package solitaire.solitaire;

import java.util.Observable;
import java.util.Observer;
import solitaire.application.Solitaire;
import solitaire.application.Usine;
import solitaire.carte.CCarte;
import solitaire.colonne.CColonne;
import solitaire.colonne.ICColonne;
import solitaire.doubletas.ICDoubleTas;
import solitaire.pac.Presentation;
import solitaire.sabot.CSabot;
import solitaire.sabot.ICSabot;
import solitaire.tasdecartescolorees.CTasDeCartesColorees;
import solitaire.tasdecartescolorees.ICTasDeCartesColorees;
import Observer.MyObservable;

public class CSolitaire extends Solitaire implements ICSolitaire, Observer {

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
		cSabot_.addObserver(this);

        cTasDeCartesColorees_ = new CTasDeCartesColorees[4];
        for(int i=0;i<4;i++){
        	cTasDeCartesColorees_[i] = (ICTasDeCartesColorees) super.pilesColorees[i];
        }
        
		cColonnes_ = new CColonne[7];
        for(int i=0;i<7;i++){
            cColonnes_[i] = (ICColonne) super.pilesAlternees[i];
            cColonnes_[i].addObserver(this);
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

	@Override
	public void update(Observable o, Object arg) {
		ICDoubleTas cDoubleTas = ((MyObservable)o).getDoubleTas();
		CCarte carte = null;
		
		try {
			carte = (CCarte) cDoubleTas.getBase();
			//test si on peut empiler la carte sur un tas colore
			for (int i = 0; i < cTasDeCartesColorees_.length; i++) {
				if(cTasDeCartesColorees_[i].isEmpilable(carte)){
					cTasDeCartesColorees_[i].empiler(carte);
					cDoubleTas.depiler();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
