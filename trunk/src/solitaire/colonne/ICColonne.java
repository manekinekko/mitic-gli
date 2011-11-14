package solitaire.colonne;

import solitaire.doubletas.ICDoubleTas;
import solitaire.pac.Controleur;

public interface ICColonne extends ICDoubleTas, Controleur{

	public void decompacter();

	public void repositionner();
	
}