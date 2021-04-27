# 1) JDK 다운받기 및 설치하기

**들어가기 전에**

JAVA언어를 이용하여 개발하기 위해서는 JDK(Java SE Development Kit)가 컴퓨터에 설치되고 환경설정이 알맞게 설정되어 있어야 합니다.

이번 학습에서는 JDK를 운영체제별로 설치해보도록 하겠습니다.



 

------

**학습 목표**

1. JDK를 운영체제 별로 설치하는 방법에 대하여 알아봅시다.

 

 

------

**핵심 개념**

- JDK
- JRE





------

**학습하기**

JAVA언어를 작성된 프로그램을 실행하기 위해선 JRE(Java SE Runtime Environment)가 필요합니다.

JAVA언어를 사용하는 개발자가 아니라 JAVA언어로 만들어진 프로그램을 실행하는 사용자라면 JRE만 컴퓨터에 설치하면 됩니다.

보통 사용자 입장에서 JAVA를 설치한다는 것은 JRE를 설치하는 것을 말합니다.

JAVA언어를 사용하는 개발자는 JAVA언어로 작성된 소스(Source)를 컴파일하고 관리할 필요가 있습니다.

이때 사용되는 도구를 JDK(Java SE Development Kit)라고 말합니다.

JDK안에는 JRE도 포함되어 있습니다.

컴파일한 결과를 실행하기 위해서는 JRE가 필요하기 때문입니다.



**JDK 다운로드 및 설치**

JDK는 Oracle사이트에서 무료로 다운로드하여 설치할 수 있습니다.

 

**1. window용 설치**

브라우저로 다음의 URL을 입력하여 이동합니다.

http://www.oracle.com/technetwork/java/index.html

[![img](https://cphinf.pstatic.net/mooc/20180101_52/1514804992562oUaWq_PNG/01.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  위의 그림과 같이 화면이 보여지면, "Java SE"를 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180101_258/15148050252486e6q4_PNG/02.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  JDK 최신버전은 9입니다. 그런데, 현재 가장 많이 사용되는 버전은 8입니다. 본 과정에서는 JDK8을 사용하도록 하겠습니다. 위의 그림과 같이 스크롤을 내려 "Java SE OOO/OOOO" 부분에 있는 "JDK Download" 버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180101_191/1514805044190jSJL4_PNG/03.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  JDK를 다운로드 받으려면 먼저 라이센스(License)에 동의해야합니다. "Accept License Agreement" 앞에 있는 레디오 버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180101_260/15148051000720MymJ_PNG/05.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  본인이 사용하는 운영체제에 맞는 JDK를 다운로드 해야합니다. 맥운영체제를 사용한다면 MacOS에 해당하는 "jdk-8u151-macosx-x64.dmg"를 클릭하고, MS윈도우 32비트 운영체제를 사용한다면 "jdk-8u151-windows-i586.exe"를 클릭하여 다운로드 받습니다. 참고로 MS윈도우 64비트 운영체제의 경우에는 "jdk-8u151-windows-x64.exe"를 다운로드 받습니다.

[![img](https://cphinf.pstatic.net/mooc/20180101_42/15148052782178YzIE_PNG/06.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  다운받은 MS Widnows 64bit용 JDK "jdk-8u151-windows-x64.exe"파일을 더블클릭하여 실행하면 위의 그림과 같은 환영 메시지가 보여집니다. Next버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180101_1/1514805294836my2eE_PNG/07.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  JDK가 설치될 경로(Path)를 지정합니다. JDK가 설치되는 경로를 JAVA_HOME경로라고도 말합니다. 해당 경로를 꼭 기억해주세요. 환경설정을 할 때 알아야 합니다. Next버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180101_219/1514805317380twpFW_PNG/08.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  JDK설치가 끝나면 JRE가 설치될 경로를 설정하게 됩니다. Next버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180101_182/1514805341522Tomra_PNG/09.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  설치가 진행되고 있습니다. 잠시만 기다려 주세요.

[![img](https://cphinf.pstatic.net/mooc/20180101_281/1514805369294xcvyi_PNG/10.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  설치가 완료되었습니다.

**2. mac os용 설치**

브라우저에서 다음의 URL로 이동합니다.

[http://www.oracle.com/technetwork/java/javase/downloads/index.htm](http:// http//www.oracle.com/technetwork/java/javase/downloads/index.htm)

[![img](https://cphinf.pstatic.net/mooc/20180129_139/1517191038996dYwQx_PNG/1.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  JDK Download 링크를 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180129_58/1517191086215tMvSp_PNG/2.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  jdk-8u121-macosx-x64.dmg 를 다운로드 받습니다.

[![img](https://cphinf.pstatic.net/mooc/20180129_126/151719114408120bUI_PNG/3.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  다운로드 받은 파일을 더블 클릭하면 위와 같은 창이 열립니다.

[![img](https://cphinf.pstatic.net/mooc/20180129_287/1517191173558Dt3E6_PNG/4.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  위와 같이 JDK설치 마법사가 실행됩니다.

[![img](https://cphinf.pstatic.net/mooc/20180129_168/1517191176988E7krk_PNG/5.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  맥의 관리자 ID와 암호를 입력하라는 창이 보여집니다. 본인의 맥 아이디와 암호를 입력하세요.

[![img](https://cphinf.pstatic.net/mooc/20180129_289/1517191213599ogCsk_PNG/6.png?type=w760)](https://www.boostcourse.org/web316/lecture/16680?isDesc=false#)

- 

  설치가 완료되었습니다.

 

 

------

**생각해보기**

1. JDK가 운영체제별로 설치파일을 제공하는 이유는 무엇입니까?

 

 

------

**참고 자료**

[**[참고링크\] windows용 설치링크**http://www.oracle.com](http://www.oracle.com/technetwork/java/index.html)

[**[참고링크\] mac os용 설치링크**http://www.oracle.com](http://www.oracle.com/technetwork/java/javase/downloads/index.htm)