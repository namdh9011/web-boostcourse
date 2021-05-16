# 2) DML(select, insert, update, delete)-2

**들어가기 전에**

이번 시간에는 DBMS에 값을 저장, 수정, 삭제, 조회하는 방법에 대해 배워보도록 하겠습니다.

 

 

------

**학습 목표**

1. insert문을 수행할 수 있다.
2. update문을 수행할 수 있다.
3. delete문을 수행할 수 있다.
4. select문을 수행할 수 있다.

 

 

------

**핵심 개념**

- select
- insert
- update
- delete

 

 

------

**학습하기**

**SELECT 구문 예제(특정 행 검색- where절)**



![2_12](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_12.png)

- **SELECT 구문 예제(특정 행 검색- where절)**

- 산술비교 연산자

예제 : employee 테이블에서 고용일(hiredate)이 1981년 이전의 사원이름과 고용일을 출력하시오.

```mysql
select name, hiredate from employee where hiredate < '1981-01-01';
```

![2_13](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_13.png)

- **select 구문 예제(특정 행 검색-where절)**

- 논리연산자

예제 : employee 테이블에서 부서번호가 30인 사원이름과 부서번호를 출력하시오.

```mysql
select name, deptno from employee where deptno = 30;
```

![2_14](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_14.png)

- **select 구문 예제(특정 행 검색-where절)-2**

- IN 키워드

예제 : employee 테이블에서 부서번호가 10또는 30인 사원이름과 부서번호를 출력하시오.

```mysql
select name, deptno from employee where deptno in (10, 30);
```

![2_15](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_15.png)

- **select 구문 예제(특정 행 검색-where절)-3**

- LIKE 키워드
- 와일드 카드를 사용하여 특정 문자를 포함한 값에 대한 조건을 처리
- % 는 0에서부터 여러 개의 문자열을 나타냄
- _ 는 단 하나의 문자를 나타내는 와일드 카드

예제 : employee 테이블에서 이름에 'A'가 포함된 사원의 이름(name)과 직업(job)을 출력하시오.

```mysql
select name, job from employee where name like '%A%';
```

![2_16](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/8_SQL_BE/image/2_16.png)

- **select 구문 예제(특정 행 검색-where절)-4**

**SELECT 구문 예제(함수의 사용)**

- UCASE, UPPER

```markup
mysql> SELECT UPPER('SEoul'), UCASE('seOUL');
 +-----------------+-----------------+
  | UPPER('SEoul') | UCASE('seOUL') |
  +-----------------+-----------------+
  | SEOUL            | SEOUL            |
  +-----------------+-----------------+
```

from 다음에 테이블이 없을 경우에는 테이블에서 조회하는 것이 아닙니다.

- LCASE, LOWER

```markup
mysql> SELECT LOWER('SEoul'), LCASE('seOUL');
 +-----------------+-----------------+
  | LOWER('SEoul') | LCASE('seOUL') |
  +-----------------+-----------------+
  | seoul              | seoul             |
  +-----------------+-----------------+
```

- substring

```markup
mysql> SELECT SUBSTRING('Happy Day',3,2);
  +-----------------+-----------------+
  | SUBSTRING('Happy Day',3,2)      |
  +-----------------+-----------------+
  | pp                                       |
  +-----------------+-----------------+
```

- LPAD, RPAD

```markup
mysql> SELECT LPAD('hi',5,'?'),LPAD('joe',7,'*');
  +------------------+-------------------+
  | LPAD('hi',5,'?')    | LPAD('joe',7,'*')   |
  +------------------+-------------------+
  | ???hi               |           ****joe    |
  +------------------+-------------------+
```

- TRIM, LTRIM, RTRIM

```markup
mysql> SELECT LTRIM(' hello '), RTRIM(' hello ');
+-------------------------------------+
| LTRIM(' hello ') | RTRIM(' hello ')  |
+-------------------------------------+
| 'hello '            | '  hello‘            |
+-------------------------------------+
mysql> SELECT TRIM(' hi '),TRIM(BOTH 'x' FROM 'xxxhixxx');
+----------------+-----------------------------------+
| TRIM(' hi ')     | TRIM(BOTH 'x' FROM 'xxxhixxx') |
+----------------+-----------------------------------+
| hi                 | hi                                       |
+----------------+-----------------------------------+
```

- ABS(x) : x의 절대값을 구합니다.

```markup
mysql> SELECT ABS(2), ABS(-2);
+-----------+------------+ 
| ABS(2)     | ABS(-2)    | 
+-----------+------------+ 
| 2            | 2             | 
+-----------+------------+
```

- MOD(n,m) % : n을 m으로 나눈 나머지 값을 출력합니다.

```markup
mysql> SELECT MOD(234,10), 253 % 7, MOD(29,9);
+----------------+------------+-------------+ 
| MOD(234,10)  | 253 % 7   | MOD(29,9) | 
+----------------+------------+-------------+ 
|      4.             |       1      |      2         | 
+----------------+------------+-------------+
```



**SELECT 구문(함수의 사용)**

- FLOOR(x) : x보다 크지 않은 가장 큰 정수를 반환합니다. BIGINT로 자동 변환합니다.
- CEILING(x) : x보다 작지 않은 가장 작은 정수를 반환합니다.
- ROUND(x) : x에 가장 근접한 정수를 반환합니다.
- POW(x,y) POWER(x,y) : x의 y 제곱 승을 반환합니다.
- GREATEST(x,y,...) : 가장 큰 값을 반환합니다.
- LEAST(x,y,...) : 가장 작은 값을 반환합니다.
- CURDATE(),CURRENT_DATE : 오늘 날짜를 YYYY-MM-DD나 YYYYMMDD 형식으로 반환합니다.
- CURTIME(), CURRENT_TIME : 현재 시각을 HH:MM:SS나 HHMMSS 형식으로 반환합니다.
- NOW(), SYSDATE() , CURRENT_TIMESTAMP : 오늘 현시각을 YYYY-MM-DD HH:MM:SS나 YYYYMMDDHHMMSS 형식으로 반환합니다. 
- DATE_FORMAT(date,format) : 입력된 date를 format 형식으로 반환합니다.
- PERIOD_DIFF(p1,p2) : YYMM이나 YYYYMM으로 표기되는 p1과 p2의 차이 개월을 반환합니다.

**참고 자료**

[**[참고링크\] 13.2.9 SELECT Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/select.html)

[**[참고링크\] 13.2.5 INSERT Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/insert.html)

[**[참고링크\] 13.2.11 UPDATE Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/update.html)

[**[참고링크\] 13.2.2 DELETE Statement**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/delete.html)