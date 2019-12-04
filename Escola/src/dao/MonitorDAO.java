package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import bean.Monitor;

public class MonitorDAO {
	private Connection connection;

	public MonitorDAO() {
		connection = new FabricaConexoes().getConnection();
	}

	public void inserir(Monitor m) {
		String sql = "INSERT INTO Monitor(cpf,nome,tel,rua,nro,bairro,cidade,senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, m.getCpf());
			stmt.setString(2, m.getNome());
			stmt.setString(3, m.getTel());
			stmt.setString(4, m.getRua());
			stmt.setString(5, m.getNro());
			stmt.setString(6, m.getBairro());
			stmt.setString(7, m.getCidade());
			stmt.setInt(8, m.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Monitor> getLista() {
		String sql = "SELECT * FROM Monitor";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Monitor> monitores = new ArrayList<>();
			while (rs.next()) {
				Monitor monitor = new Monitor();
				monitor.setCpf(rs.getString("cpf"));
				monitor.setNome(rs.getString("nome"));
				monitor.setTel(rs.getString("tel"));
				monitor.setRua(rs.getString("rua"));
				monitor.setNro(rs.getString("nro"));
				monitor.setBairro(rs.getString("bairro"));
				monitor.setCidade(rs.getString("cidade"));
				monitor.setSenha(rs.getInt("senha"));
				monitor.add(monitor);
			}
			rs.close();
			stmt.close();
			return monitores;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void remover(Monitor monitor) {
		try {
			String sql = "DELETE FROM Monitor where cpf = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, monitor.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar (Monitor monitor) {
		String sql = "UPDATE Monitor SET nome = ?, tel= ?, rua = ?, nro = ?, bairro = ?, cidade = ?, senha = ? WHERE cpf = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, monitor.getNome());
			stmt.setString(2, monitor.getTel());
			stmt.setString(3, monitor.getRua());
			stmt.setString(4, monitor.getNro());
			stmt.setString(5, monitor.getBairro());
			stmt.setString(6, monitor.getCidade());			
			stmt.setInt(7, monitor.getSenha());
			stmt.setString(8, monitor.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

	public boolean checkLogin (String cpf, String senha) {
		boolean check = false;
		String sql = "SELECT * FROM monitor WHERE cpf = ? and senha = ?";
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
	
	public String geraMonitor() {
		
		String cpf = "";	
		String sql = "SELECT cpf FROM monitor ORDER BY RAND() LIMIT 1";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				cpf = rs.getString("cpf");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpf;
		
	}
	
	public String getNome(String cpf) {
		
		String nome = "";	
		String sql = "SELECT nome FROM monitor WHERE cpf = ?";

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
	

	public boolean checkCadastro (String cpf) {
		boolean check = false;

		String sql = "SELECT * FROM monitor WHERE cpf = ?";

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
	
	public boolean checkSenha (int senha) {
		boolean check = false;
		
		String sql = "SELECT * FROM monitor WHERE cpf = ?";
		
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
	
	public void removerMatricula(String matricula) {
		try {
			String sql = "DELETE FROM monitor where cpf = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, matricula);			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
