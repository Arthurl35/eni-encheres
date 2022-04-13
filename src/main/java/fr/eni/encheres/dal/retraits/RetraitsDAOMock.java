package fr.eni.encheres.dal.retraits;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bll.articlesvendus.ArticlesVendusException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.dal.DALException;

public class RetraitsDAOMock implements RetraitsDAO{
	private static int cpt=0;
	private List<ArticleVendu> lstArticles = new ArrayList<>();
	@Override
	public void insert(Retraits retrait) throws DALException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Retraits getByIdArticle(Integer idArticle) throws DALException, ArticlesVendusException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(Retraits article) throws DALException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Retraits article) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
