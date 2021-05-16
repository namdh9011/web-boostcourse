# 4) MySQL 종료

**들어가기 전에**

이번 시간에는 실행되고 있는 MySQL서버를 종료하는 방법에 대해 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. MySQL서버를 종료할 수 있습니다.

 

 

------

**핵심 개념**

- service
- 데몬(Daemon)

 

 

------

**학습하기**

**MySQL 종료**

이번 시간에는 MySQL서버를 종료하는 방법에 대해서 알아보도록 하겠습니다.

 

**1. 윈도우에서 MySQL서버 종료하기**

윈도우에서 MySQL서버를 종료하는 것은 간단합니다.

![4_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/7_MySQL_BE/image/4_1.png)

- 

  서비스 목록에서 MySQL57을 선택한 후 우측버튼을 클릭합니다. 우측버튼을 클릭했다면 속성버튼을 클릭합니다.

![4_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/7_MySQL_BE/image/4_2.png)

- 

  속성 창에서 “중지”버튼을 클릭하면 MySQL서버는 정지됩니다. 만약, 윈도우가 실행될 때 자동으로 실행되길 원하지 않는다면, 시작 유형 “자동”을 “수동”으로 변경한 후 “확인”버튼을 클릭하면 됩니다. 이 경우에는 위의 유형 창에서 “시작”버튼을 매번 눌러줘야 MySQL서버가 실행됩니다.

**2. 맥에서의 MySQL 종료하기**

```markup
mysql.server start
```

터미널에서 위의 명령으로 서버를 실행했다면

```markup
mysql.server stop
```

위의 명령으로 서버를 종료할 수 있습니다.

```markup
Shutting down MySQL

.. SUCCESS!
```

MySQL이 종료되면서 위와 같은 메시지가 보여집니다.

만약 HomeBrew를 이용해서 다음과 같이 데몬으로 실행했다면

```markup
brew services start mysql
```

다음과 같은 명령으로 데몬 형태로 실행되고 있는 MySQL을 종료할 수 있습니다.

```markup
brew services stop mysql
```

이상으로 윈도우와 맥에서 MySQL 서버를 중지하는 방법에 대해 알아보았습니다.



 

------

**생각해보기**

DBMS에는 많은 사람들이 동시에 접속해서 사용한다고 했습니다.

사용자가 사용하는 도중에 MySQL서버가 종료된다면 어떤 일이 벌어질까요?

상상해보세요.



 

------

**참고 자료**

[**[참고링크\] Installing and Upgrading MySQL**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/installing.html)