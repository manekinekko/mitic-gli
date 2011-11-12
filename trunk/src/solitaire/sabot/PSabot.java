package solitaire.sabot;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import solitaire.carte.PCarte;
import solitaire.doubletas.PDoubleTas;
import solitaire.tasdecartes.ICTasDeCartes;

public class PSabot extends PDoubleTas implements IPSabot {

	private static final long serialVersionUID = 1L;

	public PSabot(final ICSabot controleur, ICTasDeCartes cTasCache, ICTasDeCartes cTasVisible) {
		super(controleur, cTasCache, cTasVisible);
		
		JPanel pCache = (JPanel)cTasCache.getPresentation();
		pCache.setLocation(0, 0);
		JPanel pVisible = (JPanel)cTasVisible.getPresentation();
		pVisible.setLocation(PCarte.largeur+5, 0);

		setPreferredSize(new Dimension(PCarte.largeur*3,PCarte.hauteur));

		pCache.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pCache.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.distribuer();
			}
		});
		
		//ajoute la carte en bas du tas visible dans le tas colore correspondant, si bien sur c'est possible
		/*this.addMouseListener(new MouseListener() {
			
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
				//double click
				if(e.getClickCount() == 2){
					controleur.empilerCarteSurTasColore();
				}
			}
		});*/
		
	}

}
