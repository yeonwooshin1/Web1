package example.day02.실습1;  // package

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {  // class start

    // 1. 글쓰기           POST       "/exam1/board"
    // 요청자료 : x , 응답자료 : true/false
    @PostMapping("/exam1/board")
    @ResponseBody
    public boolean write(){
        System.out.println("BoardController.write");
        return true;
    }   // func end

    // 2. 전체 글 조회      GET        "/exam1/board"
    // 요청자료 : x , 응답자료 : 임의의 List 타입 ,  [ {bno:'',btitle:''} ,  {bno:'',btitle:''}  ]
    @GetMapping("/exam1/board")
    @ResponseBody
    public List<Map<String, String>> printAll(){
        System.out.println("BoardController.printAll");
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        list.add( map1 );
        Map<String,String> map2 = new HashMap<>();
        map2.put("bno" , "2" );
        map2.put("btitle" , "제목2");
        list.add( map2 );
        return list;
    }   // func end

    // 3. 개별 글 조회      GET        "/exam1/board/view"
    // 요청자료 : x , 응답자료 : 임의의 MAP  타입  ,  {bno:'',btitle:''}
    @GetMapping("/exam1/board/view")
    @ResponseBody
    public Map<String , String> printIndividual (){
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        return map1;
    }   // func end

    // 4. 개글 글 수정      PUT        "/exam1/board"
    // 요청자료 : x , 응답자료 : true 또는 false
    @PutMapping("/exam1/board")
    @ResponseBody
    public boolean UpdateWriting () {
        System.out.println("BoardController.UpdateWriting");
        return true;
    }   // func end

    // 5. 개별 글 삭제      DELETE     "/exam1/board"
    // 요청자료 : x , 응답자료 : 임의의 삭제한 번호 , 3
    @DeleteMapping("/exam1/board")
    @ResponseBody
    public int deleteWriting () {
        System.out.println("BoardController.deleteWriting");
        return 3;
    }   // func end

}   // class end
