package fr.eni.encheres.bll.categories;

public class CategoriesManagerSing {
	private static CategoriesManager instance;

	public static CategoriesManager getInstance() {
		if (instance == null) {
			instance = new CategoriesManagerImpl();
		}
		return instance;
	}
}
