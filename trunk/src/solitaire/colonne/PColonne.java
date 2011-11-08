package solitaire.colonne;

import java.awt.Dimension;
import java.awt.dnd.DropTarget;

import solitaire.carte.PCarte;
import solitaire.dnd.MyDropTargetListener;
import solitaire.doubletas.PDoubleTas;
import solitaire.pac.Controleur;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PColonne extends PDoubleTas implements IPColonne{
	
	private static final long serialVersionUID = 1L;
	private ICColonne controleur_;
	private DropTarget dropTarget_;

	public PColonne(ICColonne controleur, ICTasDeCartes cachees, ICTasDeCartes visible) {
		super(controleur, cachees, visible);
		controleur_ = controleur;
		
		PTasDeCartes pCache = (PTasDeCartes)cachees.getPresentation();
		pCache.setLocation(0, 0);
		
		dropTarget_ = new DropTarget(this, new MyDropTargetListener(cTasVisible_));
		
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
