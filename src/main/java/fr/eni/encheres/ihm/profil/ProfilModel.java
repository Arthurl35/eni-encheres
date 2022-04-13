package fr.eni.encheres.ihm.profil;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;

public class ProfilModel {
	
	private String pseudo;
	private List<Utilisateurs> lstUtilisateurs = new ArrayList<>();
	private Utilisateurs user;
	private String message;
	
	public ProfilModel() {
		// TODO Auto-generated constructor stub
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<Utilisateurs> getLstUtilisateurs() {
		return lstUtilisateurs;
	}

	public void setLstUtilisateurs(List<Utilisateurs> lstUtilisateurs) {
		this.lstUtilisateurs = lstUtilisateurs;
	}

	public Utilisateurs getUser() {
		return user;
	}

	public void setUser(Utilisateurs user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	



}
