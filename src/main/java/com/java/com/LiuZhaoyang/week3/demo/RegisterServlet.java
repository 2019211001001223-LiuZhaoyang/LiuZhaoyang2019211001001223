package com.LiuZhaoyang.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");


        PrintWriter writer = response.getWriter();
        writer.println("<br>Username :" + username);
        writer.println("<br>Password :" + password);
        writer.println("<br>Email :" + email);
        writer.println("<br>gender :" + gender);
        writer.println("<br>birthDate :" + birthDate);

        writer.close();
        try {
            Statement st = con.createStatement();
            String sql = "insert into usertable(username,password,email,gender,birthdate) " +
                    "values('" + username + "','" + password + "','" + email + "','" + gender + "','" + birthDate + "')";
            System.out.println("sql" + sql);

            int n = st.executeUpdate(sql);
            System.out.println("n-->" + n);

            sql = "select id,username,password,email,gender,birthdate from usertable";
            ResultSet rs =st.executeQuery(sql);
            PrintWriter out = response.getWriter();

            response.sendRedirect("login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
