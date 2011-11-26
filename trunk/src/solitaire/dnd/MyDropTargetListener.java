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

import solitaire.carte.CCarte;
import solitaire.carte.PCarte;
import solitaire.observer.Feedback;
import solitaire.observer.Feedbackable;
import solitaire.tasdecartes.CTasDeCartes;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

public class MyDropTargetListener implements DropTargetListener {

	private ICTasDeCartes cTasDeCartes_;
	private boolean accepterDrop_; // pour optimiser le drop du DnD
	private Feedback feedback_;

	public MyDropTargetListener(ICTasDeCartes cTasDeCartes, Feedback feedback) {
		cTasDeCartes_ = cTasDeCartes;
		feedback_ = feedback;
	}

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
				pTasDeCartes = (PTasDeCartes) transferable.getTransferData(new DataFlavor(
						DataFlavor.javaJVMLocalObjectMimeType));

				CTasDeCartes cTasDeCartesRecu = (CTasDeCartes) pTasDeCartes.getControleur();

				if (cTasDeCartes_.isEmpilable(cTasDeCartesRecu.getBase())) {
					accepterDrop_ = true;
					feedback_.highlightValideDrop(event.getLocation());
					event.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
				} else {
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

	@Override
	public void dragExit(DropTargetEvent event) {
		feedback_.clearFeedback();
		if (!accepterDrop_) {
			return;
		}
	}

	@Override
	public void dragOver(DropTargetDragEvent event) {
		if (!accepterDrop_) {
			return;
		}
	}

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
				PTasDeCartes pTasDeCartes = (PTasDeCartes) transferable
						.getTransferData(new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType));
				CTasDeCartes cTasDeCartesRecu = (CTasDeCartes) pTasDeCartes.getControleur();
				
				if (cTasDeCartes_.isAlterne()) {
					if (cTasDeCartes_.isEmpilable(cTasDeCartesRecu.getBase())) {
						cTasDeCartes_.empiler(cTasDeCartesRecu);
						cTasDeCartes_.decompacter();
						event.getDropTargetContext().dropComplete(true);
					}
				} else {
					if (cTasDeCartesRecu.getNombre() == 1
							&& cTasDeCartes_.isEmpilable(cTasDeCartesRecu.getBase())) {
						cTasDeCartes_.empiler(cTasDeCartesRecu);
						cTasDeCartes_.compacter();
						event.getDropTargetContext().dropComplete(true);
					}
				}
				
				CCarte cCarte = (CCarte)cTasDeCartes_.getSommet();
				PCarte pCarte = (PCarte)cCarte.getPresentation();
				Feedback.highlightDraggableState((Feedbackable)pCarte);

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

	@Override
	public void dropActionChanged(DropTargetDragEvent event) {
		event.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
	}

}
