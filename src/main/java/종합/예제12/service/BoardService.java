package 종합.예제12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import 종합.예제12.model.dao.BoardDao;
import 종합.예제12.model.dto.BoardDto;

import java.util.ArrayList;

@Service
public class BoardService {
    @Autowired
    private BoardDao boardDao;

    // 등록
    public boolean boardWrite(BoardDto boardDto){
        System.out.println("BoardService.boardWrite");
        return boardDao.boardWrite(boardDto);
    }   // func end

    // 전체 조회
    public ArrayList<BoardDto> boardPrint(){
        System.out.println("BoardService.boardPrint");
        return boardDao.boardPrint();
    }   // func end

    // 개별 조회
    public BoardDto boardFind(int bno ){
        System.out.println("BoardService.boardFind");
        return boardDao.boardFind(bno);
    }   // func end

    // 삭제
    public boolean boardDelete(int bno){
        System.out.println("BoardService.boardDelete");
        return boardDao.boardDelete(bno);
    }   // func end

    // 수정
    public boolean boardUpdate(BoardDto boardDto){
        System.out.println("BoardService.boardUpdate");
        return boardDao.boardUpdate(boardDto);
    }   // func end


}   // class end
