package test.model.dao;

import org.springframework.stereotype.Repository;

import test.model.dto.MoneyDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class MoneyDao extends Dao {

    public ArrayList<MoneyDto> moneyPrint(){
        ArrayList<MoneyDto> list = new ArrayList<>();
        String sql =
                "SELECT " +
                        "  MEMBER_TBL_02.CUSTNO   AS CustomerNo, " +
                        "  MEMBER_TBL_02.CUSTNAME AS CustomerName, " +
                        "  MEMBER_TBL_02.GRADE    AS Grade, " +
                        "  SUM(MONEY_TBL_02.PRICE) AS Sales " +
                        "FROM MEMBER_TBL_02 " +
                        "INNER JOIN MONEY_TBL_02 " +
                        "  ON MONEY_TBL_02.CUSTNO = MEMBER_TBL_02.CUSTNO " +
                        "GROUP BY " +
                        "  MEMBER_TBL_02.CUSTNO, MEMBER_TBL_02.CUSTNAME, MEMBER_TBL_02.GRADE " +
                        "ORDER BY Sales DESC, MEMBER_TBL_02.CUSTNO ASC";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new MoneyDto(
                        rs.getInt("CustomerNo"),
                        rs.getString("CustomerName"),
                        rs.getString("Grade"),
                        rs.getInt("Sales")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }   // func end

}
