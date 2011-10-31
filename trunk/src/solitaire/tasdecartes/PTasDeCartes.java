package solitaire.tasdecartes;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import javax.swing.JPanel;
import solitaire.carte.ICCarte;
import solitaire.carte.PCarte;
import solitaire.dnd.MyDragGestionListener;
import solitaire.dnd.MyDragSourceListener;
import solitaire.pac.Controleur;

public class PTasDeCartes extends JPanel implements IPTasDeCartes {

	private static final long serialVersionUID = 1L;
	protected ICTasDeCartes controleur_;
	public static int ecartDecompacte = 20;

	// DnD
	protected DragSource dragSource = null;
	protected MyDragSourceListener myDragSourceListener = null;
	
	public PTasDeCartes(ICTasDeCartes controleur) {
		super(null);
		setSize(new Dimension(PCarte.largeur, PCarte.hauteur+ecartDecompacte*18));
		controleur_ = controleur;
		dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, new MyDragGestionListener(this, dragSource));
	}

	@Override
	public void add(ICCarte carte) {
		JPanel pCarte = (JPanel)carte.getPresentation();
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
		for(int i = 0; i< componentNumber; i++){
			carte = getComponent(i);
			carte.setLocation(0, i*ecartDecompacte);
			setComponentZOrder(carte, 0);
		}
	}

	@Override
	public void compacter() {
		int componentNumber = getComponentCount();
		Component carte;
		for(int i = 0; i< componentNumber; i++){
			carte = getComponent(i);
			setComponentZOrder(carte, 0);
		}
	}
	
}
