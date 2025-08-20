package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.model.dto.PointDto;
import web.service.PointService;

import java.util.ArrayList;

@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    private PointService pointService;

    // 목록 조회
    @GetMapping("/list")
    public ArrayList<PointDto> getPointList (HttpServletRequest request ) {

        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("loginMno") == null) {
            return null;
        }   // if end

        // 로그인이면 세션 정보내 로그인상태 속성값 호출
        Object obj = session.getAttribute("loginMno"); // 로그인시 정의 속성명과 동일하게 작성
        System.out.println(obj);
        // Object 타입은 자바의 최상위 클래스로써 모든 자료를 저장한다. 세션은 Object 타입으로 저장한다.
        // 즉] 세션은 모든 타입의 자료를 저장할 수 있다.
        // 타입변환 , 강제타입변환이란?  (변환할타입명)변수명; , **태생!!** : Object 가 되기전에 타입 확인? int
        int loginMno = (int) obj;
        // 서비스에게 전달하고 응답받기
        ArrayList<PointDto> result = pointService.getPointList(loginMno);
        // 결과 반환
        return result;
    }

    // 포인트 조회
    @GetMapping("/total")
    public int getTotalPoint (HttpServletRequest request ) {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("loginMno") == null) {
            return -99999;
        }   // if end

        // 로그인이면 세션 정보내 로그인상태 속성값 호출
        Object obj = session.getAttribute("loginMno"); // 로그인시 정의 속성명과 동일하게 작성
        System.out.println(obj);
        // Object 타입은 자바의 최상위 클래스로써 모든 자료를 저장한다. 세션은 Object 타입으로 저장한다.
        // 즉] 세션은 모든 타입의 자료를 저장할 수 있다.
        // 타입변환 , 강제타입변환이란?  (변환할타입명)변수명; , **태생!!** : Object 가 되기전에 타입 확인? int
        int loginMno = (int) obj;
        // 서비스에게 전달하고 응답받기
        int result = pointService.getTotalPoint(loginMno);
        // 결과 반환
        return result;
    }   // func end

}   // class end
