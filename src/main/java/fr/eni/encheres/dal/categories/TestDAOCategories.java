package fr.eni.encheres.dal.categories;


import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFact;

public class TestDAOCategories {
	private static CategoriesDAO dao = DAOFact.getCategoriesDAO();
	
	public static void main(String[] args) throws DALException {
		System.out.println("SELECTALL");
		dao.getAll().forEach(System.out::println);
	}
	
	
	
}
