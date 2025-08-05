package example.day02._2REST;   // package

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller // @Component  포함됨   // 어노테이션은 띄우면 안됨
public class RestController2 {  // class start
    // 싱글톤은 대신 @Component 이용한 인스턴스 자동 생성

    // [ 반환타입 있는 REST ]
        // @ResponseBody : 자바는 int 타입을 알지만 웹HTTP는 int 타입 누구세요??
            // 역할? 자바에서 사용하는 타입들을 자동으로 HTTP(웹)이 이해하는 타입으로 반환 해준다.

    // 1. 100 을 반환하는 메소드
    // Talend API : [METHOD] GET , [Scheme] http://localhost:8080/day02/task
    @GetMapping("/day02/task")  // @XXXMapping("URL주소정의")
    @ResponseBody // 자바에서 반환하는 int 타입을 HTTP가 이해하는 타입으로 자동 반환
    public int method1(){
        System.out.println("RestController2.method1"); // soutm
        return 100;
    }   // func end

    // 2. 문자열을 반환하는 메소드
    // Talend API : [METHOD] GET , [Scheme] http://localhost:8080/day02/task2
    @GetMapping("/day02/task2") // 주의할점 : 서버내 동일한 주소 불가능
    @ResponseBody // 자바에서 반환하는 String 타입을 HTTP가 이해하는 타입으로 자동 반환
    public String method2(){
        System.out.println("RestController2.method2");
        return "스프링 보내온 메세지";
    }   // func end

    // 3. MAP 타입 반환하는 메소드
    // Talend API : [METHOD] POST , [Scheme] http://localhost:8080/day02/task
    @PostMapping("day02/task")  // 주의할점 : 서버내 동일한 주소 불가능 하지만 REST 다르면 가능
    @ResponseBody  // 자바에서 반환하는 MAP 타입은 HTTP가 이해하는 타입으로 자동 반환
    public Map<String , Integer> method3 () {
        System.out.println("RestController2.method3");
        Map<String , Integer> map = new HashMap<>(); // 임의 데이터
        map.put("강호동" , 100);
        map.put("유재석" , 95);
        return map;
    }   // func end

    // 4. boolean 타입 반환하는 메소드
    // Talend API : [METHOD] PUT , [Scheme] http://localhost:8080/day02/task
    @PutMapping("day02/task")
    @ResponseBody // 자바에서 반환하는 boolean 타입은 HTTP가 이해하는 타입(JSON)으로 자동 반환
    public boolean method4() {
        System.out.println("RestController2.method4");
        return false;
    }   // func end

    // 5. DTO 타입 반환하는 메소드
    // Talend API : [METHOD] DELETE , [Scheme] http://localhost:8080/day02/task
    @DeleteMapping("day02/task")
    @ResponseBody
    public TaskDto method5(){
        System.out.println("RestController2.method5");
        TaskDto taskDto = new TaskDto( 20 , "유재석");    // 임의 데이터
        return taskDto;
    }   // func end

    // 6. ArrayList 타입 반환하는 메소드
    @GetMapping("day02/task3")
    @ResponseBody   // HTTP는 List 모른다. 그래서 List 타입을 HTTP 이해하는 타입으로 변환
    public List<TaskDto> method6 () {
        System.out.println("RestController2.method6");
        ArrayList<TaskDto> arrayList = new ArrayList<>();   // 임의데이터
        arrayList.add( new TaskDto( 10,"신연우"));
        arrayList.add( new TaskDto( 10,"신준혁"));
        return arrayList;
    }   // func end
}   // class end
