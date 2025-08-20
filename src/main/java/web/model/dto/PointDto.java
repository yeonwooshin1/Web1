package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Data
public class PointDto {
    private int plno ;  // 포인트 번호
    private int mno ;   // 회원 번호
    private int plpoint ;   // 포인트량
    private String plcomment ;  // 포인트 지급 사유
}   // class end
