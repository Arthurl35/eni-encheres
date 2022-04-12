package fr.eni.encheres.ihm.articles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Utilisateurs;

public class ArticlesModel {
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private Integer etatVente;
	private Categories categorie;
	private Utilisateurs utilisateur;
	private String message;
	private List<ArticleVendu> lstArticle = new ArrayList<>();

	public ArticlesModel() {
		super();
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public Integer getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public Integer getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(Integer etatVente) {
		this.etatVente = etatVente;
	}

	public Categories getCategorie() {
		return categorie;
	}

	public void setCategorie(Categories noCategorie) {
		this.categorie = noCategorie;
	}

	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateurs noUtilisateur) {
		this.utilisateur = noUtilisateur;
	}

	public List<ArticleVendu> getLstArticle() {
		return lstArticle;
	}

	public void setLstArticle(List<ArticleVendu> lstArticle) {
		this.lstArticle = lstArticle;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
