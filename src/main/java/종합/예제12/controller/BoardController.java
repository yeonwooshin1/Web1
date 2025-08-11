package 종합.예제12.controller; // package

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제12.model.dto.BoardDto;
import 종합.예제12.service.BoardService;

import java.util.ArrayList;

@RestController
@RequestMapping("/Board")
public class BoardController {  // class start
    @Autowired
    private BoardService boardService;

    @PostMapping
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardWrite");
        return boardService.boardWrite(boardDto);
    }   // func end

    @GetMapping
    public ArrayList<BoardDto> boardPrint(){
        System.out.println("BoardController.boardPrint");
        return boardService.boardPrint();
    }   // func end

    @GetMapping("/find")
    public BoardDto boardFind(@RequestParam int bno ){
        System.out.println("BoardController.boardFind");
        return boardService.boardFind(bno);
    }   // func end

    @DeleteMapping
    public boolean boardDelete(@RequestParam int bno){
        System.out.println("BoardController.boardDelete");
        return boardService.boardDelete(bno);
    }   // func end

    @PutMapping
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardUpdate");
        return boardService.boardUpdate(boardDto);
    }   // func end

}   // class end


