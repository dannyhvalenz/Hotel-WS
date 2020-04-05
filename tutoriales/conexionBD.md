# Conexion con la Base de datos de MySQL instalada en EC2

1. Abre la carpeta de tu proyecto

2. Descarga el zip del [JDBC Driver MySQL](https://dev.mysql.com/downloads/connector/j/)![Screen Shot 2020-04-05 at 3.25.02](https://github.com/dannyhvalenz/Hotel-WS/blob/master/tutoriales/img/Conexion con la BD/1.png)

3. Descomprime el zip y agrega el JAR a la carpeta principal del proyecto, donde se encuentra el archivo `pom.xml`

4. Ve a tu archivo pom.xml , agrega la siguiente dependencia y presiona guardar

   ```xml
   <dependency>
     <groupId>mysql</groupId>
     <artifactId>mysql-connector-java</artifactId>
     <version>5.1.48</version>
   </dependency>
   ```

5. Deberas crear una clase `conexión.java`
   ![Screen Shot 2020-04-05 at 3.29.19](https://github.com/dannyhvalenz/Hotel-WS/blob/master/tutoriales/img/Conexion con la BD/2.png)

6. En esa clase pondras el siguiente esqueleto y solo cambiaras los datos necesarios

   ```java
   import java.sql.Connection;
   import java.sql.DriverManager;
   import java.sql.SQLException;
   
   public class Conexion {
   
   	Connection conn = null;
   
   	String driver = "com.mysql.jdbc.Driver";
   	String database =  "NOMBRE BASE DE DATOS";
   	String hostname = "IPv4 DE TU EC2";
   	String port = "3306";
   	String url = "jdbc:mysql://"+hostname+":"+port+"/"+database+"?useTimezone=true&serverTimezone=UTC";
   	String username = "USERNAME";
   	String password = "PASSWORD";
   	
   	public Connection connect() {
   		
   		try {
   			this.conn = DriverManager.getConnection(this.url,this.username,this.password);
   		} catch (SQLException e) {
   			System.out.println("Conexion Fallida!:\n" + e.getMessage());
   		}
   
   		if (conn != null) {
   			System.out.println("Conexion establecida");
   		} else {
   			System.out.println("No se pudo establecer conexion");
   		}
   		
   		return this.conn;
   		
   	}
   
   }
   ```

7. Deberas crear dos paquetes `controladores` y `modelo`

8. En el paquete `modelo` pondras las clases que tienes en tu BD y cada clase tendra sus constructores, getters y setters
   ![Screen Shot 2020-04-05 at 3.34.21](https://github.com/dannyhvalenz/Hotel-WS/blob/master/tutoriales/img/Conexion con la BD/3.png)

9. En el paquete `controladores` pondras las clases `DAO (Data Access Object)` las cuales se componen de la siguiente estructura:

   1. **Atributos** en donde pondras los mismos atributos que en las clases de `modelo`

   2. **Constructores** a los que accederas desde `EndPoint.java`

   3. **Metodos** que interactuan con la BD

      ```java
      //Ejemplo
      public boolean registrarCliente() {
      		boolean resultado = false;
      		this.database = new Conexion();
      		try {
      			this.database.connect().createStatement().execute(
      					"INSERT INTO clientes (nombre,apellido,telefono,correo,formaPago) VALUES "
      					+ "('"+this.nombre+"','"+this.apellido+"','"+this.telefono+"','"+this.correo
      					+"','"+this.formaPago+"')");
      			resultado = true;
      		} catch (SQLException e) {
      			e.printStackTrace();
      		}
      		return resultado;
      	}
      ```

10. Y por ultimo en la clase `EndPoint.java` los metodos se veran algo asi

    ```java
    @PayloadRoot(localPart = "RegistrarClienteRequest", namespace = "http://proyectoSW.com/Hotel")
    	
    	@ResponsePayload
    	public RegistrarClienteResponse getRegistrarCliente (@RequestPayload RegistrarClienteRequest peticion) {
    		RegistrarClienteResponse respuesta = new RegistrarClienteResponse();
    		
    		ClienteDAO cliente = new ClienteDAO(peticion.getNombre(), peticion.getApellido(), 
    				peticion.getTelefono(), peticion.getCorreo(), peticion.getFormaPago());
    		
    		if (cliente.registrarCliente()) {
    			respuesta.setRespuesta("Se ha registrado al cliente "+cliente.getNombre()+" "+cliente.getApellido()+" en el sistema");
    		} else {
    			respuesta.setRespuesta("No se ha podido registrar al cliente "+cliente.getNombre()+" "+cliente.getApellido()+" en la base de datos");
    		}
    		
    		return respuesta;
    	}
    ```

    
