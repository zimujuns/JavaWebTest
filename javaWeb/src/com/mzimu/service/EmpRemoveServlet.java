package com.mzimu.service;

import com.mzimu.DAO.EmpDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmpRemoveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("remove");
        EmpServlet.removeEntity("id",id);
        resp.setHeader("js_alert","<script> alert('已将数据删除!') </script>");
        resp.sendRedirect("http://localhost:8080/index.jsp");
    }
}
