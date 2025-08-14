package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // [1] 회원가입
    @PostMapping("/signup")
    public int signUp(@RequestBody MemberDto memberDto ){
        int result = memberService.signUp( memberDto );
        return result;
    } // func end

    // [2] 로그인
    @PostMapping("/login")
    public int login( @RequestBody MemberDto memberDto , HttpServletRequest request ){
        // 1. 세션 정보 가져오기
        HttpSession session = request.getSession();
        // 2. 로그인 성공한 회원번호 확인
        int result = memberService.login( memberDto );
        if( result > 0 ){
            // 3. 세션 정보에 속성 추가하기.
            session.setAttribute("loginMno" , result );
        }
        // 4. 반환
        return result;
    }   // func end

    // [3] 로그아웃
    @GetMapping("/logout")
    public boolean logout( HttpServletRequest request ){
        HttpSession session = request.getSession();
        // 비로그인상태; // 로그아웃 실패
        if ( session == null || session.getAttribute("loginMno") == null ){
            return false;
        }   // if end

        session.removeAttribute("loginMno");
        return true;
    } // func end

    // [4] 회원정보 조회
    @GetMapping("/info")
    public MemberDto info( HttpServletRequest request ){
        HttpSession session = request.getSession();
        if(session == null || session.getAttribute("loginMno") == null) {
            return null;
        }   // if end
        // 로그인이면 세션 정보내 로그인상태 속성값 호출
        Object obj = session.getAttribute("loginMno"); // 로그인시 정의 속성명과 동일하게 작성
        System.out.println(obj);
        // Object 타입은 자바의 최상위 클래스로써 모든 자료를 저장한다. 세션은 Object 타입으로 저장한다.
        // 즉] 세션은 모든 타입의 자료를 저장할 수 있다.
        // 타입변환 , 강제타입변환이란?  (변환할타입명)변수명; , **태생!!** : Object 가 되기전에 타입 확인? int
        int loginMno = (int)obj;
        // 서비스에게 전달하고 응답받기
        MemberDto result  = memberService.info( loginMno );
        // 결과 반환
        return result;
    }   // func end

    // [5] 중복 검사
    @GetMapping("/check")
    public boolean check(@RequestParam String type , @RequestParam String data ){
        boolean result = memberService.check( type , data );
        return result;
    }

    // [6] 회원 정보 수정
    @PutMapping("/update")
    public boolean update( @RequestBody MemberDto memberDto , HttpServletRequest request ){
        HttpSession session = request.getSession();
        if( session == null || session.getAttribute("loginMno") == null ){
            return false;
        }   // if end

        // 가져오기
        Object obj = session.getAttribute("loginMno");

        // dto에 setter해주기
        memberDto.setMno((int) obj);

        return memberService.update(memberDto);
    }   // func end

    // [7] 비밀번호 수정
    @PutMapping("/update/password")
    public boolean updatePassword(@RequestBody Map<String,String> map , HttpServletRequest request ) {
        HttpSession session = request.getSession();

        if( session == null || session.getAttribute("loginMno") == null ){
            return false;
        }   // if end

        // 가져오기
        Object obj = session.getAttribute("loginMno");

        int loginMno = (int) obj;

        boolean result = memberService.updatePassword(loginMno , map);

        if(result)  session.removeAttribute("loginMno");

        return result;

    }   // func end

    // [8] 회원 탙퇴
    @DeleteMapping("/delete")
    public boolean delete( @RequestParam String oldpwd , HttpSession session ){
        // 1.매개변수로 받은 요청정보내 세션객체를 확인 해서 없으면 비로그인상태
        if( session == null || session.getAttribute("loginMno") == null )return false;
        // 2.
        int loginMno = (int)session.getAttribute("loginMno");
        // 3.
        boolean result = memberService.delete( loginMno , oldpwd );

        if(result)  session.removeAttribute("loginMno");

        return result;
    } // func end

    // [9] 아이디 찾기
    @PostMapping("/find")
    public MemberDto findId( @RequestBody MemberDto memberDto ){
        return memberService.findId( memberDto );
    }   // func end

    // [10] 비밀번호 찾기
    @PutMapping("/find")
    public Map<String, Object> findPwd(@RequestBody MemberDto memberDto) {
        String result = memberService.findPwd(memberDto);
        if (result.equals("bad")) {
            return Map.of("status", "bad");
        }
        return Map.of("status", result);
    }

} // class end
