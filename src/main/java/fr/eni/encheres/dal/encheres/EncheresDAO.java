package fr.eni.encheres.dal.encheres;

import java.util.List;

import fr.eni.encheres.bll.articlesvendus.ArticlesVendusException;
import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.dal.DALException;

public interface EncheresDAO {
	public void insert(Encheres enchere) throws DALException;
	public List<Encheres> getAll() throws DALException, ArticlesVendusException, UtilisateursException, CategoriesException;
	public List<Encheres> getById(Integer idArticle) throws DALException, ArticlesVendusException, UtilisateursException, CategoriesException;
	public void update(Encheres enchere) throws DALException; 
	public void delete(Encheres enchere) throws DALException;
}
