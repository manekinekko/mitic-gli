package solitaire.carte;

import javax.swing.ImageIcon;

import solitaire.pac.Presentation;
import solitaire.pac.Controleur;

public interface IPCarte extends Presentation {

	public void setFaceVisible(boolean faceVisible);
	
	public ImageIcon getIcone();

}
