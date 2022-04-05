package fr.eni.encheres.dal.categories;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.dal.DALException;


public class CategoriesDAOMock implements CategoriesDAO {
	private static int cpt=0;
	private List<Categories> lstCategories = new ArrayList<>();
	

	@Override
	public List<Categories> getAll() {
		return lstCategories;
	}

	@Override
	public Categories getById(Integer id) throws DALException {
		return lstCategories.stream()
		.filter(u->u.getId()==id)
		.toList().get(0);
	}

}
