package example.day03.실습2; // package

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BoardController {  // class start

    @PostMapping("/board")
    public boolean boardWrite(BoardDto dto){
        System.out.println("BoardController.boardWrite");
        System.out.println("dto = " + dto);
        return true;
    }   // func end

    @GetMapping("/board")
    public ArrayList<BoardDto> boardPrint(){
        return new ArrayList<>();
    }   // func end

    @GetMapping("/board/detail")
    public BoardDto boardDetail( int bno ){
        System.out.println("BoardController.boardDetail");
        return new BoardDto();
    }   // func end

    @DeleteMapping("/board")
    public boolean boardDelete( int bno ){
        System.out.println("BoardController.boardDelete");
        System.out.println("bno = " + bno);
        return true;
    }   // func end

    @PutMapping("/board")
    public boolean boardUpdate(@ModelAttribute BoardDto dto){
        System.out.println("BoardController.boardUpdate");
        System.out.println("dto = " + dto);
        return true;
    }   // func end

}   // class end
