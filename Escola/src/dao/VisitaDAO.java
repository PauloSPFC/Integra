package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import bean.Visita;

public class VisitaDAO {
	private Connection connection;
	
	public VisitaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public void inserir(Visita t) {
		String sql = "INSERT INTO Pessoa(monitor,professor,cod_trajeto,data_visita,horario_visita) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, t.getMonitor());
			stmt.setString(2, t.getProfessor());
			stmt.setInt(3, t.getCod_trajeto());
			stmt.setString(4, t.getData_visita());
			stmt.setString(5, t.getHorario_visita());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Visita> getLista() {
		String sql = "SELECT * FROM Visita";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Visita> visitas = new ArrayList<>();
			while (rs.next()) {
				Visita visita = new Visita(sql, sql, 0, sql, sql);;
				visita.setMonitor(rs.getString("monitor"));
				visita.setProfessor(rs.getString("professor"));
				visita.setCod_trajeto(rs.getInt("cod_trajeto"));
				visita.setData_visita(rs.getString("data_visita"));
				visita.setHorario_visita(rs.getString("horario_visita"));
				visitas.add(visita);
			}
			rs.close();
			stmt.close();
			return visitas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void remover(Visita visita) {
		try {
			String sql = "DELETE FROM Visita where cod_trajeto = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, visita.getCod_trajeto());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Visita visita) {
		String sql = "UPDATE Visita SET monitor = ?,professor = ?, cod_trajeto= ?,data_visita = ?, horario_visita = ? WHERE cod_trajeto = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(2, visita.getMonitor());
			stmt.setString(3, visita.getProfessor());
			stmt.setInt(4, visita.getCod_trajeto());
			stmt.setString(5, visita.getData_visita());
			stmt.setString(5, visita.getHorario_visita());
	
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
