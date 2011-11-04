package solitaire.doubletas;

import java.awt.Color;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import javax.swing.JPanel;
import solitaire.dnd.MyDragGestureListener;
import solitaire.dnd.MyDragSourceListener;
import solitaire.pac.Controleur;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class PDoubleTas extends JPanel implements IPDoubleTas, Presentation {

	private static final long serialVersionUID = 1L;
	protected ICTasDeCartes cTasCache_;
	protected ICTasDeCartes cTasVisible_;
	protected ICDoubleTas controleur_;
	protected MyDragSourceListener myDragSourceListener_;
	protected DragSource dragSource_;
	private MyDragGestureListener myDragSourceMotionListener_;
	
	public PDoubleTas(ICDoubleTas controleur, ICTasDeCartes cTasCache,
			ICTasDeCartes cTasVisible) {
		super(null);
		
		controleur_ = controleur;
		cTasCache_ = cTasCache;
		cTasVisible_ = cTasVisible;

		PTasDeCartes pTasCache = (PTasDeCartes) cTasCache_.getPresentation();
		PTasDeCartes pTasVisible = (PTasDeCartes) cTasVisible_.getPresentation();
		
		pTasVisible.setBackground(Color.black);
		
		myDragSourceListener_ = new MyDragSourceListener(pTasVisible);
		dragSource_ = new DragSource();
		
		myDragSourceMotionListener_ = new MyDragGestureListener(pTasVisible, dragSource_);
		
		dragSource_.createDefaultDragGestureRecognizer(this,
				DnDConstants.ACTION_MOVE, myDragSourceMotionListener_);

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
