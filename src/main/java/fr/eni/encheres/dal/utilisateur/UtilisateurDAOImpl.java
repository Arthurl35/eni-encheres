package fr.eni.encheres.dal.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.util.ConnectionProvider;
import fr.eni.encheres.messages.BundleUtil;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	private final String INSERT = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private final String SELECT = "SELECT no_Utilisateur,pseudo,nom, prenom,email,telephone, rue, code_postal,ville, mot_de_passe, credit, administrateur FROM UTILISATEURS";
	private final String UPDATE = "UPDATE UTILISATEURS SET pseudo = ?,nom = ?, prenom = ?,email = ?,telephone = ?, rue = ?, code_postal = ?,ville = ?, mot_de_passe = ? WHERE no_utilisateur=?";
	private final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?";
	private final String GETCONNECTION = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";
	private final String SELECTBYPSEUDO = "SELECT pseudo,nom, prenom,email,telephone, rue, code_postal,ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE pseudo=? ";
	private final String SELECTBYID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=? ";
	private final String SELECT_sansAdmin = "SELECT no_Utilisateur,pseudo,nom, prenom,email,telephone, rue, code_postal,ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE administrateur = 0";
	private final String UPDATEETAT = "UPDATE UTILSATEURS SET etat=? WHERE no_utilisateur=?";

	@Override
	public void insert(Utilisateurs utilisateur) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCode_postal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMot_de_passe());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.isAdministrateur());

			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbinsert"));
		}

	}

	@Override
	public List<Utilisateurs> getAll() throws DALException {
		List<Utilisateurs> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Utilisateurs utilisateur = new Utilisateurs();
				utilisateur.setId(rs.getInt("no_Utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCode_postal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));

				result.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}

		return result;
	}

	@Override
	public List<Utilisateurs> getAll_sansAdmin() throws DALException {
		List<Utilisateurs> result = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECT_sansAdmin);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Utilisateurs utilisateur = new Utilisateurs();
				utilisateur.setId(rs.getInt("no_Utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCode_postal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));

				result.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}

		return result;
	}

	@Override
	public void update(Utilisateurs utilisateur) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(UPDATE);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCode_postal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMot_de_passe());
			stmt.setInt(10, utilisateur.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbupdate"));
		}
	}

	@Override
	public void delete(Utilisateurs utilisateur) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(DELETE);
			stmt.setInt(1, utilisateur.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbdelete"));
		}
	}

	@Override
	public Utilisateurs getConnection(String pseudo, String password) throws DALException {
		Utilisateurs utilisateur = null;

		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(GETCONNECTION);
			stmt.setString(1, pseudo);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				utilisateur = new Utilisateurs();
				utilisateur.setId(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCode_postal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
				utilisateur.setEtat(rs.getBoolean("etat"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbgetConnection"));
		}
		return utilisateur;
	}

	@SuppressWarnings("null")
	@Override
	public Utilisateurs getByPseudo(String pseudo) throws DALException {
		Utilisateurs utilisateur = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTBYPSEUDO);
			stmt.setString(1, pseudo);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				utilisateur = new Utilisateurs();
				utilisateur.setId(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCode_postal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}
		return utilisateur;
	}

	@Override
	public Utilisateurs getById(Integer id) throws DALException {
		Utilisateurs utilisateur = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SELECTBYID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				utilisateur = new Utilisateurs();
				utilisateur.setId(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCode_postal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbselect"));
		}
		return utilisateur;
	}

	@Override
	public void updateEtat(Utilisateurs utilisateur) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(UPDATEETAT);
			stmt.setBoolean(1, utilisateur.getEtat());
			stmt.setInt(2, utilisateur.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(BundleUtil.getMessage("msg_pbupdate"));
		}

	}

}
