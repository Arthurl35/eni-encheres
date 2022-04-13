package fr.eni.encheres.bll.articlesvendus;

import java.util.List;

import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFact;
import fr.eni.encheres.dal.articlesVendus.ArticlesVendusDAO;

public class ArticlesVendusManagerImpl implements ArticlesVendusManager {
	private ArticlesVendusDAO dao = DAOFact.getArticlesVendusDAO();

	@Override
	public void addArticle(ArticleVendu article) throws ArticlesVendusException {
		try {
			dao.insert(article);
		} catch (DALException e) {
			throw new ArticlesVendusException("Problème à l'insertion");
		}
	}

	@Override
	public List<ArticleVendu> getAllArticles() throws ArticlesVendusException, UtilisateursException, CategoriesException {
		try {
			return dao.getAll();
		} catch (DALException e) {
			throw new ArticlesVendusException("Problème à la selection");
		}
	}

	@Override
	public void delArticle(ArticleVendu article) throws ArticlesVendusException {
		try {
			dao.delete(article);
		} catch(DALException e) {
			throw new ArticlesVendusException("Problème à la selection");
		}		
	}

	@Override
	public ArticleVendu getById(Integer id) throws ArticlesVendusException, UtilisateursException, CategoriesException {
		try {
			return dao.getById(id);
		} catch(DALException e) {
			throw new ArticlesVendusException("Impossible de modifier votre utilisateur");
		}
	}

	@Override
	public void updateArticle(ArticleVendu article) throws ArticlesVendusException {
		try {
			dao.update(article);
		} catch(DALException e) {
			throw new ArticlesVendusException("Impossible de modifier votre utilisateur");
		}		
	}
	
	
}