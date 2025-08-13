package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

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
        if(session == null || session.getAttribute("loginNo") == null) {
            return null;
        }   // if end
        // 로그인이면 세션 정보내 로그인상태 속성값 호출
        Object obj = session.getAttribute("loginMno"); // 로그인시 정의 속성명과 동일하게 작성
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

    // [6] 회원 정보 수정

    // [7] 비밀번호 수정

    // [8] 회원 탙퇴




} // class end
