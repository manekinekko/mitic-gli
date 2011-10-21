package solitaire.carte;

import solitaire.application.Carte;
import solitaire.pac.Presentation;
import solitaire.usinedecontroleurs.UsineDeControleurs;

public class CCarte extends Carte implements ICCarte{

	private IPCarte pCarte_;

	public CCarte(Carte carte) {
		super(carte);
		pCarte_ = new PCarte(""+this.valeurs[this.getValeur()-1]+this.couleurs[this.getCouleur()-1], this);
	}

	@Override
	public Presentation getPresentation() {
		return pCarte_;
	}

	public void setFaceVisible(boolean faceVisible) {
		super.setFaceVisible(faceVisible);
		pCarte_.setFaceVisible(faceVisible);
	}
	
}

