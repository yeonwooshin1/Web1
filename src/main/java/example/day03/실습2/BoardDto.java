package example.day03.실습2;

public class BoardDto {
    // 멤버변수
    private String bwriter;
    private String bcontent;

    // 생성자
    public BoardDto(){}

    public BoardDto(String bwriter, String bcontent) {
        this.bwriter = bwriter;
        this.bcontent = bcontent;

    }

    // GETTER SETTER


    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    // toString

    @Override
    public String toString() {
        return "BoardDto{" +
                "bwriter='" + bwriter + '\'' +
                ", bcontent='" + bcontent + '\'' +
                '}';
    }
}
