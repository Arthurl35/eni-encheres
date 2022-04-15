package fr.eni.encheres.bo;

import java.time.LocalDate;

public class ArticleVendu {

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
	private Utilisateurs utilisateurWin;

	public ArticleVendu() {
	}

	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, Integer etatVente) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}

	
	
	public ArticleVendu(String nomArticle, String description, Categories categorie, Integer miseAPrix, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.categorie = categorie;
		this.miseAPrix = miseAPrix;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;	
	}

	public Categories getCategorie() {
		return categorie;
	}

	public void setCategorie(Categories noCategorie) {
		this.categorie = noCategorie;
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

	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateurs noUtilisateur) {
		this.utilisateur = noUtilisateur;
	}
	

	public Utilisateurs getUtilisateurWin() {
		return utilisateurWin;
	}

	public void setUtilisateurWin(Utilisateurs utilisateurWin) {
		this.utilisateurWin = utilisateurWin;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", noCategorie=" + categorie
				+ ", noUtilisateur=" + utilisateur + "]";
	}


}
