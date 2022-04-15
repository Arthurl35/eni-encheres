package fr.eni.encheres.ihm.home;


import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.ihm.articles.ArticlesModel;

public class HomeModel {
	
	private Utilisateurs user;
	private String pseudo;
	private List<ArticleVendu> lstArticles = new ArrayList<ArticleVendu>();
	
	public List<ArticleVendu> getLstArticles() {
		return lstArticles;
	}

	public void setLstArticles(List<ArticleVendu> lstArticles) {
		this.lstArticles = lstArticles;
	}

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
