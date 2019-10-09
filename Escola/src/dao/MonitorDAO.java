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
		String sql = "INSERT INTO Monitor(cpf,nome,salario,tel,rua,nro,bairro,cidade) VALUES (?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, m.getCpf());
			stmt.setString(2, m.getNome());
			stmt.setDouble(3, m.getSalario());
			stmt.setInt(4, m.getTel());
			stmt.setString(5, m.getRua());
			stmt.setInt(6, m.getNro());
			stmt.setString(7, m.getBairro());
			stmt.setString(8, m.getCidade());
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
				monitor.setCpf(rs.getInt("cpf"));
				monitor.setNome(rs.getString("nome"));
				monitor.setSalario(rs.getDouble("salario"));
				monitor.setTel(rs.getInt("tel"));
				monitor.setRua(rs.getString("rua"));
				monitor.setNro(rs.getInt("nro"));
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
			stmt.setLong(1, monitor.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar (Monitor monitor) {
		String sql = "UPDATE Monitor SET nome = ?,salario = ?, tel= ?, rua = ?, nro = ?, bairro = ?, cidade = ? WHERE cpf = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, monitor.getCpf());
			stmt.setString(2, monitor.getNome());
			stmt.setDouble(3, monitor.getSalario());
			stmt.setInt(4, monitor.getTel());
			stmt.setString(5, monitor.getRua());
			stmt.setInt(6, monitor.getNro());
			stmt.setString(6, monitor.getBairro());
			stmt.setString(6, monitor.getCidade());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}
