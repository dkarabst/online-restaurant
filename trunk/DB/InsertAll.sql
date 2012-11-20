USE RESTAURANT ;
-- ����� �����
INSERT INTO `DISHES`   VALUES (1,1,'����� �� ���� ����� ����',20,'C:\\Java_EE\\photodb\\1_Salads\\01_Mushroom_salad.jpg','����� �� ���� ����� ����','1','00:30:00',175);
INSERT INTO `DISHES`   VALUES (2,1,'����� �� ������ ������',25,'C:\\Java_EE\\photodb\\1_Salads\\02_Greek_salad.jpg','����� �� ������ ������','1','00:30:00',170);
INSERT INTO `DISHES`   VALUES (3,1,'����� ���� � ����������',28,'C:\\Java_EE\\files\\photodb\\1_Salads\\03_Cesa�_salad.jpg','����� ���� � ����������','1','01:00:00',300);
INSERT INTO `DISHES`   VALUES (4,1,'����� ������',34,'C:\\Java_EE\\photodb\\1_Salads\\04_Summer_salad.jpg','����� ������','1','00:45:00',200);
INSERT INTO `DISHES`   VALUES (5,1,'����� ������',42,'C:\\Java_EE\\photodb\\1_Salads\\05_Mosaic_salad.jpg','����� ������','2','00:14:00',260);
INSERT INTO `DISHES`   VALUES (6,1,'����� � ���������� � ����������',18,'C:\\Java_EE\\photodb\\1_Salads\\06_Fruit_salad.jpg','����� � ���������� � ����������','1','00:30:00',170);
INSERT INTO `DISHES`   VALUES (7,1,'����� � ��������� � ��������� �����',13,'C:\\Java_EE\\photodb\\1_Salads\\07_Meat_salad.jpg','����� � ��������� � ��������� �����','1','00:10:00',100);
INSERT INTO `DISHES`   VALUES (8,1,'����� �������',25,'C:\\Java_EE\\photodb\\1_Salads\\08_Calamary_salad.jpg','����� �������','4','00:45:00',300);
INSERT INTO `DISHES`   VALUES (9,1,'����� ������ � ������� ����',27,'C:\\Java_EE\\photodb\\1_Salads\\09_Georgian_salad.jpg','����� ������ � ������� ����','2','00:45:00',250);
INSERT INTO `DISHES`   VALUES (10,1,'����� ������ � ����������',38,'C:\\Java_EE\\photodb\\1_Salads\\10_Simple_salad.jpg','����� ������ � ����������','3','00:15:00',60);

-- ����� ���������
INSERT INTO `categories`   VALUES (1,'������','images/DISHES/cat01/Category page_salads.jpg');
INSERT INTO `categories`   VALUES (2,'����','/images/DISHES/cat02/Category page_sushi.jpg');
INSERT INTO `categories`   VALUES (3,'�����','/images/DISHES/cat03/Category page_rolls.jpg');
INSERT INTO `categories`   VALUES (4,'������ �����','/images/DISHES/cat04/Category page_fishdish.jpg');
INSERT INTO `categories`   VALUES (5,'������� �������','/images/DISHES/cat05/Category page_Hot appetizers.jpg');
INSERT INTO `categories`   VALUES (6,'������ �����','/images/DISHES/cat06/Category page_First course.jpg');
INSERT INTO `categories`   VALUES (7,'������� ��������������','/images/DISHES/cat07/Category page_Non alcohol drinks.jpg');
INSERT INTO `categories`   VALUES (8,'��������','/images/DISHES/cat08/Category page_Coctails.jpg');
INSERT INTO `categories`   VALUES (9,'�������� �������','/images/DISHES/cat09/Category page_Cold.jpg');
INSERT INTO `categories`   VALUES (10,'�������','/images/DISHES/cat10/Category page_Deserts.jpg');

-- ����� �������������
INSERT INTO `users` VALUES (1,  'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin@aaa.com', 1, '111-111', 'ROLE_ADMIN');
INSERT INTO `users` VALUES (2,  'root',  '63a9f0ea7bb98050796b649e85481845', 'root@bbb.bbb.com', 1, '222-222', 'ROLE_ADMIN');
INSERT INTO `users` VALUES (3,  'user1', '24c9e15e52afc47c225b757e7bee1f9d', 'user1.user1@c.com', 1, '322-223', 'ROLE_USER');
INSERT INTO `users` VALUES (4,  'user2', '7e58d63b60197ceb55a1c487989a3720', 'u2@aaa.com', 1, '322-223', 'ROLE_USER');
INSERT INTO `users` VALUES (5,  'user3', '92877af70a45fd6a2ed7fe81e1236b78', 'eee@aaa.com', 1, '322-223', 'ROLE_USER');
INSERT INTO `users` VALUES (6,  'user4', '3f02ebe3d7929b091e3d8ccfde2f3bc6', 'fff@aaa.com', 1, '322-223', 'ROLE_USER');
INSERT INTO `users` VALUES (7,  'user5', '0a791842f52a0acfbb3a783378c066b8', 'aaa@c.com', 1, '322-223', 'ROLE_USER');
INSERT INTO `users` VALUES (8,  'user6', 'affec3b64cf90492377a8114c86fc093', 'aaa@bbb.bbb.com', 1, '322-223', 'ROLE_USER');
INSERT INTO `users` VALUES (9,  'user7', '3e0469fb134991f8f75a2760e409c6ed', 'aaa@aaa.com', 1, '322-223', 'ROLE_USER');
INSERT INTO `users` VALUES (10, 'user8', '7668f673d5669995175ef91b5d171945', 'aaa@aaa.com', 1, '322-223', 'ROLE_USER');

-- ����� ������
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

-- ����� ������������ �������					
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

-- ����� ����������
INSERT INTO `attachments` VALUE (1, 1, 1, '', '',  '');		
INSERT INTO `attachments` VALUE (2, 1, 1, '', '',  '');		
INSERT INTO `attachments` VALUE (3, 2, 1, '', '',  '');		
INSERT INTO `attachments` VALUE (4, 3, 2, '', '',  '');		
INSERT INTO `attachments` VALUE (5, 3, 3, '', '',  '');		
INSERT INTO `attachments` VALUE (6, 6, 4, '', '',  '');		
INSERT INTO `attachments` VALUE (7, 6, 1, '', '',  '');		
INSERT INTO `attachments` VALUE (8, 8, 4, '', '',  '');		
INSERT INTO `attachments` VALUE (9, 8, 6, '',  '', '');		
INSERT INTO `attachments` VALUE (10, 10, 5, '', '','');		
