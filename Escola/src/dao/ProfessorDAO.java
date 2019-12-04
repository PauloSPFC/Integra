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
		String sql = "INSERT INTO Professor(senha,cpf,nome,matricula_escola,tel) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, p.getSenha());
			stmt.setString(2, p.getCpf());
			stmt.setString(3, p.getNome());
			stmt.setInt(4, p.getMatricula_escola());
			stmt.setString(5, p.getTel());
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
				professor.setSenha(rs.getInt("senha"));
				professor.setCpf(rs.getString("cpf"));
				professor.setNome(rs.getString("nome"));
				professor.setMatricula_escola(rs.getInt("matricula_escola"));
				professor.setTel(rs.getString("tel"));
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
			stmt.setString(1, professor.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar (Professor professor) {
		String sql = "UPDATE Professor SET senha = ?, nome = ?,matricula_escola = ?, tel= ? WHERE cpf = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, professor.getSenha());
			stmt.setString(2, professor.getNome());
			stmt.setInt(3, professor.getMatricula_escola());
			stmt.setString(4, professor.getTel());
			stmt.setString(5, professor.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkLogin (String cpf, String senha) {
		boolean check = false;
		String sql = "SELECT * FROM professor WHERE cpf = ? and senha = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, cpf);
			stmt.setString(2, senha);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				check = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean checkSenha (int senha) {
		boolean check = false;
		
		String sql = "SELECT * FROM professor WHERE cpf = ?";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		
			stmt.setInt(1, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				check = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean checkCadastro (String cpf) {
		boolean check = false;

		String sql = "SELECT * FROM professor WHERE cpf = ?";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, cpf);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				check = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public String getNome(String cpf) {
		
		String nome = "";	
		String sql = "SELECT nome FROM professor WHERE cpf = ?";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, cpf);
			
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				nome = rs.getString("nome");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nome;
		
	}

	public boolean checkCpf (String cpf) {
		boolean check = false;
		
		String sql = "SELECT * FROM professor WHERE cpf = ?";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		
			stmt.setString(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				check = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public void removerMatricula(String matricula) {
		try {
			String sql = "DELETE FROM professor where cpf = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, matricula);			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removerEscola(int matricula) {
		try {
			String sql = "DELETE FROM professor where matricula_escola = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, matricula);			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
