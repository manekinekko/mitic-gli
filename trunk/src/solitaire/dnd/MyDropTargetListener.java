package solitaire.dnd;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import solitaire.tasdecartes.CTasDeCartes;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;
import solitaire.tasdecartesalternees.CTasDeCartesAlternees;

public class MyDropTargetListener implements DropTargetListener {

	private ICTasDeCartes cTasDeCartes_;

	public MyDropTargetListener(ICTasDeCartes cTasDeCartes) {
		cTasDeCartes_ = cTasDeCartes;
	}

	@Override
	public void dragEnter(DropTargetDragEvent event) {

	}

	@Override
	public void dragExit(DropTargetEvent event) {

	}

	@Override
	public void dragOver(DropTargetDragEvent event) {

	}

	@Override
	public void drop(DropTargetDropEvent event) {
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
					if (cTasDeCartes_.getNombre() == 1
							&& cTasDeCartes_.isEmpilable(cTasDeCartesRecu.getBase())) {
						cTasDeCartes_.empiler(cTasDeCartesRecu);
						event.getDropTargetContext().dropComplete(true);
						cTasDeCartes_.compacter();
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

	@Override
	public void dropActionChanged(DropTargetDragEvent event) {

	}

}
