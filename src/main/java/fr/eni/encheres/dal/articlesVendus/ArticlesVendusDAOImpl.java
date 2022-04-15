package fr.eni.encheres.dal.articlesVendus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.categories.CategoriesManager;
import fr.eni.encheres.bll.categories.CategoriesManagerSing;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursManager;
import fr.eni.encheres.bll.utilisateurs.UtilisateursManagerSing;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.util.ConnectionProvider;
import fr.eni.encheres.messages.BundleUtil;

public class ArticlesVendusDAOImpl implements ArticlesVendusDAO {
	private String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat) VALUES(?,?,?,?,?,?,?,?,?);";
	private String SELECT = "SELECT * FROM ARTICLES_VENDUS;";
	private String SELECTBYID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?;";
	private String SELECTBYCATEGORIE = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie=?;";
	private String SELECTBYETAT = "SELECT * FROM ARTICLES_VENDUS WHERE etat=?;";
	private String SELECTBYUSER = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur=?;";
	private String SELECTWINBYUSER = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur_win=?;";
	private String SELECTBYETATANDUSER = "SELECT * FROM ARTICLES_VENDUS WHERE etat=? AND no_utilisateur=?;";
	private String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=?, etat=? WHERE no_article=?;";
	private String UPDATEWIN = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=?, etat=?, no_utilisateur_win=? WHERE no_article=?;";
	private String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article=?";
	private String SELECTARTICLEENCHEREBYUSER = "SELECT DISTINCT ARTICLES_VENDUS.no_article, ARTICLES_VENDUS.nom_article, ARTICLES_VENDUS.description, ARTICLES_VENDUS.date_debut_encheres, ARTICLES_VENDUS.date_fin_encheres, ARTICLES_VENDUS.prix_initial, ARTICLES_VENDUS.prix_vente, ARTICLES_VENDUS.no_utilisateur, ARTICLES_VENDUS.no_categorie, ARTICLES_VENDUS.etat, ARTICLES_VENDUS.no_utilisateur_win from ARTICLES_VENDUS inner join ENCHERES on ARTICLES_VENDUS.no_article = ENCHERES.no_article where ENCHERES.no_utilisateur = ? AND ARTICLES_VENDUS.etat = ?;";
	
	private UtilisateursManager userManager = UtilisateursManagerSing.getInstance();
	private CategoriesManager categManager = CategoriesManagerSing.getInstance();
	;
	@Override
	public void insert(ArticleVendu article) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			stmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixVente());
			stmt.setInt(7, article.getUtilisateur().getId());
			stmt.setInt(8, article.getCategorie().getId());
			stmt.setInt(9, article.getEtatVente());
			
			System.out.println(stmt.toString());
			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					article.setNoArticle(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbinsert"));
		}
	}
	
	public ArticleVendu getById(Integer idArticle) throws DALException, UtilisateursException, CategoriesException {
		ArticleVendu article = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTBYID);
			stmt.setInt(1, idArticle);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(userManager.getById(rs.getInt("no_utilisateur")));
				article.setCategorie(categManager.getCategoriById(rs.getInt("no_categorie")));
				article.setEtatVente(rs.getInt("etat"));
				if(rs.getInt("no_utilisateur_win") != 0) {
					article.setUtilisateurWin(userManager.getById(rs.getInt("no_utilisateur_win")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}
		return article;
	}

	@Override
	public List<ArticleVendu> getAll() throws DALException, UtilisateursException, CategoriesException {
		List<ArticleVendu> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(userManager.getById(rs.getInt("no_utilisateur")));
				article.setCategorie(categManager.getCategoriById(rs.getInt("no_categorie")));
				article.setEtatVente(rs.getInt("etat"));
				if(rs.getInt("no_utilisateur_win") != 0) {
					article.setUtilisateurWin(userManager.getById(rs.getInt("no_utilisateur_win")));
				}
			
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}

		return result;
	}
	
	@Override
	public List<ArticleVendu> getAllByEtat(Integer etat) throws DALException, UtilisateursException, CategoriesException {
		List<ArticleVendu> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTBYETAT);
			stmt.setInt(1, etat);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(userManager.getById(rs.getInt("no_utilisateur")));
				article.setCategorie(categManager.getCategoriById(rs.getInt("no_categorie")));
				article.setEtatVente(rs.getInt("etat"));
				if(rs.getInt("no_utilisateur_win") != 0) {
					article.setUtilisateurWin(userManager.getById(rs.getInt("no_utilisateur_win")));
				}
			
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}

		return result;
	}
	
	@Override
	public List<ArticleVendu> getAllByCategorie(Categories categorie) throws DALException, UtilisateursException, CategoriesException {
		List<ArticleVendu> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTBYCATEGORIE);
			stmt.setInt(1, categorie.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(userManager.getById(rs.getInt("no_utilisateur")));
				article.setCategorie(categManager.getCategoriById(rs.getInt("no_categorie")));
				article.setEtatVente(rs.getInt("etat"));
				if(rs.getInt("no_utilisateur_win") != 0) {
					article.setUtilisateurWin(userManager.getById(rs.getInt("no_utilisateur_win")));
				}
			
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}

		return result;
	}
	
	@Override
	public List<ArticleVendu> getAllByUser(Utilisateurs user) throws DALException, UtilisateursException, CategoriesException {
		List<ArticleVendu> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTBYUSER);
			stmt.setInt(1, user.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(userManager.getById(rs.getInt("no_utilisateur")));
				article.setCategorie(categManager.getCategoriById(rs.getInt("no_categorie")));
				article.setEtatVente(rs.getInt("etat"));
				if(rs.getInt("no_utilisateur_win") != 0) {
					article.setUtilisateurWin(userManager.getById(rs.getInt("no_utilisateur_win")));
				}
			
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}

		return result;
	}
	
	@Override
	public List<ArticleVendu> getAllWinByUser(Utilisateurs user) throws DALException, UtilisateursException, CategoriesException {
		List<ArticleVendu> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTWINBYUSER);
			stmt.setInt(1, user.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(userManager.getById(rs.getInt("no_utilisateur")));
				article.setCategorie(categManager.getCategoriById(rs.getInt("no_categorie")));
				article.setEtatVente(rs.getInt("etat"));
				if(rs.getInt("no_utilisateur_win") != 0) {
					article.setUtilisateurWin(userManager.getById(rs.getInt("no_utilisateur_win")));
				}
			
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}

		return result;
	}
	
	@Override
	public List<ArticleVendu> getAllByEtatAndUser(Integer etat, Utilisateurs user) throws DALException, UtilisateursException, CategoriesException {
		List<ArticleVendu> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTBYETATANDUSER);
			stmt.setInt(1, etat);
			stmt.setInt(2, user.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(userManager.getById(rs.getInt("no_utilisateur")));
				article.setCategorie(categManager.getCategoriById(rs.getInt("no_categorie")));
				article.setEtatVente(rs.getInt("etat"));
				if(rs.getInt("no_utilisateur_win") != 0) {
					article.setUtilisateurWin(userManager.getById(rs.getInt("no_utilisateur_win")));
				}
			
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}

		return result;
	}
	
	@Override
	public List<ArticleVendu> getAllByEnchereUser(Utilisateurs user) throws DALException, UtilisateursException, CategoriesException {
		List<ArticleVendu> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTARTICLEENCHEREBYUSER);;
			stmt.setInt(1, user.getId());
			stmt.setInt(2, 1);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(userManager.getById(rs.getInt("no_utilisateur")));
				article.setCategorie(categManager.getCategoriById(rs.getInt("no_categorie")));
				article.setEtatVente(rs.getInt("etat"));
				if(rs.getInt("no_utilisateur_win") != 0) {
					article.setUtilisateurWin(userManager.getById(rs.getInt("no_utilisateur_win")));
				}
			
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}

		return result;
	}

	@Override
	public void update(ArticleVendu article) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(UPDATE);

			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			stmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixVente());
			stmt.setInt(7, article.getUtilisateur().getId());
			stmt.setInt(8, article.getCategorie().getId());
			stmt.setInt(9, article.getEtatVente());
			
			stmt.setInt(10, article.getNoArticle());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbupdate"));
		}
	}		
	
	@Override
	public void updateWin(ArticleVendu article) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(UPDATEWIN);

			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			stmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixVente());
			stmt.setInt(7, article.getUtilisateur().getId());
			stmt.setInt(8, article.getCategorie().getId());
			stmt.setInt(9, article.getEtatVente());
			stmt.setInt(10, article.getUtilisateurWin().getId());
			
			stmt.setInt(11, article.getNoArticle());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbupdate"));
		}
	}		

	@Override
	public void delete(ArticleVendu article) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(DELETE);
			stmt.setInt(1, article.getNoArticle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbdelete"));
		}
	}
	
}
