package Observer;

import java.util.Observable;

public class MyObservable extends Observable{

	private Object doubleTas_;

	public MyObservable(Object doubleTas) {
		doubleTas_ = doubleTas;
	}
	
	public void setChanged(){
		super.setChanged();
	}

	public Object getDoubleTas() {
		return doubleTas_;
	}
	
}
