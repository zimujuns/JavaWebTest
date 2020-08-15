
<%@ page import="com.mzimu.utils.Condition" %>
<%@ page import="com.mzimu.service.EmpServlet" %>
<%@page contentType="text/html; ISO-8859-1" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta  charset="UTF-8">
    <style>
      td{
        text-align: center;
        font-size: 18px;
        width: 10%;
        border: 1px solid black;
      }
      table{
        border: 1px solid black;
      }

    </style>
  </head>
  <body>
    <%
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      EmpServlet es = new EmpServlet();
      String id = request.getParameter("id");
      String name = request.getParameter("name");
      String job = request.getParameter("job");
      session.setAttribute("empsList",es.findEntity(new Condition(id,name,job)));
    %>
    <div>
      <form action="/index.jsp" method="post">
          员工ID <input type="text" name="id">
          姓名 <input type="text" name="name">
          工作
          <select name="job">
            <option value="JavaWebk人员">JavaWebk人员</option>
            <option value="JavaWeb人员">JavaWeb人员</option>
            <option value="总管">总管</option>
            <option value="" selected="true">所有</option>
          </select>
          <input type="submit" value="检查">
      </form>
    </div>
    <table>
      <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>job</td>
        <td>hireDate</td>
        <td>salart</td>
        <td>deptName</td>
        <td>操作</td>
      </tr>
      <c:forEach var="empsData" items="${sessionScope.empsList}">
        <tr>
          <td>${empsData.id}</td>
          <td>${empsData.name}</td>
          <td>${empsData.age}</td>
          <td>${empsData.job}</td>
          <td>${empsData.sdf}</td>
          <td>${empsData.salary}</td>
          <td>${empsData.deptName}</td>
          <td><a>删除</a></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>