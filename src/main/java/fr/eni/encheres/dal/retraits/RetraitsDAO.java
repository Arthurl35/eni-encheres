package fr.eni.encheres.dal.retraits;

import java.util.List;

import fr.eni.encheres.bll.articlesvendus.ArticlesVendusException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.dal.DALException;

public interface RetraitsDAO {
	public void insert(Retraits retrait) throws DALException;
	public Retraits getByIdArticle(Integer idArticle) throws DALException, ArticlesVendusException;
	public void update(Retraits article) throws DALException; 
	public void delete(Retraits article) throws DALException;
}
