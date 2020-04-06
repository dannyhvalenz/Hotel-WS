package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConexionAWS {

	Connection conexion = null;

	String database =  "hotel";
	String hostname = "54.162.225.248";
	String port = "3306";
	String url = "jdbc:mysql://"+hostname+":"+port+"/"+database+"?useTimezone=true&serverTimezone=UTC";
	String username = "root";
	String password = "12345";
	
	public Connection connect() {
		try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    }
	    catch(ClassNotFoundException ex){
	        ex.printStackTrace();
	        System.exit(-1);
	    }
		
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