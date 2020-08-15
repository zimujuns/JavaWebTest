package com.mzimu.DAO;

import com.mzimu.pojo.EntityData;
import com.mzimu.utils.GetConnection;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * 持久层
 */
public class EmpDAO {

    public ArrayList<EntityData> findEmpBySql(String sql) throws SQLException {
        ArrayList<EntityData> eds = new ArrayList<>();
        Connection conn = GetConnection.getConn();
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()){
            EntityData ed = new EntityData(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(4),
                    rs.getString(7),
                    rs.getDate(5),
                    rs.getInt(3),
                    rs.getFloat(6)
            );
            eds.add(ed);
        }
        rs.close();
        stat.close();
        conn.close();
        return eds;
    }


    //增加或者删除或者插入的操作
    public void removeEmpBySql(String sql) throws SQLException {
        Connection conn = GetConnection.getConn();
        Statement stat = conn.createStatement();
        stat.execute(sql);
        stat.close();
        conn.close();
    }

}
