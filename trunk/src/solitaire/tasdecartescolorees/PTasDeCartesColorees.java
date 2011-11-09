package solitaire.tasdecartescolorees;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.dnd.DropTarget;

import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

import solitaire.carte.PCarte;
import solitaire.dnd.MyDropTargetListener;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PTasDeCartesColorees extends PTasDeCartes implements IPTasDeCartesColorees{

	private static final long serialVersionUID = 1L;

	public PTasDeCartesColorees(ICTasDeCartesColorees controleur) {
		super((ICTasDeCartes) controleur);
		setPreferredSize(new Dimension(PCarte.largeur, PCarte.hauteur));
		setBackground(Color.blue);
		DropTarget dropTarget_ = new DropTarget(this, new MyDropTargetListener(controleur));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	}
	
}
