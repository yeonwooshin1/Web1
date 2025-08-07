package 과제.실습3.model.dto;

public class WaitingDto {   // class start

    // 멤버변수
    private String phone;
    private int count;
    private int seq;

    // 생성자
    public WaitingDto(){}

    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }

    public WaitingDto( int seq , int count ) {
        this.seq = seq;
        this.count = count;
    }

    // getter setter 메소드 , toString()

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }

}   // class end
