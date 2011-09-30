package editeurDessin.v2.shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Rectangle extends Shape {

	private static final long serialVersionUID = 1L;

	public Rectangle() {
		super(new Point(100, 100));
		this.setSize(new Dimension(100, 100));
		this.setBackground(Color.red);
	}

	public Rectangle(MouseEvent e) {
		super(e.getPoint());
		this.setSize(new Dimension(0, 0));
		this.setBackground(Color.red);
	}

	public void paint(Graphics g) {

		super.paint(g);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.red);
		
//		System.out.println(this.getLocation());
	}

}
