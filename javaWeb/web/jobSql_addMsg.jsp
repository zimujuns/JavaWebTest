<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/16
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加失败</title>
</head>
<body>
    <%
        response.setHeader("refresh","3;url=http://localhost:8080/index.jsp");
    %>
    <div style="display: flex">
        <h5><i>${sessionScope.msgJob}</i></h5>
        <a href="index.jsp">
            返回首页
        </a>
    </div>

</body>
</html>
