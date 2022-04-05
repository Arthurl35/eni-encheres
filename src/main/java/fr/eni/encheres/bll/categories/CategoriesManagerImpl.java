package fr.eni.encheres.bll.categories;

import java.util.List;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.dal.DAOFact;

public class CategoriesManagerImpl implements CategoriesManager {
	private CategoriesDAO dao = DAOFact.getCategoriesDAO();

	@Override
	public List<Categories> getAllCategories() {
		return dao.getAll();
	}

	@Override
	public Categories getCategoriById() {
		return dao.getById();
	}

}