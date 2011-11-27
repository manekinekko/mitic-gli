package solitaire.tasdecartescolorees;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.dnd.DropTarget;
import javax.swing.border.LineBorder;
import solitaire.carte.PCarte;
import solitaire.dnd.MyDropTargetListener;
import solitaire.feedback.Feedback;
import solitaire.feedback.Feedbackable;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

/**
 * Presentation d'un tas de cartes colorées.
 * 
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see Feedbackable
 */
public class PTasDeCartesColorees extends PTasDeCartes implements IPTasDeCartesColorees, Feedbackable{

	private static final long serialVersionUID = 1L;
	private Color originalBorderColor_;

	/**
	 * Constructeur d'un tas de cartes colorees
	 * @param controleur
	 */
	public PTasDeCartesColorees(ICTasDeCartesColorees controleur) {
		super((ICTasDeCartes) controleur);
		setPreferredSize(new Dimension(PCarte.largeur+4, PCarte.hauteur+4));
		setBackground(Color.blue);
		
		final Feedback feedback = new Feedback(this);
		@SuppressWarnings("unused")
		DropTarget dropTarget_ = new DropTarget(this, new MyDropTargetListener(controleur, feedback));

		originalBorderColor_ = Color.gray;
		setBorder(new LineBorder(originalBorderColor_, 2, true));
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void highlightValideDrop(Point location) {
		Component component = getComponentAt(location);
		if ( component != null ){
			setBorder(new LineBorder(Color.green, 2, true));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void highlightInvalideDrop(Point location) {
		Component component = getComponentAt(location);
		if ( component != null ){
			setBorder(new LineBorder(Color.red, 2, true));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clearFeedback() {
		setBorder(new LineBorder(originalBorderColor_, 2, true));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void highlightDraggable() {
	}
	
}
