package solitaire.carte;

//import solitaire.controle.* ;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import solitaire.observer.Feedback;
import solitaire.observer.Feedbackable;

/**
 * Composant Presentation d'une carte
 */
public class PCarte extends JPanel implements IPCarte, Feedbackable{

	private static final long serialVersionUID = 1L;
	protected CCarte controle ; // controleur associe
	protected JLabel face, dos;
	protected ImageIcon icone; // image de la face
	protected static ImageIcon iconeDos; // image du dos
	public static int largeur, hauteur;
	private Border border;

	/**
	 * initialiser l'image du dos et les dimensions d'une PCarte
	 */
	static {
		iconeDos = new ImageIcon(ClassLoader.getSystemResource("solitaire/cartesCSHD/dos.jpg"));
		largeur = iconeDos.getIconWidth()+4;
		hauteur = iconeDos.getIconHeight()+4;
	}
	
	/**
	 * initialiser une carte
	 * @param chaine : nom de la carte (exemple "3H" = 3 Heart)
	 */
	public PCarte(final String chaine, final CCarte controle) {
		this.controle = controle ;

		// image de la face
		icone = new ImageIcon(ClassLoader.getSystemResource("solitaire/cartesCSHD/"+ chaine + ".gif"));
		face = new JLabel(icone);
		add(face);
		face.setLocation(0, 0);
		face.setSize(largeur, hauteur);

		// image du dos
		dos = new JLabel(iconeDos);
		add(dos);
		dos.setLocation(0, 0);
		dos.setSize(largeur, hauteur);

		// le JPanel
		setLayout(null);
		setOpaque(true);
		setSize(face.getSize());
		setPreferredSize(getSize());
		setFaceVisible(false);
		
		border = BorderFactory.createLineBorder (Color.yellow, 5);
		setBorder(border);
		setOpaque(false);
		
	} // constructeur

	/**
	 * changer la visibilite de la carte
	 * @param faceVisible: vrai si la face est visible, faux sinon
	 */
	public void setFaceVisible(boolean faceVisible) {
		face.setVisible(faceVisible);
		dos.setVisible(!faceVisible);
	}

	public final CCarte getControleur() {
		return (controle) ;
	}

	public ImageIcon getIcone() {
		return icone;
	}

	@Override
	public void highlightValideDrop(Point location) {
		System.out.println("Les cartes ne sont pas concernees par le retour semantique du drop!");
	}

	@Override
	public void highlightInvalideDrop(Point location) {
		System.out.println("Les cartes ne sont pas concernees par le retour semantique du drop!");
	}

	@Override
	public void clearFeedback() {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void highlightDraggable() {
		setCursor(new Cursor(Cursor.MOVE_CURSOR));
	}

} // PCarte
