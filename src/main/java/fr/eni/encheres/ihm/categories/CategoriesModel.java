package fr.eni.encheres.ihm.categories;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categories;

public class CategoriesModel {
	
	
	private List<Categories> lstCategories = new ArrayList<>();
	private Integer id;
	private String libelle;

	public CategoriesModel() {
		super();
	}

	public List<Categories> getLstCategories() {
		return lstCategories;
	}

	public void setLstCategories(List<Categories> lstCategories) {
		this.lstCategories = lstCategories;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
}
