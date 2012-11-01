USE RESTAURANT;
-- ����� ���������
INSERT INTO CATEGORIES (CAT_NAME) VALUES ('������');
INSERT INTO CATEGORIES (CAT_NAME) VALUES ('������� �������');
INSERT INTO CATEGORIES (CAT_NAME) VALUES ('������ �����');
INSERT INTO CATEGORIES (CAT_NAME) VALUES ('�������� �����');
INSERT INTO CATEGORIES (CAT_NAME) VALUES ('�������');
INSERT INTO CATEGORIES (CAT_NAME) VALUES ('��������');
INSERT INTO CATEGORIES (CAT_NAME) VALUES ('�������� ��������������');
INSERT INTO CATEGORIES (CAT_NAME) VALUES ('�������� �������');
INSERT INTO CATEGORIES (CAT_NAME) VALUES ('�����');
INSERT INTO CATEGORIES (CAT_NAME) VALUES ('�������');
-- ����� �����
INSERT INTO DISHES (CATEGORY_CAT_ID, DISH_NAME, DISH_PRICE, DISH_PHOTO,
					DISH_DESCR, 
					DISH_AVAIL, DISH_PREP_TIME, DISH_WEIGHT)
	VALUES
		(1,'������', 390, 'C:\\images\\001.jpg',
			'����� �� �������� � �������',
			1, '00:30:00', '175'),
		(1,'��������', 880, 'C:\\images\\002.jpg',
			'����� �� �����������, ������ �������, ���� � ������� ����, ������������ ��������� ������',
			1, '00:30:00', '170'),
		(3,'��������� ��� � ������������', 490, 'C:\\images\\017.jpg',
			'',
			1, '01:00:00', 300),
		(2,'���������� ������� � ������� � ��������', 590, 'C:\\images\\010.jpg',
			'',
			1, '00:45:00', '200'),
		(7,'�������� ��������', 280, 'C:\\images\\100.jpg',
			'������-�������, �������, ���������',
			2, '00:14:00', '260'),
		(1,'��������', 880, 'C:\\images\\001.jpg',
			'����� �� �����������, ������ �������, ���� � ������� ����, ������������ ��������� ������',
			1, '00:30:00', '170'),
		(10,'����-�����', 200, 'C:\\images\\003.jpg',
			'� ���������� ���������',
			1, '00:10:00', '100'),
		(9,'���������', 880, 'C:\\images\\020.jpg',
			'�������� � ������� ��������� ���������, ��������� � ������ �� ���, ���� �������� � �������� ������, ���� � ������������� ������� �����',
			4, '00:45:00', '300/150'),
		(9,'�������', 980, 'C:\\images\\001.jpg',
			'��������, ���������� �����, ������, ���, ������',
			2, '00:45:00', '250'),
		(1,'������ ������', 1480, 'C:\\images\\00111.jpg',
			'���� ��������, ���������, ����������, ����������, �����������',
			3, '00:15:00', '60/80/80/100/100');
-- ����� �������������
INSERT INTO USERS (USER_NAME, USER_EMAIL)
	VALUES 
		('aaa', 'aaa@aaa.com'),
		('bbb', 'bbb@bbb.bbb.com'),
		('ccc', 'ccc.ccc@c.com'),
		('ddd', 'ddd@aaa.com'),
		('eee', 'eee@aaa.com'),
		('fff', 'fff@aaa.com'),
		('ggg', 'aaa@c.com'),
		('hhh', 'aaa@bbb.bbb.com'),
		('iii', 'aaa@aaa.com'),
		('jjj', 'aaa@aaa.com');
-- ����� ������
INSERT INTO ORDERINFO (OINFO_USER_ID, OINFO_DATE, OINFO_STATUS)
	VALUES
		(1, '2012-01-01 00:00:01', 'A'),
		(1, '2012-11-10 12:20:01', 'A'),
		(3, '2012-10-01 23:00:01', 'B'),
		(1, '2012-05-15 05:05:01', 'B'),
		(10,'2012-06-06 06:40:30', 'A'),
		(1, '2012-09-10 11:11:11', 'A'),
		(3, '2012-05-01 05:50:55', 'C'),
		(2, '2012-01-01 00:00:01', 'A'),
		(1, '2012-01-01 00:00:01', 'A'),
		(5, '2012-01-01 00:00:01', 'C');
-- ����� ������������ �������					
INSERT INTO ORDERSPEC (OSPEC_OINFO_ID, OSPEC_DISH_ID, OSPEC_QUANTITY)
	VALUES
		(1, 1, 1),
		(1, 2, 1),
		(1, 10, 10),
		(4, 4, 4),
		(1, 5, 1),
		(2, 7, 1),
		(3, 6, 1),
		(5, 4, 4),
		(6, 2, 100),
		(10, 1, 10);			