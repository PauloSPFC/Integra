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
		String sql = "INSERT INTO Monitor(cpf,nome,tel,rua,nro,bairro,cidade) VALUES (?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, m.getCpf());
			stmt.setString(2, m.getNome());
			stmt.setString(3, m.getTel());
			stmt.setString(4, m.getRua());
			stmt.setString(5, m.getNro());
			stmt.setString(6, m.getBairro());
			stmt.setString(7, m.getCidade());
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
			String sql = "DELETE FROM Escola where codigo = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, monitor.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar (Monitor monitor) {
		String sql = "UPDATE Monitor SET nome = ?, tel= ?, rua = ?, nro = ?, bairro = ?, cidade = ? WHERE cpf = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, monitor.getCpf());
			stmt.setString(2, monitor.getNome());
			stmt.setString(4, monitor.getTel());
			stmt.setString(5, monitor.getRua());
			stmt.setString(6, monitor.getNro());
			stmt.setString(7, monitor.getBairro());
			stmt.setString(8, monitor.getCidade());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

	public boolean checkLogin (String cpf, String senha) {
		boolean check = false;
		String sql = "SELECT * FROM escola WHERE nome = ? and matricula = ?";
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
	}
