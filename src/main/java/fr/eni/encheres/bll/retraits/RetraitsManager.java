package fr.eni.encheres.bll.retraits;

import fr.eni.encheres.bll.articlesvendus.ArticlesVendusException;
import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retraits;

public interface RetraitsManager {
	
	public void addRetrait(Retraits article) throws RetraitsException;
	public void delRetrait(Retraits article) throws RetraitsException;
	public Retraits getByIdArticle(Integer id) throws RetraitsException, ArticlesVendusException, UtilisateursException, CategoriesException;
	public void updateRetrait(Retraits article) throws RetraitsException;
}
