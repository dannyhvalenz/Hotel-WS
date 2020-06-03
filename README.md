# Hotel
## Descripción
Sistema web de un hotel

[Link del Servidor SOAP](http://54.162.225.248:8080/hotel.wsdl)

[Link servidor REST](https://rest-hotel.herokuapp.com/habitaciones)

[Link del Cliente](http://54.162.225.248/web/Hotel-WS/clientes.php)

## Documentación

[Link a la Documentación](https://github.com/dannyhvalenz/Hotel-WS/tree/master/DOCS)



## Instalación

### Cliente

La carpeta `CLIENT` debe agregarse a la carpeta de tu servidor.

### SOAP

La carpeta `SOAP` se puede abrir desde eclipse. No es necesario cambiar la ubicación de esta carpeta.

### REST

En el caso de REST, es necesario seguir estos pasos para que el sistema funciones de la forma correcta

1. Debes instalar [NodeJS](https://nodejs.org/es/download/) en tu computadora

2. Una vez instalado, abre una terminal desde la carpeta REST del proyecto

   ```
   cd /ruta/de/la/carpeta/rest
   ```

3. Ya teniendo la terminal desde la carpeta REST ejecuta el siguiente comando

   ```
   npm install
   ```

   Esto instalará todas las dependencias que necesita el proyecto para funcionar correctamente

4. Por último, ejecuta este comando para que puedas empezar a utilizar este servicio REST

   ```
   node server.js
   ```

   

## Dependencias

MySQL

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.48</version>
</dependency>
```

WSDL4J

```xml
<dependency>
	<groupId>wsdl4j</groupId>
	<artifactId>wsdl4j</artifactId>
</dependency>
```

SpringBoot dependencies

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web-services</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<scope>runtime</scope>
	<optional>true</optional>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
	<exclusions>
		<exclusion>
			<groupId>org.junit.vintage</groupId>
			<artifactId>junit-vintage-engine</artifactId>
		</exclusion>
	</exclusions>
</dependency>
```

NodeJS



