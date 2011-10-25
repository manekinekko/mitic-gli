package solitaire.dnd;

import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.util.concurrent.ExecutionException;

import javax.swing.JPanel;

import solitaire.carte.IPCarte;

public class MyDragGestionListener  implements DragGestureListener{
	protected IPCarte carteSelectionnee = null;
	private JPanel jpanel_;
	protected DragGestureEvent theInitialEvent;
	protected DragSource dragSource_;
	protected MyDragSourceListener myDragSourceListener = null;
	
	public MyDragGestionListener(JPanel jpanel, DragSource dragSource) {
		dragSource_ = dragSource;
		jpanel_ = jpanel;
		myDragSourceListener = new MyDragSourceListener(jpanel_);
	}
	
	@Override
	public void dragGestureRecognized(DragGestureEvent event) {
		carteSelectionnee = null;
		try{
			carteSelectionnee = (IPCarte) jpanel_.getComponentAt(event.getDragOrigin());
		}
		catch(Exception e){}
		
		if ( carteSelectionnee != null ){
			
			theInitialEvent = event;
			dragSource_.startDrag(event, DragSource.DefaultMoveDrop, (Transferable)carteSelectionnee, myDragSourceListener);
			
		}
	}

}
