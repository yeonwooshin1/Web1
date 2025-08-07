package 과제.실습3.controller;

import org.springframework.web.bind.annotation.*;
import 과제.실습3.model.dao.WaitingDao;
import 과제.실습3.model.dto.WaitingDto;

import java.util.ArrayList;

@RestController
public class WaitingController {
    // 싱글톤 가져오기
    WaitingDao dao = WaitingDao.getInstance();

    // 등록 메소드
    @PostMapping("/waiting")
    public boolean listWrite (@RequestBody WaitingDto waitingDto) {

        // 그 dto를 dao의 매개변수로 주기 그리고 그 값의 리턴값을 다시 리턴
        return dao.listWrite(waitingDto);
    }   // func end

    // 리스트 반환 메소드
    @GetMapping("/waiting")
    public ArrayList<WaitingDto> listPrint (){
        // dao 배열 반환값 다시 반환
        return dao.listPrint();
    }   // func end

    // 리스트 삭제 메소드
    @DeleteMapping("/waiting")
    public boolean listDelete(@RequestParam int seq ) {
        return dao.listDelete(seq);
    }   // func end

    // 리스트 수정 메소드
    @PutMapping("/waiting")
    public boolean listEdit (@RequestBody WaitingDto waitingDto) {
        return dao.listEdit(waitingDto);
    }   // func end
}
