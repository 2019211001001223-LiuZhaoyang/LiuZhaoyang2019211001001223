<%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/3/21
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
<form method="post" action="register">
    UserName :<input type="text" name="username"><br/>
    password :<input type="text" name="password"><br/>
    Email :<input type="text" name="email"><br/>
    Gender: <input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="Female">Female<br/>
    Date of Birth :<input type="text" name="birthDate"><br/>
    <input type="submit" value="Register"/>
</form>
<%@include file="header.jsp"%>
