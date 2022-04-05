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
				if (utilisateur.getPseudo().equals(u.getPseudo())) {
					throw new UtilisateursException("Pseudo d�j� existant");
				}
				if (!utilisateur.getMot_de_passe().equals(u.getMot_de_passe())) {
					throw new UtilisateursException("Votre mot de passe n'est pas identique");
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

	@Override
	public boolean connect(Utilisateurs utilisateur) throws UtilisateursException {
		boolean res = false;
		try {
			for (Utilisateurs u : dao.getAll()) {
				if (utilisateur.getPseudo().equals(u.getPseudo())
						&& utilisateur.getMot_de_passe().equals(u.getMot_de_passe())) {
					res = true;
				} else {
					throw new UtilisateursException("Votre login et/ou mot de passe n'est pas bon.");
				}
			}
			return res;
		} catch (DALException e) {
			throw new UtilisateursException("Probl�me � la selection");
		}
	}

	@Override
	public void delUtilisateur(Utilisateurs utilisateur) throws UtilisateursException {
		try {
			dao.delete(utilisateur);
		} catch(DALException e) {
			throw new UtilisateursException("Probl�me � la selection");
		}
	}
}