package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;

public interface UtilisateursManager {
	public List<Utilisateurs> getAllUtilisateurs() throws UtilisateursException;
}
