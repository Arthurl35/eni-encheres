package fr.eni.encheres.ihm.login;

import fr.eni.encheres.bo.Utilisateurs;

public class LoginModel {
	
	private String pseudo;
	private String message;
	private Utilisateurs user;
	
	public LoginModel() {
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public Utilisateurs getUser() {
		return user;
	}

	public void setUser(Utilisateurs user) {
		this.user = user;
	}
	
}
