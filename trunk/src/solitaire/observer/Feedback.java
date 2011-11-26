package solitaire.observer;

import java.awt.Component;
import java.awt.Point;
import java.util.Observable;

import javax.swing.JPanel;

public class Feedback extends Observable implements Feedbackable {

	private JPanel jPanel_;

	public Feedback(JPanel jPanel) {
		jPanel_ = jPanel;
	}
	
	@Override
	public void highlightValideDrop(Point location) {
		( (Feedbackable)jPanel_).highlightValideDrop(location);
	}
	
	@Override
	public void highlightInvalideDrop(Point location) {
		( (Feedbackable)jPanel_).highlightInvalideDrop(location);
	}
	
	@Override
	public void clearFeedback() {
		( (Feedbackable)jPanel_).clearFeedback();
	}

	@Override
	public void highlightDraggable() {
		( (Feedbackable)jPanel_).highlightDraggable();
	}
	
	public static void highlightDraggableState(Feedbackable component) {
		component.highlightDraggable();
	}

}
