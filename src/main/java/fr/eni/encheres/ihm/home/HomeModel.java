package fr.eni.encheres.ihm.home;

import fr.eni.encheres.bo.Utilisateurs;

public class HomeModel {
	
	private Utilisateurs user;
	private String pseudo;
	
	public HomeModel() {
		// TODO Auto-generated constructor stub
	}

	public Utilisateurs getUser() {
		return user;
	}

	public void setUser(Utilisateurs user) {
		this.user = user;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
}
