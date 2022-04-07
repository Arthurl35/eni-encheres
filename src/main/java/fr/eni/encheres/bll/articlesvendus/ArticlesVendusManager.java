package fr.eni.encheres.bll.articlesvendus;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;

public interface ArticlesVendusManager {
	
	public void addArticle(ArticleVendu article) throws ArticlesVendusException;
	public List<ArticleVendu> getAllArticles() throws ArticlesVendusException;
	public void delArticle(ArticleVendu article) throws ArticlesVendusException;
	public ArticleVendu getById(Integer id) throws ArticlesVendusException;
	public void updateArticle(ArticleVendu article) throws ArticlesVendusException;
}
