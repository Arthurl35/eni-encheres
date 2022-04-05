package fr.eni.encheres.bll.utilisateurs;

import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;

public interface UtilisateursManager {
	
	public void addUtilisateur(Utilisateurs utilisateur) throws UtilisateursException;
	public List<Utilisateurs> getAllUtilisateurs() throws UtilisateursException;
	public boolean connect(Utilisateurs utilisateur) throws UtilisateursException;
	public void delUtilisateur(Utilisateurs utilisateur) throws UtilisateursException;
	public Utilisateurs getByPseudo(String pseudo) throws UtilisateursException;
}
