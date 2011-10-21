package editeurDessin.v1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ZoneDessin extends JPanel {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private Coordonnees coo_;
	
	// cache the last component
	private JPanel derPanel_;

	public ZoneDessin() {
		setBackground(Color.yellow);
		addMouseListener(new EditeurListener(this));
		addMouseMotionListener(new EditeurListener(this));
		coo_ = new Coordonnees();
		setLayout(null);
	}

	public void paint(Graphics gr) {

		super.paint(gr);

	}

	public void addComponent(JPanel pan) {
		add(pan);
		repaint();
		derPanel_ = pan;
	}

	public Shape getComponent() {
		return (Shape) derPanel_;
	}

}
