package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.model.dao.MemberDao;
import test.model.dto.MemberDto;

import java.util.ArrayList;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    // 메소드

    // 자동회원번호+1 가져오기
    public int getNextCustomerNo() {
        return memberDao.getNextCustomerNo();
    }

    // 등록 service
    public boolean memberWrite( MemberDto memberDto ){
        return memberDao.memberWrite( memberDto );
    }   // func end

    // 조회
    public ArrayList<MemberDto> memberPrint( ){
        return memberDao.memberPrint();
    }   // func end

    // 개별 조회
    public MemberDto memberFind( int customerNo ){
        return memberDao.memberFind( customerNo );
    }   // func end

    // 수정
    public boolean memberUpdate( MemberDto memberDto){
        return memberDao.memberUpdate( memberDto );
    }   // func end

}   // class end
