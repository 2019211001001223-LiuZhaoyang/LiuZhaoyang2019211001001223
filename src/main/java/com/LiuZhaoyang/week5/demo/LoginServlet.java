package com.LiuZhaoyang.week5.demo;

import com.LiuZhaoyang.dao.UserDao;
import com.LiuZhaoyang.model.User;
import javax.servlet.ServletConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb;";
        String username="sa";
        String password="123456";
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("1连接数据库失败！");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con,username,password);
            if(user!=null) {

                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null &&rememberMe.equals("1"))

                {
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername().trim());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword().trim());
                    Cookie rememberMeCookie=new Cookie("rememberMeVal",request.getParameter("rememberMe").trim());
                    usernameCookie.setMaxAge(60*60*24*50);
                    passwordCookie.setMaxAge(60*60*24*50);
                    rememberMeCookie.setMaxAge(60*60*24*50);
                    System.out.println(usernameCookie.getValue());
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                HttpSession session=request.getSession();
                System.out.println(session.getId());
                session.setMaxInactiveInterval(60*60);
                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }
            else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
        String sqlQuery="select * from userTB where username=? and password=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1,username);
            ps.setString(2,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //out.println("<h1>Login Successful ! </h1><br/>");
                //out.println("<h1>Welcome "+ username + "</h1><br/>");
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
@@ -65,18 +80,18 @@ protected void doPost(HttpServletRequest request, HttpServletResponse response)
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            } else {
                //out.println("<h1>Login Failed ! </h1><br/>");
                //out.println("<h1>Username or Password Error ! </h1><br/>");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        //doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}