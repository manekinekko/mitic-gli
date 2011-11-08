package Observer;

import java.util.Observable;

import solitaire.doubletas.ICDoubleTas;

public class MyObservable extends Observable{

	private ICDoubleTas doubleTas_;

	public MyObservable(ICDoubleTas doubleTas) {
		doubleTas_ = doubleTas;
	}
	
	public void setChanged(){
		super.setChanged();
	}

	public ICDoubleTas getDoubleTas() {
		return doubleTas_;
	}
	
}
