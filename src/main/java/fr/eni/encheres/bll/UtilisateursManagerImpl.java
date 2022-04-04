package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;

public class UtilisateursManagerImpl implements UtilisateursManager {
	
	@Override
	public List<Utilisateurs> getAllUtilisateurs() throws UtilisateursException {
		try {
			return dao.getAll();
		} catch (DALException e) {
			throw new UtilisateursException("Problème à la selection");
		}
	}
}
