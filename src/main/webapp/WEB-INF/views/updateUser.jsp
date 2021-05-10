<%@ page import="com.LiuZhaoyang.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/4/25
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<h1>User update</h1>
<%
    User user=(User) session.getAttribute("user");
%>

<head>
    <title>register</title>
    <script>
        function isPasswordValid() {
            var psw=document.getElementById("psw").value;
            if(psw.length<8) {
                alert("password lenth less than 8:，"+psw.length+"/8");
                document.getElementById("psw").style.color="red";
                return false;
            }
            document.getElementById("psw").style.color="green";
            return true;
        }
        function isMailValid(){
            var x=document.getElementById("mail").value;
            var atpos=x.indexOf("@");
            var dotpos=x.lastIndexOf(".");
            if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
                alert("e-mail format wrong");
                document.getElementById("mail").style.color="red";
                return false;
            }
            document.getElementById("mail").style.color="green";
            return true;
        }
        function isDateValid() {
            var obj=document.getElementById("birth");
            var strDate = obj.value;
            console.log(strDate+"-<")
            var re = /^(\d{4})-(\d{2})-(\d{2})$/;
            if (re.test(strDate))//判断日期格式符合YYYY-MM-DD标准
            {
                var dateElement = new Date(RegExp.$1, parseInt(RegExp.$2, 10) - 1, RegExp.$3);
                if (!((dateElement.getFullYear() == parseInt(RegExp.$1)) && ((dateElement.getMonth() + 1) == parseInt(RegExp.$2, 10)) && (dateElement.getDate() == parseInt(RegExp.$3))))//判断日期逻辑
                {

                    alert("You can only input Date.(YYYY-MM-DD) !");
                    document.getElementById("birth").style.color="red";
                    return false;
                }
            } else {
                alert("You can only input Date.(YYYY-MM-DD)!");
                document.getElementById("birth").style.color="red";
                return false;
            }
            document.getElementById("birth").style.color="green";
            return true;
        }
        function checkAll() {
            if(isDateValid()&&isMailValid()&&isPasswordValid()&&document.getElementById("userName").value!=null&&document.getElementById("sex").value!=null) {
                alert("update complete")
                return true;
            }
            alert("update failed")
            return false;
        }
    </script>
</head>
<body>
<h1>User update!</h1>
<form action="updateUser" method="post" onsubmit="checkAll()">
    <input type="hidden" id="id" name="id" value="<%=user.getId()%>">
    Username:<input type="text" id="username" name="username" value="<%=user.getUsername()%>"><br>
    Password:<input type="text" id="psw" name="password" onchange="isPasswordValid()" value="<%=user.getPassword()%>"><br>
    E-mail:<input type="email" id="mail" name="email" onchange="isMailValid()" value="<%=user.getEmail()%>"><br>
    Gender:<input type="radio" name="sex" value="male" <%=user.getGender().trim().equals("male")?"checked":""%>>male
    <input type="radio" name="sex" value="female" <%=user.getGender().trim().equals("female")?"checked":""%>>female<br>
    Birth:<input type="text" id="birth" name="birth" onchange="isDateValid()" value="<%=user.getBirthDate()%>"><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
<%@ include file="footer.jsp"%>