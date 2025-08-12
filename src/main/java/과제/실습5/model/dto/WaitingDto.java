package 과제.실습5.model.dto;

import lombok.*;
@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 풀 생성자
@Getter // getter
@Setter // setter
@ToString // ToString
public class WaitingDto {   // class start
    // 멤버변수
    private String phone;
    private int count;
    private String date;
    private int seq;
}   // class end
