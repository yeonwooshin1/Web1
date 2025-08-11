package 종합.예제12.model.dao;   // package

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {  // class start
    // DB연동 생성자 * 싱글톤 아니다.
    public Dao(){
        connect();
    }

    // DB에 대한 정보 받아오기
    private String db_url = "jdbc:mysql://localhost:3306/boardService";  // DB 주소
    private String db_user = "root";                                    // 이름
    private String db_password = "1234";                                // 비밀번호

    // connection 연결 메소드 , 상속 받아야해서 public으로 해줌
    public Connection getConnection() throws SQLException {            // SQLException 던지기
        return DriverManager.getConnection(db_url, db_user, db_password);   // DriverManager.getConnection(매개변수값 3개)
    }

    // 연동 함수
    private void connect(){
        try{
            // mysql 를 지정한 Driver 클래스 가져오기
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch ( ClassNotFoundException e ) { System.out.println("[실패] mysql 드라이버 연동 실패"); } // 클래스 있는지 잘 연결됐는지 예외
    }   // func end
}   // class end

