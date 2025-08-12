package test.model.dao;

import org.springframework.stereotype.Repository;
import test.model.dto.MemberDto;
import 종합.예제12.model.dto.BoardDto;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class MemberDao extends Dao{



    // 등록
    public boolean memberWrite( MemberDto memberDto ){
        try {
            String sql = "INSERT INTO MEMBER_TBL_02 ( CUSTNAME  , PHONE , ADDRESS , JOINDATE , GRADE , CITY ) " +
                    "VALUES ( ? , ? , ? , ? , ? , ? );";  // 1. SQL 작성한다.
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );  // 2. SQL 기재한다..
            // 3. SQL 매개변수 대입 , 현재 ? 2개
            ps.setString( 1 , memberDto.getCustomerName() );
            ps.setString( 2 , memberDto.getPhone() );
            ps.setString( 3 , memberDto.getAddress() );
            if (memberDto.getJoinDate() == null || memberDto.getJoinDate().isBlank()) {
                ps.setNull(4, java.sql.Types.DATE);
            } else {
                // dto.getJoinDate()는 yyyy-MM-dd
                ps.setDate(4, java.sql.Date.valueOf(memberDto.getJoinDate()));
            }
            ps.setString( 5 , memberDto.getGrade() );
            ps.setString( 6 , memberDto.getCity() );

            // 4. SQL 실행  , insert/update/delete 은 .executeUpdate();
            int count = ps.executeUpdate();
            // 5. sql 결과에 따른 로직/리턴/확인
            if( count >= 1 ) return true; // 1개 이상 insert 했으면 저장성공
            return false; // 1개이상 insert 못했으면 저장실패
        } catch (Exception e) { System.out.println(e); } // catch end
        return false; // 예외 발생시 저장실패.
    }   // func end



    // 조회
    public ArrayList<MemberDto> memberPrint(){
        ArrayList<MemberDto> list = new ArrayList<>();
        try {
            String sql = "select * from MEMBER_TBL_02 order by CUSTNO"; // 1. SQL 작성
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );  // 2. SQL 기재한다..

            // 3. SQL 매개변수 대입 , SQL문법에 ?(매개변수)가 없어서 생략
            ResultSet rs = ps.executeQuery();  // 4. SQL 실행   , select = executeQuery()

            while (rs.next()) {

                int CustomerNo = rs.getInt("CUSTNO"); // rs.get타입("가져올속성명or번호")
                String CustomerName = rs.getString("CUSTNAME");
                String phone = rs.getString("PHONE");
                String address =  rs.getString("ADDRESS");
                java.sql.Date jd = rs.getDate("JOINDATE");
                String joinDate = (jd != null) ? jd.toLocalDate().toString() : null; // yyyy-MM-dd
                String grade =  rs.getString("GRADE");
                String city =  rs.getString("CITY");

                MemberDto memberDto = new MemberDto(CustomerNo, CustomerName, phone , address
                , joinDate , grade ,  city );

                list.add(memberDto);
            } // while 반복문 종료
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }   // func end

    // 개별 조회
    public MemberDto memberFind( int customerNo ){
        MemberDto dto = new MemberDto();
        try {
            String sql = "select * from MEMBER_TBL_02 where CUSTNO = ?";
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customerNo);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                java.sql.Date jd = rs.getDate("JOINDATE");
                String joinDate = (jd != null) ? jd.toLocalDate().toString() : null; // yyyy-MM-dd
                dto.setJoinDate(joinDate);

                dto.setCustomerNo(rs.getInt("CUSTNO")); // rs.get타입("가져올속성명or번호")
                dto.setCustomerName(rs.getString("CUSTNAME") );
                dto.setPhone(rs.getString("PHONE"));
                dto.setAddress(rs.getString("ADDRESS"));
                dto.setGrade( rs.getString("GRADE"));
                dto.setCity(rs.getString("CITY"));
            }   // if end
        } catch (Exception e) {
            System.out.println(e);
        }
        return dto;
    }   // func end


    // 수정
    public boolean memberUpdate( MemberDto memberDto){
        try { // * try ~ catch
            String sql = "update MEMBER_TBL_02 set CUSTNAME = ? , PHONE = ? , ADDRESS = ? , JOINDATE = ? , GRADE = ? , CITY = ? where CUSTNO = ? "; // 1. SQL 작성
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );  // 2. SQL 기재한다..
            // 3. SQL 매개변수 대입 , SQL문법내 ? 개수만큼 대입
            ps.setString( 1 , memberDto.getCustomerName() );
            ps.setString( 2 , memberDto.getPhone() );
            ps.setString( 3 , memberDto.getAddress() );
            if (memberDto.getJoinDate() == null || memberDto.getJoinDate().isBlank()) {
                ps.setNull(4, java.sql.Types.DATE);
            } else {
                // dto.getJoinDate()는 yyyy-MM-dd
                ps.setDate(4, java.sql.Date.valueOf(memberDto.getJoinDate()));
            }
            ps.setString( 5 , memberDto.getGrade() );
            ps.setString( 6 , memberDto.getCity() );
            ps.setInt(7, memberDto.getCustomerNo());

            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1 ) return true; // 수정 sql 결과가 1개 이면 수정성공
            return false; // 수정 sql 결과가 1이 아니면 수정실패
        } catch (Exception e) { System.out.println(e);  }
        return false; // 예외발생시 수정실패
    }   // func end

} // class end
