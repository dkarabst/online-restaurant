-- ������ ���� ����
CREATE DATABASE RESTAURANT CHARACTER SET = 'utf8';
-- �������� ���� ����
USE RESTAURANT;
-- ������ ������������ �� ����� ������� ��� ����� ����,
-- �������� �������� ������ ������
-- username: root
-- password: (��� ������!!!!)
GRANT ALL PRIVILEGES
ON RESTAURANT.*
TO food@localhost
IDENTIFIED BY 'food'
WITH GRANT OPTION;
GRANT ALL PRIVILEGES
ON RESTAURANT.*
TO food@"%"
IDENTIFIED BY 'food'
WITH GRANT OPTION;
-- ������ ������ �������
USE RESTAURANT;
CREATE TABLE CATEGORIES (
	CAT_ID			INT		UNSIGNED AUTO_INCREMENT	PRIMARY KEY,
	CAT_NAME		VARCHAR(50),
	CAT_PHOTO		VARCHAR(50)
);
CREATE TABLE DISHES (
	DISH_ID				INT		UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	CATEGORY_CAT_ID		INT,
	DISH_NAME			VARCHAR(50),
	DISH_PRICE			INT,
	DISH_PHOTO			VARCHAR(255),
	DISH_DESCR			VARCHAR(255),
	DISH_AVAIL			CHAR,
	DISH_PREP_TIME		TIME,
	DISH_WEIGHT			INT
);
CREATE TABLE ORDERINFO (
	OINFO_ID		INT		UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	USER_USER_ID	INT,
	OINFO_DATE		DATETIME,
	OINFO_STATUS	CHAR
);
CREATE TABLE ORDERSPEC (
	OSPEC_ID			INT		UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	ORDERINFO_OINFO_ID	INT,
	DISH_DISH_ID		INT,
	OSPEC_QUANTITY		INT
);
CREATE TABLE USERS (
	USER_ID			INT		UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	USER_NAME		VARCHAR(50),
	USER_PASSWORD	VARCHAR(50),	
	USER_EMAIL		VARCHAR(50),
	USER_ENABLE		INT,
	USER_PHONE		VARCHAR(50),
	USER_ROLE		VARCHAR(50)	
);
CREATE TABLE ATTACHMENTS (
	ATTACHMENTS_ID	INT		UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	USER_USER_ID	INT,
	DISH_DISH_ID	INT,
	DTYPE			VARCHAR(31),
	NAME			VARCHAR(255),
	PATH			VARCHAR(255)
);

