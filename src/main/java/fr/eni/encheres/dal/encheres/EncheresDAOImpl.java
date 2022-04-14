package fr.eni.encheres.dal.encheres;

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
import fr.eni.encheres.bll.utilisateurs.UtilisateursManager;
import fr.eni.encheres.bll.utilisateurs.UtilisateursManagerSing;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.util.ConnectionProvider;
import fr.eni.encheres.messages.BundleUtil;

public class EncheresDAOImpl implements EncheresDAO {
	private String INSERT = "INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES(?,?,?,?);";
	private String SELECT = "SELECT * FROM ENCHERES;";
	private String SELECTBYID = "SELECT * FROM ENCHERES WHERE no_article=? ORDER  BY montant_enchere DESC;";
	private String UPDATE = "UPDATE ENCHERES SET no_utilisateur=?, no_article=?, date_enchere=?, montant_enchere=?;";
	private String DELETE = "DELETE FROM ENCHERES WHERE no_article=?";
	
	private UtilisateursManager userManager = UtilisateursManagerSing.getInstance();
	private ArticlesVendusManager articleManager = ArticlesVendusManagerSing.getInstance();
	
	@Override
	public void insert(Encheres enchere) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, enchere.getUtilisateur().getId());
			stmt.setInt(2, enchere.getArticle().getNoArticle());
			stmt.setDate(3, java.sql.Date.valueOf(enchere.getDate_enchere()));
			stmt.setInt(4, enchere.getMontant_enchere());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbinsert"));
		}
	}
	
	public List<Encheres> getById(Integer idArticle) throws DALException, ArticlesVendusException, UtilisateursException, CategoriesException {
		Encheres enchere = null;
		List<Encheres> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTBYID);
			stmt.setInt(1, idArticle);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				enchere = new Encheres();
				enchere.setArticle(articleManager.getById(idArticle));
				enchere.setUtilisateur(userManager.getById(rs.getInt("no_utilisateur")));
				enchere.setDate_enchere(rs.getDate("date_enchere").toLocalDate());
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
			
				result.add(enchere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}
		return result;
	}

	@Override
	public List<Encheres> getAll() throws DALException, ArticlesVendusException, UtilisateursException, CategoriesException {
		Encheres enchere = null;
		List<Encheres> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				enchere = new Encheres();
				enchere.setArticle(articleManager.getById(rs.getInt("no_article")));
				enchere.setUtilisateur(userManager.getById(rs.getInt("no_utilisateur")));
				enchere.setDate_enchere(rs.getDate("date_enchere").toLocalDate());
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
			
				result.add(enchere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}

		return result;
	}

	@Override
	public void update(Encheres enchere) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(UPDATE);
			stmt.setInt(1, enchere.getUtilisateur().getId());
			stmt.setInt(2, enchere.getArticle().getNoArticle());
			stmt.setDate(3, java.sql.Date.valueOf(enchere.getDate_enchere()));
			stmt.setInt(4, enchere.getMontant_enchere());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbupdate"));
		}
	}		

	@Override
	public void delete(Encheres enchere) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(DELETE);
			stmt.setInt(1, enchere.getArticle().getNoArticle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbdelete"));
		}
	}
	
}
