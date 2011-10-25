package solitaire.sabot;

import solitaire.application.Sabot;
import solitaire.application.Usine;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;

public class CSabot extends Sabot implements ICSabot {

	private IPSabot pSabot_;

	public CSabot(String nom, Usine usine) {
		super(nom, usine);
		pSabot_ = new PSabot(this, (ICTasDeCartes) cachees, (ICTasDeCartes) visibles);
	}

	@Override
	public Presentation getPresentation() {
		return pSabot_;
	}
	
	public void compacter(){
		ICTasDeCartes cachees = (ICTasDeCartes)super.cachees;
		cachees.compacter();
		ICTasDeCartes visibles = (ICTasDeCartes)super.visibles;
		visibles.compacter();
	}

}
