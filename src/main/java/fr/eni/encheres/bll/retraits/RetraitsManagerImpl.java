package fr.eni.encheres.bll.retraits;

import fr.eni.encheres.bll.articlesvendus.ArticlesVendusException;
import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFact;
import fr.eni.encheres.dal.retraits.RetraitsDAO;

public class RetraitsManagerImpl implements RetraitsManager {
	private RetraitsDAO dao = DAOFact.getRetraitsDAO();

	@Override
	public void addRetrait(Retraits retrait) throws RetraitsException {
		try {
			dao.insert(retrait);
		} catch (DALException e) {
			throw new RetraitsException("Problème à l'insertion");
		}
	}

	@Override
	public void delRetrait(Retraits retrait) throws RetraitsException {
		try {
			dao.delete(retrait);
		} catch(DALException e) {
			throw new RetraitsException("Problème à la selection");
		}		
	}

	@Override
	public Retraits getByIdArticle(Integer id) throws RetraitsException, ArticlesVendusException, UtilisateursException, CategoriesException {
		try {
			return dao.getByIdArticle(id);
		} catch(DALException e) {
			throw new RetraitsException("Impossible de modifier votre utilisateur");
		}
	}

	@Override
	public void updateRetrait(Retraits retrait) throws RetraitsException {
		try {
			dao.update(retrait);
		} catch(DALException e) {
			throw new RetraitsException("Impossible de modifier votre utilisateur");
		}	
	}
	
	
}