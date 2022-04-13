package fr.eni.encheres.dal.retraits;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bll.articlesvendus.ArticlesVendusException;
import fr.eni.encheres.bll.articlesvendus.ArticlesVendusManager;
import fr.eni.encheres.bll.articlesvendus.ArticlesVendusManagerSing;
import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.util.ConnectionProvider;
import fr.eni.encheres.messages.BundleUtil;

public class RetraitsDAOImpl implements RetraitsDAO {
	private String INSERT = "INSERT INTO RETRAITS(no_article, rue, code_postal, ville) VALUES(?,?,?,?);";
	private String SELECT = "SELECT * FROM RETRAITS;";
	private String SELECTBYIDARTICLE = "SELECT * FROM RETRAITS WHERE no_article=?;";
	private String UPDATE = "UPDATE RETRAITS SET rue=?, code_postal=?, ville=? WHERE no_article=?;";
	private String DELETE = "DELETE FROM RETRAITS WHERE no_article=?";
	
	private ArticlesVendusManager articleManager = ArticlesVendusManagerSing.getInstance();
	
	@Override
	public void insert(Retraits retrait) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, retrait.getArticle().getNoArticle());
			stmt.setString(2, retrait.getRue());
			stmt.setString(3, retrait.getCode_postal());
			stmt.setString(4, retrait.getVille());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbinsert"));
		}
	}
	
	public Retraits getByIdArticle(Integer idArticle) throws DALException, ArticlesVendusException, UtilisateursException, CategoriesException {
		Retraits retrait = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTBYIDARTICLE);
			stmt.setInt(1, idArticle);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				retrait = new Retraits();
				retrait.setArticle(articleManager.getById(rs.getInt("no_article")));
				retrait.setRue(rs.getString("rue"));
				retrait.setCode_postal(rs.getString("code_postal"));
				retrait.setVille(rs.getString("ville"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}
		return retrait;
	}

	@Override
	public void update(Retraits retrait) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(UPDATE);
			
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getCode_postal());
			stmt.setString(3, retrait.getVille());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbupdate"));
		}
	}		

	@Override
	public void delete(Retraits retrait) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(DELETE);
			stmt.setInt(1, retrait.getArticle().getNoArticle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbdelete"));
		}
	}
	
}
