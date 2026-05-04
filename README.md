## 1차 요구사항 구현
- [x] 유저가 루트 url로 접속시에 게시글 리스트 페이지(http://주소:포트/article/list)가 나온다.
- [x] 리스트 페이지에서는 등록 버튼이 있고 버튼을 누르면 http://주소:포트/article/create 경로로 이동하고 등록 폼이 나온다.
- [x] 게시글 등록을 하면 http://주소:포트/article/create로 POST 요청을 보내어 DB에 해당 내용을 저장한다.
- [x] 게시글 등록이 되면 해당 게시글 리스트 페이지로 리다이렉트 된다. 페이지 URL 은 http://주소:포트/article/list 이다.
- [x] 리스트 페이지에서 해당 게시글을 클릭하면 상세페이지로 이동한다. 해당 경로는 http://주소:포트/article/detail/{id} 가 된다.
- [x] 게시글 상세 페이지에는 id에 맞는 게시글 데이터와 목록 버튼이 있다. 목록 버튼을 누르면 게시글 리스트 페이지로 이동하게 된다.

## UI/UX (화면 캡처본을 복사 붙여 넣기, url 주소 나오도록)
- 게시글 리스트 페이지
  <img width="644" height="558" alt="image" src="https://github.com/user-attachments/assets/82b891ef-c5cc-4136-b9f1-f48a4cffbab9" />

- 게시글 등록 폼 페이지
  <img width="542" height="447" alt="image" src="https://github.com/user-attachments/assets/62c8b573-c105-45bb-ba96-f1e90a92c892" />

- 게시글 상세 페이지
  <img width="670" height="508" alt="image" src="https://github.com/user-attachments/assets/b2434432-be10-41c2-9897-28d26a7adbea" />

## MVC 패턴
- MVC 패턴은 Model - View - Controller의 약자
- 사용자의 요청을 Controller에서 받아 Service에서 비즈니스 로직을 처리하고 View를 통해 결과를 보여주는 구조
- <code>ArticleController</code>에서 목록/등록/상세 요청을 받으면 <code>AricleService</code>를 호출해서 View를 반환하고 있음

## 스프링에서 의존성 주입(DI) 방법 3가지 방법
1. 생성자 주입 : 객체가 생성되면서 함께 의존성을 주입
   -> final 키워드로 불변성을 보장하고, 테스트 코드를 작성하기 쉽다.
2. 필드 주입 : 선언할때 @Autowired로 주입
   -> final을 사용할 수 없으며, 의존성 교체가 어려워 비권장하는 방법
3. Setter 주입 : 객체를 먼저 생성하고, 그 후에 Setter를 사용하여 의존성을 주입
   -> 생성자 주입에 비해 오류 발견이 늦고, 런타임 중에 의존성이 교체될 수 있음

## JPA의 장점과 단점
- 장점
  - SQL을 직접 작성하지 않아도 DB 조회가 가능.
  - DB 종류에 상관없이 설정만 바꿔주면 코드 변경이 필요없음.
  - 객체 중심적 개발이 가능.
  - 반복적인 코드(쿼리, 매핑 등) 사용 없이 간결하게 작성.
- 단점
  - 복잡한 쿼리에는 사용하기 어려움.
  - 성능 튜닝이 어려움
  - N+1 문제 : JOIN되는 쿼리도 같이 실행.

## HTTP GET 요청과 POST 요청의 차이
- GET은 서버에서 데이터를 조회, POST는 서버에 데이터를 전송함
- GET은 데이터를 URL에 담아서 전달하여 정보가 URL에 노출됨
- POST는 데이터를 Body에 담아서 전달하여 URL에 노출되지 않음
