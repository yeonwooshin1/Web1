package 과제.실습4.controller;  // package

import org.springframework.web.bind.annotation.*;
import 과제.실습4.model.dao.WaitingDao;
import 과제.실습4.model.dto.WaitingDto;

import java.util.ArrayList;

@RestController
@RequestMapping("/waiting")
public class WaitingController {    // class start


    // 0. DAO 싱글톤 불러오기
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 등록
    @PostMapping("/write")
    public boolean listWrite (@RequestBody WaitingDto dto) {
        return waitingDao.listWrite(dto);
    }   // func end

    // 조회
    @GetMapping("/print")
    public ArrayList<WaitingDto> listPrint () {
        return waitingDao.listPrint();
    }   // func end

    // 삭제
    @DeleteMapping("/delete")
    public boolean listDelete(@RequestParam int seq ) {
        return waitingDao.listDelete(seq);
    }   // func end

    // 수정
    @PutMapping("/edit")
    public boolean listEdit (@RequestBody WaitingDto dto) {
        return waitingDao.listEdit(dto);
    }   // func end



}   // class end
