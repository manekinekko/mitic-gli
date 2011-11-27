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

/**
 * 
 * Cette classe définit le comportement des colonnes. Elle hérite également de noyau applicatif {@link PDoubleTas}.<br/>
 * Cette classe implémente l'interface {@link Feedback} qui lui permet ainsi de définir des comportant liés au retour
 * sémantique. 
 *
 * @author Wassim Chegham {@link contact@cheghamwassim.com}
 * @author Gurval Le Bouter {@link sketylee@gmail.com}
 * @see PDoubleTas
 *
 */
public class PColonne extends PDoubleTas implements IPColonne, Feedbackable {

	private static final long serialVersionUID = 1L;
	private ICColonne controleur_;
	private PTasDeCartes pCache_;
	private PTasDeCartesAlternees pVisible_;
	private Color originalBackgroundColor_;

	/**
	 * Le constructeur permet d'initialiser les présentations des différents tas de cartes,
	 * ainsi 
	 * 
	 * 
	 * @param controleur Le controleur des colonnes
	 * @param cachees Le controleur des tas de cartes cachées
	 * @param visible Le controleur des tas de cartes visibles
	 */
	public PColonne(final ICColonne controleur, final ICTasDeCartes cachees,
			final ICTasDeCartes visible) {
		super(controleur, cachees, visible);
		controleur_ = controleur;

		pCache_ = (PTasDeCartes) cachees.getPresentation();
		pVisible_ = (PTasDeCartesAlternees) visible.getPresentation();
		pCache_.setLocation(0, 0);

		final Feedback feedback_ = new Feedback(this);
		
		@SuppressWarnings("unused")
		DropTarget dropTarget_ = new DropTarget(this, new MyDropTargetListener(
				cTasVisible_, feedback_));

		setPreferredSize(new Dimension(PCarte.largeur, PCarte.hauteur
				+ PTasDeCartes.ecartDecompacte * 18));
		repositionner();

		// on mémorise la couleur de l'arrière plan
		originalBackgroundColor_ = getBackground();

		// on définit les différents évenements auxquels doit réagir cette colonne
		addMouseListener(new MouseListener() {
			private int lastZOrder_;
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			/**
			 * Permet de retirer le comportement de retour sémantique sur les cartes visibles et cachées de la colonne courante.<br/>
			 * Ce retour sémantique est définit lors d'un évènement <b>mouseEntered</b>.<br/>
			 * Pour les cartes visibles, on délègue cette opération à la classe Feedback qui va pouvoir annuler le retour sémantique.<br/>
			 * Concernant les cartes cachées, on repositionne la carte au sommet à son niveau Z-Order de départ après l'avoir corrigé lors de 
			 * l'évènement <b>mouseEntered</b> de départ.
			 */
			@Override
			public void mouseExited(MouseEvent e) {
				if (visible.getNombre() > 0) {
					
					for(int i=0; i<pVisible_.getComponentCount(); i++) {
						Feedback.clearDraggableState((Feedbackable)pVisible_.getComponent(i));
					}

				} else {
					if ( cachees.getNombre() > 0 && lastZOrder_ >= 0 ) {
						try {
							
							CCarte cCarte = (CCarte) cachees.getSommet();
							JPanel pCarte = ((JPanel) cCarte.getPresentation());
							setComponentZOrder(pCarte, lastZOrder_);
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}

			/**
			 * Permet de définir un comportement de retour sémantique sur les cartes visibles et cachées de la colonne courante.<br/>
			 * Pour les cartes visibles, on délègue la tâche à la classe Feedback qui va s'en occuper.<br/>
			 * Pour les cartes cachées, on définit un nouveau curseur accompagné d'une légère correction du niveau Z-Order de la carte au sommet
			 * du tas.
			 */
			@Override
			public void mouseEntered(MouseEvent e) {

				if (visible.getNombre() > 0) {
					
					for(int i=0; i<pVisible_.getComponentCount(); i++) {
						Feedback.highlightDraggableState((Feedbackable)pVisible_.getComponent(i));
					}

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

			/**
			 * Lors d'un simple click, lorsqu'il n'y a plus de cartes visibles, on retourne la carte cachée se trouvant au sommet du tas caché. 
			 * Puis on empile cette carte sur le tas visible.<br/>
			 * Lors d'un double-click sur une carte visible, on essaye d'empiler cette dernière sur l'un des tas colorés.
			 */
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
		
		// on définit le comportant du retour sémantique sur la carte se trouvant au sommet
		// au sein de la colonne courante. Ce comportement est décrit dans la classe PCarte.
		int count = pVisible_.getComponentCount();
		if ( count > 0 ) {
			((PCarte)pVisible_.getComponent( count-1 )).highlightDraggable();
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Controleur getControleur() {
		return controleur_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void repositionner() {
		pVisible_.setLocation(0, cTasCache_.getNombre()
				* PTasDeCartes.ecartDecompacte);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void highlightValideDrop(Point location) {
		Component component = getComponentAt(location);
		if (component != null) {
			setBackground(new Color(0, 255, 0, 255));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void highlightInvalideDrop(Point location) {
		Component component = getComponentAt(location);
		if (component != null) {
			setBackground(new Color(255, 0, 0, 255));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clearFeedback() {
		setBackground(originalBackgroundColor_);
	}

	/**
	 * {@inheritDoc}
	 * Cette méthode ne concerne pas les colonnes, puis ces dernières ne sont pas censées être déplacables.
	 */
	@Override
	public void highlightDraggable() {
		System.out.println("Les colonnes ne sont pas concernees par le drag!");
	}

}
