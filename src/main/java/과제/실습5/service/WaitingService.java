package 과제.실습5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 과제.실습5.model.dao.WaitingDao;
import 과제.실습5.model.dto.WaitingDto;

import java.util.ArrayList;

@Service
public class WaitingService {

    @Autowired
    private WaitingDao waitingDao;

    // 등록
    public boolean listWrite (WaitingDto dto) {
        return waitingDao.listWrite(dto);
    }   // func end

    // 조회

    public ArrayList<WaitingDto> listPrint () {
        return waitingDao.listPrint();
    }   // func end

    // 개별 조회
    public WaitingDto listFind(int seq) {
        return waitingDao.listFind(seq);
    }

    // 삭제
    public boolean listDelete( int seq ) {
        return waitingDao.listDelete(seq);
    }   // func end

    // 수정
    public boolean listEdit ( WaitingDto dto) {
        return waitingDao.listEdit(dto);
    }   // func end
}
