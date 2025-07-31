package Example.day02._2REST;   // package

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller // 해당 크래스에  @Controller 를 주입한다.
// 1. @Component    : Spring 컨테이너(메모리) 에 bean(객체)를 등록/생성 한다. < 싱글톤 대용 >
// 2. Spring Controller 는 기본적으로 HTTP(웹 서블릿) 통신 지원한다.

public class RestController1 {   // class start
    // 싱글톤 생략   : @Controller -> @Component 포함돼서 자동으로 싱글톤 처럼 하나의 객체를 만들어준다.

    // Spring REST 란? CRUD 기능을 @PostMapping , @GetMapping , @PutMapping , @DeleteMapping 제공하므로써 웹기술 제공
    // Rest 테스터 프로그램 : Talend API Tester - Free Edition
        // 1. 크롬 실행
        // 2. https://chromewebstore.google.com/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?hl=ko&utm_source=ext_sidebar
        // 3. 크롬에 추가
        // 4. 크롬 상단에 주소 오른쪽 입력칸에 즐겨찾기 아이콘 옆에 조각(아이콘) 확장 프로그램 클릭('Talend API Tester')하기
        // 5.
    // 1) 등록 : CREATE    -> @PostMapping
    @PostMapping // Talend API : [METHOD] POST , [Scheme] : http://localhost:8080 , 주의할 점 https 가 아닌 http
    public void 등록하기() {
        System.out.println("RestController1.등록하기"); // soutm 자동완성
    }   // m end
    // 2) 조회 : READ     -> @GetMapping
    @GetMapping // Talend API : [METHOD] GET , [Scheme] : http://localhost:8080 , 주의할 점 https 가 아닌 http
    public void 조회하기() {
        System.out.println("RestController1.조회하기");
    }   // m end
    // 3) 수정 : UPDATE   -> @PutMapping
    @PutMapping // Talend API : [METHOD] PUT , [Scheme] : http://localhost:8080 , 주의할 점 https 가 아닌 http
    public void 수정하기() {
        System.out.println("RestController1.수정하기");
    }   // func end
    // 4) 삭제 : DELETE  -> @DeleteMapping
    @DeleteMapping // Talend API : [METHOD] DELETE , [Scheme] : http://localhost:8080 , 주의할 점 https 가 아닌 http
    public void 삭제하기() {
        System.out.println("RestController1.삭제하기");
    }   // func end
}   // class end
