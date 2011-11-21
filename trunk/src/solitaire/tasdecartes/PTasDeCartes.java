package solitaire.tasdecartes;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.JPanel;
import solitaire.carte.CCarte;
import solitaire.carte.ICCarte;
import solitaire.carte.PCarte;
import solitaire.pac.Controleur;

public class PTasDeCartes extends JPanel implements IPTasDeCartes,
		Transferable, Serializable {

	private static final long serialVersionUID = 1L;
	protected ICTasDeCartes controleur_;
	public static int ecartDecompacte = 20;

	public PTasDeCartes(ICTasDeCartes controleur) {
		super(null);
		setSize(new Dimension(PCarte.largeur, PCarte.hauteur));
		controleur_ = controleur;
		setOpaque(false);

	}

	@Override
	public void add(ICCarte carte) {
		setSize(new Dimension(getSize().width, PCarte.hauteur + ecartDecompacte
				* (controleur_.getNombre() - 1)));
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

		// enleve toutes les cartes
		Component comp[] = getComponents();
		for (int i = 0; i < comp.length; i++) {
			PCarte component = (PCarte) comp[i];
			remove(component);
		}

		// parcours du controleur pour recuperer les cartes et les ajouter
		try {

			int nbCarte = controleur_.getNombre();

			for (int i = nbCarte; i > 0; i--) {
				CCarte carte = (CCarte) controleur_.getCarte(i);
				PCarte pCarte = (PCarte) carte.getPresentation();
				add(pCarte);
				pCarte.setLocation(0, (nbCarte - i) * ecartDecompacte);
				setComponentZOrder(pCarte, 0);
			}

		} catch (Exception e) {
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

		int nbCarte = controleur_.getNombre();

		if (nbCarte > 0) {

			// enleve toutes les cartes
			Component comp[] = getComponents();
			int nbCartesVisibles = comp.length > 3 ? 3 : comp.length;
			
			for (int i = 0; i < nbCartesVisibles; i++) {
				PCarte component = (PCarte) comp[i];
				remove(component);
			}

			try {
				int j = nbCartesVisibles-1;

				for (int i = 1; i <= nbCartesVisibles; i++) {
					CCarte cCarte = (CCarte) controleur_.getCarte(i);
					PCarte pCarte = (PCarte) cCarte.getPresentation();
					System.out.println(cCarte+" "+i);
					add(pCarte);
					pCarte.setLocation(j * ecartDecompacte, 0);
					j--;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

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

	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {

		Object result = null;
		if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {
			result = this;
		}

		return result;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor[] data = new DataFlavor[1];
		try {
			data[0] = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
		} catch (ClassNotFoundException e) {
		}
		return data;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType);
	}

}
