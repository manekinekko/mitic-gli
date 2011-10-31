package solitaire.tasdecartes;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import javax.swing.JPanel;
import solitaire.carte.ICCarte;
import solitaire.carte.PCarte;
import solitaire.dnd.MyDragGestureListener;
import solitaire.dnd.MyDragSourceListener;
import solitaire.pac.Controleur;

public class PTasDeCartes extends JPanel implements IPTasDeCartes, Transferable {

	private static final long serialVersionUID = 1L;
	protected ICTasDeCartes controleur_;
	public static int ecartDecompacte = 20;

	// DnD
	protected DragSource dragSource = null;
	protected MyDragSourceListener myDragSourceListener = null;

	public PTasDeCartes(ICTasDeCartes controleur) {
		super(null);
		setSize(new Dimension(PCarte.largeur, PCarte.hauteur + ecartDecompacte
				* 18));
		controleur_ = controleur;
		dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(this,
				DnDConstants.ACTION_MOVE, new MyDragGestureListener(this,
						dragSource));
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
			setComponentZOrder(carte, 0);
		}
	}

	@Override
	public Object getTransferData(DataFlavor flavor) {
		Object result = null;
		if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {
			result = this;
		}
		return result;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor data[] = new DataFlavor[1];
		try {
			data[0] = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
		} catch (ClassNotFoundException ex) {
		}
		return data;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {
			return true;
		}
		return false;
	}

}
