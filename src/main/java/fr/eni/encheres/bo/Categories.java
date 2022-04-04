package fr.eni.encheres.bo;

public class Categories {
	private Integer no_categorie;
	private String libelle;

	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categories(Integer no_categorie, String libelle) {
		super();
		this.no_categorie = no_categorie;
		this.libelle = libelle;
	}

	public Integer getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(Integer no_categorie) {
		this.no_categorie = no_categorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}