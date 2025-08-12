package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.model.dto.MemberDto;
import test.service.MemberService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;

@RestController
@RequestMapping("/member")
public class MemberController {
    // 가져오기
    @Autowired
    private MemberService memberService;

    // 메소드
    @PostMapping
    public boolean memberWrite(@RequestBody MemberDto memberDto){
        // joinDate 정규화: "YYYYMMDD" 또는 "yyyy-MM-dd" → "yyyy-MM-dd", 빈값/누락 → null
        memberDto.setJoinDate(normalizeIsoDate(memberDto.getJoinDate()));
        return memberService.memberWrite( memberDto );
    }   // func end

    @GetMapping
    public ArrayList<MemberDto> memberPrint(){
        return memberService.memberPrint();
    }   // func end

    @GetMapping("/find")
    public MemberDto memberFind( int customerNo ){
        return memberService.memberFind( customerNo );
    }   // func end

    @PutMapping
    public boolean memberUpdate(@RequestBody MemberDto memberDto){
        memberDto.setJoinDate(normalizeIsoDate(memberDto.getJoinDate()));
        return memberService.memberUpdate( memberDto );
    }   // func end

    // ---------- 유틸: 8자리/ISO 허용, 그 외는 null ----------
    private String normalizeIsoDate(String raw) {
        if (raw == null) return null;
        String s = raw.trim();
        if (s.isEmpty()) return null;

        // 이미 yyyy-MM-dd 형태면 유효성만 확인 후 그대로 사용
        if (s.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return isValidIso(s) ? s : null;
        }

        // 숫자만 남기고 8자리면 하이픈 삽입
        String digits = s.replaceAll("\\D", "");
        if (digits.length() == 8) {
            String iso = digits.substring(0,4) + "-" + digits.substring(4,6) + "-" + digits.substring(6,8);
            return isValidIso(iso) ? iso : null;
        }
        return null; // 형식 불일치 시 null 처리(원하면 예외로 바꿔도 됨)
    }

    private boolean isValidIso(String iso) {
        try {
            DateTimeFormatter f = DateTimeFormatter.ISO_LOCAL_DATE.withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(iso, f);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}   // class end
