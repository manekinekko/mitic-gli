package solitaire.colonne;

import java.awt.Dimension;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import solitaire.carte.PCarte;
import solitaire.dnd.MyDropTargetListener;
import solitaire.doubletas.PDoubleTas;
import solitaire.pac.Controleur;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PColonne extends PDoubleTas implements IPColonne{
	
	private static final long serialVersionUID = 1L;
	private ICColonne controleur_;

	public PColonne(final ICColonne controleur, final ICTasDeCartes cachees, final ICTasDeCartes visible) {
		super(controleur, cachees, visible);
		controleur_ = controleur;
		
		PTasDeCartes pCache = (PTasDeCartes)cachees.getPresentation();
		pCache.setLocation(0, 0);
		
		DropTarget dropTarget_ = new DropTarget(this, new MyDropTargetListener(cTasVisible_));
		
		setPreferredSize(new Dimension(PCarte.largeur, PCarte.hauteur+PTasDeCartes.ecartDecompacte*18));
		repositionner();
		
		//ajoute la carte en bas du tas visible dans le tas colore correspondant, si bien sur c'est possible
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				if(visible.isVide()){
					try {
						visible.empiler(cachees.getSommet());
						visible.depiler();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				} else {
					//double click
					if(e.getClickCount() == 2){
						controleur.empilerCarteSurTasColore();
					}
				}
				
			}
		});
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
