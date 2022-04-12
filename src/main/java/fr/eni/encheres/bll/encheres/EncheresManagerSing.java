package fr.eni.encheres.bll.encheres;


public class EncheresManagerSing {
	private static EncheresManager instance;
	public static EncheresManager getInstance() {
		if(instance==null) {
			instance = new EncheresManagerImpl();
		}
		return instance;
	}
}