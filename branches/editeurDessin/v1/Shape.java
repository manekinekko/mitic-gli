package editeurDessin.v1;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public abstract class Shape extends JPanel {

	private static final long serialVersionUID = 1L;

	public Shape(Point p){
		this.setLocation(p);
		addMouseListener(new ShapeListener(this));
		addMouseMotionListener(new ShapeListener(this));
	}
	
	public void paint(Graphics g){
		super.paint(g);
	}
	
	public void setSizer(int x, int y) {
		int width = Math.abs(x - this.getX());
		int height = y - this.getY();
		this.setSize(new Dimension(width, height));
	}
	
}
