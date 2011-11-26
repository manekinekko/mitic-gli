package solitaire.observer;

import java.awt.Component;
import java.awt.Point;

public interface Feedbackable {
	public void highlightValideDrop(Point location);
	public void highlightInvalideDrop(Point location);
	public void highlightDraggable();
	public void clearFeedback();
}
