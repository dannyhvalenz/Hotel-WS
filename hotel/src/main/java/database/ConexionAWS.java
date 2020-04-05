package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConexionAWS {

	Connection conexion = null;

	String driver = "com.mysql.jdbc.Driver";
	String database =  "hotel";
	String hostname = "54.162.225.248"; // 54.162.225.248
	String port = "3306";
	String url = "jdbc:mysql://"+hostname+":"+port+"/"+database+"?useTimezone=true&serverTimezone=UTC";
	String username = "root";
	String password = "12345";
	
	public Connection connect() {
		
		try {
			this.conexion = DriverManager.getConnection(this.url,this.username,this.password);
		} catch (SQLException e) {
			System.out.println("Conexion Fallida!:\n" + e.getMessage());
		}

		if (conexion != null) {
			System.out.println("Conexion establecida");
		} else {
			System.out.println("No se pudo establecer conexion");
		}
		
		return this.conexion;
		
	}

}