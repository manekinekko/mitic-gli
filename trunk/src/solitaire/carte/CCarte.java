package solitaire.carte;

import solitaire.application.Carte;
import solitaire.pac.Presentation;

public class CCarte extends Carte implements ICCarte{

	private IPCarte pCarte_;

	public CCarte(int valeur, int couleur) {
		super(valeur, couleur);
		pCarte_ = new PCarte(this.valeurs[valeur-1]+this.couleurs[couleur-1], this);
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

