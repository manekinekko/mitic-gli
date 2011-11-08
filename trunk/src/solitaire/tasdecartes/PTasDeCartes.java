package solitaire.tasdecartes;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import solitaire.carte.ICCarte;
import solitaire.carte.PCarte;
import solitaire.pac.Controleur;

public class PTasDeCartes extends JPanel implements IPTasDeCartes {

	private static final long serialVersionUID = 1L;
	protected ICTasDeCartes controleur_;
	public static int ecartDecompacte = 20;

	public PTasDeCartes(ICTasDeCartes controleur) {
		super(null);
		setSize(new Dimension(PCarte.largeur, PCarte.hauteur + ecartDecompacte
				* 18));
		controleur_ = controleur;
	}

	@Override
	public void add(ICCarte carte) {
		JPanel pCarte = (JPanel) carte.getPresentation();
		add(pCarte);
	}

	@Override
	public Controleur getControleur() {
		return controleur_;
	}

	@Override
	public void decompacter() {
		System.out.println("pdecompacter");
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
	public void remove() {
	}

	@Override
	public void decompacterHorizontal() {
		
		int componentNumber = getComponentCount();
		System.out.println(componentNumber);
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
}
