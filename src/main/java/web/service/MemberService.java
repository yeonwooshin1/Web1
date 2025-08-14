package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

import java.security.SecureRandom;
import java.util.Map;

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
    public boolean check( String type , String data ){
        boolean result = memberDao.check( type , data );
        return result;
    }   // func end

    // [6] 회원 정보 수정
    public boolean update( MemberDto memberDto ){
        boolean result = memberDao.update( memberDto );
        return result;
    }   // func end

    // [7] 비밀번호 수정
    public boolean updatePassword( int mno , Map<String,String> map ){
        boolean result = memberDao.updatePassword( mno , map );
        return result;
    }   // func end

    // [8] 회원 탈퇴
    public boolean delete( int mno , String oldpwd ){
        boolean result = memberDao.delete( mno , oldpwd );
        return result;
    }   // func end

    // [9] 아이디 찾기
    public MemberDto findId( MemberDto memberDto ){

        return memberDao.findId( memberDto );
    }   // func end

    // [10] 비밀번호 찾기
    public String findPwd( MemberDto memberDto ){
        // 유저 번호 받기
        int result = memberDao.findPwd(memberDto);

        if(result > 0){
            String random = createRandomNum(10);
            if( !memberDao.putNewPwd( random , result) ){
                return "bad";
            }
            return random;
        } else {
            return "bad";
        }   // if end
    }   // func end

    // 난수 생성 헬퍼 메소드
    String createRandomNum(int digits) {
        // 난수
        SecureRandom RANDOM_DIGITS = new SecureRandom();
        // 10의 digits => 10 , 10의 10승의 랜덤 숫자 만듦.
        int bound = (int) Math.pow(10, digits);
        // String 화. 10자리 숫자 아니면 나머지는 0으로 채움.
        return String.format("%0" + digits + "d", RANDOM_DIGITS.nextInt(bound));
    }   // func end

}   // class end
