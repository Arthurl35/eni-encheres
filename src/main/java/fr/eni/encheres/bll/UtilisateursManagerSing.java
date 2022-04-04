package fr.eni.encheres.bll;


public class UtilisateursManagerSing {
	private static UtilisateursManager instance;
	public static UtilisateursManager getInstance() {
		if(instance==null) {
			instance = new VotantManagerImpl();
		}
		return instance;
	}
}
