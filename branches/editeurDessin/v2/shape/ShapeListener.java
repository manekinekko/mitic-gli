package editeurDessin.v2.shape;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import editeurDessin.v2.Canvas;
import editeurDessin.v2.Editeur;

public class ShapeListener implements MouseListener, MouseMotionListener {
	
	private Shape shape;
	
	@SuppressWarnings("unused")
	private Point mouseP;
	
	private int mouseX =0, mouseY=0;
	
	public ShapeListener(Shape shape){
		this.shape = shape;
	}
	
	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
//		shape.setLocation((int)mouseP.getX()+e.getX(), (int)mouseP.getY()+e.getY());
		shape.setLocation(shape.getX()+(e.getX()-mouseX), shape.getY()+(e.getY()-mouseY));
//		shape.setLocation((int)mouseP.getX()+e.getX()-dx, (int)mouseP.getY()+e.getY()-dy);
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
		mouseX = e.getX();
		mouseY = e.getY();		
		mouseP = shape.getMousePosition();
		Canvas.setSelectedShape(shape);
		Editeur.getFillColorArea().setBackground(shape.getBackground());
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
