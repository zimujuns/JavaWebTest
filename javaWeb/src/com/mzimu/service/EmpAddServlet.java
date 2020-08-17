package com.mzimu.service;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class EmpAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String job = req.getParameter("job");
        String salary = req.getParameter("salary");
        String hireDate = req.getParameter("hireDate").replace("T"," ");
        try {
            EmpServlet.addEntity(name,age,job,salary,hireDate);
            req.getSession().setAttribute("msg","添加成功! 3秒钟后自动返回首页 若未返回请手动返回");
        } catch (SQLException e) {
            req.getSession().setAttribute("msg","添加失败!请通知管理员 3秒钟后自动返回首页 若未返回请手动返回");
        }finally {
            resp.sendRedirect("http://localhost:8080/empSql_addMsg.jsp");
        }

    }
}
