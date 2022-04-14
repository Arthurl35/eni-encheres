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
					throw new UtilisateursException("Email déjà existant !");
				}
				if (utilisateur.getTelephone().equals(u.getTelephone())) {
					throw new UtilisateursException("Numéro de téléphone déjà existant !");
				}
				if (utilisateur.getPseudo().equals(u.getPseudo())) {
					throw new UtilisateursException("Pseudo déjà existant");
				}
			}

			dao.insert(utilisateur);
		} catch (DALException e) {
			throw new UtilisateursException("Problème à l'insertion");
		}

	}

	@Override
	public List<Utilisateurs> getAllUtilisateurs() throws UtilisateursException {
		try {
			return dao.getAll();
		} catch (DALException e) {
			throw new UtilisateursException("Problème à la selection");
		}
	}
	
	@Override
	public List<Utilisateurs> getAllUtilisateurs_sansAdmin() throws UtilisateursException {
		try {
			return dao.getAll_sansAdmin();
		} catch (DALException e) {
			throw new UtilisateursException("Problème à la selection");
		}
	}

	@Override
	public Utilisateurs connect(String pseudo, String password) throws UtilisateursException {
		Utilisateurs user = null;
		try {
			user = dao.getConnection(pseudo, password);
		} catch(DALException e) {
			throw new UtilisateursException("Login et/ou mot de passe incorect !");
		}
		return user;
	}

	@Override
	public void delUtilisateur(Utilisateurs utilisateur) throws UtilisateursException {
		try {
			dao.delete(utilisateur);
		} catch(DALException e) {
			throw new UtilisateursException("Problème à la selection");
		}
	}
	
	@Override
	public void updateUtilisateur(Utilisateurs utilisateur) throws UtilisateursException {
		try {
			dao.update(utilisateur);
		} catch(DALException e) {
			throw new UtilisateursException("Impossible de modifier votre utilisateur");
		}
	}
	
	@Override
	public Utilisateurs getById(Integer id) throws UtilisateursException {
		try {
			return dao.getById(id);
		} catch(DALException e) {
			throw new UtilisateursException("Impossible de modifier votre utilisateur");
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
			throw new UtilisateursException("Problème à la selection");
		}
	}

	@Override
	public void updateEtat(Utilisateurs utilisateur) throws UtilisateursException {
		try {
			dao.updateEtat(utilisateur);
		} catch(DALException e) {
			throw new UtilisateursException("Impossible de modifier votre utilisateur");
		}		
	}
}