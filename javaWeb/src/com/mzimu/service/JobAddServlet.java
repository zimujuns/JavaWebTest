package com.mzimu.service;

import com.mzimu.DAO.EmpDAO;
import com.mzimu.pojo.JobData;
import com.mzimu.utils.Condition;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class JobAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String job = req.getParameter("jobSet");
        String deptName = req.getParameter("deptNameSet");
        try {
            EmpServlet.addJob(new JobData(job,deptName));
            req.getSession().setAttribute("msgJob","添加成功! 3秒钟后自动返回首页 若未返回请手动返回");
        } catch (SQLException e) {
            req.getSession().setAttribute("msgJob","添加失败!请通知管理员 3秒钟后自动返回首页 若未返回请手动返回");
        }finally {
            resp.setHeader("refresh","5;http://localhost:8080/jobSql_addMsg.jsp");
            resp.sendRedirect("http://localhost:8080/jobSql_addMsg.jsp");
        }
    }
}
