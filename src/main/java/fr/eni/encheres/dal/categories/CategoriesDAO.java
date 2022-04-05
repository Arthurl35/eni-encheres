package fr.eni.encheres.dal.categories;

import java.util.List;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.dal.DALException;


public interface CategoriesDAO {
	public List<Categories> getAll() throws DALException;
	public Categories getById(Integer id) throws DALException;
}
