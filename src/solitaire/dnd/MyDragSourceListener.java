package solitaire.dnd;

import java.awt.Component;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.JPanel;

public class MyDragSourceListener implements DragSourceListener{

	private JPanel jpanel_;

	public MyDragSourceListener(JPanel jpanel) {
		jpanel_ = jpanel;
	}
	
	@Override
	public void dragDropEnd(DragSourceDropEvent event) {
		if ( event.getDropSuccess() ){
			
			// TODO verifier la source a retirer !!
			jpanel_.remove((Component)event.getSource());
			jpanel_.validate();
			jpanel_.repaint();
		}
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
