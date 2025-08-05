package example.day01.model.dao;

import example.day01.model.dto.BoardDto;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao { // class start
    // 싱글톤 만들기
    private BoardDao(){
        connectDB();
    }
    private static final BoardDao dao = new BoardDao();
    public static BoardDao getInstance() {
        return dao;
    }

    // DB 정보입력
    private String db_url = "jdbc:mysql://localhost:3306/boardService";
    private String db_user = "root";
    private String db_password = "1234";

    // Connection 연결 메소드
    private Connection getConnection () throws SQLException {
        return DriverManager.getConnection( db_url , db_user , db_password );
    }   // func end

    // DB 연동 메소드 Class.forName("com.mysql.cj.jdbc.Driver");
    private void connectDB () {
        try{
            // mysql 를 지정한 Driver 클래스 가져오기
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch ( ClassNotFoundException e ) { System.out.println("[실패] mysql 드라이버 연동 실패"); } // 클래스 있는지 잘 연결됐는지 예외
    }   // func end



    // Board 등록 메소드
    public boolean BoardWrite( BoardDto boardDto ) {
        String sql = "insert into board( bwriter , bcontent ) values (?,?)";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString(1, boardDto.getBwriter() );
            ps.setString(2, boardDto.getBcontent() );
            int result = ps.executeUpdate();

            return result == 1;
        } catch ( SQLException e ) { // 데이터 베이스 접근 예외
            System.out.println("[경고] 데이터베이스 접근 실패");
            return false;
        }    // catch end
    }   // func end

    // Board 출력 메소드
    public ArrayList<BoardDto> BoardPrint() {
        String sql = "select bno , bwriter , bcontent from board";
        ArrayList<BoardDto> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                BoardDto dto = new BoardDto();
                dto.setBno(rs.getInt("bno"));
                dto.setBwriter(rs.getString("bwriter"));
                dto.setBcontent(rs.getString("bcontent"));
                list.add(dto);
            }   // while end
        } catch (SQLException e) {
            System.out.println("[경고] 데이터베이스에서 가져오기 실패");
        }    // catch end
        return list;
    }   // func end
}