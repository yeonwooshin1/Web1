package web.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.PointDao;
import web.model.dto.PointDto;

import java.util.ArrayList;

@Service
public class PointService {

    @Autowired private PointDao pointDao;

    // 등록
    public boolean getPoint (int mno , int type ) {
        PointDto pointDto = new PointDto();

        if(type == 1){
            pointDto.setPlpoint(1000);
            pointDto.setPlcomment("회원가입");
        } else if (type == 2) {
            pointDto.setPlpoint(10);
            pointDto.setPlcomment("로그인");
        } else {
            return false;
        } // if end
        boolean result = pointDao.getPoint(mno, pointDto);

        return result;
    }   // func end

    // 목록 조회
    public ArrayList<PointDto> getPointList (int mno) {
        return pointDao.getPointList(mno);
    }   // func end

    // 합계 조회
    public int getTotalPoint ( int mno ) {
        return pointDao.getTotalPoint(mno);
    }   // func end
}
