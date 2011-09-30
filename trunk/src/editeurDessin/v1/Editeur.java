package editeurDessin.v1;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Editeur extends JFrame {

	private static final long serialVersionUID = 1L;

	public Editeur(){
		super();
		add(new ZoneDessin());
		setPreferredSize(new Dimension(1000, 500));
		setBackground(Color.black);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Editeur();
	}
	
}
