<%@ page import="com.LiuZhaoyang.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/4/11
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" language="java"%>

<h2>User Info</h2>
<%
    User user=(User) request.getAttribute("user");
%>
<table border="1" >
    <tr>
        <td>Username</td><td><%=user.getUsername()%></td> </tr>
    <td>Password</td><td><%=user.getPassword()%></td> </tr>
    <td>Email</td> <td><%=user.getEmail()%></td> </tr>
    <td>Gender</td><td><%=user.getGender()%></td> </tr>
    <td>Birthdate</td> <td><%=user.getBirthDate()%></td>
    </tr>
</table>

<%@include file="footer.jsp" %>
