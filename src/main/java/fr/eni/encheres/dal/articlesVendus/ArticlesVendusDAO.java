package fr.eni.encheres.dal.articlesVendus;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DALException;

public interface ArticlesVendusDAO {
	public void insert(ArticleVendu article) throws DALException;
	public List<ArticleVendu> getAll() throws DALException;
	public ArticleVendu getById(Integer idArticle) throws DALException;
	public void update(ArticleVendu article) throws DALException; 
	public void delete(ArticleVendu article) throws DALException;
}
