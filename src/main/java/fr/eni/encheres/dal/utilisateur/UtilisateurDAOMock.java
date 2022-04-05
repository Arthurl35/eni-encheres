package fr.eni.encheres.dal.utilisateur;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DALException;


public class UtilisateurDAOMock implements UtilisateurDAO {
	private static int cpt=0;
	private List<Utilisateurs> lstUtilisateus = new ArrayList<>();
	
	@Override
	public void insert(Utilisateurs utilisateur) {
		utilisateur.setId(cpt++);
		lstUtilisateus.add(utilisateur);
	}

	@Override
	public List<Utilisateurs> getAll() {
		return lstUtilisateus;
	}

	@Override
	public void update(Utilisateurs utilisateur) throws DALException {
		lstUtilisateus.stream()
			.filter(u->u.getId()==utilisateur.getId())
			.forEach(u->{
				u.setNom(utilisateur.getNom());
				u.setPrenom(utilisateur.getPrenom());
			});
	}

	@Override
	public void delete(Utilisateurs utilisateur) throws DALException {
		lstUtilisateus.removeIf(v->v.getId()==utilisateur.getId());
	}

	@Override
	public Utilisateurs getByPseudo(String pseudo) throws DALException {
		return lstUtilisateus.stream()
		.filter(u->u.getPseudo().equals(pseudo))
		.toList().get(0);
	}

}
