package Example.day_03.실습2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BoardController {
    @PostMapping("/board")
    public boolean boardWrite(BoardDto dto){
        System.out.println("BoardController.boardWrite");
        System.out.println("dto = " + dto);
        return true;
    }

    @GetMapping("/board")
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> list = new ArrayList<>();
        return list;
    }

    @GetMapping("/board/detail")
    public BoardDto boardDetail( int bno ){
        System.out.println("BoardController.boardDetail");
        return new BoardDto();
    }

    @DeleteMapping("/board")
    public boolean boardDelete( int bno ){
        System.out.println("BoardController.boardDelete");
        System.out.println("bno = " + bno);
        return true;
    }

    @PutMapping("/board")
    public boolean boardUpdate(BoardDto dto){
        System.out.println("BoardController.boardUpdate");
        System.out.println("dto = " + dto);
        return true;
    }

}
