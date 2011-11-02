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

import solitaire.carte.IPCarte;

public class MyDragGestureListener implements DragGestureListener,
		DragSourceMotionListener {
	protected IPCarte carteSelectionnee_ = null;
	private JPanel jpanel_;
	protected DragGestureEvent theInitialEvent;
	protected DragSource dragSource_;
	protected MyDragSourceListener myDragSourceListener = null;
	private Window valise_;

	public MyDragGestureListener(JPanel jpanel, DragSource dragSource) {
		dragSource_ = dragSource;
		jpanel_ = jpanel;
		myDragSourceListener = new MyDragSourceListener(jpanel_);
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent event) {
		System.out.println("merde");
		carteSelectionnee_ = null;
		try {
			Object obj = jpanel_.getComponentAt(event.getDragOrigin());
			if ( obj != null ){
				carteSelectionnee_ = (IPCarte) obj;
			}
		} catch (Exception e) {
		}

		System.out.println(carteSelectionnee_);

		if (carteSelectionnee_ != null) {

			theInitialEvent = event;
			dragSource_.startDrag(event, DragSource.DefaultCopyDrop,
					(Transferable) carteSelectionnee_, myDragSourceListener);
			jpanel_.remove((Component) carteSelectionnee_);

			valise_ = new Window((Window) (jpanel_.getRootPane().getParent()));
			valise_.add((Component) carteSelectionnee_);
			valise_.pack();
			valise_.setVisible(true);
			jpanel_.validate();
			jpanel_.repaint();

		}
	}

	@Override
	public void dragMouseMoved(DragSourceDragEvent event) {
		if (valise_ != null) {
			valise_.setLocation(1 + event.getX(), 1 + event.getY());
		}
	}

}
