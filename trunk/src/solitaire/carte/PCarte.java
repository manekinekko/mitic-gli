package solitaire.carte;

//import solitaire.controle.* ;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * Composant Presentation d'une carte
 */
public class PCarte extends JPanel implements IPCarte {

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
		
		border = BorderFactory.createLineBorder (Color.yellow, 10);
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

} // PCarte
