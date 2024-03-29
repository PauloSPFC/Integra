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
		String sql = "INSERT INTO Visita(monitor,professor,cod_trajeto,data_visita,horario_visita,nro_alunos,cod_visita,escola) VALUES (?, ?, ?, ?, ?,?,?,?);";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, t.getMonitor());
			stmt.setString(2, t.getProfessor());
			stmt.setInt(3, t.getCod_trajeto());
			stmt.setString(4, t.getData_visita());
			stmt.setString(5, t.getHorario_visita());
			stmt.setInt(6, t.getNro_alunos());
			stmt.setInt(7, t.getCod_visita());
			stmt.setInt(8, t.getEscola());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Visita> getLista(int matricula) {
		ArrayList<Visita> visitas = new ArrayList<>();
		String sql = "SELECT * FROM Visita WHERE escola = ?";
		PreparedStatement stmt;
		try {						
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, matricula);
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
				visita.setEscola(rs.getInt("escola"));
				visitas.add(visita);				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return visitas;
	}
	
	public ArrayList<Visita> getListaP(String cpf) {
		ArrayList<Visita> visitas = new ArrayList<>();
		String sql = "SELECT * FROM Visita WHERE professor = ?";
		PreparedStatement stmt;
		try {						
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
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
				visita.setEscola(rs.getInt("escola"));
				visitas.add(visita);				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return visitas;
	}
	
	public ArrayList<Visita> getListaM(String cpf) {
		ArrayList<Visita> visitas = new ArrayList<>();
		String sql = "SELECT * FROM Visita WHERE monitor = ?";
		PreparedStatement stmt;
		try {						
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
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
				visita.setEscola(rs.getInt("escola"));
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
	
	public void removerMonitor(String cpf) {
		try {
			String sql = "DELETE FROM Visita where monitor = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removerEscola(int matricula) {
		try {
			String sql = "DELETE FROM Visita where escola = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, matricula);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removerProfessor(String cpf) {
		try {
			String sql = "DELETE FROM Visita where professor = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Visita visita) {
		String sql = "UPDATE Visita SET monitor = ?,professor = ?, cod_trajeto= ?,data_visita = ?, horario_visita = ?, nro_alunos = ?, escola = ? WHERE cod_visita = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, visita.getCod_visita());
			stmt.setString(2, visita.getMonitor());
			stmt.setString(3, visita.getProfessor());
			stmt.setInt(4, visita.getCod_trajeto());
			stmt.setString(5, visita.getData_visita());
			stmt.setString(6, visita.getHorario_visita());
			stmt.setInt(7, visita.getNro_alunos());
			stmt.setInt(8, visita.getEscola());
	
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
	
	public boolean checkVisita (int trajeto, String data, String hora) {	
		boolean check = false;
		String sql = "SELECT * FROM visita WHERE cod_trajeto = ? and data_visita = ? and horario_visita = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setInt(1, trajeto);
			stmt.setString(2, data);
			stmt.setString(3, hora);

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
