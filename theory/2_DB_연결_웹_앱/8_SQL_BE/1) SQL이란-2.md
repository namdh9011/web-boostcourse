# 1) SQL이란?-2

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

**데이터를 저장하는 공간 테이블(Table)**

- 마이크로소프트의 엑셀(Excel)을 실행하면 표가 나옵니다. 이러한 표에 각종 값을 저장할 수 있습니다.
- 데이터베이스도 엑셀의 표와 유사한 테이블을 가질 수 있습니다.
- 엑셀과 다른 점은 데이터베이스를 생성해도 테이블은 존재하지 않는다는 것입니다.
- 테이블을 사용하려면 테이블을 생성하는 SQL을 사용해야 합니다.
- 그리고, 테이블에 값을 저장하려면 저장하기 위한 SQL을 사용해야 합니다.



**테이블(table)의 구성요소**

![1_7](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/1_7.png)

- **테이블(table)의 구성요소**

- 테이블 : RDBMS의 기본적 저장구조 한 개 이상의 column과 0개 이상의 row로 구성합니다.
- 열(Column) : 테이블 상에서의 단일 종류의 데이터를 나타냄. 특정 데이터 타입 및 크기를 가지고 있습니다.
- 행(Row) : Column들의 값의 조합. 레코드라고 불림. 기본키(PK)에 의해 구분. 기본키는 중복을 허용하지 않으며 없어서는 안 됩니다.
- Field : Row와 Column의 교차점으로 Field는 데이터를 포함할 수 있고 없을 때는 NULL 값을 가지고 있습니다.

​           

**현재 데이터베이스에 존재하는 테이블 목록 확인하기**

Database를 선택 후, Database의 전체 테이블 목록을 출력합니다.

```mysql
mysql> show tables;

Empty set (0.02 sec)
```

“empty set” 은  데이터베이스에 어떤 테이블도 아직 생성되지 않았다는 것을 알려줍니다.



**SQL 연습을 위한 테이블 생성과 값의 저장**

examples.sql을 다운로드 합니다. [링크 바로가기](https://github.com/connect-boostcamp/boostcourse_fullstack_web/tree/master/part2)

터미널에서 examples.sql이 있는 폴더로 이동한 후, 다음과 같이 명령을 수행합니다.

명령을 수행한 후 암호를 입력합니다.

```mysql
mysql   -uconnectuser  -p  connectdb   <  examples.sql
```

examples.sql에는 연습을 위한 테이블 생성문과 해당 테이블에 값을 저장하는 입력문이 존재합니다.

```mysql
mysql –uconnectuser -p  connectdb
```

위의 명령으로 connectdb에 접속한 후 다음과 같이 명령을 수행합니다.

```mysql
mysql> show tables
```

위의 명령은 접속한 db의 테이블 목록을 보는 명령입니다.

![1_8](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/1_8.png)

- **SQL연습을 위한 테이블 생성과 값의 저장**

**테이블 구조를 확인하기 위한 DESCRIBE 명령**

table 구조를 확인하기 위해, DESCRIBE 명령을 사용할 수 있습니다.

짧게 DESC라고 사용해도 됩니다.

EMPLOYEE테이블의 구조를 확인해 봅시다.

```mysql
mysql> desc EMPLOYEE;
```

![1_9](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/1_9.png)

 

------

**생각해보기**

하나의 DBMS에는 여러 개의 데이터베이스를 생성하고, 각각의 데이터베이스를 사용할 수 있는 사용자를 추가할 수 있습니다.

이번 시간에 만든 connectdb와 connectuser 말고, 추가로 데이터베이스를 생성하고, 생성한 데이터베이스를 사용한 사용자를 추가하고 로그인해보세요.



 

------

**참고 자료**

[ ![img](http://files.idg.co.kr/ciokr/img/avatar/article/2017/[mm\]/yesss@korea.com/0_analyze_inspect_examine_find_research_data_charts_graphs_magnifying_glass_thinkstock_493572720-100724455-large.jpg?type=mfullfill_199_148)**[참고링크] 데이터베이스의 언어··· SQL이란 무엇인가**http://www.ciokorea.com](http://www.ciokorea.com/print/35385)

[**[참고링크\] 13.1.11 CREATE DATABASE Syntax**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/create-database.html)

[**[참고링크\] 13.7.1.4 GRANT Syntax**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/grant.html)

[**[참고링크\] 13.2.9 SELECT Syntax**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/select.html)

*** examples.sql은 아래의 zip파일에서 받아주세요.**

- **examples(sql)** [ZIP](https://www.boostcourse.org/downloadFile/fileDownload?attachmentId=304661&autoClose=true)