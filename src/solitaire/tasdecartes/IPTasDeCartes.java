package solitaire.tasdecartes;

import solitaire.pac.Presentation;
import solitaire.carte.ICCarte;

public interface IPTasDeCartes extends Presentation {

	public void add(ICCarte carte);

	public void decompacter();

	public void compacter();

	public void decompacterHorizontal();
	
}