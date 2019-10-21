package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class FabricaConexoes {
	public Connection getConnection() {
		try {
			return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cerrado?useSSL=false","root", "paulo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
