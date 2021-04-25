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

<%--<%Cookie []allCookies=request.getCookies();--%>
<%--for (Cookie c:allCookies){--%>
<%--    out.println("<br/>"+c.getName()+"---"+c.getValue());--%>
<%--}--%>
<%--%>--%>
<%
    User u=(User) session.getAttribute("user");
%>
<table border="1" >
    <tr>
        <td>Username</td><td><%=u.getUsername()%></td> </tr>
    <td>Password</td><td><%=u.getPassword()%></td> </tr>
    <td>Email</td> <td><%=u.getEmail()%></td> </tr>
    <td>Gender</td><td><%=u.getGender()%></td> </tr>
    <td>Birthdate</td> <td><%=u.getBirthDate()%></td>
    </tr>
    <tr>
        <td><a href="updateUser">update User</a></td>
    </tr>
</table>

<%@include file="footer.jsp" %>
