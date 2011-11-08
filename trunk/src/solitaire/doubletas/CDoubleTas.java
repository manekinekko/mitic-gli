package solitaire.doubletas;

import java.util.Observer;
import solitaire.application.DoubleTas;
import solitaire.application.Tas;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;

public class CDoubleTas extends DoubleTas implements ICDoubleTas {

	private PDoubleTas pDoubleTas_;

	public CDoubleTas(Tas cache, Tas visible) {
		super(cache, visible);
		pDoubleTas_ = new PDoubleTas(this, (ICTasDeCartes)cache, (ICTasDeCartes)visible);
	}

	@Override
	public Presentation getPresentation() {
		return pDoubleTas_;
	}

	@Override
	public void addObserver(Observer o) {
	}

	@Override
	public void empilerCarteSurTasColore() {
	}

}
