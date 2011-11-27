package solitaire.solitaire;

import java.util.Observable;
import java.util.Observer;
import solitaire.application.Solitaire;
import solitaire.application.Usine;
import solitaire.carte.CCarte;
import solitaire.colonne.CColonne;
import solitaire.colonne.ICColonne;
import solitaire.doubletas.ICDoubleTas;
import solitaire.pac.Presentation;
import solitaire.sabot.CSabot;
import solitaire.sabot.ICSabot;
import solitaire.tasdecartescolorees.CTasDeCartesColorees;
import solitaire.tasdecartescolorees.ICTasDeCartesColorees;
import solitaire.observer.MyObservable;

/**
 * Contrôleur du solitaire.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @see ICSolitaire
 * @see Observer
 */
public class CSolitaire extends Solitaire implements ICSolitaire, Observer {

	private PSolitaire pSolitaire_;
	private ICSabot cSabot_;
	private ICTasDeCartesColorees[] cTasDeCartesColorees_;
	private ICColonne[] cColonnes_;

	/**
	 * Constructeur du solitaire.
	 * 
	 * @param nom
	 * @param usine
	 */
	public CSolitaire(String nom, Usine usine) {
		super(nom, usine);
		initialiser();
		run();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Presentation getPresentation() {
		return pSolitaire_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialiser() {
		super.initialiser();

		cSabot_ = (CSabot) super.sabot;
		cSabot_.addObserver(this);

		cTasDeCartesColorees_ = new CTasDeCartesColorees[4];
		for (int i = 0; i < 4; i++) {
			cTasDeCartesColorees_[i] = (ICTasDeCartesColorees) super.pilesColorees[i];
		}

		cColonnes_ = new CColonne[7];
		for (int i = 0; i < 7; i++) {
			cColonnes_[i] = (ICColonne) super.pilesAlternees[i];
			cColonnes_[i].addObserver(this);
		}

		pSolitaire_ = new PSolitaire(this);

	}

	/**
	 * Retourne le contrôleur du sabot.
	 * 
	 * @return cSabot le sabot.
	 */
	public ICSabot getCSabot() {
		return cSabot_;
	}

	/**
	 * Retourne un tableau contenant les contrôleurs des tas de cartes colorées.
	 * 
	 * @return cTasDeCartesColorees les tas de cartes colorées.
	 */
	public ICTasDeCartesColorees[] getCTasDeCartesColorees() {
		return cTasDeCartesColorees_;
	}

	/**
	 * Retourne un tableau contenant les contrôleurs des colonnes.
	 * 
	 * @return cColonnes les colonnes.
	 */
	public ICColonne[] getCColonnes() {
		return cColonnes_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object arg) {
		//on recupere la carte à partire de l'objet observable.
		ICDoubleTas cDoubleTas = (ICDoubleTas) ((MyObservable) o).getObservable();
		CCarte carte = null;

		try {
			carte = (CCarte) cDoubleTas.getBase();
			// cherche un tas de cartes colorées sur lequel on peut empiler la
			// carte
			for (int i = 0; i < cTasDeCartesColorees_.length; i++) {
				if (cTasDeCartesColorees_[i].isEmpilable(carte)) {
					cTasDeCartesColorees_[i].empiler(carte);
					cDoubleTas.depiler();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
