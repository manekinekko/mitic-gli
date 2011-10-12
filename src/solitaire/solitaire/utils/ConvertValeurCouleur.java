package solitaire.utils;


public class ConvertValeurCouleur {
	
	private static final String[] valCartes = {
		"1","2","3","4","5","6","7","8","9","10","J","Q","K",
		};
	
	private static final String[] coulCartes = {
		"H","D","S","C"
	};

	public static String getValCarte(int v){
		return valCartes[v-1];
	}
	
	public static String getCoulCarte(int c){
		return coulCartes[c-1];
	}

	public static String getCarte(int v, int c){
		return getValCarte(v)+getCoulCarte(c);
	}
}
