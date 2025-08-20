package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.PointDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class PointDao extends Dao {

    // 등록
    public boolean getPoint(int mno , PointDto pointDto ){
        try {
            String sql = "insert into pointlog( mno, plpoint , plcomment )values(?,?,?)"; // SQL

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, mno); ps.setInt(2, pointDto.getPlpoint());
            ps.setString(3, pointDto.getPlcomment());

            int result = ps.executeUpdate();
            return result == 1;

        } catch (Exception e){System.out.println(e);
        return false;}
    }   // func end

    // 목록 조회
    public ArrayList<PointDto> getPointList (int mno) {
        ArrayList<PointDto> list = new ArrayList<>();

        try {
            String sql = "select * from pointlog where mno = ? order by pldate desc; "; // SQL

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, mno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                PointDto dto = new PointDto();
                dto.setPlpoint(rs.getInt("plpoint"));
                dto.setPlcomment(rs.getString("plcomment"));
                dto.setPldate(rs.getString("pldate"));
                list.add(dto);
            }   // while end
        } catch (Exception e){System.out.println(e);
        }
        return list;
    }


    // 합계 조회
    public int getTotalPoint ( int mno ) {
        try {
            // COALESCE 는 젤 왼쪽이 null 이면 그 오른쪽 놈을 대신 준다는 거
            String sql = "select COALESCE(SUM(plpoint), 0) as totalPoint FROM pointlog WHERE mno = ?"; // SQL

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, mno);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return rs.getInt("totalPoint");
            }   // while end
            // 행 없으면 -99999 반환
            return -99999;
        } catch (Exception e){System.out.println(e);
            // 예외 뜨면 -88888 반환
            return -88888;
        }
    }   // func end

}   // class end
