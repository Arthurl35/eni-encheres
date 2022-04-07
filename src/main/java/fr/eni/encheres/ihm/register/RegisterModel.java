package fr.eni.encheres.ihm.register;

import fr.eni.encheres.bo.Utilisateurs;

public class RegisterModel {
	
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String code_postal;
	private String ville;
	private String mot_de_passe;
	private String mot_de_passe_confirm;
	private String mess;
	
	private Utilisateurs user;
	
	public RegisterModel() {
		// TODO Auto-generated constructor stub
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public String getMot_de_passe_confirm() {
		return mot_de_passe_confirm;
	}

	public void setMot_de_passe_confirm(String mot_de_passe_confirm) {
		this.mot_de_passe_confirm = mot_de_passe_confirm;
	}
	
	public String getMessage() {
		return mess;
	}

	public void setMessage(String message) {
		this.mess = message;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public Utilisateurs getUser() {
		return user;
	}

	public void setUser(Utilisateurs user) {
		this.user = user;
	}
	
	
}
