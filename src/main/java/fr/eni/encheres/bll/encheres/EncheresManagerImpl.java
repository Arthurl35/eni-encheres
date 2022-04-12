package fr.eni.encheres.bll.encheres;

import java.util.List;

import fr.eni.encheres.bll.articlesvendus.ArticlesVendusException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFact;
import fr.eni.encheres.dal.encheres.EncheresDAO;

public class EncheresManagerImpl implements EncheresManager {
	private EncheresDAO dao = DAOFact.getEncheresDAO();

	@Override
	public void addEnchere(Encheres enchere) throws EncheresException {
		try {
			dao.insert(enchere);
		} catch (DALException e) {
			throw new EncheresException("Problème à l'insertion");
		}
	}

	@Override
	public List<Encheres> getAllEncheres() throws EncheresException, ArticlesVendusException, UtilisateursException {
		try {
			return dao.getAll();
		} catch (DALException e) {
			throw new EncheresException("Problème à la selection");
		}
	}

	@Override
	public void delEnchere(Encheres enchere) throws EncheresException {
		try {
			dao.delete(enchere);
		} catch(DALException e) {
			throw new EncheresException("Problème à la selection");
		}		
	}

	@Override
	public List<Encheres> getById(Integer id) throws EncheresException, ArticlesVendusException, UtilisateursException {
		try {
			return dao.getById(id);
		} catch(DALException e) {
			throw new EncheresException("Impossible de trouver les enchères associé");
		}
	}

	@Override
	public void updateEnchere(Encheres enchere) throws EncheresException {
		try {
			dao.update(enchere);
		} catch(DALException e) {
			throw new EncheresException("Impossible de modifier votre utilisateur");
		}		
	}
	
	
}