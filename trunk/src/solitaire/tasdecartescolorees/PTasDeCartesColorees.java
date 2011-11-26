package solitaire.tasdecartescolorees;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.dnd.DropTarget;
import javax.swing.border.LineBorder;
import solitaire.observer.Feedback;
import solitaire.observer.Feedbackable;
import solitaire.carte.PCarte;
import solitaire.dnd.MyDropTargetListener;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PTasDeCartesColorees extends PTasDeCartes implements IPTasDeCartesColorees, Feedbackable{

	private static final long serialVersionUID = 1L;
	private Color originalBorderColor_;

	public PTasDeCartesColorees(ICTasDeCartesColorees controleur) {
		super((ICTasDeCartes) controleur);
		setPreferredSize(new Dimension(PCarte.largeur+4, PCarte.hauteur+4));
		setBackground(Color.blue);
		
		Feedback feedback_ = new Feedback(this);
		DropTarget dropTarget_ = new DropTarget(this, new MyDropTargetListener(controleur, feedback_));

		originalBorderColor_ = Color.gray;
		setBorder(new LineBorder(originalBorderColor_, 2, true));
		
	}

	@Override
	public void highlightValideDrop(Point location) {
		Component component = getComponentAt(location);
		if ( component != null ){
			setBorder(new LineBorder(Color.green, 2, true));
		}
	}

	@Override
	public void highlightInvalideDrop(Point location) {
		Component component = getComponentAt(location);
		if ( component != null ){
			setBorder(new LineBorder(Color.red, 2, true));
		}
	}

	@Override
	public void clearFeedback() {
		setBorder(new LineBorder(originalBorderColor_, 2, true));
	}

	@Override
	public void highlightDraggable() {
		// TODO Auto-generated method stub
	}
	
}
