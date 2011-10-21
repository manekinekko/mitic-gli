package solitaire;

import solitaire.solitaire.CSolitaire;
import solitaire.usinedecontroleurs.UsineDeControleurs;

public class TestSolitaire {

	public static void main(String[] args) {
		new CSolitaire("Mon Super Solitaire", new UsineDeControleurs());
	}
	
}
