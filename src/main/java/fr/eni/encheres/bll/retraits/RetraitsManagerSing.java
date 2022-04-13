package fr.eni.encheres.bll.retraits;


public class RetraitsManagerSing {
	private static RetraitsManager instance;
	public static RetraitsManager getInstance() {
		if(instance==null) {
			instance = new RetraitsManagerImpl();
		}
		return instance;
	}
}