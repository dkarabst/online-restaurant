Run "CreateDB.bat" from the command line

DB owner: 		'food'
his password:	'food'

NOTE: I suppose that
1. "mysql.exe" is added to the PATH
(if not, copy all files to its directory and run "CreateDB.bat" from there)
2. Admin name for the MySQL server is "root"
3. Admin has no password
If 2 & 3 are not true, please edit "CreateDB.bat". It should be

mysql -u "your Admin name" -p "your Admin password" < CreateAll.sql
mysql -u "your Admin name" -p "your Admin password" < InsertAll.sql