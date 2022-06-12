set foreign_key_checks = 0;

--insert into user (id, firstName, lastName, email, password, roles) values
--(1, 'a', 'b', 'a', 'a12', '{"USER"}');

insert into car_model (id, name, year_of_production) values
(1,'Mercedes-Benz', '1957'),
(2,'Mercedes-Benz', '1958'),
(3,'Mercedes-Benz', '1959'),
(4,'Mercedes-Benz', '1960'),
(5,'Mercedes-Benz', '1961'),
(6,'Mercedes-Benz', '1962'),
(7,'BMW', '1957'),
(8,'BMW', '1958'),
(9,'BMW', '1959'),
(10,'BMW', '1960'),
(11,'BMW', '1961'),
(12,'BMW', '1962'),
(13,'Ford', '1957'),
(14,'Ford', '1958'),
(15,'Ford', '1959'),
(16,'Ford', '1960'),
(17,'Ford', '1961'),
(18,'Ford', '1962'),
(19,'Fiat', '1957'),
(20,'Fiat', '1958'),
(21,'Fiat', '1959'),
(22,'Fiat', '1960'),
(23,'Fiat', '1961'),
(24,'Fiat', '1962'),
(25,'Volvo', '1957'),
(26,'Volvo', '1958'),
(27,'Volvo', '1959'),
(28,'Volvo', '1960'),
(29,'Volvo', '1961'),
(30,'Volvo', '1962'),
(31,'Saab', '1957'),
(32,'Saab', '1958'),
(33,'Saab', '1959'),
(34,'Saab', '1960'),
(35,'Saab', '1961'),
(36,'Saab', '1962'),
(37,'Opel', '1957'),
(38,'Opel', '1958'),
(39,'Opel', '1959'),
(40,'Opel', '1960'),
(41,'Opel', '1961'),
(42,'Opel', '1962'),
(43,'Chevrolet', '1957'),
(44,'Chevrolet', '1958'),
(45,'Chevrolet', '1959'),
(46,'Chevrolet', '1960'),
(47,'Chevrolet', '1961'),
(48,'Chevrolet', '1962'),
(49,'Porsche', '1957'),
(50,'Porsche', '1958'),
(51,'Porsche', '1959'),
(52,'Porsche', '1960'),
(53,'Porsche', '1961'),
(54,'Porsche', '1962'),
(55,'Peugeot', '1957'),
(56,'Peugeot', '1958'),
(57,'Peugeot', '1959'),
(58,'Peugeot', '1960'),
(59,'Peugeot', '1961'),
(60,'Peugeot', '1962'),
(61,'Renault', '1957'),
(62,'Renault', '1958'),
(63,'Renault', '1959'),
(64,'Renault', '1960'),
(65,'Renault', '1961'),
(66,'Renault', '1962'),
(67,'Dacia', '1957'),
(68,'Dacia', '1958'),
(69,'Dacia', '1959'),
(70,'Dacia', '1960'),
(71,'Dacia', '1961'),
(72,'Dacia', '1962'),
(73,'Citroen', '1957'),
(74,'Citroen', '1958'),
(75,'Citroen', '1959'),
(76,'Citroen', '1960'),
(77,'Citroen', '1961'),
(78,'Citroen', '1962');

insert into car_part (id, name, price, quantity) values
(1,'Engine', '100', '100'),
(2,'Engine', '200', '123'),
(3,'Engine', '300', '123'),
(4,'Engine', '400', '123'),
(5,'Engine', '500', '123'),
(6,'Engine', '600', '123'),
(7,'Engine', '700', '123'),
(8,'Engine', '800', '123'),
(9,'Engine', '900', '123'),
(10,'Engine', '1000', '247'),
(11,'Engine', '1100', '247'),
(12,'Engine', '1200', '247'),
(13,'Engine', '1300', '247'),
(14,'Engine', '1400', '247'),
(15,'Engine', '1500', '247'),
(16,'Engine', '1600', '247'),
(17,'Engine', '1700', '247'),
(18,'Engine', '1800', '247'),
(19,'Engine', '1900', '247'),
(20,'Engine', '2000', '247'),
(21,'Engine', '2100', '247'),
(22,'Engine', '2200', '247'),
(23,'Engine', '2300', '247'),
(24,'Engine', '2400', '247'),
(25,'Engine', '2500', '247'),
(26,'Engine', '2600', '247'),
(27,'Engine', '2700', '247'),
(28,'Engine', '2800', '252'),
(29,'Engine', '2900', '252'),
(30,'Engine', '3000', '252'),
(31,'Engine', '3100', '252'),
(32,'Engine', '3200', '252'),
(33,'Engine', '3300', '252'),
(34,'Engine', '3400', '252'),
(35,'Engine', '3500', '252'),
(36,'Engine', '3600', '252'),
(37,'Engine', '3700', '252'),
(38,'Engine', '3800', '252'),
(39,'Engine', '3900', '252'),
(40,'Engine', '4000', '252'),
(41,'Battery', '100', '252'),
(42,'Battery', '200', '252'),
(43,'Battery', '300', '252'),
(44,'Battery', '400', '252'),
(45,'Battery', '500', '252'),
(46,'Battery', '600', '252'),
(47,'Battery', '700', '252'),
(48,'Battery', '800', '252'),
(49,'Battery', '900', '161'),
(50,'Battery', '1000', '321'),
(51,'Battery', '1100', '321'),
(52,'Battery', '1200', '321'),
(53,'Battery', '1300', '321'),
(54,'Battery', '1400', '321'),
(55,'Battery', '1500', '321'),
(56,'Battery', '1600', '321'),
(57,'Battery', '1700', '321'),
(58,'Battery', '1800', '321'),
(59,'Battery', '1900', '321'),
(60,'Battery', '2000', '321'),
(61,'Brake', '100', '252'),
(62,'Brake', '200', '252'),
(63,'Brake', '300', '252'),
(64,'Brake', '400', '252'),
(65,'Brake', '500', '252'),
(66,'Brake', '600', '252'),
(67,'Brake', '700', '252'),
(68,'Brake', '800', '252'),
(69,'Brake', '900', '161'),
(70,'Brake', '1000', '321'),
(71,'Brake', '1100', '321'),
(72,'Brake', '1200', '321'),
(73,'Brake', '1300', '321'),
(74,'Brake', '1400', '321'),
(75,'Brake', '1500', '321'),
(76,'Brake', '1600', '321'),
(77,'Brake', '1700', '321'),
(78,'Brake', '1800', '321'),
(79,'Brake', '1900', '321'),
(80,'Brake', '2000', '321'),
(81,'Brake', '2100', '321'),
(82,'Brake', '2200', '321'),
(83,'Brake', '2300', '321'),
(84,'Brake', '2400', '321'),
(85,'Brake', '2500', '321'),
(86,'Brake', '2600', '321'),
(87,'Brake', '2700', '321'),
(88,'Brake', '2800', '321'),
(89,'Brake', '2900', '321'),
(90,'Brake', '3000', '321'),
(91,'Brake', '3100', '321'),
(92,'Wheel', '100', '252'),
(93,'Wheel', '200', '252'),
(94,'Wheel', '300', '252'),
(95,'Wheel', '400', '252'),
(96,'Wheel', '500', '252'),
(97,'Wheel', '600', '252'),
(98,'Wheel', '700', '252'),
(99,'Wheel', '800', '252'),
(100,'Wheel', '900', '161'),
(101,'Wheel', '1000', '321'),
(102,'Wheel', '1100', '321'),
(103,'Wheel', '1200', '321'),
(104,'Wheel', '1300', '321'),
(105,'Wheel', '1400', '321'),
(106,'Wheel', '1500', '321'),
(107,'Wheel', '1600', '321'),
(108,'Wheel', '1700', '321'),
(109,'Wheel', '1800', '321'),
(110,'Wheel', '1900', '321'),
(111,'Wheel', '2000', '321'),
(112,'Suspension', '100', '252'),
(113,'Suspension', '200', '252'),
(114,'Suspension', '300', '252'),
(115,'Suspension', '400', '252'),
(116,'Suspension', '500', '252'),
(117,'Suspension', '600', '252'),
(118,'Suspension', '700', '252'),
(119,'Suspension', '800', '252'),
(120,'Suspension', '900', '161'),
(121,'Suspension', '1000', '321'),
(122,'Suspension', '1100', '321'),
(123,'Suspension', '1200', '321'),
(124,'Suspension', '1300', '321'),
(125,'Suspension', '1400', '321'),
(126,'Suspension', '1500', '321'),
(127,'Suspension', '1600', '321'),
(128,'Suspension', '1700', '321'),
(129,'Suspension', '1800', '321'),
(130,'Suspension', '1900', '321'),
(131,'Suspension', '2000', '321'),
(132,'Suspension', '2100', '321'),
(133,'Suspension', '2200', '321'),
(134,'Suspension', '2300', '321'),
(135,'Suspension', '2400', '321'),
(136,'Suspension', '2500', '321'),
(137,'Suspension', '2600', '321'),
(138,'Suspension', '2700', '321'),
(139,'Suspension', '2800', '321'),
(140,'Suspension', '2900', '321'),
(141,'Suspension', '3000', '321'),
(142,'Suspension', '3100', '321'),
(143,'Suspension', '3200', '321'),
(144,'Suspension', '3300', '321'),
(145,'Suspension', '3400', '321'),
(146,'Suspension', '3500', '321'),
(147,'Suspension', '3600', '321'),
(148,'Suspension', '3700', '321'),
(149,'Suspension', '3800', '321'),
(150,'Suspension', '3900', '321'),
(151,'Suspension', '4000', '321'),
(152,'Suspension', '4100', '321'),
(153,'Suspension', '4200', '321'),
(154,'Suspension', '4300', '321'),
(155,'Suspension', '4400', '321'),
(156,'Suspension', '4500', '321'),
(157,'Suspension', '4600', '321'),
(158,'Suspension', '4700', '321'),
(159,'Suspension', '4800', '321'),
(160,'Suspension', '4900', '321'),
(161,'Suspension', '5000', '321'),
(162,'Suspension', '5100', '321'),
(163,'Suspension', '5200', '321'),
(164,'Suspension', '5300', '321'),
(165,'Suspension', '5400', '321'),
(166,'Suspension', '5500', '321'),
(167,'Suspension', '5600', '321'),
(168,'Suspension', '5700', '321'),
(169,'Suspension', '5800', '321'),
(170,'Suspension', '5900', '321'),
(171,'Suspension', '6000', '321'),
(172,'Suspension', '6100', '321'),
(173,'Suspension', '6200', '321'),
(174,'Suspension', '6300', '321'),
(175,'Suspension', '6400', '321'),
(176,'Suspension', '6500', '321'),
(177,'Suspension', '6600', '321'),
(178,'Suspension', '6700', '321'),
(179,'Suspension', '6800', '321'),
(180,'Suspension', '6900', '321'),
(181,'Suspension', '7000', '321'),
(182,'Suspension', '7100', '321'),
(183,'Suspension', '7200', '321'),
(184,'Suspension', '7300', '321'),
(185,'Suspension', '7400', '321'),
(186,'Suspension', '7500', '321'),
(187,'Suspension', '7600', '321'),
(188,'Suspension', '7700', '321'),
(189,'Suspension', '7800', '321');

insert into car_part_car_model (car_part_id, car_model_id) values
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10),
(11,11),
(12,12),
(13,13),
(14,14),
(15,15),
(16,16),
(17,17),
(18,18),
(19,19),
(20,20),
(21,21),
(22,22),
(23,23),
(24,24),
(25,25),
(26,26),
(27,27),
(28,28),
(29,29),
(30,30),
(31,31),
(32,32),
(33,33),
(34,34),
(35,35),
(36,36),
(37,37),
(38,38),
(39,39),
(40,40),
(41,41),
(42,42),
(43,43),
(44,44),
(45,45),
(46,46),
(47,47),
(48,48),
(49,49),
(50,50),
(51,51),
(52,52),
(53,53),
(54,54),
(55,55),
(56,56),
(57,57),
(58,58),
(59,59),
(60,60),
(61,61),
(62,62),
(63,63),
(64,64),
(65,65),
(66,66),
(67,67),
(68,68),
(69,69),
(70,70),
(71,71),
(72,72),
(73,73),
(74,74),
(75,75),
(76,76),
(77,77),
(78,78),
(79,78),
(80,77),
(81,76),
(82,75),
(83,74),
(84,73),
(85,72),
(86,71),
(87,70),
(88,69),
(89,68),
(90,67),
(91,66),
(92,65),
(93,64),
(94,63),
(95,62),
(96,61),
(97,60),
(98,59),
(99,58),
(100,57),
(101,56),
(102,55),
(103,54),
(104,53),
(105,52),
(106,51),
(107,50),
(108,49),
(109,48),
(110,47),
(111,46),
(112,45),
(113,44),
(114,43),
(115,42),
(116,41),
(117,40),
(118,39),
(119,38),
(120,37),
(121,36),
(122,35),
(123,34),
(124,33),
(125,32),
(126,31),
(127,30),
(128,29),
(129,28),
(130,27),
(131,26),
(132,25),
(133,24),
(134,23),
(135,22),
(136,21),
(137,20),
(138,19),
(139,18),
(140,17),
(141,16),
(142,15),
(143,14),
(144,13),
(145,12),
(146,11),
(147,10),
(148,9),
(149,8),
(150,7),
(151,6),
(152,5),
(153,4),
(154,3),
(155,2),
(156,1),
(157,1),
(158,2),
(159,3),
(160,4),
(161,5),
(162,6),
(163,7),
(164,8),
(165,9),
(166,10),
(167,11),
(168,12),
(169,13),
(170,14),
(171,15),
(172,16),
(173,17),
(174,18),
(175,19),
(176,20),
(177,21),
(178,22),
(179,23),
(180,24),
(181,25),
(182,26),
(183,27),
(184,28),
(185,29),
(186,30),
(187,31),
(188,32),
(189,33);

set foreign_key_checks = 1;
