package solitaire.observer;

import java.util.Observable;

/**
 * La classe MyObservable permet d'utiliser la classe Observable par délégation
 * (voir pattern Observer). Les contrôleurs on parfois besoin d'être des
 * observables, mais ne peuvent pas hériter de Observable puisqu'ils héritent
 * déjà de l'abstraction (pas de multiple héritage en java). Cette classe est là
 * pour palier à ce problème.
 * 
 * 
 */
public class MyObservable extends Observable {

	private Object observable_;

	/**
	 * Constructeur de MyObservable.
	 * @param observable
	 */
	public MyObservable(Object observable) {
		observable_ = observable;
	}

	/**
	 * Surcharge de la méthode setChanged pour augmenter sa visibilité, car
	 * celle ci est protected.
	 */
	public void setChanged() {
		super.setChanged();
	}

	/**
	 * 
	 * @return
	 */
	public Object getObservable() {
		return observable_;
	}

}
