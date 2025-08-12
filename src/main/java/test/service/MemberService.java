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

    public boolean memberWrite( MemberDto memberDto ){
        return memberDao.memberWrite( memberDto );
    }   // func end



    public ArrayList<MemberDto> memberPrint( ){
        return memberDao.memberPrint();
    }   // func end


    public MemberDto memberFind( int customerNo ){
        return memberDao.memberFind( customerNo );
    }   // func end



    public boolean memberUpdate( MemberDto memberDto){
        return memberDao.memberUpdate( memberDto );
    }   // func end


}
