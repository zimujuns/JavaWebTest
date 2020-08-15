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
@MultipartConfig
public class EmpServlet extends HttpServlet {


    public ArrayList<EntityData> findEntity(Condition cd){
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
}
