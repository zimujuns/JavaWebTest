<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/15
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <% request.getSession().setAttribute("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).replace(" ","T")); %>

    <form action="/EmpAddServlet" method="post" >
        姓名 <input name="name" type="text">
        <br/>
        年龄 <input name="age" type="number">
        <br/>
        岗位
        <!-- 这里可以做一个jstl的遍历 然后通过Java代码来获取数据库的表[数据库表需要创建一个外键,用来存放职位的]  -->
        <select name="job">
            <option selected="true">JavaWeb人员</option>
            <option>JavaWebk人员</option>
            <option>总管</option>
        </select>
        <br/>
        工资
        <input name="salary" type="number">
        <br/>
        部门
        <select name="deptName">
            <option>研发部</option>
        </select>
        <br/>
        入职时间<input name="hireDate" type="datetime-local" value="${sessionScope.time}" >
        <input type="submit" value="提交">
    </form>
</body>
</html>
