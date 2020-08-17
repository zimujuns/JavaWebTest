<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/17
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@page %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>添加职位</title>
</head>
<body>
    <form action="JobAddServlet" method="post" accept-charset="UTF-8">
        岗位名称<input name="jobSet" type="text">
        所属部门<input name="deptNameSet" type="text">
        <input value="提交" type="submit">
    </form>
</body>
</html>
