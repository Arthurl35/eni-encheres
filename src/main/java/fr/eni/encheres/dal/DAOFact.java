package fr.eni.encheres.dal;


import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAOImpl;

public class DAOFact {
	public static UtilisateurDAO getUtilisateurtDAO() {
		return new UtilisateurDAOImpl();
	}
}	
