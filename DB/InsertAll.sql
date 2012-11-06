USE RESTAURANT;
-- Задаём категории
INSERT INTO `categories` VALUES (1, 'Вне категории');
INSERT INTO `categories` VALUES (2, 'Салаты');
INSERT INTO `categories` VALUES (3, 'Горячие закуски');
INSERT INTO `categories` VALUES (4, 'Первые блюда');
INSERT INTO `categories` VALUES (5, 'Основные блюда');
INSERT INTO `categories` VALUES (6, 'Напитки');
INSERT INTO `categories` VALUES (7, 'Коктейли');
INSERT INTO `categories` VALUES (8, 'Коктейли безалкогольные');
INSERT INTO `categories` VALUES (9, 'Холодные закуски');
INSERT INTO `categories` VALUES (10, 'Десерты');

-- Задаём блюда
INSERT INTO `dishes` VALUES (1, 1, 'Летний', 390, 'C:\\images\\001.jpg', 'Салат со шпинатом и курицей', '1', '00:30:00', '175');
INSERT INTO `dishes` VALUES (2, 1, 'Свежесть', 880, 'C:\\images\\002.jpg', 'Салат из шампиньонов, свежих огурцов, феты и раковых шеек, заправленный тыквенным маслом', '1', '00:30:00', '170');
INSERT INTO `dishes` VALUES (3, 3, 'Гороховый суп с копчёностями', 490, 'C:\\images\\017.jpg', '', '1', '01:00:00', '300');
INSERT INTO `dishes` VALUES (4, 2, 'Свекольный блинчик с лососем и шпинатом', 590, 'C:\\images\\010.jpg', '', '1', '00:45:00', '200');
INSERT INTO `dishes` VALUES (5, 7, 'Травяная свежесть', 280, 'C:\\images\\100.jpg', 'Травка-муравка, конопля, боярышник', '2', '00:14:00', '260');
INSERT INTO `dishes` VALUES (6, 1, 'Свежесть', 880, 'C:\\images\\001.jpg', 'Салат из шампиньонов, свежих огурцов, феты и раковых шеек, заправленный тыквенным маслом', '1', '00:30:00', '170');
INSERT INTO `dishes` VALUES (7, 10, 'Крем-Брюле', 200, 'C:\\images\\003.jpg', 'С шоколадной присыпкой', '1', '00:10:00', '100');
INSERT INTO `dishes` VALUES (8, 9, 'Карбонара', 880, 'C:\\images\\020.jpg', 'Спагетти с мелкими кусочками гуанчиале, смешанные с соусом из яиц, сыра пармезан и пекорино романо, соли и свежемолотого черного перца', '4', '00:45:00', '300/150');
INSERT INTO `dishes` VALUES (9, 9, 'Овощная', 980, 'C:\\images\\001.jpg', 'Спагетти, болгарский перец, томаты, лук, зелень', '2', '00:45:00', '250');
INSERT INTO `dishes` VALUES (10, 1, 'Сырные изыски', 1480, 'C:\\images\\00111.jpg', 'Сыры пармезан, моцарелла, горгонзола, российский, пошехонский', '3', '00:15:00', '60/80/80/100/100');

-- Задаём пользователей
INSERT INTO `users` VALUES (1, 'admin', 'admin', 'admin', 'aaa@aaa.com', '777');
INSERT INTO `users` VALUES (2, 'bbb', 'user', 'bbb', 'bbb@bbb.bbb.com', '777');
INSERT INTO `users` VALUES (3, 'ccc', 'user', 'ccc', 'ccc.ccc@c.com', '666');
INSERT INTO `users` VALUES (4, 'ddd', 'user', 'ddd', 'ddd@aaa.com', '555');
INSERT INTO `users` VALUES (5, 'eee', 'user', 'eee', 'eee@aaa.com', '4444');
INSERT INTO `users` VALUES (6, 'fff', 'user', 'fff', 'fff@aaa.com', '333');
INSERT INTO `users` VALUES (7, 'ggg', 'user', 'ggg', 'aaa@c.com', '222');
INSERT INTO `users` VALUES (8, 'hhh', 'user', 'hhh', 'aaa@bbb.bbb.com', '111');
INSERT INTO `users` VALUES (9, 'iii', 'user', 'iii', 'aaa@aaa.com', '23123');
INSERT INTO `users` VALUES (10, 'jjj', 'user', 'jjj', 'aaa@aaa.com', '4124');
-- Задаём заказы
INSERT INTO `orderinfo` VALUES (1, 1, '2012-1-1 00:00:01', 'A');
INSERT INTO `orderinfo` VALUES (2, 1, '2012-11-10 12:20:01', 'A');
INSERT INTO `orderinfo` VALUES (3, 3, '2012-10-1 23:00:01', 'B');
INSERT INTO `orderinfo` VALUES (4, 1, '2012-5-15 05:05:01', 'B');
INSERT INTO `orderinfo` VALUES (5, 10, '2012-6-6 06:40:30', 'A');
INSERT INTO `orderinfo` VALUES (6, 1, '2012-9-10 11:11:11', 'A');
INSERT INTO `orderinfo` VALUES (7, 3, '2012-5-1 05:50:55', 'C');
INSERT INTO `orderinfo` VALUES (8, 2, '2012-1-1 00:00:01', 'A');
INSERT INTO `orderinfo` VALUES (9, 1, '2012-1-1 00:00:01', 'A');
INSERT INTO `orderinfo` VALUES (10, 5, '2012-1-1 00:00:01', 'C');
INSERT INTO `orderinfo` VALUES (17, 1, '2012-11-2 00:00:00', 'A');
INSERT INTO `orderinfo` VALUES (18, 1, '2012-11-2 00:00:00', 'A');
INSERT INTO `orderinfo` VALUES (19, 1, '2012-11-2 00:00:00', 'A');
INSERT INTO `orderinfo` VALUES (20, 1, '2012-11-2 00:00:00', 'A');
INSERT INTO `orderinfo` VALUES (22, 1, '2012-11-2 00:00:00', 'A');
-- Задаём спецификации заказов					
INSERT INTO `orderspec` VALUES (1, 1, 1, 1);
INSERT INTO `orderspec` VALUES (2, 1, 2, 1);
INSERT INTO `orderspec` VALUES (3, 1, 10, 10);
INSERT INTO `orderspec` VALUES (4, 4, 4, 4);
INSERT INTO `orderspec` VALUES (5, 1, 5, 1);
INSERT INTO `orderspec` VALUES (6, 2, 7, 1);
INSERT INTO `orderspec` VALUES (7, 3, 6, 1);
INSERT INTO `orderspec` VALUES (8, 5, 4, 4);
INSERT INTO `orderspec` VALUES (9, 6, 2, 100);
INSERT INTO `orderspec` VALUES (10, 10, 1, 10);
INSERT INTO `orderspec` VALUES (11, 20, 4, 1);
INSERT INTO `orderspec` VALUES (13, 22, 6, 1);			