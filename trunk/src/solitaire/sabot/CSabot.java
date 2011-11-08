package solitaire.sabot;

import java.awt.Dimension;

import solitaire.application.Sabot;
import solitaire.application.Usine;
import solitaire.carte.PCarte;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class CSabot extends Sabot implements ICSabot {

	private IPSabot pSabot_;
	private PTasDeCartes pTasVisible_;
	private PTasDeCartes pTasCache_;

	public CSabot(String nom, Usine usine) {
		super(nom, usine);
		pSabot_ = new PSabot(this, (ICTasDeCartes) super.cachees,
				(ICTasDeCartes) super.visibles);
		Presentation pTasVisible = ((ICTasDeCartes)super.visibles).getPresentation();
		pTasVisible_ = ((PTasDeCartes)pTasVisible);
		pTasVisible_.setSize(new Dimension(PCarte.largeur*2, PCarte.hauteur));
		
		Presentation pTasCache = ((ICTasDeCartes)super.cachees).getPresentation();
		pTasCache_ = ((PTasDeCartes)pTasCache);
	}

	@Override
	public Presentation getPresentation() {
		return pSabot_;
	}

	public void compacter() {
		ICTasDeCartes cachees = (ICTasDeCartes) super.cachees;
		cachees.compacter();
		ICTasDeCartes visibles = (ICTasDeCartes) super.visibles;
		visibles.compacter();
	}

	@Override
	public void distribuer() {
		System.out.println("nombr cachee" + cachees.getNombre());
		for (int i = 0; i < 3; i++) {
			if (cachees.getNombre() > 0) {
				try {
					super.retournerCarte();
					((PSabot)this.pSabot_).repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		pTasVisible_.decompacterHorizontal();
		
		if(cachees.getNombre() == 0){
			try {
				super.retourner();
				pTasCache_.compacter();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
