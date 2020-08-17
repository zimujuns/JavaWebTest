package com.mzimu.DAO;

import com.mysql.cj.protocol.Resultset;
import com.mzimu.pojo.EntityData;
import com.mzimu.pojo.JobData;
import com.mzimu.utils.GetConnection;

import java.lang.reflect.Array;
import java.sql.*;
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

    public ArrayList<JobData> findJobBySql(String sql) throws SQLException {
        ArrayList<JobData> eds = new ArrayList<>();
        Connection conn = GetConnection.getConn();
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()){
            JobData jd = new JobData(
                    rs.getString(1),
                    rs.getString(2)
            );
            eds.add(jd);
        }
        rs.close();
        stat.close();
        conn.close();
        return eds;
    }

    //增加或者删除或者插入的操作
    public void empBySql(String sql) throws SQLException {
        Connection conn = GetConnection.getConn();
        Statement stat = conn.createStatement();
        stat.execute(sql);
        stat.close();
        conn.close();
    }

    //获取表结构
    public ArrayList<String> empsCoum() throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        Connection conn = GetConnection.getConn();
        //与Statement 区别是  这个是个预编译的方法
        PreparedStatement pst = conn.prepareStatement("select * from emps");
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData rsmd =  rs.getMetaData();
        for(int i=1;i<=rsmd.getColumnCount();i++){
            list.add(rsmd.getColumnName(i));
        }
        return list;
    }

    public ArrayList<String> JobCoum() throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        Connection conn = GetConnection.getConn();
        PreparedStatement stat = conn.prepareStatement("select * from empsJob");
        ResultSet rs = stat.executeQuery();
        while (rs.next()){
            list.add(rs.getString("job"));
        }
        return list;
    }
}
