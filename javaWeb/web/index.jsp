
<%@ page import="com.mzimu.utils.Condition" %>
<%@ page import="com.mzimu.service.EmpServlet" %>
<%@ page import="com.mzimu.DAO.EmpDAO" %>
<%@page contentType="text/html; ISO-8859-1" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta  charset="UTF-8">
    <style>
      td{
        text-align: center;
        font-size: 18px;
        width: 11%;
        border: 1px solid black;
      }
      table{
        border: 1px solid black;
      }

      ul{
        list-style-type: none;
        overflow: hidden;
      }
      ul li{
        margin-left: 10px;
        float: left;
      }

    </style>
  </head>
  <body>
    <%
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      String id = request.getParameter("id");
      String name = request.getParameter("name");
      String job = request.getParameter("job");
      session.setAttribute("empsList",EmpServlet.findEntity(new Condition(id,name,job)));
      session.setAttribute("empsColumList", new EmpDAO().empsCoum());
      String js = request.getHeader("js_alert");
      if(js!=null && js.isEmpty()){
        response.getWriter().println(js);
      }


    %>
    <ul>
      <li>
        <a href="index.jsp">首页</a>
      </li>
      <li>
        <a href="empSql_add.jsp">添加</a>
      </li>
    </ul>

    <div id ="sql">
      <form action="/index.jsp" method="post">
          员工ID <input type="text" name="id">
          姓名 <input type="text" name="name">
          工作
          <select name="job">
            <c:forEach var="job_Name" items="${sessionScope.empsJobList}">
              <option value="${job_Name}">${job_Name}</option>
            </c:forEach>
            <option value="" selected="true">所有</option>
          </select>
          <input type="submit" value="检查">
      </form>
      <table>
        <tr>
          <c:forEach var="empsColum" items="${sessionScope.empsColumList}">
            <td>${empsColum}</td>
          </c:forEach>
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
            <td><a href="/EmpRemoveServlet?remove=${empsData.id}" >删除</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>