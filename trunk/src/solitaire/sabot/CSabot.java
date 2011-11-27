package solitaire.sabot;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import solitaire.application.Sabot;
import solitaire.application.Usine;
import solitaire.carte.PCarte;
import solitaire.observer.MyObservable;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;
import solitaire.tasdecartes.PTasDeCartes;

/**
 * Contrôleur du sabot.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @see ICSabot
 * @see Observer
 */
public class CSabot extends Sabot implements ICSabot, Observer {

	private IPSabot pSabot_;
	private PTasDeCartes pTasVisible_;
	@SuppressWarnings("unused")
	private PTasDeCartes pTasCache_;
	private MyObservable observable_;
	private ICTasDeCartes visibles_;
	private ICTasDeCartes cachees_;

	/**
	 * Constructeur du sabot.
	 * @param nom
	 * @param usine
	 */
	public CSabot(String nom, Usine usine) {
		super(nom, usine);

		visibles_ = (ICTasDeCartes) super.visibles;
		cachees_ = (ICTasDeCartes) super.cachees;

		Presentation pTasVisible = visibles_.getPresentation();
		Presentation pTasCache = cachees_.getPresentation();

		pTasVisible_ = ((PTasDeCartes) pTasVisible);
		pTasCache_ = ((PTasDeCartes) pTasCache);

		pTasVisible_.setSize(new Dimension(PCarte.largeur * 2, PCarte.hauteur));
		pSabot_ = new PSabot(this, cachees_, visibles_);
		observable_ = new MyObservable(this);
		visibles_.addObserver(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Presentation getPresentation() {
		return pSabot_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void compacter() {
		cachees_.compacter();
		visibles_.compacter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void distribuer() {
		for (int i = 0; i < 3; i++) {
			if (cachees.getNombre() > 0) {
				try {
					super.retournerCarte();
					((PSabot) this.pSabot_).repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (cachees.getNombre() == 0) {
			try {
				super.retourner();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		pTasVisible_.decompacterHorizontal();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addObserver(Observer o) {
		observable_.addObserver(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void empilerCarteSurTasColore() {
		observable_.setChanged();
		observable_.notifyObservers();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object obj) {
		ICTasDeCartes cTasDeCartes = (ICTasDeCartes) obj;
		if(cTasDeCartes != null){
			cTasDeCartes.decompacterHorizontal();
		}
				
	}

}
