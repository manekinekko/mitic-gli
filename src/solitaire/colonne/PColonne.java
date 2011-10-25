package solitaire.colonne;

import java.awt.Dimension;
import javax.swing.JPanel;
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
		
		JPanel pCache = (JPanel)cachees.getPresentation();
		pCache.setLocation(0, 0);
		
		setPreferredSize(new Dimension(PCarte.largeur, PCarte.hauteur+PTasDeCartes.ecartDecompacte*18));
	}
	
	@Override
	public Controleur getControleur() {
		return controleur_;
	}
	
	public void repositionner(){
		JPanel pVisible = (JPanel)cTasVisible_.getPresentation();
		pVisible.setLocation(0, cTasCache_.getNombre()*PTasDeCartes.ecartDecompacte);
	}

}
