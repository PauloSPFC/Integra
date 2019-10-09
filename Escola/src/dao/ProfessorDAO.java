package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import bean.Professor;

public class ProfessorDAO {
	private Connection connection;
	
	public ProfessorDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public void inserir(Professor p) {
		String sql = "INSERT INTO Professor(cpf,nome,matricula_escola,tel) VALUES (?, ?, ?, ?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, p.getCpf());
			stmt.setString(2, p.getNome());
			stmt.setInt(3, p.getMatricula_escola());
			stmt.setInt(4, p.getTel());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Professor> getLista() {
		String sql = "SELECT * FROM Professor";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Professor> professores = new ArrayList<>();
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setCpf(rs.getInt("cpf"));
				professor.setNome(rs.getString("nome"));
				professor.setMatricula_escola(rs.getInt("matricula_escola"));
				professor.setTel(rs.getInt("tel"));
				professor.add(professor);
			}
			rs.close();
			stmt.close();
			return professores;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void remover(Professor professor) {
		try {
			String sql = "DELETE FROM Professor where cpf = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, professor.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar (Professor professor) {
		String sql = "UPDATE Professor SET nome = ?,matricula_escola = ?, tel= ? WHERE cpf = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, professor.getCpf());
			stmt.setString(2, professor.getNome());
			stmt.setInt(3, professor.getMatricula_escola());
			stmt.setInt(4, professor.getTel());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}
