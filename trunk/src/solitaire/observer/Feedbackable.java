package solitaire.observer;

import java.awt.Point;

public interface Feedbackable {
	public void highlightValideDrop(Point location);
	public void highlightInvalideDrop(Point location);
	public void clearHighlight();
}
