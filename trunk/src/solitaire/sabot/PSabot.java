package solitaire.sabot;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import solitaire.carte.CCarte;
import solitaire.carte.PCarte;
import solitaire.doubletas.PDoubleTas;
import solitaire.observer.Feedback;
import solitaire.observer.Feedbackable;
import solitaire.tasdecartes.ICTasDeCartes;

public class PSabot extends PDoubleTas implements IPSabot {

	private static final long serialVersionUID = 1L;
	final private JPanel pVisible_;
	
	public PSabot(final ICSabot controleur, ICTasDeCartes cTasCache, ICTasDeCartes cTasVisible) {
		super(controleur, cTasCache, cTasVisible);
		
		JPanel pCache = (JPanel)cTasCache.getPresentation();
		pCache.setLocation(0, 0);
		pVisible_ = (JPanel)cTasVisible.getPresentation();
		pVisible_.setLocation(PCarte.largeur+5, 0);

		setPreferredSize(new Dimension(PCarte.largeur*3,PCarte.hauteur));

		pCache.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// le addMouseListener devrait etre applique sur pVisible_
		// mais ceci rentre en conflit avec le mecanisme du DnD
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {
				if ( pVisible_.getComponentCount() > 0 ) {
					Feedback.highlightDraggableState((Feedbackable)pVisible_.getComponent(0));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});	
		
		pCache.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {
				if ( pVisible_.getComponentCount() > 0 ) {
					
					// ajouter un retour semantique sur la carte au sommet du tas de cartes visible
					PCarte pCarte = (PCarte) pVisible_.getComponent(0);
					Feedback.highlightDraggableState((Feedbackable)pCarte);

				}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.distribuer();
			}
		});
		
	}

}
