package com.example.korea_sleepTech_springboot.시험;

import org.springframework.web.bind.annotation.RestController;

public class Test01 {
}

// 1번: 3
// 2번: 4
// 3번: 3
// 4번: 2
// 5번: 2
// 6번: 2
// 7번: 4
// 8번: 4
// 9번: 3
// 10번: 3
// 11번: @Bean
// 12번: delete()
// 13번: @PathVariable
// 14번: @RequestParam
// 15번: Service 계층
// 16번: 클래스를 데이터베이스와 직접 연결되어 데이터를 저장하거나 조회하는
//       Repository 계층으로 등록하기 위해서
// 17번: save()
// 18번: aplication.properties
// 19번:
// @RestController
// @RequestMapping("/hello")
// public class TestController{
//    public String GetRequest(){
//      return "Hello, Spring Boot!";
// }
// 20번:
// @Entity
// @Table(name = "User")
// @NoArgsConstructor
// @AllArgsConstructor
// public class User{
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column
//  private Long id;

//  @Column
//  private String username;

//  @Column
//  private String email
//}


// =================================================================================================//
// CRUD 테스트에 대한 느낀점
/* entity, repository, dto, controller 계층은 수월하게 구현할 수 있을 거 같습니다.
 다만 service 계층을 구현하는데에는 시간이 좀 드는 것 같습니다.
 그리고 요청의 성공 여부를 나타내는 클래스인 ResponseDto를 활용하는 부분을 깊게 공부해봐야할 것 같습니다.
 또 스프링 부트에서 사용되는 어노테이션을 좀 더 학습하고 외울 필요성을 느꼈습니다.
 */