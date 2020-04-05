/*
 Navicat Premium Data Transfer

 Source Server         : AWS
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 54.162.225.248:3306
 Source Schema         : hotel

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 05/04/2020 03:45:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for clientes
-- ----------------------------
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `formaPago` varchar(45) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of clientes
-- ----------------------------
BEGIN;
INSERT INTO `clientes` VALUES (1, 'Laurel', 'Weeks', 'Integer.eu@etmalesuadafames.edu', '508-187-6433', 'Efectivo');
INSERT INTO `clientes` VALUES (2, 'Yuli', 'Tate', 'quam.quis.diam@Fuscemi.net', '490-449-3090', 'Efectivo');
INSERT INTO `clientes` VALUES (3, 'Beck', 'Mcdowell', 'cursus@cursus.co.uk', '334-350-4138', 'Debito');
INSERT INTO `clientes` VALUES (4, 'Tyler', 'Fowler', 'ligula.elit.pretium@risusodio.edu', '742-210-1729', 'Debito');
INSERT INTO `clientes` VALUES (5, 'Craig', 'Shelton', 'aliquet.libero.Integer@arcuVivamus.edu', '471-588-2338', 'Efectivo');
INSERT INTO `clientes` VALUES (6, 'Kylee', 'Moss', 'libero.Integer.in@purus.org', '775-833-1684', 'Debito');
INSERT INTO `clientes` VALUES (7, 'Imelda', 'Durham', 'Aliquam@nequeNullam.org', '937-201-1751', 'Efectivo');
INSERT INTO `clientes` VALUES (8, 'Melinda', 'Fernandez', 'sed.leo.Cras@elitEtiam.net', '968-225-4203', 'Credito');
INSERT INTO `clientes` VALUES (9, 'Cedric', 'Klein', 'ipsum@vel.org', '206-335-4141', 'Efectivo');
INSERT INTO `clientes` VALUES (10, 'Ira', 'Flowers', 'magna.Lorem@Quisque.co.uk', '961-750-4121', 'Efectivo');
INSERT INTO `clientes` VALUES (11, 'Maryam', 'Shelton', 'sollicitudin.orci.sem@laoreetposuere.com', '299-693-4208', 'Efectivo');
INSERT INTO `clientes` VALUES (12, 'Kiayada', 'Oneal', 'sollicitudin.adipiscing.ligula@acfacilisis.org', '642-742-2490', 'Debito');
INSERT INTO `clientes` VALUES (13, 'Kristen', 'Fisher', 'non.dui.nec@semutcursus.co.uk', '790-500-4529', 'Debito');
INSERT INTO `clientes` VALUES (14, 'Tatyana', 'Mercado', 'eget.massa@sodalesat.com', '926-368-7531', 'Debito');
INSERT INTO `clientes` VALUES (15, 'Damian', 'Chase', 'Aliquam.gravida@Quisquetincidunt.net', '499-218-1504', 'Debito');
INSERT INTO `clientes` VALUES (16, 'Bethany', 'Alexander', 'aliquam.iaculis.lacus@non.com', '796-978-9857', 'Credito');
INSERT INTO `clientes` VALUES (17, 'Emmanuel', 'Woodward', 'Nunc@facilisisnonbibendum.com', '523-465-1391', 'Credito');
INSERT INTO `clientes` VALUES (18, 'Honorato', 'Wallace', 'amet@egetipsum.co.uk', '788-515-0255', 'Credito');
INSERT INTO `clientes` VALUES (19, 'Yetta', 'Forbes', 'cursus@egestasascelerisque.edu', '903-149-8449', 'Credito');
INSERT INTO `clientes` VALUES (20, 'Brooke', 'Acevedo', 'fermentum.risus@vel.net', '827-784-3981', 'Efectivo');
INSERT INTO `clientes` VALUES (21, 'Sylvester', 'Hurley', 'semper.rutrum@Vestibulum.edu', '754-822-7752', 'Efectivo');
INSERT INTO `clientes` VALUES (22, 'Aphrodite', 'Buckner', 'orci@tinciduntDonec.com', '701-274-9786', 'Credito');
INSERT INTO `clientes` VALUES (23, 'Gillian', 'Curry', 'mauris.Suspendisse.aliquet@aliquet.co.uk', '455-144-4804', 'Debito');
INSERT INTO `clientes` VALUES (24, 'Molly', 'Kerr', 'dui@Cum.net', '293-856-5896', 'Debito');
INSERT INTO `clientes` VALUES (25, 'Deacon', 'Mitchell', 'arcu.eu@justo.edu', '630-661-8508', 'Credito');
INSERT INTO `clientes` VALUES (26, 'Charity', 'Guerra', 'parturient.montes@ornarelibero.edu', '583-271-0119', 'Efectivo');
INSERT INTO `clientes` VALUES (27, 'Lydia', 'Love', 'ridiculus.mus.Proin@ornare.com', '585-321-6922', 'Efectivo');
INSERT INTO `clientes` VALUES (28, 'Nomlanga', 'Patterson', 'Aliquam@Proinmi.org', '245-541-2802', 'Debito');
INSERT INTO `clientes` VALUES (29, 'Beau', 'Norris', 'metus.In@quisdiam.com', '780-734-5902', 'Efectivo');
INSERT INTO `clientes` VALUES (30, 'Winter', 'Cabrera', 'hendrerit.neque.In@aaliquet.ca', '476-984-2825', 'Credito');
INSERT INTO `clientes` VALUES (31, 'Carissa', 'Mendoza', 'amet@mattis.ca', '645-393-3731', 'Efectivo');
INSERT INTO `clientes` VALUES (32, 'Simone', 'Valdez', 'rutrum.magna.Cras@pharetra.ca', '179-608-6229', 'Credito');
INSERT INTO `clientes` VALUES (33, 'Kaseem', 'Madden', 'dolor.Donec.fringilla@nisiCumsociis.ca', '168-577-0750', 'Debito');
INSERT INTO `clientes` VALUES (34, 'Omar', 'White', 'diam.lorem@montesnasceturridiculus.edu', '409-278-7853', 'Debito');
INSERT INTO `clientes` VALUES (35, 'Regan', 'Kaufman', 'lobortis.ultrices.Vivamus@sociisnatoque.co.uk', '306-397-8544', 'Efectivo');
INSERT INTO `clientes` VALUES (36, 'Mark', 'Dillon', 'taciti.sociosqu.ad@Pellentesqueut.edu', '368-431-4172', 'Debito');
INSERT INTO `clientes` VALUES (37, 'Jack', 'Pitts', 'lacinia@arcuNuncmauris.edu', '981-156-1472', 'Credito');
INSERT INTO `clientes` VALUES (38, 'Jack', 'Vang', 'Sed@Donectempor.ca', '836-243-0001', 'Debito');
INSERT INTO `clientes` VALUES (39, 'Felicia', 'Dale', 'congue.elit@ut.ca', '314-128-7473', 'Debito');
INSERT INTO `clientes` VALUES (40, 'Duncan', 'Ayers', 'massa.lobortis.ultrices@hendrerit.com', '212-409-5061', 'Credito');
INSERT INTO `clientes` VALUES (41, 'Amela', 'Huffman', 'Fusce@sitametrisus.co.uk', '695-247-0778', 'Credito');
INSERT INTO `clientes` VALUES (42, 'Regan', 'Ortiz', 'nibh@luctusfelispurus.org', '571-572-9513', 'Credito');
INSERT INTO `clientes` VALUES (43, 'Jelani', 'York', 'vel.pede@Suspendissetristiqueneque.net', '772-422-4790', 'Efectivo');
INSERT INTO `clientes` VALUES (44, 'Claire', 'Bowman', 'In.faucibus.Morbi@enimnectempus.edu', '445-527-5577', 'Efectivo');
INSERT INTO `clientes` VALUES (45, 'Ignatius', 'Stanley', 'ultrices@natoque.net', '717-990-0940', 'Debito');
INSERT INTO `clientes` VALUES (46, 'Maile', 'Hendrix', 'quis@magna.ca', '660-664-5160', 'Debito');
INSERT INTO `clientes` VALUES (47, 'Blaze', 'Mccullough', 'auctor.Mauris.vel@iderat.net', '590-690-2485', 'Debito');
INSERT INTO `clientes` VALUES (48, 'Melvin', 'Turner', 'ac@Aliquamfringillacursus.net', '230-598-3445', 'Debito');
INSERT INTO `clientes` VALUES (49, 'Allen', 'Gould', 'Curae.Phasellus@milaciniamattis.net', '542-424-9102', 'Credito');
INSERT INTO `clientes` VALUES (50, 'Cassandra', 'Owens', 'blandit.Nam@acmattisvelit.net', '253-247-7469', 'Efectivo');
INSERT INTO `clientes` VALUES (51, 'Sybil', 'Neal', 'elit.pellentesque.a@cursuseteros.edu', '273-597-2643', 'Debito');
INSERT INTO `clientes` VALUES (52, 'Jessica', 'Hensley', 'lacus@arcuiaculis.edu', '717-398-3327', 'Efectivo');
INSERT INTO `clientes` VALUES (53, 'Hyatt', 'Chang', 'odio.tristique@sitametmetus.edu', '575-763-3418', 'Credito');
INSERT INTO `clientes` VALUES (54, 'Ezekiel', 'Molina', 'ridiculus.mus@elitsedconsequat.net', '318-990-1984', 'Credito');
INSERT INTO `clientes` VALUES (55, 'Imelda', 'Reese', 'et.netus.et@acliberonec.co.uk', '906-549-7248', 'Efectivo');
INSERT INTO `clientes` VALUES (56, 'Zahir', 'Finch', 'egestas.a.dui@Phasellus.ca', '492-657-5565', 'Efectivo');
INSERT INTO `clientes` VALUES (57, 'Selma', 'Craft', 'Aliquam.erat@lobortismaurisSuspendisse.net', '943-474-2950', 'Efectivo');
INSERT INTO `clientes` VALUES (58, 'Kenneth', 'Burton', 'Morbi.accumsan@malesuada.ca', '542-938-5949', 'Efectivo');
INSERT INTO `clientes` VALUES (59, 'Jessamine', 'Hensley', 'fermentum.arcu.Vestibulum@ametdiameu.org', '501-303-4513', 'Debito');
INSERT INTO `clientes` VALUES (60, 'Vera', 'Mendoza', 'ligula.eu.enim@euaugueporttitor.edu', '656-835-1534', 'Credito');
INSERT INTO `clientes` VALUES (61, 'Ulla', 'Kemp', 'lacus@sitamet.edu', '275-179-7801', 'Debito');
INSERT INTO `clientes` VALUES (62, 'Brynn', 'Sweeney', 'Duis.gravida@quisaccumsan.net', '610-789-4202', 'Efectivo');
INSERT INTO `clientes` VALUES (63, 'Penelope', 'Owens', 'facilisis.magna.tellus@a.org', '888-484-3762', 'Credito');
INSERT INTO `clientes` VALUES (64, 'Nyssa', 'Serrano', 'lobortis.risus@Namtempor.net', '638-336-3589', 'Debito');
INSERT INTO `clientes` VALUES (65, 'Rama', 'Vazquez', 'fermentum@luctus.ca', '897-833-4510', 'Efectivo');
INSERT INTO `clientes` VALUES (66, 'Kadeem', 'Bright', 'vel.arcu@risusvarius.co.uk', '947-856-1091', 'Efectivo');
INSERT INTO `clientes` VALUES (67, 'Berk', 'Acevedo', 'magna@Inscelerisquescelerisque.org', '663-728-6949', 'Credito');
INSERT INTO `clientes` VALUES (68, 'Neville', 'Potter', 'ac@libero.edu', '203-802-6355', 'Debito');
INSERT INTO `clientes` VALUES (69, 'Kiayada', 'Barrett', 'posuere.cubilia@Pellentesque.com', '438-121-6963', 'Efectivo');
INSERT INTO `clientes` VALUES (70, 'Ian', 'Calhoun', 'Donec@Proin.co.uk', '144-745-2117', 'Debito');
INSERT INTO `clientes` VALUES (71, 'Nayda', 'Nielsen', 'ante.Maecenas.mi@fringilla.net', '938-942-9696', 'Credito');
INSERT INTO `clientes` VALUES (72, 'Tatum', 'Silva', 'erat.semper@diameu.com', '912-438-1130', 'Credito');
INSERT INTO `clientes` VALUES (73, 'Raya', 'Decker', 'sem.elit.pharetra@elementumsem.net', '870-413-6845', 'Efectivo');
INSERT INTO `clientes` VALUES (74, 'Cullen', 'Powell', 'nunc.risus.varius@odioauctorvitae.ca', '450-833-5623', 'Debito');
INSERT INTO `clientes` VALUES (75, 'Leonard', 'Mckinney', 'Donec.consectetuer.mauris@quis.edu', '811-556-9790', 'Efectivo');
INSERT INTO `clientes` VALUES (76, 'Abbot', 'Alexander', 'cubilia.Curae@eratvolutpat.edu', '348-478-3511', 'Credito');
INSERT INTO `clientes` VALUES (77, 'Orli', 'Spence', 'mollis.non@sed.org', '999-447-9385', 'Credito');
INSERT INTO `clientes` VALUES (78, 'Thaddeus', 'Rutledge', 'torquent@at.net', '178-946-2440', 'Efectivo');
INSERT INTO `clientes` VALUES (79, 'Kyla', 'Dotson', 'eget.ipsum@semperrutrum.com', '541-549-5284', 'Credito');
INSERT INTO `clientes` VALUES (80, 'Blake', 'Garrett', 'mi@Donecfelis.co.uk', '820-503-7927', 'Credito');
INSERT INTO `clientes` VALUES (81, 'Lara', 'Mcguire', 'odio.semper@quisaccumsan.net', '128-460-1000', 'Debito');
INSERT INTO `clientes` VALUES (82, 'Pandora', 'Dickson', 'Duis.sit@loremlorem.edu', '750-881-2606', 'Debito');
INSERT INTO `clientes` VALUES (83, 'Amethyst', 'Ball', 'Etiam.gravida@anteVivamus.net', '515-388-6231', 'Credito');
INSERT INTO `clientes` VALUES (84, 'Ivana', 'Johnson', 'sociis.natoque@magnis.edu', '660-521-0820', 'Efectivo');
INSERT INTO `clientes` VALUES (85, 'Justin', 'Ware', 'eget.tincidunt.dui@tristiqueac.org', '669-318-0962', 'Debito');
INSERT INTO `clientes` VALUES (86, 'Quinlan', 'Salinas', 'a.tortor.Nunc@gravidamolestie.edu', '275-949-5328', 'Debito');
INSERT INTO `clientes` VALUES (87, 'Stone', 'Reyes', 'sollicitudin@lectusquismassa.co.uk', '574-820-5687', 'Efectivo');
INSERT INTO `clientes` VALUES (88, 'Sasha', 'Mckay', 'in.faucibus.orci@faucibus.edu', '980-479-9306', 'Credito');
INSERT INTO `clientes` VALUES (89, 'Leah', 'Walker', 'leo@Nunc.net', '143-912-3492', 'Debito');
INSERT INTO `clientes` VALUES (97, 'Dalton', 'Mcdowell', 'sed.sapien@nisl.ca', '641-353-5135', 'Credito');
COMMIT;

-- ----------------------------
-- Table structure for estancias
-- ----------------------------
DROP TABLE IF EXISTS `estancias`;
CREATE TABLE `estancias` (
  `idEstancia` int(11) NOT NULL,
  `numHabitacion` int(11) NOT NULL,
  `numAdultos` int(11) NOT NULL,
  `numNinos` int(11) NOT NULL,
  `precio` double NOT NULL,
  `fechaCheckIn` date NOT NULL,
  `fechaCheckOut` date NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idEstancia`),
  KEY `idClienteEstancia` (`idCliente`),
  KEY `numHabitacion` (`numHabitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of estancias
-- ----------------------------
BEGIN;
INSERT INTO `estancias` VALUES (1, 44, 4, 1, 2013, '2021-02-20', '2020-12-09', 27);
INSERT INTO `estancias` VALUES (2, 22, 6, 0, 5947, '2020-05-12', '2019-07-19', 78);
INSERT INTO `estancias` VALUES (3, 52, 8, 0, 2693, '2019-09-15', '2020-11-22', 3);
INSERT INTO `estancias` VALUES (4, 34, 4, 1, 7875, '2019-11-14', '2020-10-25', 20);
INSERT INTO `estancias` VALUES (5, 79, 7, 0, 7097, '2019-12-05', '2019-09-29', 86);
INSERT INTO `estancias` VALUES (6, 84, 4, 0, 6582, '2021-03-28', '2019-09-14', 53);
INSERT INTO `estancias` VALUES (7, 76, 8, 2, 2186, '2019-06-08', '2019-07-05', 62);
INSERT INTO `estancias` VALUES (8, 82, 3, 0, 2642, '2020-03-27', '2020-12-28', 35);
INSERT INTO `estancias` VALUES (9, 93, 3, 1, 6268, '2019-08-12', '2020-07-13', 15);
INSERT INTO `estancias` VALUES (10, 93, 4, 0, 4695, '2020-02-24', '2020-07-10', 32);
INSERT INTO `estancias` VALUES (11, 6, 6, 2, 9079, '2020-09-30', '2020-12-19', 6);
INSERT INTO `estancias` VALUES (12, 57, 4, 1, 9229, '2020-12-04', '2019-10-01', 7);
INSERT INTO `estancias` VALUES (13, 10, 1, 2, 2264, '2020-08-05', '2021-01-15', 44);
INSERT INTO `estancias` VALUES (14, 96, 1, 2, 4389, '2019-12-03', '2020-12-18', 79);
INSERT INTO `estancias` VALUES (15, 18, 8, 0, 7038, '2020-02-03', '2020-08-11', 6);
INSERT INTO `estancias` VALUES (16, 88, 2, 0, 9452, '2020-07-31', '2020-12-19', 16);
INSERT INTO `estancias` VALUES (17, 7, 6, 1, 6841, '2019-06-15', '2021-03-25', 61);
INSERT INTO `estancias` VALUES (18, 32, 4, 2, 6208, '2020-05-13', '2020-01-20', 61);
INSERT INTO `estancias` VALUES (19, 55, 5, 1, 9825, '2019-08-02', '2021-03-25', 83);
INSERT INTO `estancias` VALUES (20, 90, 3, 2, 5885, '2021-01-19', '2020-09-09', 98);
INSERT INTO `estancias` VALUES (21, 97, 7, 1, 4345, '2019-05-26', '2019-12-14', 21);
INSERT INTO `estancias` VALUES (22, 84, 6, 1, 8032, '2019-10-02', '2019-06-22', 78);
INSERT INTO `estancias` VALUES (23, 73, 2, 1, 9204, '2020-04-08', '2020-11-02', 8);
INSERT INTO `estancias` VALUES (24, 11, 8, 2, 9346, '2019-06-18', '2021-03-12', 18);
INSERT INTO `estancias` VALUES (25, 61, 1, 2, 6418, '2020-05-11', '2019-09-13', 95);
INSERT INTO `estancias` VALUES (26, 59, 2, 2, 3010, '2019-11-04', '2019-09-29', 9);
INSERT INTO `estancias` VALUES (27, 61, 5, 1, 4362, '2021-01-22', '2019-09-18', 71);
INSERT INTO `estancias` VALUES (28, 65, 8, 0, 8129, '2020-03-23', '2021-04-09', 31);
INSERT INTO `estancias` VALUES (29, 51, 8, 2, 9812, '2020-07-28', '2020-01-07', 53);
INSERT INTO `estancias` VALUES (30, 31, 4, 0, 8786, '2019-12-28', '2020-07-21', 13);
INSERT INTO `estancias` VALUES (31, 96, 4, 1, 9680, '2020-10-23', '2020-11-23', 46);
INSERT INTO `estancias` VALUES (32, 2, 8, 0, 6622, '2020-08-15', '2019-05-04', 44);
INSERT INTO `estancias` VALUES (33, 31, 1, 0, 8430, '2019-05-30', '2020-10-21', 5);
INSERT INTO `estancias` VALUES (34, 45, 6, 1, 7520, '2020-10-08', '2020-07-03', 34);
INSERT INTO `estancias` VALUES (35, 70, 8, 0, 4640, '2020-01-22', '2019-04-16', 35);
INSERT INTO `estancias` VALUES (36, 16, 7, 0, 9649, '2020-08-21', '2019-07-28', 87);
INSERT INTO `estancias` VALUES (37, 6, 4, 1, 2102, '2021-01-14', '2019-04-25', 52);
INSERT INTO `estancias` VALUES (38, 54, 1, 1, 5786, '2020-11-25', '2020-05-18', 22);
INSERT INTO `estancias` VALUES (39, 45, 6, 1, 7561, '2020-07-21', '2020-01-15', 29);
INSERT INTO `estancias` VALUES (40, 56, 2, 0, 2225, '2020-01-04', '2019-09-11', 27);
INSERT INTO `estancias` VALUES (41, 61, 1, 1, 5683, '2019-04-16', '2020-06-04', 2);
INSERT INTO `estancias` VALUES (42, 7, 4, 2, 5167, '2019-04-16', '2019-09-17', 45);
INSERT INTO `estancias` VALUES (43, 21, 3, 0, 7564, '2021-03-20', '2021-03-30', 45);
INSERT INTO `estancias` VALUES (44, 19, 4, 1, 6382, '2020-12-18', '2019-09-22', 12);
INSERT INTO `estancias` VALUES (45, 99, 3, 2, 5057, '2020-04-01', '2019-04-18', 94);
INSERT INTO `estancias` VALUES (46, 75, 4, 0, 4931, '2020-08-16', '2021-02-21', 41);
INSERT INTO `estancias` VALUES (47, 88, 1, 2, 3209, '2020-12-08', '2021-03-13', 76);
INSERT INTO `estancias` VALUES (48, 76, 4, 2, 8369, '2020-01-29', '2019-08-22', 53);
INSERT INTO `estancias` VALUES (49, 85, 5, 0, 6505, '2020-06-15', '2019-04-26', 28);
INSERT INTO `estancias` VALUES (50, 24, 1, 2, 7474, '2020-03-25', '2019-05-24', 46);
COMMIT;

-- ----------------------------
-- Table structure for habitaciones
-- ----------------------------
DROP TABLE IF EXISTS `habitaciones`;
CREATE TABLE `habitaciones` (
  `numHabitacion` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `numCamas` int(11) NOT NULL,
  `cupoPersonas` int(11) NOT NULL,
  `tipoHabitacion` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`numHabitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of habitaciones
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for reservaciones
-- ----------------------------
DROP TABLE IF EXISTS `reservaciones`;
CREATE TABLE `reservaciones` (
  `idReservacion` int(11) NOT NULL AUTO_INCREMENT,
  `fechaLlegada` date NOT NULL,
  `fechaSalida` date NOT NULL,
  `numAdultos` int(11) NOT NULL,
  `numNinos` int(11) NOT NULL,
  `numCamas` int(11) NOT NULL,
  `tipoHabitacion` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idReservacion`),
  KEY `IdClienteReservacion` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of reservaciones
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
