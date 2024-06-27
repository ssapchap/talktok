## 톡톡스피킹
2024.04~2024.05<br>
http://52.78.174.223/ (현재 중단)
<br><br>

✔ <u>주요 기술</u>
- JAVA, Spring Boot, JPA, MySQL, Thyemleaf, Gradle, AWS, Docker

✔ <u>역할</u>
+ 공통 기획 및 UI 설계
+ 메인페이지 개발
+ 강의목록, 강의상세 개발
+ 마이페이지 및 회원기능 일부, 결제내역과 스터디룸(WebRTC) 구현
+ Frontend 총괄, 전체 디자인

<br>

✔ <u>주요 내용</u>
- Repository / Service / Controller Layer 분리하여 개발
- Pageable 을 이용한 페이징 처리
- 사용자 편의성을 위해 포트원 카카오페이 API 사용
- 강의 결제 시 장바구니 데이터의 일관성 유지를 위한 트랜잭션 관리
- 최적의 사용자 경험을 제공하기 위해 반응형 디자인 적용

<br>

✔ <u>결과 및 성과</u>
- Spring Data JPA의 Pageable 인터페이스로 대용량 데이터를 효율적으로 처리할 수 있게됨
- 포트원 API를 사용하면서 결제 과정의 보안성 및 사용자 편의성을 동시에 향상시킴
- 결제 후 사용자의 장바구니에서 해당 강의 데이터를 자동으로 삭제하여 데이터 일관성을 유지함
- 미디어 쿼리를 이용해 다양한 화면 크기에 대응시킴
- Docker를 활용하여 시스템 환경 설정의 일관성을 유지하고 배포 및 확장성을 개선함

<br>

✔ <u>자세한 설명</u>
- 톡톡스피킹은 WebRTC 기술을 활용한 실시간 화상회의 서비스입니다. 기존 녹화강의의 불편함을 해소하기 위한 목적으로 플랫폼을 구축했습니다. 카카오페이 결제 연동을 진행하며, 콜백 데이터를 DB에 커스텀해 저장하는 과정에서 형변환과 관련하여 많은 어려움과 경험을 쌓았습니다. 이를 통해 보다 기초적인 부분을 깊게 이해해야 한다는 깨달음을 얻었습니다.

<br><br>

![01](https://github.com/ssapchap/talktok/assets/163481508/8da7de79-0f5c-440d-901d-9a2196f37d64)


![02](https://github.com/ssapchap/talktok/assets/163481508/9d6620f2-cbcf-434e-81a4-1409d0e0b318)
