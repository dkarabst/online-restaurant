USE RESTAURANT;
-- ����� ���������
INSERT INTO `categories` VALUES (1, '��� ���������');
INSERT INTO `categories` VALUES (2, '������');
INSERT INTO `categories` VALUES (3, '������� �������');
INSERT INTO `categories` VALUES (4, '������ �����');
INSERT INTO `categories` VALUES (5, '�������� �����');
INSERT INTO `categories` VALUES (6, '�������');
INSERT INTO `categories` VALUES (7, '��������');
INSERT INTO `categories` VALUES (8, '�������� ��������������');
INSERT INTO `categories` VALUES (9, '�������� �������');
INSERT INTO `categories` VALUES (10, '�������');

-- ����� �����
INSERT INTO `dishes` VALUES (1, 1, '������', 390, 'C:\\images\\001.jpg', '����� �� �������� � �������', '1', '00:30:00', '175');
INSERT INTO `dishes` VALUES (2, 1, '��������', 880, 'C:\\images\\002.jpg', '����� �� �����������, ������ �������, ���� � ������� ����, ������������ ��������� ������', '1', '00:30:00', '170');
INSERT INTO `dishes` VALUES (3, 3, '��������� ��� � ������������', 490, 'C:\\images\\017.jpg', '', '1', '01:00:00', '300');
INSERT INTO `dishes` VALUES (4, 2, '���������� ������� � ������� � ��������', 590, 'C:\\images\\010.jpg', '', '1', '00:45:00', '200');
INSERT INTO `dishes` VALUES (5, 7, '�������� ��������', 280, 'C:\\images\\100.jpg', '������-�������, �������, ���������', '2', '00:14:00', '260');
INSERT INTO `dishes` VALUES (6, 1, '��������', 880, 'C:\\images\\001.jpg', '����� �� �����������, ������ �������, ���� � ������� ����, ������������ ��������� ������', '1', '00:30:00', '170');
INSERT INTO `dishes` VALUES (7, 10, '����-�����', 200, 'C:\\images\\003.jpg', '� ���������� ���������', '1', '00:10:00', '100');
INSERT INTO `dishes` VALUES (8, 9, '���������', 880, 'C:\\images\\020.jpg', '�������� � ������� ��������� ���������, ��������� � ������ �� ���, ���� �������� � �������� ������, ���� � ������������� ������� �����', '4', '00:45:00', '300/150');
INSERT INTO `dishes` VALUES (9, 9, '�������', 980, 'C:\\images\\001.jpg', '��������, ���������� �����, ������, ���, ������', '2', '00:45:00', '250');
INSERT INTO `dishes` VALUES (10, 1, '������ ������', 1480, 'C:\\images\\00111.jpg', '���� ��������, ���������, ����������, ����������, �����������', '3', '00:15:00', '60/80/80/100/100');

-- ����� �������������
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