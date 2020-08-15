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
        String deptName = req.getParameter("deptName");
        String hireDate = req.getParameter("hireDate").replace("T"," ");
        try {
            EmpServlet.addEntity(name,age,job,salary,deptName,hireDate);
            resp.sendRedirect("http://localhost:8080/empSql_addYes.jsp");
        } catch (SQLException e) {
            resp.sendRedirect("http://localhost:8080/empSql_addNo.jsp");
        }

    }
}
