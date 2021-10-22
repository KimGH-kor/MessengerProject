# MessengerProject
친구와 함께 만드는 메신저 프로젝트
___
이 프로젝트를 진행하면서 
<br>
socket을 이용하여 서버와 클라이언트를 다뤘고 쓰레드 개념의 이해와 해쉬맵의 필요성을 느낄 수 있었습니다.
<br>
또한 유지보수로 DB를 연결하여 유저 정보 및 각각의 유저마다 데이터 베이스를 만들어 대화내용도 저장할 예정입니다.

진행 방향
Numbers:
1. 자바 스윙을 이용하여 라인, 카카오톡을 벤치마킹한 UI구현
2. 소켓을 이용하여 ID와 PW를 받아 로그인 기능 구현(DB는 아직 미구현이라 더미클래스를 사용)
3. 자바 스윙 J리스트를 활용하여 로그인한 사람의 목록을 띄워준다.
4. 로그인 한 사람을 클릭하면 채팅창이 열리고 채팅 기능 구현
5. DB를 연결하여 대화 내용 저장 및 업데이트

현재 DB연결 빼고 기능은 다 구현 되었습니다.
하지만 쓰레드 개념과 프로토콜 개념을 조금 공부한 다음에 오류부터 잡고 진행할 예정입니다.

현재 오류
1. 4개 이상의 유저 접속시 오류
2. close 설정
