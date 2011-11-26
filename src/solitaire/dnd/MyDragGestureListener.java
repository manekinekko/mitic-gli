package solitaire.dnd;

import java.awt.Color;
import java.awt.Window;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragSourceMotionListener;
import solitaire.carte.CCarte;
import solitaire.carte.PCarte;
import solitaire.tasdecartes.CTasDeCartes;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class MyDragGestureListener implements DragGestureListener, DragSourceMotionListener {
	private ICTasDeCartes cTasDeCartes_;
	private PTasDeCartes pTasDeCartes_;
	protected DragSource dragSource_;
	protected MyDragSourceListener myDragSourceListener = null;
	private Window valise_;
	private CTasDeCartes cTasDeCartesTemp_;
	protected PCarte pCarteSelectionnee_;

	public MyDragGestureListener(ICTasDeCartes cTasDeCartes, DragSource dragSource) {
		dragSource_ = dragSource;
		cTasDeCartes_ = cTasDeCartes;
		pTasDeCartes_ = (PTasDeCartes) cTasDeCartes_.getPresentation();
		myDragSourceListener = new MyDragSourceListener();
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent event) {
		PCarte pCarteSelectionnee = null;
		CCarte cCarteSelectionnee = null;
		try {
			pCarteSelectionnee = (PCarte) pTasDeCartes_.getComponentAt(event.getDragOrigin().x - pTasDeCartes_.getX(),
					event.getDragOrigin().y - pTasDeCartes_.getY());
			cCarteSelectionnee = (CCarte) pCarteSelectionnee.getControleur();
			
			//on ne peut pas faire un drag au milieu d'un tas s'il n'est pas alterne
			if(!cTasDeCartes_.isAlterne() && cCarteSelectionnee != cTasDeCartes_.getSommet()){
				return;
			}
			
		} catch (Exception e) {
		}

		if (pCarteSelectionnee != null) {

			CTasDeCartes cTasDeCartesTempInverse_ = new CTasDeCartes("", null);
			cTasDeCartesTemp_ = new CTasDeCartes("", null);
			PTasDeCartes pTasDeCartesTemp = (PTasDeCartes) cTasDeCartesTemp_.getPresentation();

			CCarte cCarte;
			try {
				do {
					cCarte = (CCarte) (cTasDeCartes_.getSommet());
					cTasDeCartes_.depiler();
					cTasDeCartesTempInverse_.empiler(cCarte);

				} while (!cCarte.equals(cCarteSelectionnee));

				while (!cTasDeCartesTempInverse_.isVide()) {
					cTasDeCartesTemp_.empiler(cTasDeCartesTempInverse_.getSommet());
					cTasDeCartesTempInverse_.depiler();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			dragSource_.startDrag(event, DragSource.DefaultCopyDrop, (Transferable) pTasDeCartesTemp, myDragSourceListener);

			pTasDeCartesTemp.decompacter();

			valise_ = new Window((Window) (pTasDeCartes_.getRootPane().getParent()));
			valise_.add((PTasDeCartes) pTasDeCartesTemp);
			valise_.setSize(pTasDeCartesTemp.getSize());
			valise_.setBackground(new Color(0, 255, 0, 50));
			valise_.repaint();
		}
	}

	@Override
	public void dragMouseMoved(DragSourceDragEvent event) {
		if (valise_ != null) {
			valise_.setLocation(1 + event.getX(), 1 + event.getY());
			if (!valise_.isVisible()) {
				valise_.setVisible(true);
			}
		}
	}

	class MyDragSourceListener implements DragSourceListener {

		@Override
		public void dragDropEnd(DragSourceDropEvent event) {

			if (event.getDropSuccess()) {
				pTasDeCartes_.validate();
				pTasDeCartes_.repaint();
			} else {

				while (!cTasDeCartesTemp_.isVide()) {
					try {
						cTasDeCartes_.empiler(cTasDeCartesTemp_.getSommet());
						cTasDeCartesTemp_.depiler();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				cTasDeCartes_.redessiner();
				valise_.remove((PTasDeCartes) cTasDeCartesTemp_.getPresentation());
			}

			valise_.setVisible(false);
		}

		@Override
		public void dragEnter(DragSourceDragEvent dsde) {
		}

		@Override
		public void dragExit(DragSourceEvent dse) {
		}

		@Override
		public void dragOver(DragSourceDragEvent dsde) {
		}

		@Override
		public void dropActionChanged(DragSourceDragEvent dsde) {
		}

	}

}
