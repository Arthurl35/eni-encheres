package fr.eni.encheres.bll.categories;

import java.util.List;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFact;
import fr.eni.encheres.dal.categories.CategoriesDAO;

public class CategoriesManagerImpl implements CategoriesManager {
	private CategoriesDAO dao = DAOFact.getCategoriesDAO();

	@Override
	public List<Categories> getAllCategories() throws CategoriesException {
		try {
			return dao.getAll();
		} catch (DALException e) {
			throw new CategoriesException("Problème à l'insertion");
		}
	}

	@Override
	public Categories getCategoriById(Integer id) throws CategoriesException {
		try {
			return dao.getById(id);
		} catch (DALException e) {
			throw new CategoriesException("Problème à l'insertion");
		}
	}

}