package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import bean.Pessoa;

public class EscolaDAO {
	private Connection connection;
	
	public EscolaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public void inserir(Pessoa p) {
		String sql = "INSERT INTO Pessoa(codigo,nome,diaNasc,mesNasc,anoNasc,sexo) VALUES (?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, p.getCodigo());
			stmt.setString(2, p.getNome());
			stmt.setInt(3, p.getDiaNasc());
			stmt.setInt(4, p.getMesNasc());
			stmt.setInt(5, p.getAnoNasc());
			stmt.setString(6, p.getSexo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pessoa> getLista() {
		String sql = "SELECT * FROM Pessoa";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Pessoa> pessoas = new ArrayList<>();
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setCodigo(rs.getInt("codigo"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setDiaNasc(rs.getInt("diaNasc"));
				pessoa.setMesNasc(rs.getInt("mesNasc"));
				pessoa.setAnoNasc(rs.getInt("anoNasc"));
				pessoa.setSexo(rs.getString("sexo"));
				pessoas.add(pessoa);
			}
			rs.close();
			stmt.close();
			return pessoas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void remover(Pessoa pessoa) {
		try {
			String sql = "DELETE FROM Pessoa where codigo = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, pessoa.getCodigo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar (Pessoa pessoa) {
		String sql = "UPDATE Pessoa SET nome = ?,diaNasc = ?, mesNasc= ?, anoNasc = ?, sexo = ? WHERE codigo = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, pessoa.getCodigo());
			stmt.setString(2, pessoa.getNome());
			stmt.setInt(3, pessoa.getDiaNasc());
			stmt.setInt(4, pessoa.getMesNasc());
			stmt.setInt(5, pessoa.getAnoNasc());
			stmt.setString(6, pessoa.getSexo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}
