package fr.eni.encheres.dal.categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.util.ConnectionProvider;
import fr.eni.encheres.messages.BundleUtil;




public class CategoriesDAOImpl implements CategoriesDAO {
	private final String SELECT = "SELECT no_categorie,libelle FROM CATEGORIES";
	private final String SELECTBYID = "SELECT no_categorie,libelle FROM CATEGORIES WHERE no_categorie=? ";

	

	@Override
	public List<Categories> getAll() throws DALException {
		List<Categories> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categories categorie = new Categories();
				categorie.setId(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
				
				result.add(categorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}

		return result;
	}

	@Override
	public Categories getById(Integer id) throws DALException {
		Categories categorie = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTBYID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				categorie = new Categories();
				categorie.setId(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}
		return categorie;
	}

}
