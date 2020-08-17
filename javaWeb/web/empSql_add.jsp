<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.mzimu.DAO.EmpDAO" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/15
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        ul{
            list-style-type: none;
            overflow: hidden;
        }
        ul li{
            margin-left: 10px;
            float: left;
        }
    </style>
    <meta charset="UTF-8">
    <title>添加数据</title>
</head>
<body>
    <ul>
        <li>
            <a href="index.jsp">首页</a>
        </li>
        <li>
            <a href="empSql_add.jsp">添加</a>
        </li>
    </ul>
    <%
        session.setAttribute("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).replace(" ","T"));
        session.setAttribute("empsJobList",new EmpDAO().JobCoum());
    %>

    <form action="/EmpAddServlet" method="post" >
        姓名 <input name="name" type="text">
        <br/>
        年龄 <input name="age" type="number">
        <br/>
        岗位
        <select name="job">
            <c:forEach var="job_Name" items="${sessionScope.empsJobList}">
                <option value="${job_Name}">${job_Name}</option>
            </c:forEach>
        </select>
        <a href="jobSql_add.jsp">添加岗位</a>
        <br/>
        工资
        <input name="salary" type="number">
        <br/>
        入职时间<input name="hireDate" type="datetime-local" value="${sessionScope.time}" >
        <input type="submit" value="提交">
    </form>
</body>
</html>
