package fr.eni.encheres.dal;


import fr.eni.encheres.dal.categories.CategoriesDAO;
import fr.eni.encheres.dal.categories.CategoriesDAOImpl;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAOImpl;

public class DAOFact {
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
	public static CategoriesDAO getCategoriesDAO() {
		return new CategoriesDAOImpl();
	}
}	
