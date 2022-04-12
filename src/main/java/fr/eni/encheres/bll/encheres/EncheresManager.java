package fr.eni.encheres.bll.encheres;

import java.util.List;

import fr.eni.encheres.bll.articlesvendus.ArticlesVendusException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.Encheres;

public interface EncheresManager {
	
	public void addEnchere(Encheres enchere) throws EncheresException;
	public List<Encheres> getAllEncheres() throws EncheresException, ArticlesVendusException, UtilisateursException;
	public void delEnchere(Encheres enchere) throws EncheresException;
	public List<Encheres> getById(Integer id) throws EncheresException, ArticlesVendusException, UtilisateursException;
	public void updateEnchere(Encheres enchere) throws EncheresException;
}
