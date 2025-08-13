package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@Service // 스프링 컨테이너(메모리) 빈(객체) 등록
public class MemberService {
    @Autowired // 스프링 컨테이너(메모리)에 등록된 빈 주입(꺼내) 받기
    private MemberDao memberDao;

    // [1] 회원가입
    public int signUp(MemberDto memberDto ){
        int result = memberDao.signUp( memberDto );
        return result;
    }   // func end

    // [2] 로그인
    public int login(MemberDto memberDto) {
        int result = memberDao.login( memberDto );
        return result;
    }   // func end


    // [4] 회원정보조회
    public MemberDto info( int mno ){
        MemberDto result = memberDao.info( mno );
        return result;
    }   // func end

    // [5] 중복 검사


    // [6] 회원 정보 수정

    // [7] 비밀번호 수정

    // [8] 회원 탙퇴
}
