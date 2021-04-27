# 5) Tomcat 다운받기 및 설치하기

**들어가기 전에**

word 파일을 열어서 내용을 확인하기 위해서는 ms office의 word 프로그램이나 viewer가 필요합니다.

웹 어플리케이션을 실행하기 위해서도 필요한 것이 있습니다.

그것이 WAS이고, 이번 학습에서 설치할 Apache Tomcat은 WAS 중 하나입니다.

웹 어플리케이션을 실행하기 위해서 필요하므로 설치해야 합니다.

 

 

------

**학습 목표**

1. WAS 가 무엇인지 설명할 수 있습니다.
2. Apache Tomcat을 다운로드 받아 설치할 수 있습니다.

 

 

**핵심 개념**

- Apache Tomcat
- WAS(Web application server)



 

------

**학습하기**

**Apache Tomcat이란?**

아파치 톰캣(Apache Tomcat)은 아파치 소프트웨어 재단(Apache Software Foundation, ASF)에서 개발한 세계에서 가장 많이 사용되는 WAS(Web Application Server)입니다.

컴퓨터에 운영체제를 설치해야만 컴퓨터를 사용할 수 있는 것처럼, 자바를 이용하여 작성된 웹 어플리케이션은 WAS가 있어야만 실행할 수 있습니다.

이때 가장 많이 사용되는 WAS가 아파치 톰캣이라고 말할 수 있습니다.

아파치 톰캣은 오픈소스 소프트웨어로써 누구나 무료로 사용할 수 있습니다.

참고로 Tomcat은 '수고양이'를 뜻합니다. 톰과 제리의 톰이 생각나기도 합니다.

 

**Apache Tomcat 다운로드 및 설치**

아파치 톰캣은 [http://tomcat.apache.org](http://tomcat.apache.org/) 에서 다운로드 받을 수 있습니다.

[http://tomcat.apache.org](http://tomcat.apache.org/) 로 이동한 후 "Tomcat 8"을 선택합니다.

2017년 12월 기준 최신 버전은 "Tomcat 9"입니다만, 이번 수업에서는 "Tomcat 8"을 다운로드 하도록 하겠습니다.

Tomcat 8버전은 JDK 7이상에서 동작하며 Servlet Spec 3.1을 지원합니다.

Tomcat 9버전은 JDK 8이상에서 동작하며 Servlet Spec 4.0을 지원합니다.

좌측 "Download"메뉴 아래에 있는 "Tomcat 8"링크를 클릭합니다.

![5_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/4_%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD_%EC%84%A4%EC%A0%95_BE/image/5_1.png)

- 

  8.5.24 버전의 zip파일을 다운로드 합니다. (MAC OS 사용자는 tar.gz 파일을 다운로드 합니다.) 다운로드 받은 파일을 압축 해제합니다.

![5_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/4_%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD_%EC%84%A4%EC%A0%95_BE/image/5_2.png)

- 

  압축을 해제하면 다음과 같은 파일과 폴더들이 있는 것을 확인할 수 있습니다. 

![5_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/4_%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD_%EC%84%A4%EC%A0%95_BE/image/5_3.png)

- **Apach Tomcat 실행**

  아파치 톰캣 설치 폴더 아래에 있는 bin폴더를 보면 확장자가 bat인 윈도우용 배치파일과 확장자가 sh인 쉘스크립트(shell script)파일이 있는 것을 확인할 수 있습니다. 쉘스크립트 파일은 linux나 맥 운영체제에서 실행 가능한 파일입니다. 윈도우 사용자라면 startup.bat파일을 더블 클릭하여 실행하고, 맥 운영체제나 linux를 사용하는 사용자는 startup.sh을 더블 클릭하여 실행합니다. 

**MAC OS 사용자의 경우**

\1. 다운로드 받은  tar.gz 확장자의 톰캣파일의 압축을 해제합니다.

관리의 편의를 위해 압축해제 한 폴더를 ~/ 경로의 apps 폴더로 옮깁니다.

```markup
mkdir ~/apps
cd ~/apps
mv ~/Downloads/apache-tomcat-8.5.24 ~/apps/
```

\2. 쉘확장자를 가진 파일의 실행권한을 줍니다.

```markup
chmod +x ./bin/*.sh
```

\3. 제대로 실행 권한이 생성 되었는지 확인해 보기 위해 **ls -al** 로 해당 폴더의 파일 목록을 봅니다.
해당 파일명 앞에 **-rwxr-xr-x@** 와 같이 권한 마지막 부분에 **x**가 보인다면 **실행권한이 부여 된 것**입니다.

```markup
ls -al

-rw-r-----@  1 username  staff   34894 Mar  5 22:11 bootstrap.jar
-rw-r-----@  1 username  staff    1664 Mar  5 22:13 catalina-tasks.xml
-rw-r-----@  1 username  staff   15815 Mar  5 22:11 catalina.bat
-rwxr-x--x@  1 username  staff   23387 Mar  5 22:11 catalina.sh
-rw-r-----@  1 username  staff  207125 Mar  5 22:11 commons-daemon-native.tar.gz
-rw-r-----@  1 username  staff   25145 Mar  5 22:11 commons-daemon.jar
-rw-r-----@  1 username  staff    2040 Mar  5 22:11 configtest.bat
-rwxr-x---@  1 username  staff    1922 Mar  5 22:11 configtest.sh
-rwxr-x---@  1 username  staff    8509 Mar  5 22:11 daemon.sh
-rw-r-----@  1 username  staff    2091 Mar  5 22:11 digest.bat
-rwxr-x---@  1 username  staff    1965 Mar  5 22:11 digest.sh
-rw-r-----@  1 username  staff    3574 Mar  5 22:11 setclasspath.bat
-rwxr-x---@  1 username  staff    3680 Mar  5 22:11 setclasspath.sh
-rw-r-----@  1 username  staff    2020 Mar  5 22:11 shutdown.bat
-rwxr-x---@  1 username  staff    1902 Mar  5 22:11 shutdown.sh
-rw-r-----@  1 username  staff    2022 Mar  5 22:11 startup.bat
-rwxr-x---@  1 username  staff    1904 Mar  5 22:11 startup.sh
-rw-r-----@  1 username  staff   49335 Mar  5 22:11 tomcat-juli.jar
-rw-r-----@  1 username  staff  405109 Mar  5 22:11 tomcat-native.tar.gz
-rw-r-----@  1 username  staff    4574 Mar  5 22:11 tool-wrapper.bat
-rwxr-x---@  1 username  staff    5483 Mar  5 22:11 tool-wrapper.sh
-rw-r-----@  1 username  staff    2026 Mar  5 22:11 version.bat
-rwxr-x---@  1 username  staff    1908 Mar  5 22:11 version.sh
```


\4. 터미널에서 다음과 같이 명령어를 실행해 줍니다.

```markup
./bin/startup.sh 
```

 

\5. 이 때 아래와 같은 오류가 나오면, 다음의 명령어 **chmod +x bin/catalina.sh** 를 실행해 줍니다.

```markup
Cannot find bin/catalina.sh
The file is absent or does not have execute permission
This file is needed to run this program
```

다음과 같이 해당 파일을 생성하고 실행권한도 생성해 줍니다.

```markup
chmod +x bin/catalina.sh
```

\6. 그리고 다시 다음의 명령어로 톰캣을 실행해 줍니다.

```markup
./bin/startup.sh 
```

\7. 톰캣이 시작되었다는 메시지는 출력되지만 8080포트로 접근이 되지 않을 때는 root 권한으로 서버를 시작해 줍니다.

```markup
sudo ./bin/startup.sh 
```

\- 쉘 파일의 실행 권한을 주고 서버를 실행 했음에도 http://localhost:8080/ 로 접근이 되지 않을 때 sudo 명령어를 통해 서버를 시작해야 합니다.

![5_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/4_%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD_%EC%84%A4%EC%A0%95_BE/image/5_4.png)

- 

  콘솔창이 열리면서 다음과 같이 실행되는 것을 알 수 있습니다. tomcat은 기본적으로 8080포트로 실행됩니다. 실행된 화면을 보면 "http-nio-8080"이라는 문자열을 볼 수 있는데 8080으로 실행되는 것을 표현하고 있는 것입니다. tomcat설정파일을 수정함으로써 실행되는 포트를 바꿀 수 있습니다. 앞에서도 설명했지만, 컴퓨터를 구분하기 위해서 사용되는 것이 도메인이나 ip이고, 컴퓨터에 설치되어 있는 여러개의 소프트웨어 서버를 구분하기 위해 사용되는 값이 포트(port)라고 하였습니다.

![5_5](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/4_%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD_%EC%84%A4%EC%A0%95_BE/image/5_5.png)

- 

  웹 브라우저를 실행한 후 주소창에 http://localhost:8080 나 http://127.0.0.1:8080 으로 입력해 보도록 하겠습니다. localhost는 현재 사용중인 컴퓨터를 나타내는 도메인(domain)주소이고 127.0.0.1은 현재 사용 중인 컴퓨터를 나타내는 ip주소입니다. 웹 브라우저로 현재 컴퓨터에서 8080포트로 동작하는 서버에 접속하라는 의미입니다. Tomcat이 기본으로 제공하는 웹 사이트가 보여지는 것을 확인할 수 있습니다.

![5_6](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/4_%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD_%EC%84%A4%EC%A0%95_BE/image/5_6.png)

- 

  아파치 톰켓 설치 폴더 아래의 bin폴더에 있는 shutdown.bat파일이나 shutdown.sh파일을 더블클릭하여 실행하면 아파치 톰캣이 종료됩니다. 혹은, 실행 중인 창을 닫아도 아파치 톰캣은 종료됩니다. 아파치 톰켓이 종료 된 후 http://localhost:8080으로 다시 접속해보면, 아래의 그림과 같이 오류 화면이 보여지는 것을 확인할 수 있습니다.

![5_7](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/4_%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD_%EC%84%A4%EC%A0%95_BE/image/5_7.png)

- 

  이번 학습에서는 아파치 톰캣을 설치하고, 실행해 보았습니다.

 

 

------

**생각해보기**

1. Apache Tomcat 외에 WAS는 어떤 것 들이 있을까요? 
2. WAS가 없으면 웹 어플리케이션은 왜 실행할 수 없을까요? 



 

------

**참고 자료**

[**[참고링크\] Apache Tomcat**http://tomcat.apache.org](http://tomcat.apache.org/)