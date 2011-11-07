package solitaire.dnd;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import solitaire.carte.PCarte;
import solitaire.tasdecartes.ICTasDeCartes;

public class MyDropTargetListener implements DropTargetListener {

	private ICTasDeCartes cTasVisible_;

	public MyDropTargetListener(ICTasDeCartes cTasVisible) {
		cTasVisible_ = cTasVisible;
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
		System.out.println("drop");
		Transferable transferable = event.getTransferable();
		try {
			if (transferable.isDataFlavorSupported(new DataFlavor(
					DataFlavor.javaJVMLocalObjectMimeType))) {
				PCarte pCarte = (PCarte) transferable
						.getTransferData(new DataFlavor(
								DataFlavor.javaJVMLocalObjectMimeType));
				if (cTasVisible_.isEmpilable(pCarte.getControleur())) {
					cTasVisible_.empiler(pCarte.getControleur());
					cTasVisible_.decompacter();
					event.getDropTargetContext().dropComplete(true);
				} else {
					event.rejectDrop();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent event) {

	}

}
