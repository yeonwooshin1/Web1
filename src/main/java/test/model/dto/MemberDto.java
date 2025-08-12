package test.model.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDto {
    private int customerNo;     // 고객번호
    private String customerName;    // 고객 이름
    private String phone;           // 고객 번호
    private String address;         // 주소
    private String joinDate;        // 가입날짜
    private String grade;             // 고객 등급
    private String city;           // 거주도시 코드
}
