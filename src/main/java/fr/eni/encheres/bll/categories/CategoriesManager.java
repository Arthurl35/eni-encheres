package fr.eni.encheres.bll.categories;

import java.util.List;

import fr.eni.encheres.bo.Categories;

public interface CategoriesManager {
	
	public List<Categories> getAllCategories() throws CategoriesException;
	public Categories getCategoriById(Integer id) throws CategoriesException;
}
