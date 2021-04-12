<%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/3/14
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <h1>My JSP page</h1>
</head>
<body>
<%@include file="header.jsp" %>
This is my JSP page. <br>
<br/>
<%@include file="footer.jsp" %>
</body>
</html>

