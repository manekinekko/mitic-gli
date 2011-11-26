package solitaire.colonne;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import solitaire.application.TasDeCartes;
import solitaire.carte.CCarte;
import solitaire.carte.PCarte;
import solitaire.dnd.MyDropTargetListener;
import solitaire.doubletas.PDoubleTas;
import solitaire.pac.Controleur;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;
import solitaire.tasdecartesalternees.PTasDeCartesAlternees;
import solitaire.observer.Feedback;
import solitaire.observer.Feedbackable;

public class PColonne extends PDoubleTas implements IPColonne, Feedbackable {

	private static final long serialVersionUID = 1L;
	private ICColonne controleur_;
	private PTasDeCartes pCache_;
	private PTasDeCartesAlternees pVisible_;
	private Color originalBackgroundColor_;

	public PColonne(final ICColonne controleur, final ICTasDeCartes cachees,
			final ICTasDeCartes visible) {
		super(controleur, cachees, visible);
		controleur_ = controleur;

		pCache_ = (PTasDeCartes) cachees.getPresentation();
		pVisible_ = (PTasDeCartesAlternees) visible.getPresentation();
		pCache_.setLocation(0, 0);

		Feedback feedback_ = new Feedback(this);
		DropTarget dropTarget_ = new DropTarget(this, new MyDropTargetListener(
				cTasVisible_, feedback_));

		setPreferredSize(new Dimension(PCarte.largeur, PCarte.hauteur
				+ PTasDeCartes.ecartDecompacte * 18));
		repositionner();

		originalBackgroundColor_ = getBackground();

		/**
		 * TODO revoir cette partie
		 */
		int count = pVisible_.getComponentCount();
		if ( count > 0 ) {
			((PCarte)pVisible_.getComponent( count-1 )).highlightDraggable();
		}
		
		addMouseListener(new MouseListener() {
			private int lastZOrder_;
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (visible.getNombre() > 0) {
//					try {
//						CCarte cCarte = (CCarte) visible.getSommet();
//						JPanel pCarte = ((JPanel) cCarte.getPresentation());
//						pCarte.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
				} 
				else if (cachees.getNombre() > 0) {
					try {
						
						CCarte cCarte = (CCarte) cachees.getSommet();
						JPanel pCarte = ((JPanel) cCarte.getPresentation());
						setComponentZOrder(pCarte, lastZOrder_);
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				if (visible.getNombre() > 0) {
//					try {
//						CCarte cCarte = (CCarte) visible.getSommet();
//						JPanel pCarte = ((JPanel) cCarte.getPresentation());
//						pCarte.setCursor(new Cursor(Cursor.MOVE_CURSOR));
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}

				} else {
					if (cachees.getNombre() > 0) {
						try {
							CCarte cCarte = (CCarte) cachees.getSommet();
							JPanel pCarte = ((JPanel) cCarte.getPresentation());
							pCarte.setCursor(new Cursor(Cursor.HAND_CURSOR));
							
							lastZOrder_ = getComponentZOrder(pCarte);
							setComponentZOrder(pCarte, 0);
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}

				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				if (visible.isVide() && (visible.getNombre() > 0 || cachees.getNombre() > 0)) {
					try {
						visible.empiler(cachees.getSommet());
						cachees.depiler();
						repositionner();
						pVisible_.decompacter();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				} else {
					// double click
					if (e.getClickCount() == 2) {
						controleur.empilerCarteSurTasColore();
					}
				}

			}
		});

	}

	@Override
	public Controleur getControleur() {
		return controleur_;
	}

	public void repositionner() {
		pVisible_.setLocation(0, cTasCache_.getNombre()
				* PTasDeCartes.ecartDecompacte);
	}

	@Override
	public void highlightValideDrop(Point location) {
		Component component = getComponentAt(location);
		if (component != null) {
			setBackground(new Color(0, 255, 0, 255));
		}
	}

	@Override
	public void highlightInvalideDrop(Point location) {
		Component component = getComponentAt(location);
		if (component != null) {
			setBackground(new Color(255, 0, 0, 255));
		}
	}

	@Override
	public void clearFeedback() {
		setBackground(originalBackgroundColor_);
	}

	@Override
	public void highlightDraggable() {
		System.out.println("Les colonnes ne sont pas concernees par le drag!");
	}

}
