package example.day08._2MVC.model.dao;  // package

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository // [3] Repository 빈 등록
public class MvcDao extends Dao {   // class start
    // 다음 레이어(계층) 없어서 @AutoWired 없다.

    public void method(){
        System.out.println("MvcDao.method");
        try{
            String sql = "select * from mvc";
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("var1"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }   // func end

}   // class end
