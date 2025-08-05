package example.day01.controller;

import example.day01.model.dao.BoardDao;
import example.day01.model.dto.BoardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class BoardController {  // class start
    // 싱글톤 만들기
    private BoardController() {
    }

    private static final BoardController controller = new BoardController();

    public static BoardController getInstance() {
        return controller;
    }

    // 싱글톤 가져오기
    BoardDao dao = BoardDao.getInstance();
    @PostMapping
    // Board 등록 메소드
    public boolean BoardWrite(String bcontent, String bwriter) {
        BoardDto dto = new BoardDto(bcontent, bwriter);

        return dao.BoardWrite(dto);
    }   // func end

    @GetMapping
    // Board 출력 메소드
    public ArrayList<BoardDto> BoardPrint() {
        return dao.BoardPrint();
    }   // func end
}
