# JavaWeb_NextStep

```text
이 Repository는 자바 웹 프로그래밍 NEXT STEP의 책을 기반으로 공부목적으로 만들었습니다.  
모든 내용은 해당 책을 참조하였음을 알려드립니다.  
```  

---
### 참고 URL
* https://github.com/slipp/jwp-book
* https://slipp.net
  
* stackoverflow.com
* slideshare.net
* trello.com
* MOOC sites
  * codecademy
  * codeschool
  * khanacademy
* http://code.org/learn - hour of code
* https://www.khanacademy.org/computing/computer-programming
* https://cs50.harvard.edu  
    
* https://opentutorials.org/course/1688 - php
* https://www.codecademy.com/learn
* http://www.w3schools.com - front  

* http://backlogtool.com/git-guide/kr/: 누구나 쉽게 이해할 수 있는 Git 입문
* http://rogerdudler.github.io/git-guide/index.ko.html: Git 설치, 기본 사용법
* http://www.slideshare.net/ibare/dvcs-git: Git의 commit과 push 개념 잡기
---
### Books
* 열혈강의 자바 웹 개발 워크북
* SQL 첫걸음
* 자바 프로그래밍(Heff Langr)
* 코딩을 지탱하는 기술  
  
* 습관의 힘
* 이너 게임
* 몰입의 즐거움  
  
* 이펙티브 자바
* 성공으로 이끄는 팀 개발 실천 기술
* HTTP & Network
* IT 인프라 구조  

---
### 3장. 개발 환경 구축 및 웹 서버 실습 요구사항
  * 3.3 원격 서버에 배포
    - 로컬 개발 환경을 구축한 후 바로 실습 단계를 진행할 수도 있지만
      HTTP 웹 서버를 원격 서버에 배포하는 경험도 중요하다.
    - 이로써 터미널 환경에서 작업하는 것에 익숙해져야 하며 두려움을 없애야 한다.
    - 기본적인 명령어 : pwd, cd, ls, chmod, cp, rm, mv, ln, ps. kill
    - vi Editor
    - 아마존 웹 서비스(AWS)를 활용(EC2 인스턴스)(https://opentutorials.org/module/1946)
      
  
---
### JUnit
  - 프로그래밍에서 모든 함수와 메서드에 대한 테스트 케이스(Test case)를 작성하여 의도된 대로 잘 동작하는지 검증하는 절차  
  - 프로그램을 작은 단위로 쪼개어 각 단위가 정확하게 동작하는지 검사함으로써 프로그램의 안정성을 높임  
  - System.out.println()으로 하는 번거로운 디버깅이 필요없으며, 개발기간 중 대부분을 차지하는 디버깅 시간을 단축  
  
  - 단정 메서드
    1. assertArrayEquals(a, b): 배열 A와 B가 일치함을 확인
    2. assertEquals(a, b): 객체 A와 B가 같은 값을 가지는지 확인
    3. assertEquals(a, b, c): 객체 A와 B가 값이 일치함을 확인( a: 예상값, b:결과값, c: 오차범위)
    4. assertSame(a, b): 객체 A와 B가 같은 객체임을 확인
    5. assertTrue(a): 조건 A가 참인지 확인
    6. assertNotNull(a): 객체 A가 null이 아님을 확인
---  
### 기본적의 웹 동작  
  1. 클라이언트(웹브라우저)가 서버에 페이지(url) 요청
  2. 서버는 클라이언트 요청을 받아 해당 파일(html)을 리턴
  3. 웹브라우저는 수신받은 html 내용(자바스크립트, css 포함)을 해석해서 화면에 표시
  
  그러나 html 은 정적인 파일(내용을 직접 수정하기전까지 변하지 않음)이므로 시시각각 변하는 뉴스기사 라든가 날씨정보, 쇼핑몰의 상품 정보등을 가지고 있을 수 없다.  
  이러한 정보들은 데이터베이스에 저장되어 있으며 웹을 통해 정보를 제공하려면 사용자의 웹 요청을 받아 별도의 프로그램이 동작해야 하고 데이터베이스에서 가지고온 정보들은 html 로 재구성해서 클라이언트에 다시 전달해야 한다.  
  
  이외에도 사용자 로그인 처리를 위해서는 입력한 아이디와 비밀번호등을 데이터베이스에 저장된 내용과 비교해야 하고 게시판의 경우 입력한 내용을 데이터베이스에 저장해야 하는 과정이 필요 하게 된다.  

서블릿
---  
### Ubuntu Apache 설치
 1. $ sudo apt-get update
 2. $ sudo apt-get install apache2
 3. $ sudo service apache2 start : 아파치 실행
 4. $ ps aux | grep apache2 : 아파치 실행 확인
 5. ip 접속 후 Apache2 화면 확인
 6. $ sudo service apache2 stop : 아파치 종료
  
---  
  
### Etc  
  1. import org.junit.Test; 사용시 public으로 하지 않으면 run이 안됨. 왜?  
  2. @Before, @After 애노테이션은 @Test 애노테이션의 메소드가 실행 전, 후에 반복해서 실행된다.  
  3. No tests found for given includes 에러 발생  
    - Settings > Build,Execution,Deployment > Build Tools > Gradle > "Run tests using:  IntelliJ IDEA" 로 변경  
  
### 명령어  
  - env
  - wget
  - gunzip
  - tar
  - cd
  - mv
  - rm
  - ln -s
  - source
  - vi
