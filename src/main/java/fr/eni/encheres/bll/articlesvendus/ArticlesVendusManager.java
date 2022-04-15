package fr.eni.encheres.bll.articlesvendus;

import java.util.List;

import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Utilisateurs;

public interface ArticlesVendusManager {
	
	public void addArticle(ArticleVendu article) throws ArticlesVendusException;
	public List<ArticleVendu> getAllArticles() throws ArticlesVendusException, UtilisateursException, CategoriesException;
	public void delArticle(ArticleVendu article) throws ArticlesVendusException;
	public ArticleVendu getById(Integer id) throws ArticlesVendusException, UtilisateursException, CategoriesException;
	public void updateArticle(ArticleVendu article) throws ArticlesVendusException;
	List<ArticleVendu> getAllArticlesByEtat(Integer etat)
			throws ArticlesVendusException, UtilisateursException, CategoriesException;
	List<ArticleVendu> getAllArticlesByUser(Utilisateurs user)
			throws ArticlesVendusException, UtilisateursException, CategoriesException;
	List<ArticleVendu> getAllArticlesByEtatAndUser(Integer etat, Utilisateurs user)
			throws ArticlesVendusException, UtilisateursException, CategoriesException;
	List<ArticleVendu> getAllArticlesWinByUser(Utilisateurs user)
			throws ArticlesVendusException, UtilisateursException, CategoriesException;
	List<ArticleVendu> getAllArticlesByEnchereUser(Utilisateurs user)
			throws ArticlesVendusException, UtilisateursException, CategoriesException;
	void updateArticleWin(ArticleVendu article) throws ArticlesVendusException;
	List<ArticleVendu> getAllArticlesByCategorie(Categories categorie)
			throws ArticlesVendusException, UtilisateursException, CategoriesException;
}
