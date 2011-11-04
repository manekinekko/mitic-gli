package solitaire.colonne;

import java.awt.Dimension;
import solitaire.carte.PCarte;
import solitaire.doubletas.PDoubleTas;
import solitaire.pac.Controleur;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PColonne extends PDoubleTas implements IPColonne{
	
	private static final long serialVersionUID = 1L;
	private ICColonne controleur_;

	public PColonne(ICColonne controleur, ICTasDeCartes cachees, ICTasDeCartes visible) {
		super(controleur, cachees, visible);
		controleur_ = controleur;
		
		PTasDeCartes pCache = (PTasDeCartes)cachees.getPresentation();
		pCache.setLocation(0, 0);
		
		setPreferredSize(new Dimension(PCarte.largeur, PCarte.hauteur+PTasDeCartes.ecartDecompacte*18));
		repositionner();
	}
	
	@Override
	public Controleur getControleur() {
		return controleur_;
	}
	
	public void repositionner(){
		PTasDeCartes pVisible = (PTasDeCartes)cTasVisible_.getPresentation();
		pVisible.setLocation(0, cTasCache_.getNombre()*PTasDeCartes.ecartDecompacte);
	}

}
