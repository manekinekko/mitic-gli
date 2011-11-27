package solitaire.doubletas;

import java.util.Observer;
import solitaire.application.DoubleTas;
import solitaire.application.Tas;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;

/**
 * Contrôleur du double tas.
 * 
 * @author Wassim Chegham <contact@cheghamwassim.com>
 * @author Gurval Le Bouter <gurval.lebouter@gmail.com>
 * @see ICDoubleTas
 */
public class CDoubleTas extends DoubleTas implements ICDoubleTas {

	private PDoubleTas pDoubleTas_;

	/**
	 * Constructeur du double tas.
	 * @param cache
	 * @param visible
	 */
	public CDoubleTas(Tas cache, Tas visible) {
		super(cache, visible);
		pDoubleTas_ = new PDoubleTas(this, (ICTasDeCartes)cache, (ICTasDeCartes)visible);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Presentation getPresentation() {
		return pDoubleTas_;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addObserver(Observer o) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void empilerCarteSurTasColore() {
	}

}
