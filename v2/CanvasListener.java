package editeurDessin.v2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CanvasListener implements MouseMotionListener, MouseListener {

	private Canvas canvas_;

	public CanvasListener(Canvas canvas) {
		canvas_ = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		canvas_.addComponent();
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		Canvas.getSelectedShape().mySetSize((int) e.getX(), (int) e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}

}
