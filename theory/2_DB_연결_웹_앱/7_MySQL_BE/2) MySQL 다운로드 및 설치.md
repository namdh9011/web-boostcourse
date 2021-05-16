# 2) MySQL 다운로드 및 설치

**들어가기 전에**

DBMS의 종류는 상당히 많습니다.

그중에서 인기있는 DBMS에는 Oracle, MyBatis, PostgreSQL, SQLite 등이 있습니다.

이번엔 세상에서 가장 인기 있는 DBMS 중에 하나인 MySQL DBMS를 설치해보도록 하겠습니다.



 

------

**학습 목표**

1. MySQL DBMS를 다운로드하고 설치할 수 있다.



 

------

**핵심 개념**

- MySQL



 

------

**학습하기**

**MySQL설치**

Windows와 Mac에서 MySQL을 설치하는 방법에 대해 알아보도록 하겠습니다.

 

**1. Windows 에서 MySQL 설치하기**

**MySQL 설치 프로그램 다운로드 하기**

https://www.mysql.com/downloads/

위의 URL주소로 접속합니다.

[![img](https://cphinf.pstatic.net/mooc/20180130_220/1517301639758tipul_PNG/2_7_2_01.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  접속하면 하단에 위와 같은 링크가 보여집니다. Community(GPL) Downloads를 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180130_50/15173016771322yd4l_PNG/2_7_2_02.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  다시 화면이 바뀌고, 하단에서 위와 같은 부분을 찾습니다. MySQL Community Server Download링크를 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180130_141/1517301716304Elg4m_PNG/2_7_2_03.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  본인이 사용하는 윈도우에 맞는 버전을 선택합니다. 그리고 나서 Go to Download Page버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180130_178/1517301741527LIfS9_PNG/2_7_2_04.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  위와 같은 화면으로 전환되면 붉은 사각형으로 처져 있는 Download버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180130_26/1517301764096QbT2o_PNG/2_7_2_05.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  로그인을 하지 않고 다운로드 하려면 No thanks, just start my download 링크를 클릭합니다. MySQL Community Edition이 이제 다운로드 됩니다. mysql-installer-community-5.7.21.0.msi 를 실행합니다.

[![img](https://cphinf.pstatic.net/mooc/20180130_66/1517301795664jFdjh_PNG/2_7_2_06.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  설치 프로그램을 실행하면 가장 먼저 라이선스에 대해서 물어보는 화면이 보입니다. 라이선스 동의 체크박스를 선택한 후 Next버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180130_230/1517301822203xcY00_PNG/2_7_2_07.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  Developer Default를 선택한 후 Next버튼을 클릭합니다. 말 그대로 개발자를 위한 MySQL을 설치하겠다는 것입니다. 개발자를 위한 다양한 도구들이 함께 설치가 됩니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_207/1517373007940UfqlB_PNG/2_7_2_07-1.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  위와 같은 화면이 보이면, Execute버튼을 클릭하여 설치를 진행합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_270/1517373039324B9lDb_PNG/2_7_2_08.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  MySQL이 설치되고 실행되기 위해서 필요한 도구들에 대해서 Execute를 눌러 설치한 후 Next버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_177/15173730685845io2c_PNG/2_7_2_09.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  설치할 항목이 표시됩니다. Execute버튼을 클릭하여 설치를 시작합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_97/1517373135155jRYVo_PNG/2_7_2_10.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  설치가 모두 진행되었다면 Next버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_196/1517373151599Lltmo_PNG/2_7_2_11.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  MySQL과 관련된 설정 과정이 진행된다는 안내가 표시됩니다. Next버튼을 클릭합니다. root계정의 암호를 설정하는 부분까지 기본값으로 설치를 진행합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_300/1517373194725igKRc_PNG/2_7_2_12.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  MySQL의 관리자(root)계정의 암호를 설정합니다. 암호를 잊지 않게 조심해 주세요. 암호를 입력했다면 Next버튼을 클릭합니다. 커넥션 연결 테스트를 진행할 때까지 기본값으로 설치를 진행하도록 하겠습니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_60/15173732195796I7yM_PNG/2_7_2_13.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  MySQL이 잘 실행되고 있는지 확인하기 위한 화면입니다. 앞에서 입력했던 root사용자의 암호를 입력하고 Check버튼을 클릭합니다. 위와 같이 연결 성공이라는 녹색화면이 보이면 Next버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_18/1517373256380a1AEr_PNG/2_7_2_14.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  모든 설치 과정이 끝났습니다. Finish버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_221/1517373280390svBSo_PNG/2_7_2_15.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  모든 인스톨 과정이 완료되었습니다. Finish버튼을 클릭하면 MySQL Workbench와 MySQL Shell이 실행될 것이라는 체크박스가 선택되어 있습니다. Finish버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_225/1517373299598m4PwL_PNG/2_7_2_16.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  MySQL Workbench 실행화면입니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_268/1517373321570TWSkE_PNG/2_7_2_17.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  MySQL Shell 쉘의 실행화면입니다. 앞으로 MySQL을 이용해서 개발을 진행할 때 워크벤치나 MySQL 쉘을 이용해야하는 경우가 많이 발생할 것입니다. 창을 닫고, 프로그램을 종료해주세요.

[![img](https://cphinf.pstatic.net/mooc/20180131_203/1517373400661QD25h_PNG/2_7_2_18.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  윈도우 메뉴를 보면 MySQL그룹이 새로 생긴 것을 볼 수 있습니다. 위의 그림중에서 붉은 상자로 되어 있는 부분이 워크벤치와 MySQL shell을 실행하기 위한 아이콘입니다. 뒤에서 MySQL을 사용할 때 위의 아이콘을 선택하시면 됩니다. 콘솔창에서 mysql 명령을 실행하려면, 다음의 경로를 PATH에 지정하세요. 윈도우 검색창에 "환경" 이라고 입력합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_33/1517373431461Yc8M2_PNG/2_7_2_19.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  시스템 환경 변수 편집이라는 프로그램이 보이면 클릭해서 실행합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_177/15173734556398WYJk_PNG/2_7_2_20.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  위와 같은 시스템 속성창이 열리면 아래 쪽의 "환경 변수"버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_38/15173734789828xbN0_PNG/2_7_2_21.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  시스템 변수 중에서 Path를 선택하고, "편집" 버튼을 클릭합니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_276/1517373550179G8GOy_PNG/2_7_2_22.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- 

  "새로 만들기"버튼을 클릭한 후, 아래의 path를 입력한 후 "확인" 버튼을 클릭합니다. 이전 창도 모두 "확인"버튼을 눌러 닫습니다.  C:\Program Files\MySQL\MySQL Server 5.7\bin  이제 콘솔창에서 mysql 명령을 수행할 수 있습니다.

**2. Mac에서 MySQL 설치하기**

**HomeBrew 설치하기**

먼저 맥에 HomeBrew가 설치되어 있어야 합니다.

터미널에서 아래 명령어를 통해 HomeBrew가 설치되어 있는지 확인해볼 수 있습니다.

```markup
brew -v
```

만약 HomeBrew가 기존에 설치된 상태라면 버전 정보를 확인해볼 수 있습니다.

```markup
Homebrew 1.5.0

Homebrew/homebrew-core (git revision ce185; last commit 2018-01-20)
```

만약 버전 정보가 제대로 나오지 않는다면 먼저 HomeBrew를 설치를 먼저 해주세요.

HomeBrew 설치법은 [https://brew.sh](https://brew.sh/) 사이트 설명을 참고하시면 됩니다.

설치법이 간단하고 한국어 설명도 지원하기 때문에 쉽게 할 수 있습니다.



**- HomeBrew를 이용한 MySQL 설치하기**

HomeBrew를 이용하면 쉽게 설치할 수 있고, 환경변수를 설정할 필요도 없습니다.

Oracle사에서 직접 다운로드하여 설치하는 것보다 훨씬 쉽게 설치하고 사용할 수 있습니다.

```markup
brew install mysql
```

위의 문장을 다음과 같은 화면이 출력되고 설치가 완료됩니다.

[![img](https://cphinf.pstatic.net/mooc/20180131_126/1517373609859J1odM_PNG/2_7_2_23.png?type=w760)](https://www.boostcourse.org/web316/lecture/16717/?isDesc=false#)

- **HomeBrew를 이용해서 MySQL을 설치한 화면**

다음 시간에는 설치된 MySQL서버를 실행하고, 종료하는 방법에 대해서 알아보도록 하겠습니다.

 

 

------

**생각해보기**

MySQL DBMS를 잘 설치하셨나요?

DBMS는 여러 명의 사용자가 동시에 접속해서 사용할 수 있다고 앞에서 배웠었습니다.

그런데, 개인용 PC에 설치된 MySQL은 항상 켜져 있는 것이 아닐 테니, 여러 사람이 동시에 이용하기 어려울 것입니다.

여러 사람이 동시에 항상 접속해서 사용할 수 있으려면 MySQL을 어떤 컴퓨터에 설치하고 운영해야 할까요?

 

 

------

**참고 자료**

[**[참고링크\] Installing and Upgrading MySQL**https://dev.mysql.com](https://dev.mysql.com/doc/refman/5.7/en/installing.html)

[ ![img](https://cphinf.pstatic.net/mooc/20180131_17/15173737261787ynO5_JPEG/UY2vZx5URY6XOd2DtJnh.jpg?type=mfullfill_199_148)**[참고링크\] 최근 가장 인기있는 DBMS는 무엇?…포스트그레SQL 선전**http://www.ddaily.co.kr](http://www.ddaily.co.kr/news/article.html?no=158998)