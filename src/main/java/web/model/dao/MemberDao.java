package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.MemberDto;
import web.service.MemberService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository // 스프링 컨테이너에 빈 등록
public class MemberDao extends Dao { // JDBC 연동 상속받기

    // [1] 회원가입
    public int signUp(MemberDto memberDto ){
        try{
            String sql = "insert into member( mid,mpwd,mname,mphone)values(?,?,?,?)"; // 1. SQL 작성한다.
            // 2. SQL 기재한다. + ***auto_increment(자동PK)값 결과를 반환 설정***
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS );
            // 3. SQL문법내 매개변수 대입
            ps.setString( 1 , memberDto.getMid() );     ps.setString( 2 , memberDto.getMpwd() );
            ps.setString( 3 , memberDto.getMname() );   ps.setString( 4, memberDto.getMphone() );
            // 4. 기재된 sql 실행 한 결과 레코드 저장 개수 반환
            int count = ps.executeUpdate();
            if( count == 1 ){
                // 5. auto_increment 로 자동 할당된 pk값 반환하여 rs 로 조작하기
                ResultSet rs = ps.getGeneratedKeys();
                if( rs.next() ){ // 자동 할당된 pk값중에 첫번째 pk값 으로 이동
                    int mno = rs.getInt( 1 ); // pk값 가져오기
                    return mno; // 회원가입 성공한 회원의 번호를 반환한다.
                }
            }
        } catch (Exception e) {       System.out.println(e);  }
        return 0; // 회원가입 실패시 0 반환한다.
    } // func end


    // [2] 로그인
    public int login(MemberDto memberDto) {
        try{
            String sql = "select * from member where mid = ? , mpwd = ?";
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1 , memberDto.getMid());
            ps.setString(2 , memberDto.getMpwd());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("mno");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }   // func end


    // [4] 회원정보 조회 : mno(세션)
    public MemberDto info( int mno ){
        try {
            String sql = "select * from member where mno = ? ";
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, mno);

            ResultSet rs = ps.executeQuery();

            if ( rs.next() ) {
                MemberDto memberDto  = new MemberDto(); // pwd 제외
                memberDto.setMno( rs.getInt( "mno" ) );
                memberDto.setMid( rs.getString( "mid" ) );
                memberDto.setMname( rs.getString( "mname" ) );
                memberDto.setMphone( rs.getString( "mphone" ) );
                memberDto.setMdate( rs.getString( "mdate" ) );
                return memberDto;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }   // func end


    // [5] 중복 검사

    // [6] 회원 정보 수정

    // [7] 비밀번호 수정

    // [8] 회원 탙퇴



} // class end
