package editeurDessin.v1;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ShapeListener implements MouseListener, MouseMotionListener {
	
	private Shape shape;
	
	@SuppressWarnings("unused")
	private Point mouseP;
	private int mouseX =0, mouseY=0;
	
	public ShapeListener(Shape shape){
		this.shape = shape;
		this.mouseP = new Point();
	}
	
	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		//shape.setLocation((int)mouseP.getX()+e.getX(), (int)mouseP.getY()+e.getY());
		shape.setLocation(shape.getX()+(e.getX()-mouseX), shape.getY()+(e.getY()-mouseY));
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		//shape.setLocation(e.getPoint());
		mouseX = e.getX();
		mouseY = e.getY();		
		mouseP = shape.getMousePosition();
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		shape.setCursor(new Cursor(Cursor.MOVE_CURSOR));		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		shape.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));		
	}

}
