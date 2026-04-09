mysql> use db;
Database changed
mysql> create table student(vtu_number varchar(20) Primary key,name varchar(30),email varchar(50),phone varchar(15),department varchar(50));
mysql> select *from student;
+------------+-------------+----------------+------------+------------+
| vtu_number | name        | email          | phone      | department |
+------------+-------------+----------------+------------+------------+
| 1MS23CS001 | Arjun Kumar | arjun@mail.com | 9845011223 | CSE        |
| 1MS23CS002 | Sneha Rao   | sneha@mail.com | 9845022334 | IT         |
| 1MS23CS003 | Rahul Nair  | rahul@mail.com | 9845033445 | CSE        |
| 1MS23CS004 | Priya Das   | priya@mail.com | 9845044556 | ECE        |
| 1MS23CS005 | Amit Singh  | amit@mail.com  | 9845055667 | IT         |
+------------+-------------+----------------+------------+------------+
5 rows in set (0.02 sec)
mysql>
mysql> CREATE TRIGGER student_after_insert
    -> AFTER INSERT
    -> ON student
    -> FOR EACH ROW
    -> BEGIN
    ->     INSERT INTO student_log
    ->     VALUES (NEW.vtu_number, 'INSERT', NOW());
    -> END$$
Query OK, 0 rows affected (0.03 sec)

mysql> DELIMITER ;
mysql> INSERT INTO student
    -> VALUES ('1VTU23EC001', 'Charan', 'charan@gmail.com', '9876543210', 'ECE');
ERROR 1146 (42S02): Table 'db.student_log' doesn't exist
mysql> CREATE TABLE student_log (
    ->     vtu_number VARCHAR(20),
    ->     action VARCHAR(20),
    ->     action_time TIMESTAMP
    -> );
Query OK, 0 rows affected (0.08 sec)

mysql> INSERT INTO student
    -> VALUES ('1VTU23EC001', 'Charan', 'charan@gmail.com', '9876543210', 'ECE');
Query OK, 1 row affected (0.02 sec)

mysql> SELECT * FROM student_log;
+-------------+--------+---------------------+
| vtu_number  | action | action_time         |
+-------------+--------+---------------------+
| 1VTU23EC001 | INSERT | 2026-01-05 11:46:16 |
+-------------+--------+---------------------+
1 row in set (0.00 sec)
