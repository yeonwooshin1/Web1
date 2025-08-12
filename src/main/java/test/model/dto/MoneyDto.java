package test.model.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MoneyDto {
    private int CustomerNo;       // 회원번호
    private String CustomerName;  // 회원성명
    private String Grade;         // 고객등급
    private int Sales;            // 총매출
}
