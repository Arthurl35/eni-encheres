package fr.eni.encheres.bo;

import java.time.LocalDate;

public class Encheres {
	private LocalDate date_enchere;
	private Integer montant_enchere;
	private Utilisateurs utilisateur;
	private ArticleVendu article;

	public Encheres() {
	}

	public Encheres(LocalDate date_enchere, Integer montant_enchere, Utilisateurs utilisateur, ArticleVendu article) {
		super();
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
		this.utilisateur = utilisateur;
		this.article = article;
	}

	public LocalDate getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(LocalDate date_enchere) {
		this.date_enchere = date_enchere;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

}
