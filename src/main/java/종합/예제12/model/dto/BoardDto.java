package 종합.예제12.model.dto;  // package

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BoardDto { // class start
    // 멤버변수
    private int bno;
    private String bcontent;
    private String bwriter;

}   // class end
