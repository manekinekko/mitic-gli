package solitaire.dnd;

import java.awt.Component;
import java.awt.Window;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceMotionListener;
import javax.swing.JPanel;
import solitaire.carte.PCarte;
import solitaire.tasdecartes.PTasDeCartes;

public class MyDragGestureListener implements DragGestureListener,
		DragSourceMotionListener {
	protected PCarte carteSelectionnee_ = null;
	private PTasDeCartes pTasDeCarte_;
	protected DragGestureEvent theInitialEvent;
	protected DragSource dragSource_;
	protected MyDragSourceListener myDragSourceListener = null;
	private Window valise_;

	public MyDragGestureListener(PTasDeCartes pTasDeCarte, DragSource dragSource) {
		dragSource_ = dragSource;
		pTasDeCarte_ = pTasDeCarte;
		myDragSourceListener = new MyDragSourceListener(pTasDeCarte_);
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent event) {
		carteSelectionnee_ = null;
		try {
			System.out.println(pTasDeCarte_.getLocation());
			carteSelectionnee_ = (PCarte) pTasDeCarte_.getComponentAt(event.getDragOrigin().x, event.getDragOrigin().y-pTasDeCarte_.getY());
		} catch (Exception e) {
		}

		if (carteSelectionnee_ != null) {

			theInitialEvent = event;
			dragSource_.startDrag(event, DragSource.DefaultCopyDrop,
					(Transferable) carteSelectionnee_, myDragSourceListener);
			pTasDeCarte_.remove((Component) carteSelectionnee_);

			valise_ = new Window((Window) (pTasDeCarte_.getRootPane().getParent()));
			valise_.add(carteSelectionnee_);
			valise_.pack();
			valise_.setVisible(true);
			pTasDeCarte_.validate();
			pTasDeCarte_.repaint();
		}
	}

	@Override
	public void dragMouseMoved(DragSourceDragEvent event) {
		if (valise_ != null) {
			valise_.setLocation(1 + event.getX(), 1 + event.getY());
		}
	}

}
