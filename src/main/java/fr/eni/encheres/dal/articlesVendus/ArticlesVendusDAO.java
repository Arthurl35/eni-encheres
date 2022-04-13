package fr.eni.encheres.dal.articlesVendus;

import java.util.List;

import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DALException;

public interface ArticlesVendusDAO {
	public void insert(ArticleVendu article) throws DALException;
	public List<ArticleVendu> getAll() throws DALException, UtilisateursException, CategoriesException;
	public ArticleVendu getById(Integer idArticle) throws DALException, UtilisateursException, CategoriesException;
	public void update(ArticleVendu article) throws DALException; 
	public void delete(ArticleVendu article) throws DALException;
}
