package solitaire.doubletas;

import solitaire.application.DoubleTas;
import solitaire.application.Tas;
import solitaire.pac.Presentation;

public class CDoubleTas extends DoubleTas implements ICDoubleTas{

	private Presentation pDoubleTas_;

	public CDoubleTas(Tas cache, Tas visible) {
		super(cache, visible);
		pDoubleTas_ = new PDoubleTas(this);
	}

	@Override
	public Presentation getPresentation() {
		return pDoubleTas_;
	}

}
