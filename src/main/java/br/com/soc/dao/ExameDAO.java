package br.com.soc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.soc.model.Exame;
import br.com.soc.util.UserException;

public class ExameDAO {

	public void saveOrUpdateExame(Exame exame) throws SQLException, UserException {
		if (exame == null) {
			throw new UserException("Exame não informado!");
		}
		else if (exame.getId() != 0 && this.getExameById(exame.getId()) == null) {
			throw new UserException("Exame não localizado!");
		}

		try (Connection con = DAO.getConnection();) {
			con.setAutoCommit(false);
			
			try {
				PreparedStatement stmt = null;
				
				if (exame.getId() == 0) {
					stmt = con.prepareStatement("INSERT INTO Exame (nome_paciente, nome_exame, data_exame, resultado) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
					stmt.setString(1, exame.getNomePaciente());
					stmt.setString(2, exame.getNomeExame());
					stmt.setDate(3, exame.getDataExame());
					stmt.setString(4, exame.getResultado());
					stmt.executeUpdate();
					
					ResultSet rs = stmt.getGeneratedKeys();
					
					if (rs.next()) {
						exame.setId(rs.getInt(1));
					}
				}
				else {
					stmt = con.prepareStatement("UPDATE Exame SET nome_paciente = ?, nome_exame = ?, data_exame = ?, resultado = ? WHERE ID = ?;");
					stmt.setString(1, exame.getNomePaciente());
					stmt.setString(2, exame.getNomeExame());
					stmt.setDate(3, exame.getDataExame());
					stmt.setString(4, exame.getResultado());
					stmt.setInt(5, exame.getId());
					stmt.executeUpdate();
				}
	
				con.commit();
			}
			catch (SQLException e) {
				con.rollback();
				throw e;
			}
			finally {
				con.setAutoCommit(false);
			}
		}
		catch (SQLException e) {
			throw e;
		}
	}

	public void deleteExame(int id) throws SQLException, UserException {

		try (Connection con = DAO.getConnection();) {
			Exame exame = this.getExameById(id, con);

			if (exame == null) {
				throw new UserException("Exame não localizado!");
			}

			try {
				con.setAutoCommit(false);
				
				PreparedStatement stmt = con.prepareStatement("DELETE FROM Exame WHERE ID = ?;");
				stmt.setInt(1, id);
				stmt.executeUpdate();
				
				con.commit();
			}
			catch (SQLException e) {
				con.rollback();
				throw e;
			}
			finally {
				con.setAutoCommit(false);
				con.close();
			}
		}
		catch (SQLException e) {
			throw e;
		}
	}
	
	public List<Exame> listExame() throws SQLException {
		List<Exame> exames = new ArrayList<Exame>();

		try (Connection con = DAO.getConnection(); Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Exame ORDER BY nome_paciente, nome_exame;");

            while (rs.next()) {
            	Exame exame = new Exame();
            	exame.setId(rs.getInt("Id"));
            	exame.setNomePaciente(rs.getString("nome_paciente"));
            	exame.setNomeExame(rs.getString("nome_exame"));
            	exame.setDataExame(rs.getDate("data_exame"));
            	exame.setResultado(rs.getString("resultado"));
            	
            	exames.add(exame);
            }

            con.close();
        }
        catch (SQLException e) {
			throw e;
        }
		
		return exames;
	}

	public Exame getExameById(int id) throws SQLException {
		Exame exame = null;

		try (Connection con = DAO.getConnection();) {
			exame = getExameById(id, con);
			con.close();
		}
        catch (SQLException e) {
			throw e;
        }
		
		return exame;
	}

	public Exame getExameById(int id, Connection con) throws SQLException {
		Exame exame = null;

		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Exame WHERE ID = ?;");
			stmt.setInt(1, id);
				
			ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            	exame = new Exame();
            	exame.setId(rs.getInt("Id"));
            	exame.setNomePaciente(rs.getString("nome_paciente"));
            	exame.setNomeExame(rs.getString("nome_exame"));
            	exame.setDataExame(rs.getDate("data_exame"));
            	exame.setResultado(rs.getString("resultado"));
            }
		}
        catch (SQLException e) {
			throw e;
        }
		
		return exame;
	}

	public boolean getExameExist(int id, String nome) throws SQLException {
		boolean exist = false;

		try (Connection con = DAO.getConnection();) {
			PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) AS exist FROM Exame WHERE nome_paciente = ? AND ID != ?;");
			stmt.setString(1, nome);
			stmt.setInt(2, id);
				
			ResultSet rs = stmt.executeQuery();
            
            if (rs.next())
            	exist = rs.getInt("exist") > 0;

            con.close();
		}
        catch (SQLException e) {
			throw e;
        }
		
		return exist;
	}
}
