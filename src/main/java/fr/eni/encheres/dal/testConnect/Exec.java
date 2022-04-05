package fr.eni.encheres.dal.testConnect;

import java.sql.Connection;
import java.sql.SQLException;

import fr.eni.encheres.dal.util.ConnectionProvider;

public class Exec {

	public static void main(String[] args) {
		try(Connection con = ConnectionProvider.getConnection()) {
			System.out.println("Je suis connecté "+ con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
