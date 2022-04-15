package fr.eni.encheres.bll.articlesvendus;

import java.util.List;

import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Utilisateurs;
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
	public List<ArticleVendu> getAllArticlesByCategorie(Categories categorie) throws ArticlesVendusException, UtilisateursException, CategoriesException {
		try {
			return dao.getAllByCategorie(categorie);
		} catch (DALException e) {
			throw new ArticlesVendusException("Problème à la selection");
		}
	}
	
	@Override
	public List<ArticleVendu> getAllArticlesByEtat(Integer etat) throws ArticlesVendusException, UtilisateursException, CategoriesException {
		try {
			return dao.getAllByEtat(etat);
		} catch (DALException e) {
			throw new ArticlesVendusException("Problème à la selection");
		}
	}
	
	@Override
	public List<ArticleVendu> getAllArticlesByUser(Utilisateurs user) throws ArticlesVendusException, UtilisateursException, CategoriesException {
		try {
			return dao.getAllByUser(user);
		} catch (DALException e) {
			throw new ArticlesVendusException("Problème à la selection");
		}
	}
	
	@Override
	public List<ArticleVendu> getAllArticlesWinByUser(Utilisateurs user) throws ArticlesVendusException, UtilisateursException, CategoriesException {
		try {
			return dao.getAllWinByUser(user);
		} catch (DALException e) {
			throw new ArticlesVendusException("Problème à la selection");
		}
	}
	
	@Override
	public List<ArticleVendu> getAllArticlesByEtatAndUser(Integer etat, Utilisateurs user) throws ArticlesVendusException, UtilisateursException, CategoriesException {
		try {
			return dao.getAllByEtatAndUser(etat, user);
		} catch (DALException e) {
			throw new ArticlesVendusException("Problème à la selection");
		}
	}
	
	@Override
	public List<ArticleVendu> getAllArticlesByEnchereUser(Utilisateurs user) throws ArticlesVendusException, UtilisateursException, CategoriesException {
		try {
			return dao.getAllByEnchereUser(user);
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
	
	@Override
	public void updateArticleWin(ArticleVendu article) throws ArticlesVendusException {
		try {
			dao.updateWin(article);
		} catch(DALException e) {
			throw new ArticlesVendusException("Impossible de modifier votre utilisateur");
		}		
	}
	
	
}