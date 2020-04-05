# MySQL en una instancia EC2 de AWS

## 1. Instalar MySQL en la instancia EC2

### En el caso de MacOS

1. ```shell
   sudo wget https://dev.mysql.com/get/mysql57-community-release-el7-11.noarch.rpm
   ```

2. ```
   sudo yum localinstall mysql57-community-release-el7-11.noarch.rpm
   ```

3. ```
   sudo yum install mysql-community-server
   ```

4. ```
   sudo systemctl start mysqld.service
   ```

5. Obtener una contraña temporal para ingresar a la consola de MySQL

   ```
   sudo grep 'temporary password' /var/log/mysqld.log
   ```

6. Ingresa a MySQL

   ```
   mysql -u USERNAME -p
   ```

   Una vez ejecutado te pedira tu contraña e ingresaras la contraseña generada en el **paso 5**

## 2. Mantener Corriendo MySQL

1. Abre tu consola de AWS

2. Ve a tu EC2 Dashboard
    ![1 - Dashboard](https://github.com/dannyhvalenz/Hotel-WS/blob/master/tutoriales/img/EC2/1.png)

3. Da click en `running instances` y verifica que tu instancia este corriendo
   ![2](https://github.com/dannyhvalenz/Hotel-WS/blob/master/tutoriales/img/EC2/2.png)

4. En la barra lateral de la izquierda selecciona la opcion que dice `Security Groups` 
   ![3](https://github.com/dannyhvalenz/Hotel-WS/blob/master/tutoriales/img/EC2/3.png)

5. Da click en la opcion donde el `Security group name = launch-wizard-1`
   ![4](https://github.com/dannyhvalenz/Hotel-WS/blob/master/tutoriales/img/EC2/4.png)

6. Te aparecera el siguiente panel

   ![5](https://github.com/dannyhvalenz/Hotel-WS/blob/master/tutoriales/img/EC2/5.png)

7. Si **no** tienes alguna instancia de `MySQL/Aurora` entonces da click en `Edit inbound rules`

8. 



## 3. Maneja tu base de datos desde MySQL Workbrench

1. Abre MySQL Workbrench

2. Da click en el icono `+`
   ![1](https://github.com/dannyhvalenz/Hotel-WS/blob/master/tutoriales/img/MySQLWorkbrench/1.png)

3. Llena los campos
   `Connection Name` = nombre con el que guardaras la conexion 
   `Hostname` = IPv4 de tu instancia EC2
   `Port` = 3306 es el puerto por defecto
   `Username` = nombre del usuario de tu base de datos (Ej. root)
   `Password` = click en <u>Store in keychain</u> e ingresas la contraseña del Username

   ![Screen Shot 2020-04-05 at 3.10.44](https://github.com/dannyhvalenz/Hotel-WS/blob/master/tutoriales/img/MySQLWorkbrench/2.png)

4. Da click en Test Connection

   1. Si es exitosa da click en `Close`
   2. Si no es exitosa verifica que todos los pasos anteriores sean correctos
