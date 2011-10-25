package solitaire.tasdecartes;

import solitaire.application.Carte;
import solitaire.application.Tas;
import solitaire.carte.ICCarte;
import solitaire.pac.Controleur;

public interface ICTasDeCartes extends Controleur {

	public ICCarte getCCarte(int number);

	public void depiler() throws Exception;

	public void empiler(Carte carte);

	public void empiler(Tas tas);

	public void empiler(Tas tas, int nbCartes);

	public Carte getBase() throws Exception;

	public Carte getCarte(int n) throws Exception;

	public String getNom();

	public int getNombre();

	public boolean isAlterne();

	public boolean isEmpilable(Carte carte);

	public boolean isEmpilable(Tas tas);

	public boolean isEmpilable(Tas tas, int nbCartes);

	public boolean isVide();

	public void recopier(Tas tas);
	
	public void compacter();
	
	public void decompacter();

}
