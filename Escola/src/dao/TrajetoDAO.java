package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import bean.Trajeto;

public class TrajetoDAO {
	private Connection connection;
	
	public TrajetoDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public void inserir(Trajeto t) {
		String sql = "INSERT INTO Pessoa(descricao,codigo,area,temp_media,tempo_passeio) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, t.getDescricao());
			stmt.setInt(2, t.getCodigo());
			stmt.setDouble(3, t.getArea());
			stmt.setDouble(4, t.getTemp_media());
			stmt.setInt(5, t.getTempo_passeio());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Trajeto> getLista() {
		String sql = "SELECT * FROM Trajeto";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Trajeto> trajetos = new ArrayList<>();
			while (rs.next()) {
				Trajeto trajeto = new Trajeto();;
				trajeto.setDescricao(rs.getString("descricao"));
				trajeto.setCodigo(rs.getInt("codigo"));
				trajeto.setArea(rs.getDouble("area"));
				trajeto.setTemp_media(rs.getDouble("temp_media"));
				trajeto.setTempo_passeio(rs.getInt("tempo_passeio"));
				trajetos.add(trajeto);
			}
			rs.close();
			stmt.close();
			return trajetos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void remover(Trajeto trajeto) {
		try {
			String sql = "DELETE FROM Trajeto where codigo = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, trajeto.getCodigo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Trajeto trajeto) {
		String sql = "UPDATE Pessoa SET descricao = ?, temp_media= ?, tempo_passeio = ? WHERE codigo = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, trajeto.getCodigo());
			stmt.setString(2, trajeto.getDescricao());
			stmt.setDouble(3, trajeto.getTemp_media());
			stmt.setInt(4, trajeto.getTempo_passeio());
	
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
