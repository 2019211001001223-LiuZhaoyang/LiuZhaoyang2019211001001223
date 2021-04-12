<%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/4/6
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%@include file="header.jsp" %>
<h3>Login</h3>
<form method="post" action="${pageContext.request.contextPath}/login">
    <p>Username:<input type="text" name="name"/></p>
    <p>Password:<input type="password" name="password"/></p>
    <input type="submit" value="Login"/>
</form>
</body>
<%@include file="footer.jsp" %>
</html>