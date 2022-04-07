package fr.eni.encheres.bll.articlesvendus;


public class ArticlesVendusManagerSing {
	private static ArticlesVendusManager instance;
	public static ArticlesVendusManager getInstance() {
		if(instance==null) {
			instance = new ArticlesVendusManagerImpl();
		}
		return instance;
	}
}