package fr.eni.encheres.dal.utilisateur;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFact;

public class TestDAOUtilisateur {
	private static UtilisateurDAO dao = DAOFact.getUtilisateurDAO();
	
	public static void main(String[] args) throws DALException {
		System.out.println("INSERT");
		Utilisateurs vincent = new Utilisateurs("titoune","Tim","Vincent","tim@tim.com","0626262626","10 rue de la rue","35000","rennes","mot",400,false);
		dao.insert(vincent);
		Utilisateurs v = new Utilisateurs("cece","Cerien","jean","jean@gmail.com","0626262626","10 rue de la rue","35000","rennes","mot",400,true);
		dao.insert(v);
		dao.getAll().forEach(System.out::println);
		
		System.out.println("UPDATE");
		v.setNom("Airienafaire");
		dao.update(v);
		dao.getAll().forEach(System.out::println);
		
		System.out.println("DELETE");
		dao.delete(v);
		dao.getAll().forEach(System.out::println);
		
		System.out.println("GETBYID");
		System.out.println(dao.getById(vincent.getId()));
		
		dao.delete(vincent);
	}
	
	
	
}
