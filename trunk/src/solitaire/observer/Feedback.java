package solitaire.observer;

import java.awt.Point;
import java.util.Observable;

import javax.swing.JPanel;

public class Feedback extends Observable implements Feedbackable {

	private JPanel jPanel_;

	public Feedback(JPanel jPanel) {
		jPanel_ = jPanel;
	}
	
	public void highlightValideDrop(Point location) {
		( (Feedbackable)jPanel_).highlightValideDrop(location);
	}
	
	public void highlightInvalideDrop(Point location) {
		( (Feedbackable)jPanel_).highlightInvalideDrop(location);
	}
	
	public void clearHighlight() {
		( (Feedbackable)jPanel_).clearHighlight();
	}

}
