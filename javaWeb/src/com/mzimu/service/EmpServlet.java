package com.mzimu.service;



import com.mzimu.DAO.EmpDAO;
import com.mzimu.pojo.EntityData;
import com.mzimu.utils.Condition;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * 服务层
 */
public class EmpServlet {


    public static ArrayList<EntityData> findEntity(Condition cd){
        ArrayList<EntityData> eds = new ArrayList<>();
        StringBuffer sb = new StringBuffer("select * from emps where 1=1");
        sb.append(cd.getWhere());
        EmpDAO empDAO = new EmpDAO();
        try {
            eds = empDAO.findEmpBySql(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eds;
    }

    public static void addEntity(String name, String age, String job, String salary, String deptName, String hireDate) throws SQLException {
        StringBuffer sb = new StringBuffer("insert into emps(name,age,job,hireDate,salary,deptName) values('");
        sb.append(name).append("',").append(age).append(",'").append(job).append("','").append(hireDate).append("',").append(salary).append(",'").append(deptName).append("');");
        EmpDAO empDAO = new EmpDAO();
        empDAO.empBySql(sb.toString());
    }

    public static void removeEntity(String key,String value){
        StringBuffer sb = new StringBuffer("delete from emps where ");
        sb.append(key).append("='").append(value).append("';");
        EmpDAO empDAO = new EmpDAO();
        try{
            empDAO.empBySql(sb.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void removeEntity(String key,Number value){
        StringBuffer sb = new StringBuffer("delete from emps where ");
        sb.append(key).append("=").append(value).append(";");
        EmpDAO empDAO = new EmpDAO();
        try{
            empDAO.empBySql(sb.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
