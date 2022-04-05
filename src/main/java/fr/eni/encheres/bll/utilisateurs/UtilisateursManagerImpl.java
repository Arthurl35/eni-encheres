package fr.eni.encheres.bll.utilisateurs;

import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFact;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;

public class UtilisateursManagerImpl implements UtilisateursManager {
	private UtilisateurDAO dao = DAOFact.getUtilisateurDAO();
	
	@Override
	public void addUtilisateur(Utilisateurs utilisateur) throws UtilisateursException {
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
	public Utilisateurs connect(String pseudo, String password) throws UtilisateursException {
		Utilisateurs user = null;
		try {
			user = dao.getConnection(pseudo, password);
		} catch(DALException e) {
			throw new UtilisateursException("Login et/ou password incorect !");
		}
		return user;
	}

	@Override
	public void delUtilisateur(Utilisateurs utilisateur) throws UtilisateursException {
		try {
			dao.delete(utilisateur);
		} catch(DALException e) {
			throw new UtilisateursException("Probl�me � la selection");
		}
	}


	@Override
	public Utilisateurs getByPseudo(String pseudo) throws UtilisateursException {
		try {
			Utilisateurs res = null;
			for (Utilisateurs u : dao.getAll()) {
				if(u.getPseudo().equals(pseudo)) {
					res = u;
				}
				else {
					throw new UtilisateursException("Utilisateur non existant");
				}
			}
			return res;
		} catch(DALException e) {
			throw new UtilisateursException("Probl�me � la selection");
		}
	}
}