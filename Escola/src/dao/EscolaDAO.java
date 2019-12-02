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
		String sql = "INSERT INTO Escola(matricula,nome,rua,nro,bairro,cidade,tel,estado) VALUES (?, ?, ?, ?, ?, ?, ?,?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, es.getMatricula());
			stmt.setString(2, es.getNome());
			stmt.setString(3, es.getRua());
			stmt.setString(4, es.getNro());
			stmt.setString(5, es.getBairro());
			stmt.setString(6, es.getCidade());
			stmt.setString(7, es.getTel());
			stmt.setString(8, es.getEstado());
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
				escola.setNro(rs.getString("nro"));
				escola.setBairro(rs.getString("bairro"));
				escola.setCidade(rs.getString("cidade"));
				escola.setTel(rs.getString("tel"));
				escola.setEstado(rs.getString("estado"));
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
			String sql = "DELETE FROM Escola where matricula = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, escola.getMatricula());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removerMatricula(int matricula) {
		try {
			String sql = "DELETE FROM Escola where matricula = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, matricula);			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar (Escola escola) {
		String sql = "UPDATE Escola SET nome = ?,rua = ?, nro= ?, bairro = ?, tel = ?, cidade = ?, estado = ? WHERE matricula = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, escola.getNome());
			stmt.setString(2, escola.getRua());
			stmt.setString(3, escola.getNro());
			stmt.setString(4, escola.getBairro());
			stmt.setString(5, escola.getTel());
			stmt.setString(6, escola.getCidade());
			stmt.setString(7, escola.getEstado());
			stmt.setInt(8, escola.getMatricula());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
	public boolean checkLogin (String nome, String matricula) {
		boolean check = false;
		String sql = "SELECT * FROM escola WHERE nome = ? and matricula = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		
			stmt.setString(1, nome);
			stmt.setString(2, matricula);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				check = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean checkCadastro (String nome) {
		boolean check = false;
		
		String sql = "SELECT * FROM escola WHERE nome = ?";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		
			stmt.setString(1, nome);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				check = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean checkMatricula (int matricula) {
		boolean check = false;
		
		String sql = "SELECT * FROM escola WHERE matricula = ?";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		
			stmt.setInt(1, matricula);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				check = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
public String getNome(int mat) {
		
		String nome = "";	
		String sql = "SELECT nome FROM escola WHERE matricula = ?";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setInt(1, mat);
			
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				nome = rs.getString("nome");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nome;
		
	}
}
