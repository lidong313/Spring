<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>主页面</title>
</head>
<body>
    用户名：${sessionScope.username}
    <font color="red">${username}</font>
    <p></p>

    <a href="<%=basePath%>jsps/product/add.jsp">添加</a><br>
    <a href="<%=basePath%>jsps/product/update.jsp">修改</a><br>
    <a href="<%=basePath%>jsps/product/showall.jsp">列表</a><br>



</body>
</html>