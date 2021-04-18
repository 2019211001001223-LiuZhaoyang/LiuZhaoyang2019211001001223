<<<<<<< HEAD
<%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/4/11
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" language="java"%>

<h2>User Info</h2>

<table border="1" >
    <tr>
        <td>Username</td><td><%=request.getAttribute("Username")%></td> </tr>
    <td>Password</td><td><%=request.getAttribute("Username")%></td> </tr>
    <td>Email</td> <td><%=request.getAttribute("Email")%></td> </tr>
    <td>Gender</td><td><%=request.getAttribute("Gender")%></td> </tr>
    <td>Birthdate</td> <td><%=request.getAttribute("Birthdate")%></td>
    </tr>
</table>

<%@include file="footer.jsp" %>
=======
<%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/4/11
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" language="java"%>

<h2>User Info</h2>

<table border="1" >
    <tr>
        <td>Username</td><td><%=request.getAttribute("Username")%></td> </tr>
    <td>Password</td><td><%=request.getAttribute("Username")%></td> </tr>
    <td>Email</td> <td><%=request.getAttribute("Email")%></td> </tr>
    <td>Gender</td><td><%=request.getAttribute("Gender")%></td> </tr>
    <td>Birthdate</td> <td><%=request.getAttribute("Birthdate")%></td>
    </tr>
</table>

<%@include file="footer.jsp" %>
>>>>>>> origin/master
