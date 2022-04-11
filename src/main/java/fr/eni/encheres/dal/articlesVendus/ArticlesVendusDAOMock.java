package fr.eni.encheres.dal.articlesVendus;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DALException;

public class ArticlesVendusDAOMock implements ArticlesVendusDAO{
	private static int cpt=0;
	private List<ArticleVendu> lstArticles = new ArrayList<>();
	
	@Override
	public void insert(ArticleVendu article) {
		article.setNoArticle(cpt++);
		lstArticles.add(article);
	}

	@Override
	public List<ArticleVendu> getAll() {
		return lstArticles;
	}

	@Override
	public void update(ArticleVendu article) throws DALException {
		lstArticles.stream()
			.filter(a->a.getNoArticle()==article.getNoArticle())
			.forEach(a->{
				a.setNomArticle(article.getNomArticle());
				a.setDescription(article.getDescription());
				a.setDateDebutEncheres(article.getDateDebutEncheres());
				a.setDateFinEncheres(article.getDateFinEncheres());
				a.setMiseAPrix(article.getMiseAPrix());
				a.setPrixVente(article.getPrixVente());
				a.setUtilisateur(article.getUtilisateur());
				a.setCategorie(article.getCategorie());
			});
	}

	@Override
	public void delete(ArticleVendu article) throws DALException {
		lstArticles.removeIf(v->v.getNoArticle()== article.getNoArticle());
	}

	@Override
	public ArticleVendu getById(Integer idArticle) throws DALException {
		return lstArticles.stream()
		.filter(u->u.getNoArticle() == idArticle)
		.toList().get(0);
	}

}
