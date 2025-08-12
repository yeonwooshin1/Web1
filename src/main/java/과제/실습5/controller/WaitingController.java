package 과제.실습5.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import 과제.실습5.model.dto.WaitingDto;
import 과제.실습5.service.WaitingService;

import java.util.ArrayList;

@RestController
@RequestMapping("/waiting")
public class WaitingController {    // class start

    @Autowired
    private WaitingService waitingService;

    // 등록
    @PostMapping
    public boolean listWrite (@RequestBody WaitingDto dto) {
        return waitingService.listWrite(dto);
    }   // func end

    // 조회
    @GetMapping
    public ArrayList<WaitingDto> listPrint () {
        return waitingService.listPrint();
    }   // func end

    // 개별 조회
    @GetMapping("find")
    public WaitingDto listFind(int seq) {
        return waitingService.listFind(seq);
    }


    // 삭제
    @DeleteMapping
    public boolean listDelete(@RequestParam int seq ) {
        return waitingService.listDelete(seq);
    }   // func end

    // 수정
    @PutMapping
    public boolean listEdit (@RequestBody WaitingDto dto) {
        return waitingService.listEdit(dto);
    }   // func end



}   // class end