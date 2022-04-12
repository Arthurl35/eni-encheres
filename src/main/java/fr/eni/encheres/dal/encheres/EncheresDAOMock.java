package fr.eni.encheres.dal.encheres;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.dal.DALException;

public abstract class EncheresDAOMock implements EncheresDAO{
	private static int cpt=0;
	private List<Encheres> lstArticles = new ArrayList<>();
	
	@Override
	public void insert(Encheres enchere) {
		//enchere.setNoArticle(cpt++);
		lstArticles.add(enchere);
	}

	@Override
	public List<Encheres> getAll() {
		return lstArticles;
	}
/*
	@Override
	public void update(Encheres enchere) throws DALException {
		lstArticles.stream()
			.filter(a->a.getNoArticle()==enchere.getNoArticle())
			.forEach(a->{
				a.setNomArticle(enchere.getNomArticle());
				a.setDescription(enchere.getDescription());
				a.setDateDebutEncheres(enchere.getDateDebutEncheres());
				a.setDateFinEncheres(enchere.getDateFinEncheres());
				a.setMiseAPrix(enchere.getMiseAPrix());
				a.setPrixVente(enchere.getPrixVente());
				a.setNoUtilisateur(enchere.getNoUtilisateur());
				a.setNoCategorie(enchere.getNoCategorie());
			});
	}

	@Override
	public void delete(Encheres article) throws DALException {
		lstArticles.removeIf(v->v.getNoArticle()== article.getNoArticle());
	}

	@Override
	public Encheres getById(Integer idArticle) throws DALException {
		return lstArticles.stream()
		.filter(u->u.getNoArticle() == idArticle)
		.toList().get(0);
	}
*/
}
