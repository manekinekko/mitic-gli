package editeurDessin.v2.shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Circle extends Shape {

	private static final long serialVersionUID = 1L;
	private boolean isFill_;
	
	public Circle(Boolean isFill) {
		super(new Point(100, 100));
		setSize(new Dimension(100, 100));
		setBackground(Color.black);
		setOpaque(false);
		isFill_ = isFill;
	}

	public Circle(Boolean isFill, MouseEvent e) {
		super(e.getPoint());
		setOpaque(false);
		setSize(new Dimension(100, 100));
		setBackground(Color.black);
		isFill_ = isFill;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);		
		
		if ( isFill_ ){
			g.fillOval(0, 0, getWidth(), getHeight());
		}
		else {
			g.drawOval(0, 0, getWidth(), getHeight());
		}
	}

}
