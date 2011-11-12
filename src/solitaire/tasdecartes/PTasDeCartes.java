package solitaire.tasdecartes;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JPanel;

import solitaire.application.Carte;
import solitaire.carte.CCarte;
import solitaire.carte.ICCarte;
import solitaire.carte.PCarte;
import solitaire.pac.Controleur;

public class PTasDeCartes extends JPanel implements IPTasDeCartes, Transferable, Serializable {

	private static final long serialVersionUID = 1L;
	protected ICTasDeCartes controleur_;
	public static int ecartDecompacte = 20;

	public PTasDeCartes(ICTasDeCartes controleur) {
		super(null);
		setSize(new Dimension(PCarte.largeur, PCarte.hauteur + ecartDecompacte
				* 18));
		controleur_ = controleur;
		setOpaque(false);

	}

	@Override
	public void add(ICCarte carte) {
		JPanel pCarte = (JPanel) carte.getPresentation();
		add(pCarte);
		repaint();
	}

	@Override
	public Controleur getControleur() {
		return controleur_;
	}

	@Override
	public void decompacter() {
		
		Component comp[] = getComponents();
		for (int i = 0; i < comp.length; i++) {
			PCarte component = (PCarte)comp[i];
			CCarte carte = (CCarte) component.getControleur();
			System.out.print("ptas:"+carte+" ; ");
		}
		System.out.println();
		
		int componentNumber = getComponentCount();
		Component carte;
		for (int i = 0; i < componentNumber; i++) {
			carte = getComponent(i);
			carte.setLocation(0, i * ecartDecompacte);
			setComponentZOrder(carte, 0);
		}
	}

	@Override
	public void compacter() {
		int componentNumber = getComponentCount();
		Component carte;
		for (int i = 0; i < componentNumber; i++) {
			carte = getComponent(i);
			carte.setLocation(0, 0);
			setComponentZOrder(carte, 0);
		}
	}

	@Override
	public void decompacterHorizontal() {
		
		int componentNumber = getComponentCount();
		Component carte;
		int i;
		for (i = 0; i < componentNumber-3; i++) {
			carte = getComponent(i);
			carte.setLocation(0, 0);
			setComponentZOrder(carte, 0);
		}
		for (int j = i; j < componentNumber; j++) {
			carte = getComponent(j);
			carte.setLocation((j-i) * ecartDecompacte,0);
			setComponentZOrder(carte, 0);
		}
		
	}
	
	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		
		Object result = null;
		if ( flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType) ){
			result = this;
		}
		
		return result;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor[] data = new DataFlavor[1];
		try{
			data[0] = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
		}
		catch(ClassNotFoundException e){
		}
		return data;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType);
	}

	@Override
	public void redessiner() {
		repaint();
	}

	@Override
	public void remove(PCarte pCarte) {
        super.remove(pCarte);
        repaint();
	}
}
