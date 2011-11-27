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

/**
 * Classe permettant d'effectuer le drag du drag 'n drop.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see DragGestureListener, DragSourceMotionListener
 * 
 */
public class MyDragGestureListener implements DragGestureListener, DragSourceMotionListener {
	private ICTasDeCartes cTasDeCartes_;
	private PTasDeCartes pTasDeCartes_;
	protected DragSource dragSource_;
	protected MyDragSourceListener myDragSourceListener = null;
	private Window valise_;
	private CTasDeCartes cTasDeCartesTemp_;
	protected PCarte pCarteSelectionnee_;

	/**
	 * Constructeur de MyDragGestureListener
	 * 
	 * @param cTasDeCartes
	 * @param dragSource
	 */
	public MyDragGestureListener(ICTasDeCartes cTasDeCartes, DragSource dragSource) {
		dragSource_ = dragSource;
		cTasDeCartes_ = cTasDeCartes;
		pTasDeCartes_ = (PTasDeCartes) cTasDeCartes_.getPresentation();
		myDragSourceListener = new MyDragSourceListener();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dragGestureRecognized(DragGestureEvent event) {
		PCarte pCarteSelectionnee = null;
		CCarte cCarteSelectionnee = null;
		try {
			// recupération de la carte à partir des coordonnées de la souris
			// sur le tas de cartes
			pCarteSelectionnee = (PCarte) pTasDeCartes_.getComponentAt(event.getDragOrigin().x - pTasDeCartes_.getX(),
					event.getDragOrigin().y - pTasDeCartes_.getY());
			cCarteSelectionnee = (CCarte) pCarteSelectionnee.getControleur();

			// on ne peut pas faire un drag au milieu d'un tas s'il n'est pas
			// alterne
			if (!cTasDeCartes_.isAlterne() && cCarteSelectionnee != cTasDeCartes_.getSommet()) {
				return;
			}

		} catch (Exception e) {
		}

		// si une carte a bien été selectionnée
		if (pCarteSelectionnee != null) {

			CTasDeCartes cTasDeCartesTempInverse_ = new CTasDeCartes("", null);
			cTasDeCartesTemp_ = new CTasDeCartes("", null);
			PTasDeCartes pTasDeCartesTemp = (PTasDeCartes) cTasDeCartesTemp_.getPresentation();

			CCarte cCarte;
			try {
				// on récupère le sous tas à partir de la carte sélectionner
				// jusqu'au sommet du tas
				do {
					cCarte = (CCarte) (cTasDeCartes_.getSommet());
					cTasDeCartes_.depiler();
					cTasDeCartesTempInverse_.empiler(cCarte);

				} while (!cCarte.equals(cCarteSelectionnee));

				// on inverse ce sous tas afin que les cartes soit dans le bon
				// ordre
				while (!cTasDeCartesTempInverse_.isVide()) {
					cTasDeCartesTemp_.empiler(cTasDeCartesTempInverse_.getSommet());
					cTasDeCartesTempInverse_.depiler();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			// on commence le drag
			dragSource_.startDrag(event, DragSource.DefaultCopyDrop, (Transferable) pTasDeCartesTemp, myDragSourceListener);

			pTasDeCartesTemp.decompacter();

			// on créer la window qui permettra d'afficher le tas de carte
			// durant le dnd
			valise_ = new Window((Window) (pTasDeCartes_.getRootPane().getParent()));
			valise_.add((PTasDeCartes) pTasDeCartesTemp);
			valise_.setSize(pTasDeCartesTemp.getSize());

			// cela permet de corriger un bug (inconnu) d'affichage de la valise
			// sur Windows
			valise_.setBackground(new Color(0, 0, 0, 0));

			valise_.repaint();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dragMouseMoved(DragSourceDragEvent event) {
		if (valise_ != null) {
			// on fait suivre la valise à la souris
			valise_.setLocation(1 + event.getX(), 1 + event.getY());
			if (!valise_.isVisible()) {
				valise_.setVisible(true);
			}
		}
	}

	/**
	 * Classe implémentant DragSourceListener.
	 * On utilise une inner classe afin qu'elle ai accès à la valise.
	 */
	class MyDragSourceListener implements DragSourceListener {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void dragDropEnd(DragSourceDropEvent event) {

			// le dnd a réussi
			if (event.getDropSuccess()) {
				pTasDeCartes_.validate();
				pTasDeCartes_.repaint();
			} else {

				// si le dndn a echoué, on récupère les cartes de la valise et
				// on les remmet dans le tas initial
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
