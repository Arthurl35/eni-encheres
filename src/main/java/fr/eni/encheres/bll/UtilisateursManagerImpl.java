package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;

public class UtilisateursManagerImpl implements UtilisateursManager {

	@Override
	public void addUtilisateurs(Utilisateurs utilisateur) throws UtilisateursException {
		try {
			for (Utilisateurs u : dao.getAll()) {
				if (utilisateur.getEmail().equals(u.getEmail())) {
					throw new UtilisateursException("Email d�j� existant !");
				}
				if (utilisateur.getTelephone().equals(u.getTelephone())) {
					throw new UtilisateursException("Num�ro de t�l�phone d�j� existant !");
				}
			}

			dao.insert(utilisateur);
		} catch (DALException e) {
			throw new UtilisateursException("Probl�me � l'insertion");
		}

	}

	@Override
	public List<Utilisateurs> getAllUtilisateurs() throws UtilisateursException {
		try {
			return dao.getAll();
		} catch (DALException e) {
			throw new UtilisateursException("Probl�me � la selection");
		}
	}

}