<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<h1>Login</h1><br>
<%
    if(request.getAttribute("msg") != null)
    {
        out.println("<h3 style = 'color:red'>"+request.getAttribute("msg")+"</h3>");
    }
%>
<%
    //read cookies
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeval="";
    if(allCookies!=null){
        //we read 3 cookies
        for(Cookie c:allCookies){
            //get one by one
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeval=c.getValue();
            }
        }
    }
%>

<form method="post" action="${pageContext.request.contextPath}/login">
    Username:<input type="text" name="username" value="<%=username%>"><br/>

    Password:<input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeval.equals("1") ?"checked":""%>/>RememberMe<br/>
    <input type="submit" value="submit"/>
</form>
<%@include file="footer.jsp" %>
