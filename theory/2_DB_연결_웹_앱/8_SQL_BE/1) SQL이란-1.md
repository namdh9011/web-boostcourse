# 1) SQL이란?-1

**들어가기 전에**

사람과 사람이 대화하기 위해서는 언어가 필요합니다.

DBMS에게 명령을 내릴 때도 특별한 명령이 필요합니다.

이 명령을 SQL이라고 합니다.

이번 시간엔 SQL에 대한 개념을 알아보고, 직접 데이터베이스 사용자와 데이터베이스를 생성해보도록 하겠습니다.



 

------

**학습 목표**

1. SQL이 무엇인지 이해한다.
2. MySQL에서 Database를 생성할 수 있다.
3. MySQL에서 Database를 이용하는 계정을 생성하고, 권한을 부여할 수 있다.
4. 생성한 Database에 sample데이터를 추가할 수 있다.



 

------

**핵심 개념**

- create database
- grant
- flush privileges
- select

 

 

------

**학습하기**

**SQL(Structured Query Language)**

- SQL은 데이터를 보다 쉽게 검색하고 추가, 삭제, 수정 같은 조작을 할 수 있도록 고안된 컴퓨터 언어입니다.
- 관계형 데이터베이스에서 데이터를 조작하고 쿼리하는 표준 수단입니다.
- DML (Data Manipulation Language): 데이터를 조작하기 위해 사용합니다.
  INSERT, UPDATE, DELETE, SELECT 등이 여기에 해당합니다.
- DDL (Data Definition Language): 데이터베이스의 스키마를 정의하거나 조작하기 위해 사용합니다.
  CREATE, DROP, ALTER 등이 여기에 해당합니다.
- DCL (Data Control Language) : 데이터를 제어하는 언어입니다.
  권한을 관리하고, 테이터의 보안, 무결성 등을 정의합니다.
  GRANT, REVOKE 등이 여기에 해당합니다.

 

**Database 생성하기**

콘솔에서 다음과 같이 명령을 실행합니다.

MySQL 관리자 계정인 root로 데이터베이스 관리 시스템에 접속하겠다는 것입니다.

```mysql
mysql –uroot  -p
```

window 사용자는 설치 시에 입력했던 암호를 입력합니다.

맥 사용자는 암호가 없으니 그냥 엔터를 입력하면 됩니다.

MySQL DBMS에 접속하면 “mysql>” 프롬프트가 보입니다.

![1_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/1_1.png)

- **Database 생성하기**

관리자 계정으로 MySQL에 접속했다면, 다음과 같은 명령으로 데이터베이스를 생성합니다.

```mysql
 mysql> create database DB이름;
```

우리는 다음과 같은 명령을 실행하여 DB이름을 “connectdb＂로 생성하도록 하겠습니다.

```mysql
mysql> create database connectdb;
```

![1_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/1_2.png)

- **Database 생성하기2**

**Database 사용자 생성과 권한 주기**

- Database를 생성했다면, 해당 데이터베이스를 사용하는 계정을 생성해야 합니다.
- 또한, 해당 계정이 데이터베이스를 이용할 수 있는 권한을 줘야 합니다.
- 아래와 같은 명령을 이용해서 사용자 생성과 권한을 줄 수 있습니다.
- db이름 뒤의 * 는 모든 권한을 의미한다.
- @’%’는 어떤 클라이언트에서든 접근 가능하다는 의미이고, @’localhost’는 해당 컴퓨터에서만 접근 가능하다는 의미입니다.
- flush privileges는 DBMS에게 적용을 하라는 의미입니다.
- 해당 명령을 반드시 실행해줘야 합니다.

```mysql
grant all privileges on db이름.* to 계정이름@'%' identified by ＇암호’;
grant all privileges on db이름.* to 계정이름@'localhost' identified by ＇암호’;
flush privileges;
```

- 사용자 계정이름은 'connectuser', 암호는 'connect123!@#', 해당 사용자가 사용하는 데이터베이스는 'connectdb'로 계정을 생성하려면 다음과 같이 명령을 수행합니다.

```mysql
grant all privileges on connectdb.* to connectuser@'%' identified by 'connect123!@#';

grant all privileges on connectdb.* to connectuser@'localhost' identified by 'connect123!@#';

flush privileges;
```
**노트**
- MySQL 8.0버전의 경우
```mysql
create user 'connectuser'@'localhost' identified by 'connect123!@#';
create user 'connectuser'@'%' identified by 'connect123!@#';
grant all privileges on connectdb.* to 'connectuser'@'localhost';
grant all privileges on connectdb.* to 'connectuser'@'%';
flush privileges;
```


![1_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/1_3.png)

- **실행한 모습**

**생성한 Database에 접속하기**

아래와 같이 명령을 실행하여 원하는 데이터베이스에 접속할 수 있습니다.

```mysql
mysql –h호스트명 –uDB계정명 –p 데이터베이스이름
```

db이름이 connectdb, db계정이 connectuser, 암호가 connect123!@# 일 경우 콘솔창에서 다음과 같이 입력합니다.

```mysql
mysql –h127.0.0.1 –uconnectuser –p connectdb [enter]
```

![1_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/1_4.png)

- **다음과 같이 프롬프트가 보이면 성공**

**MySQL 연결끊기**

프롬프트에서 quit혹은 exit라고 입력합니다.

```mysql
mysql> QUIT
mysql> exit
```

![1_5](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/1_5.png)

- **다음과 같이 Bye라고 나오면 연결 끊기 성공**

**MySQL 버전과 현재 날짜 구하기**

```mysql
mysql> SELECT VERSION(), CURRENT_DATE;
+-----------+--------------+
| VERSION() | CURRENT_DATE |
+-----------+--------------+
| 5.1.67    | 2013-01-05   |
+-----------+--------------+
1 row in set (0.00 sec)
```

프롬프트에서는 SQL을 입력합니다.

SQL은 semicolon (;)으로 끝납니다.

SQL은 쿼리(Query)라고 읽습니다.

쿼리는 DBMS에게 명령을 내릴 때 사용하는 문장이라고 생각하면 쉽습니다.

SELECT는 어떤 내용을 조회할 때 사용하는 키워드입니다.

MySQL은 쿼리에 해당하는 결과의 전체 row를 출력하고 마지막에 전체 row 수와 쿼리실행에 걸린 시간을 표시합니다.

 

**키워드는 대소문자를 구별하지 않는다.**

다음 쿼리들은 모두 같습니다.

```mysql
mysql> SELECT VERSION(), CURRENT_DATE;
mysql> select version(), current_date;
mysql> SeLeCt vErSiOn(), current_DATE;
```

 

**쿼리를 이용해서 계산식의 결과도 구할 수 있다.**

 함수 및 수식 사용 예제

```mysql
mysql> SELECT SIN(PI()/4), (4+1)*5;
+-------------+---------+
| SIN(PI()/4) | (4+1)*5 |
+-------------+---------+
|    0.707107 |      25 |
+-------------+---------+
```

 

**여러 문장을 한 줄에 연속으로 붙여서 실행가능하다.**

각 문장에 semicolon(;)만 붙혀 주면 됩니다.

```mysql
mysql> SELECT VERSION(); SELECT NOW();
+--------------+
| VERSION()    |
+--------------+
| 3.22.20a-log |
+--------------+
+---------------------+
| NOW()               |
+---------------------+
| 2004 00:15:33 |
+---------------------+
```

**
**

**하나의 SQL은 여러 줄로 입력가능하다.**

MySQL은 문장의 끝을 라인으로 구분하는 것이 아니라 semicolon(;)으로 구분하기 때문에 여러 줄에 거쳐 문장을 쓰는 것도 가능합니다.

```mysql
mysql> SELECT
    -> USER()
    -> ,
    -> CURRENT_DATE;
+--------------------+--------------+
| USER()             | CURRENT_DATE |
+--------------------+--------------+
| joesmith@localhost | 1999-03-18   |
+--------------------+--------------+
```

 

**SQL을 입력하는 도중에 취소할 수 있다.**

긴 쿼리를 작성하다가 중간에 취소해야 하는 경우에는 즉시 \c를 붙혀주면 됩니다.

```mysql
mysql> SELECT

    -> USER()

    -> \c

mysql>
```

 

**DBMS에 존재하는 데이터베이스 확인하기**

작업하기 위한 데이터베이스를 선택하기 위해서는 어떤 데이터베이스가 존재하는지 알아보아야 합니다.

현재 서버에 존재하는 데이터베이스를 찾아보기 위해서 SHOW statement을 사용합니다.

```mysql
mysql> show databases;
+-----------------------+
| Database               |
+-----------------------+
| information_schema |
| connectdb              |
+-----------------------+
2 rows in set (0.00 sec)
```

 

 

**사용중인 데이터베이스 전환하기**

Database을 선택하기 위해, “use” command 사용합니다.

```mysql
mysql> use mydb;
```

데이터베이스를 전환하려면, 이미 데이터베이스가 존재해야 하며 현재 접속 중인 계정이 해당 데이터베이스를 사용할 수 있는 권한이 있어야 합니다.

**참고**

mysql 버전 8에서는 사용자생성및 권한주는 부분이 아래와 같이 변경되었습니다. 설치한 mysql 버전을 확인 하고, 알맞게 사용하세요. **참고로 설치시에 "Use Lagacy Password Encryption" 방식으로 설치했을때에 해당합니다. (이렇게 설정을 해야지만 MySQL 5.x버전에서 사용하던 인증방식과 호환이 됩니다.)** 만약, SHA 256기반의 암호화를 사용해야 한다면 'Use Strong Password Encryption for Authentication'을 선택하면 됩니다. 하지만, 이렇게 되면 새 버전(8.x)에서 제공하는 프로그램들만 서버에 접근이 가능하기 때문에 이전에 하던 모든 프로그램을 업그레이드 해야합니다. JDBC Driver도 8.x에 맞는 버전을 사용해야 합니다.

 

mysql -u root -p 

위와 같이 root 계정으로 접속을 합니다. 암호는 설치시 입력한 암호를 사용합니다.

CREATE DATABASE connectdb;

CREATE USER connectuser@localhost IDENTIFIED BY 'connect123!@#';

GRANT ALL PRIVILEGES ON connectdb.* TO 'connectuser'@'localhost';

FLUSH PRIVILEGES:

 

![1_6](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/1_6.png)



------

**참고 자료**

[**데이터베이스의 언어··· SQL이란 무엇인가**https://www.ciokorea.com](https://www.ciokorea.com/news/35385)

[**[참고링크\] 13.1.11 CREATE DATABASE Syntax**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/create-database.html)

[**[참고링크\] 13.7.1.4 GRANT Syntax**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/grant.html)

[**[참고링크\] 13.2.9 SELECT Syntax**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/select.html)

*** examples.sql은 아래의 zip파일에서 받아주세요.**

- **examples(sql)** [ZIP](https://www.boostcourse.org/downloadFile/fileDownload?attachmentId=304661&autoClose=true)