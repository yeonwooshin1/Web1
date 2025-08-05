package example.day01.model.dto;

public class BoardDto { // class start
    // 멤버변수
    private int bno;            // 목록 번호
    private String bcontent;    // 내용
    private String bwriter;     // 작성자

    // 생성자
    public BoardDto(){}

    public BoardDto(String bcontent, String bwriter) {
        this(0 , bcontent , bwriter);
    }

    public BoardDto( int bno , String bcontent) {
        this(bno , bcontent , null);
    }

    public BoardDto(int bno, String bcontent, String bwriter) {
        this.bno = bno;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    // setter getter

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }


    // toString
    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                '}';
    }

}   // class end

