package fr.eni.encheres.dal.utilisateur;

import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DALException;


public interface UtilisateurDAO {
	public void insert(Utilisateurs utilisateur) throws DALException;
	public List<Utilisateurs> getAll() throws DALException;
	public List<Utilisateurs> getAll_sansAdmin() throws DALException;
	public void update(Utilisateurs utiisateur) throws DALException; 
	public void delete(Utilisateurs utilisateur) throws DALException;
	public Utilisateurs getConnection(String pseudo, String password) throws DALException;
	public Utilisateurs getByPseudo(String pseudo) throws DALException;
	Utilisateurs getById(Integer id) throws DALException;
	public void updateEtat(Utilisateurs utilisateur) throws DALException;
}
