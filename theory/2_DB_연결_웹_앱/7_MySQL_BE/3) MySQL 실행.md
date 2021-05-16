# 3) MySQL 실행

**들어가기 전에**

MySQL서버를 설치했다면, 설치된 서버를 실행할 수 있어야 할 것입니다.

또한, 운영체제가 켜질 때 자동으로 실행될 수 있다면 편리할 것입니다.

이번 시간에는 MySQL서버를 실행하는 방법에 대해 배워보도록 하겠습니다.



 

------

**학습 목표**

1. MySQL서버를 실행할 수 있다.
2. MySQL서버를 서비스 혹은 데몬 형태로 실행할 수 있다.

 

------

**핵심 개념**

- Service
- 데몬 (Daemon)



 

------

**학습하기**

**MySQL 서버 실행 방법**

이번 시간엔 MySQL서버를 실행하는 방법에 대해 알아보도록 하겠습니다.

 

**1. MS Window 10**

![3_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/7_MySQL_BE/image/3_1.png)

- 

  윈도우 검색 버튼에서 서비스라고 입력하면 서비스(데스크톱 앱)이라는 프로그램이 보입니다. 해당 프로그램을 선택하세요.

![3_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/7_MySQL_BE/image/3_2.png)

- 

  위와 같이 MySQL57 이라는 이름으로 서비스가 실행된 것을 알 수 있습니다. 참고로 MySQL이 설치될 때 유심히 봤다면 MySQL57이라는 서비스 이름으로 서비스가 실행된다는 메시지가 보입니다. 시작 유형은 자동으로 되어 있기 때문에, 윈도우가 실행될 때 자동으로 서버가 서비스 형태로 실행됩니다. 나중에, MySQL이 동작하지 않는다면 해당 서비스에서 “실행 중”이라고 표시되는지 확인해주세요.

**2. Mac**

HomeBrew를 이용해서 MySQL을 설치했다면, 실행과 중지가 상당히 간편합니다.

환경 변수 설정 등이 모두 자동으로 이뤄지기 때문입니다.



**MySQL 서버 실행하기**

mysql서버를 실행하려면 터미널을 실행해 주신 후 아래와 같이 명령을 실행해 주세요.

```markup
 mysql.server start
```

위의 명령을 내리면 아래와 같은 메시지가 실행됩니다.



```markup
Starting MySQL
. SUCCESS!
```

 

**MySQL을 데몬으로 실행하기**

운영체제의 백그라운드로 MySQL이 계속 실행되도록 하고 싶다면 HomeBrew가 제공하는 명령을 이용하면 됩니다.

HomeBrew로 다음과 같이 mysql 데몬을 실행합니다.

아래와 같이 명령을 수행하면 간단하게 mysql을 데몬형태로 실행할 수 있습니다.

```markup
brew services start mysql
```

 서비스 재시작도 HomeBrew가 제공하는 명령을 이용하면 됩니다.

아래와 같이 명령을 수행하세요.

```markup
brew services restart mysql
```

 데몬으로 실행되고 있는 프로그램들이 궁금하다면 아래와 같이 명령을 실행하면 됩니다.

```markup
brew services list
```

이상으로 윈도우와 맥에서 MySQL서버를 실행하는 방법을 알아보았습니다.



 

------

**생각해보기**

MySQL 프로세스가 운영체제에 실행되고 있는지 확인하려면 어떻게 해야 할까요?

자신이 사용하는 운영체제에 맞게 고민해보세요.



 

------

**참고 자료**

[**[참고링크\] Installing and Upgrading MySQL**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/installing.html)