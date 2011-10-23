package solitaire.doubletas;

import solitaire.application.DoubleTas;
import solitaire.application.Tas;
import solitaire.pac.Presentation;
import solitaire.tasdecartes.ICTasDeCartes;

public class CDoubleTas extends DoubleTas implements ICDoubleTas{

	private IPDoubleTas pDoubleTas_;

	public CDoubleTas(Tas cache, Tas visible) {
		super(cache, visible);
		pDoubleTas_ = new PDoubleTas((ICTasDeCartes)cache, (ICTasDeCartes)visible);
	}

	@Override
	public Presentation getPresentation() {
		return pDoubleTas_;
	}

}
