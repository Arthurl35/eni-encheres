package fr.eni.encheres.ihm.encheres;


import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.Utilisateurs;

public class EncheresModel {
	
	private Utilisateurs user;
	private ArticleVendu article;
	private List<Encheres> lstEncheres;
	private String message;
	
	public Utilisateurs getUser() {
		return user;
	}
	public void setUser(Utilisateurs user) {
		this.user = user;
	}
	public ArticleVendu getArticle() {
		return article;
	}
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}
	public List<Encheres> getLstEncheres() {
		return lstEncheres;
	}
	public void setLstEncheres(List<Encheres> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
