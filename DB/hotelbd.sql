-- Database export via SQLPro (https://www.sqlprostudio.com/allapps.html)
-- Exported by dany at 25-06-2020 23:13.
-- WARNING: This file may contain descructive statements such as DROPs.
-- Please ensure that you are running the script at the proper location.


-- BEGIN TABLE clientes
DROP TABLE IF EXISTS clientes;
CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `formaPago` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=latin1;

-- Inserting 93 rows into clientes
-- Insert batch #1
INSERT INTO clientes (idCliente, nombre, apellido, correo, telefono, formaPago) VALUES
(9, 'Roberto', 'Escamilla', 'robertoes@live.com', '1243512435', 'Credito'),
(10, 'Rita', 'Flores', 'ritaflores@live.com', '1436713912', 'Efectivo'),
(11, 'Maryam', 'Shelton', 'sollicitudin.orci.sem@laoreetposuere.com', '299-693-4208', 'Efectivo'),
(12, 'Kiayada', 'Oneal', 'sollicitudin.adipiscing.ligula@acfacilisis.org', '642-742-2490', 'Debito'),
(13, 'Kristen', 'Fisher', 'non.dui.nec@semutcursus.co.uk', '790-500-4529', 'Debito'),
(14, 'Tatyana', 'Mercado', 'eget.massa@sodalesat.com', '926-368-7531', 'Debito'),
(15, 'Damian', 'Chase', 'Aliquam.gravida@Quisquetincidunt.net', '499-218-1504', 'Debito'),
(16, 'Bethany', 'Alexander', 'aliquam.iaculis.lacus@non.com', '796-978-9857', 'Credito'),
(17, 'Emmanuel', 'Woodward', 'Nunc@facilisisnonbibendum.com', '523-465-1391', 'Credito'),
(18, 'Honorato', 'Wallace', 'amet@egetipsum.co.uk', '788-515-0255', 'Credito'),
(19, 'Yetta', 'Forbes', 'cursus@egestasascelerisque.edu', '903-149-8449', 'Credito'),
(20, 'Brooke', 'Acevedo', 'fermentum.risus@vel.net', '827-784-3981', 'Efectivo'),
(21, 'Sylvester', 'Hurley', 'semper.rutrum@Vestibulum.edu', '754-822-7752', 'Efectivo'),
(22, 'Aphrodite', 'Buckner', 'orci@tinciduntDonec.com', '701-274-9786', 'Credito'),
(23, 'Gillian', 'Curry', 'mauris.Suspendisse.aliquet@aliquet.co.uk', '455-144-4804', 'Debito'),
(24, 'Molly', 'Kerr', 'dui@Cum.net', '293-856-5896', 'Debito'),
(25, 'Deacon', 'Mitchell', 'arcu.eu@justo.edu', '630-661-8508', 'Credito'),
(26, 'Charity', 'Guerra', 'parturient.montes@ornarelibero.edu', '583-271-0119', 'Efectivo'),
(27, 'Lydia', 'Love', 'ridiculus.mus.Proin@ornare.com', '585-321-6922', 'Efectivo'),
(28, 'Nomlanga', 'Patterson', 'Aliquam@Proinmi.org', '245-541-2802', 'Debito'),
(30, 'Winter', 'Cabrera', 'hendrerit.neque.In@aaliquet.ca', '476-984-2825', 'Credito'),
(31, 'Carissa', 'Mendoza', 'amet@mattis.ca', '645-393-3731', 'Efectivo'),
(32, 'Simone', 'Valdez', 'rutrum.magna.Cras@pharetra.ca', '179-608-6229', 'Credito'),
(33, 'Kaseem', 'Madden', 'dolor.Donec.fringilla@nisiCumsociis.ca', '168-577-0750', 'Debito'),
(34, 'Omar', 'White', 'diam.lorem@montesnasceturridiculus.edu', '409-278-7853', 'Debito'),
(35, 'Regan', 'Kaufman', 'lobortis.ultrices.Vivamus@sociisnatoque.co.uk', '306-397-8544', 'Efectivo'),
(36, 'Mark', 'Dillon', 'taciti.sociosqu.ad@Pellentesqueut.edu', '368-431-4172', 'Debito'),
(37, 'Jack', 'Pitts', 'lacinia@arcuNuncmauris.edu', '981-156-1472', 'Credito'),
(38, 'Jack', 'Vang', 'Sed@Donectempor.ca', '836-243-0001', 'Debito'),
(39, 'Felicia', 'Dale', 'congue.elit@ut.ca', '314-128-7473', 'Debito'),
(101, 'Rafael', 'Rojano', 'rafael@live.com.mx', '12321313', 'Credito'),
(166, 'Franco ', ' Escamilla', 'franco@escamilla.com', '1436713912', 'Debito'),
(170, 'Jorge ', ' Santiago', 'Jorgeasantiago96@gmail.com', '6020391556', 'Debito'),
(177, 'Francisco', 'Jimenez', 'francisco@jimenez.com', '1234565432', 'Credito'),
(178, 'Jorge ', ' Santiago', 'Jorgeasantiago96@gmail.com', '9630589475', 'Debito'),
(179, 'travel Agent', 'Agent', 'travel@correo.com', '3524777483', 'Debito'),
(180, 'yaelmo ruiz pucheta', '', 'correo2@correo.com', '4183858873', 'Debito');

-- END TABLE clientes

-- BEGIN TABLE estancias
DROP TABLE IF EXISTS estancias;
CREATE TABLE `estancias` (
  `idEstancia` int(11) NOT NULL AUTO_INCREMENT,
  `numHabitacion` int(11) NOT NULL,
  `numPersonas` int(11) NOT NULL,
  `precio` double NOT NULL,
  `fechaCheckIn` date NOT NULL,
  `fechaCheckOut` date NOT NULL,
  `idCliente` int(11) NOT NULL,
  `tipoHabitacion` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstancia`),
  KEY `idClienteEstancia` (`idCliente`),
  KEY `numHabitacion` (`numHabitacion`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

-- Inserting 7 rows into estancias
-- Insert batch #1
INSERT INTO estancias (idEstancia, numHabitacion, numPersonas, precio, fechaCheckIn, fechaCheckOut, idCliente, tipoHabitacion, status) VALUES
(1, 44, 4, 2013, '2021-02-20', '2020-12-09', 27, '', 'check-out'),
(2, 22, 6, 5947, '2020-05-12', '2019-07-19', 78, '', ''),
(3, 52, 8, 2693, '2019-09-15', '2020-11-22', 3, '', ''),
(4, 34, 4, 7875, '2019-11-14', '2020-10-25', 20, '', ''),
(5, 79, 7, 7097, '2019-12-05', '2019-09-29', 86, '', ''),
(6, 84, 4, 6582, '2021-03-28', '2019-09-14', 53, '', ''),
(7, 76, 8, 2186, '2019-06-08', '2019-07-05', 62, '', '');

-- END TABLE estancias

-- BEGIN TABLE habitaciones
DROP TABLE IF EXISTS habitaciones;
CREATE TABLE `habitaciones` (
  `numHabitacion` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `numCamas` int(11) NOT NULL,
  `cupoPersonas` int(11) NOT NULL,
  `tipoHabitacion` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`numHabitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Inserting 9 rows into habitaciones
-- Insert batch #1
INSERT INTO habitaciones (numHabitacion, piso, numCamas, cupoPersonas, tipoHabitacion, status) VALUES
(1, 1, 4, 8, 'Suite', 'Disponible'),
(2, 2, 2, 4, 'Doble', 'Disponible'),
(10, 2, 2, 2, 'Sencilla', 'Disponible'),
(12, 1, 3, 6, 'Junior', 'Disponible'),
(13, 4, 2, 4, 'Doble', 'Disponible'),
(200, 2, 2, 4, 'Doble', 'Disponible'),
(1111, 11, 1, 2, 'Sencilla', 'Disponible'),
(1212, 12, 4, 8, 'Suite', 'Disponible'),
(121212, 1212, 1, 2, 'Sencilla', 'Disponible');

-- END TABLE habitaciones

-- BEGIN TABLE reservaciones
DROP TABLE IF EXISTS reservaciones;
CREATE TABLE `reservaciones` (
  `idReservacion` int(11) NOT NULL AUTO_INCREMENT,
  `fechaLlegada` date NOT NULL,
  `fechaSalida` date NOT NULL,
  `numPersonas` int(11) NOT NULL,
  `tipoHabitacion` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `idCliente` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`idReservacion`),
  KEY `IdClienteReservacion` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

-- Inserting 29 rows into reservaciones
-- Insert batch #1
INSERT INTO reservaciones (idReservacion, fechaLlegada, fechaSalida, numPersonas, tipoHabitacion, precio, idCliente, status) VALUES
(3, '2020-11-12', '2020-11-17', 2, 'Junior', 9500, 1, 'vigente'),
(4, '2020-10-05', '2020-10-15', 1, 'Doble', 14000, 1, 'vigente'),
(6, '2020-10-10', '2020-10-11', 4, 'Suite', 2400, 1, 'vigente'),
(7, '2020-01-01', '2020-01-03', 5, 'Suite', 4800, 1, 'vigente'),
(8, '2020-01-01', '2020-02-02', 1, 'Sencilla', 0, 5, 'Vigente'),
(9, '2020-05-15', '2020-05-16', 1, 'Suite', 2400, 1, 'vigente'),
(11, '2020-12-01', '2020-12-15', 4, 'Doble', 19600, 1, 'vigente'),
(14, '2020-11-17', '2020-11-18', 1, 'Sencilla', 900, 1, 'vigente'),
(19, '2020-06-20', '2020-06-21', 1, 'Junior', 1900, 1, 'vigente'),
(20, '2020-06-20', '2020-06-21', 1, 'Sencilla', 900, 1, 'vigente'),
(35, '2020-06-21', '2020-06-22', 1, 'Sencilla', 900, 165, 'vigente'),
(36, '2020-06-21', '2020-06-22', 1, 'Sencilla', 900, 165, 'vigente'),
(37, '2020-06-21', '2020-06-22', 1, 'Sencilla', 900, 165, 'vigente'),
(38, '2020-06-21', '2020-06-22', 1, 'Suite', 2400, 165, 'vigente'),
(39, '2020-06-21', '2020-06-22', 1, 'Sencilla', 900, 166, 'vigente'),
(40, '2020-06-22', '2020-06-23', 1, 'Sencilla', 900, 170, 'vigente'),
(41, '2020-06-22', '2020-06-23', 1, 'Sencilla', 900, 166, 'vigente'),
(42, '2020-06-22', '2020-06-22', 1, 'Sencilla', 900, 177, 'vigente'),
(43, '2020-06-22', '2020-06-22', 1, 'Sencilla', 900, 9, 'vigente'),
(44, '2020-06-23', '2020-06-24', 1, 'Doble', 1400, 170, 'vigente'),
(45, '2020-06-23', '2020-06-24', 1, 'Doble', 1400, 170, 'vigente'),
(46, '2020-06-23', '2020-06-24', 1, 'Doble', 1400, 170, 'vigente'),
(47, '2020-06-23', '2020-06-24', 1, 'Sencilla', 900, 179, 'vigente'),
(48, '2020-06-17', '2020-06-20', 1, 'Sencilla', 900, 1, 'vigente'),
(49, '2020-06-24', '2020-06-25', 1, 'Junior', 1900, 170, 'vigente'),
(50, '2020-06-25', '2020-06-26', 1, 'Sencilla', 900, 180, 'vigente'),
(51, '2020-06-25', '2020-06-26', 1, 'Sencilla', 900, 180, 'vigente'),
(52, '2020-06-25', '2020-06-26', 1, 'Sencilla', 900, 180, 'vigente'),
(53, '2020-06-25', '2020-06-26', 1, 'Sencilla', 900, 180, 'vigente');

-- END TABLE reservaciones

