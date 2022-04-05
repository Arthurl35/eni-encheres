package fr.eni.encheres.bll.utilisateurs;


public class UtilisateursManagerSing {
	private static UtilisateursManager instance;
	public static UtilisateursManager getInstance() {
		if(instance==null) {
			instance = new UtilisateursManagerImpl();
		}
		return instance;
	}
}