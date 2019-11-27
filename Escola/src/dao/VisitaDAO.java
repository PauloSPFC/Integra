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
		String sql = "INSERT INTO Visita(monitor,professor,cod_trajeto,data_visita,horario_visita,nro_alunos,cod_visita,nome_escola) VALUES (?, ?, ?, ?, ?,?,?,?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, t.getMonitor());
			stmt.setString(2, t.getProfessor());
			stmt.setInt(3, t.getCod_trajeto());
			stmt.setString(4, t.getData_visita());
			stmt.setString(5, t.getHorario_visita());
			stmt.setInt(6, t.getNro_alunos());
			stmt.setInt(7, t.getCod_visita());
			stmt.setString(8, t.getNome_escola());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Visita> getLista(String nome) {
		ArrayList<Visita> visitas = new ArrayList<>();
		String sql = "SELECT * FROM Visita WHERE nome_escola = ?";
		PreparedStatement stmt;
		try {						
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Visita visita = new Visita();
				visita.setMonitor(rs.getString("monitor"));
				visita.setProfessor(rs.getString("professor"));
				visita.setCod_trajeto(rs.getInt("cod_trajeto"));
				visita.setData_visita(rs.getString("data_visita"));
				visita.setHorario_visita(rs.getString("horario_visita"));
				visita.setNro_alunos(rs.getInt("nro_alunos"));
				visita.setCod_visita(rs.getInt("cod_visita"));
				visita.setNome_escola(rs.getString("nome_escola"));
				visitas.add(visita);				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return visitas;
	}
	
	public void remover(Visita visita) {
		try {
			String sql = "DELETE FROM Visita where cod_visita = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, visita.getCod_visita());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Visita visita) {
		String sql = "UPDATE Visita SET monitor = ?,professor = ?, cod_trajeto= ?,data_visita = ?, horario_visita = ?, nro_alunos = ?, nome_escola = ? WHERE cod_visita = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, visita.getCod_visita());
			stmt.setString(2, visita.getMonitor());
			stmt.setString(3, visita.getProfessor());
			stmt.setInt(4, visita.getCod_trajeto());
			stmt.setString(5, visita.getData_visita());
			stmt.setString(6, visita.getHorario_visita());
			stmt.setInt(7, visita.getNro_alunos());
			stmt.setString(8, visita.getNome_escola());
	
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkCodigo (int codigo) {
		boolean check = false;
		
		String sql = "SELECT * FROM visita WHERE cod_visita = ?";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		
			stmt.setInt(1, codigo);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				check = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean checkVisita (String data, String hora) {	
		boolean check = false;
		String sql = "SELECT * FROM visita v WHERE v.data_visita = ? and v.horario_visita = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, data);
			stmt.setString(2, hora);

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
