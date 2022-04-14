package fr.eni.encheres.bll.utilisateurs;

import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DALException;

public interface UtilisateursManager {
	
	public void addUtilisateur(Utilisateurs utilisateur) throws UtilisateursException;
	public List<Utilisateurs> getAllUtilisateurs() throws UtilisateursException;
	public List<Utilisateurs> getAllUtilisateurs_sansAdmin() throws UtilisateursException;
	public Utilisateurs connect(String pseudo, String password) throws UtilisateursException;
	public void delUtilisateur(Utilisateurs utilisateur) throws UtilisateursException;
	public Utilisateurs getByPseudo(String pseudo) throws UtilisateursException;
	public void updateUtilisateur(Utilisateurs u) throws UtilisateursException;
	Utilisateurs getById(Integer id) throws UtilisateursException;
	public void updateEtat(Utilisateurs utilisateur) throws UtilisateursException;
}
