package solitaire.dnd;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import solitaire.feedback.Feedback;
import solitaire.tasdecartes.CTasDeCartes;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

/**
 * Classe permettant d'effectuer le drop du drag 'n drop.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @see DropTargetListener
 */
public class MyDropTargetListener implements DropTargetListener {

	private ICTasDeCartes cTasDeCartes_;
	private boolean accepterDrop_; // pour optimiser le drop du DnD
	private Feedback feedback_;

	/**
	 * Constructeur de MyDropTargetListener.
	 * @param cTasDeCartes
	 * @param feedback
	 */
	public MyDropTargetListener(ICTasDeCartes cTasDeCartes, Feedback feedback) {
		cTasDeCartes_ = cTasDeCartes;
		feedback_ = feedback;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dragEnter(DropTargetDragEvent event) {

		DataFlavor flavors[] = event.getCurrentDataFlavors();
		int i;
		for (i = 0; i < flavors.length; ++i) {
			if (((PTasDeCartes) cTasDeCartes_.getPresentation()).isDataFlavorSupported(flavors[i])) {
				break;
			}
		}
		// si on n'a pas trouve le flavor
		if (i >= flavors.length) {
			event.rejectDrag();
		} else {

			Transferable transferable = event.getTransferable();
			PTasDeCartes pTasDeCartes;
			try {
				//récupère le tas de carte
				pTasDeCartes = (PTasDeCartes) transferable.getTransferData(new DataFlavor(
						DataFlavor.javaJVMLocalObjectMimeType));

				CTasDeCartes cTasDeCartesRecu = (CTasDeCartes) pTasDeCartes.getControleur();

				//test si le tas de carte est empilable
				if (cTasDeCartes_.isEmpilable(cTasDeCartesRecu.getBase())) {
					accepterDrop_ = true;
					//affichage d'un retour sémentique "drop possible"
					feedback_.highlightValideDrop(event.getLocation());
					event.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
				} else {
					//affichage d'un retour sémentique "drop impossible"
					feedback_.highlightInvalideDrop(event.getLocation());
					accepterDrop_ = false;
				}

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (UnsupportedFlavorException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dragExit(DropTargetEvent event) {
		//enlève le retour sémentique
		feedback_.clearFeedback();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dragOver(DropTargetDragEvent event) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void drop(DropTargetDropEvent event) {

		feedback_.clearFeedback();
		if (!accepterDrop_) {
			return;
		}

		Transferable transferable = event.getTransferable();
		try {

			if (transferable.isDataFlavorSupported(new DataFlavor(
					DataFlavor.javaJVMLocalObjectMimeType))) {
				//recupère le tas de carte
				PTasDeCartes pTasDeCartes = (PTasDeCartes) transferable
						.getTransferData(new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType));
				CTasDeCartes cTasDeCartesRecu = (CTasDeCartes) pTasDeCartes.getControleur();
				
				if (cTasDeCartes_.isAlterne()) {
					if (cTasDeCartes_.isEmpilable(cTasDeCartesRecu.getBase())) {
						//si le tas de carte est alterné et que l'on peut empiler le tas, on empile
						cTasDeCartes_.empiler(cTasDeCartesRecu);
						cTasDeCartes_.decompacter();
						event.getDropTargetContext().dropComplete(true);
					}
				} else {
					//si le tas n'est pas alterné, il s'agit d'un tas coloré
					//on vérifi alors que l'on empile bien une seul carte
					if (cTasDeCartesRecu.getNombre() == 1
							&& cTasDeCartes_.isEmpilable(cTasDeCartesRecu.getBase())) {
						cTasDeCartes_.empiler(cTasDeCartesRecu);
						cTasDeCartes_.compacter();
						event.getDropTargetContext().dropComplete(true);
					}
				}

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dropActionChanged(DropTargetDragEvent event) {
		event.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
	}

}
