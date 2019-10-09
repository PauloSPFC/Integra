package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import bean.Escola;

public class EscolaDAO {
	private Connection connection;
	
	public EscolaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public void inserir(Escola es) {
		String sql = "INSERT INTO Escola(matricula,nome,rua,nro,bairro,cidade,tel) VALUES (?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, es.getMatricula());
			stmt.setString(2, es.getNome());
			stmt.setString(3, es.getRua());
			stmt.setInt(4, es.getNro());
			stmt.setString(5, es.getBairro());
			stmt.setString(6, es.getCidade());
			stmt.setInt(7, es.getTel());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Escola> getLista() {
		String sql = "SELECT * FROM Escola";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Escola> escolas = new ArrayList<>();
			while (rs.next()) {
				Escola escola = new Escola();
				escola.setMatricula(rs.getInt("matricula"));
				escola.setNome(rs.getString("nome"));
				escola.setRua(rs.getString("rua"));
				escola.setNro(rs.getInt("nro"));
				escola.setBairro(rs.getString("bairro"));
				escola.setCidade(rs.getString("cidade"));
				escola.setTel(rs.getInt("tel"));
				escola.add(escola);
			}
			rs.close();
			stmt.close();
			return escolas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void remover(Escola escola) {
		try {
			String sql = "DELETE FROM Escola where codigo = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, escola.getMatricula());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar (Escola escola) {
		String sql = "UPDATE Escola SET nome = ?,rua = ?, nro= ?, bairro = ?, tel = ? WHERE codigo = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, escola.getMatricula());
			stmt.setString(2, escola.getNome());
			stmt.setString(3, escola.getRua());
			stmt.setInt(4, escola.getNro());
			stmt.setString(5, escola.getBairro());
			stmt.setInt(6, escola.getTel());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}
