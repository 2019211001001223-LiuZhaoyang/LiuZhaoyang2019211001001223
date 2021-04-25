<%@ page import="com.LiuZhaoyang.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/4/25
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User update</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<form action="updateUser" method="post" >
    <input type="hidden" name="id" value="<%=u.getId()%>">
    <span style="color:#FFB6C1">Username</span> <input type="text" name="name" required="true" style="background-color: #EAEAAE" value="<%=u.getUsername()%>"><br/>
    <span style="color: #FFB6C1">Password</span> <input type="password" name="password" maxlength="8" style="background-color: #EAEAAE" value="<%=u.getPassword()%>"><br/>
    <span style="color: #FFB6C1">Email</span><input type="email" name="email" required="true"style="background-color: #EAEAAE" value="<%=u.getEmail()%>"><br/>
    <span style="color: #FFB6C1">Gender</span>
    <label for="1">
        <input type="radio" name="gender" value="male" <%= "male".equals(u.getGender()) ?"checked" :""%> id="1"/> <span style="color: #D2B48C">Male</span>
    </label>

    <label for="2">
        <input type="radio" name="gender" value="female" <%= "female".equals(u.getGender()) ?"checked" :""%>id="2"/> <span style="color: #D2B48C">Female</span>
    </label>
    <br/>
    <span style="color: #FFA500">Date of birth(yyyy-mm-dd)</span><input type="date"name="birth"  value="<%=u.getBirthDate()%>" pattern="yyyy-mm-dd" required="true"style="background-color: #EAEAAE"><br/>
    <input type="submit" value="Save Changes" style="background-color: #EAEAAE">


</form>
<%@include file="footer.jsp"%>