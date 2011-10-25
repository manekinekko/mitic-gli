package solitaire.carte;

//import solitaire.controle.* ;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.*;

/**
 * Composant Presentation d'une carte
 */
public class PCarte extends JPanel implements IPCarte, Transferable, Serializable {

	private static final long serialVersionUID = 1L;
	protected CCarte controle ; // controleur associe
	protected JLabel face, dos;
	protected ImageIcon icone; // image de la face
	protected static ImageIcon iconeDos; // image du dos
	public static int largeur, hauteur;

	/**
	 * initialiser l'image du dos et les dimensions d'une PCarte
	 */
	static {
		iconeDos = new ImageIcon(ClassLoader.getSystemResource("solitaire/cartesCSHD/dos.jpg"));
		largeur = iconeDos.getIconWidth() + 4;
		hauteur = iconeDos.getIconHeight() + 4;
	}
	
	/**
	 * initialiser une carte
	 * @param chaine : nom de la carte (exemple "3H" = 3 Heart)
	 */
	public PCarte(final String chaine, CCarte controle) {
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
		setBackground(Color.yellow);
		setOpaque(true);
		setSize(face.getSize());
		setPreferredSize(getSize());
		setFaceVisible(false);
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
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		
		Object result = null;
		if ( flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType) ){
			result = this;
		}
		else if ( flavor.isMimeTypeEqual(new DataFlavor(String.class, null)) ){
			result = null;
		}
		return result;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor[] data = new DataFlavor[2];
		try{
			data[0] = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
			data[1] = new DataFlavor(String.class, null);
		}
		catch(ClassNotFoundException e){
		}
		return data;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)
				|| (flavor.isMimeTypeEqual(new DataFlavor(String.class, null)));
	}

} // PCarte
