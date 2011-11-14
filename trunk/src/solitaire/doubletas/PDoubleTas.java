package solitaire.doubletas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import solitaire.carte.CCarte;
import solitaire.dnd.MyDragGestureListener;
import solitaire.pac.Controleur;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PDoubleTas extends JPanel implements IPDoubleTas, Presentation {

	private static final long serialVersionUID = 1L;
	protected ICTasDeCartes cTasCache_;
	protected ICTasDeCartes cTasVisible_;
	protected ICDoubleTas controleur_;
	protected DragSource dragSource_;
	private MyDragGestureListener myDragSourceMotionListener_;
	
	public PDoubleTas(final ICDoubleTas controleur, ICTasDeCartes cTasCache,
			ICTasDeCartes cTasVisible) {
		super(null);
		
		controleur_ = controleur;
		cTasCache_ = cTasCache;
		cTasVisible_ = cTasVisible;

		PTasDeCartes pTasCache = (PTasDeCartes) cTasCache_.getPresentation();
		PTasDeCartes pTasVisible = (PTasDeCartes) cTasVisible_.getPresentation();
		
		//classes pour le drag
		dragSource_ = new DragSource();
		myDragSourceMotionListener_ = new MyDragGestureListener(cTasVisible_, dragSource_);
		dragSource_.createDefaultDragGestureRecognizer(this,DnDConstants.ACTION_MOVE, myDragSourceMotionListener_);
		dragSource_.addDragSourceMotionListener(myDragSourceMotionListener_);
		
		add(pTasCache);
		add(pTasVisible);
		setComponentZOrder(pTasVisible, 0);
		
	}

	@Override
	public Controleur getControleur() {
		return controleur_;
	}

}