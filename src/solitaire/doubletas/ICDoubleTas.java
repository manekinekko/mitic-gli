package solitaire.doubletas;

import java.util.Observer;

import solitaire.application.Carte;
import solitaire.pac.Controleur;

public interface ICDoubleTas extends Controleur{

	public void addObserver(Observer o);
	public void empilerCarteSurTasColore();
	public Carte getBase() throws Exception;
	public void depiler() throws Exception;
	
}
