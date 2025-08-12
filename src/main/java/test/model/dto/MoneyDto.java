package test.model.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MoneyDto {
    private int customerNo;       // 회원번호
    private String customerName;  // 회원성명
    private String grade;         // 고객등급
    private int sales;            // 총매출
}
