package fr.eni.encheres.dal;


import fr.eni.encheres.dal.articlesVendus.ArticlesVendusDAO;
import fr.eni.encheres.dal.articlesVendus.ArticlesVendusDAOImpl;
import fr.eni.encheres.dal.categories.CategoriesDAO;
import fr.eni.encheres.dal.categories.CategoriesDAOImpl;
import fr.eni.encheres.dal.encheres.EncheresDAO;
import fr.eni.encheres.dal.encheres.EncheresDAOImpl;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAOImpl;

public class DAOFact {
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
	public static CategoriesDAO getCategoriesDAO() {
		return new CategoriesDAOImpl();
	}
	public static ArticlesVendusDAO getArticlesVendusDAO() {
		return new ArticlesVendusDAOImpl();
	}
	public static EncheresDAO getEncheresDAO() {
		return new EncheresDAOImpl();
	}
}	
