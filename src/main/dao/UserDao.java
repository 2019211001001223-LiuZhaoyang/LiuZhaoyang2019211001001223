package com.LiuZhaoyang.dao;

import com.LiuZhaoyang.model.User;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, Object o) throws SQLException {
        return false;
    }

    @Override
    public int deleteUser(Connection con, Object o) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, Object o) throws SQLException {
        return 0;
    }

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {

        String sql="insert into usertable values(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ps.setString(2, (String) user.getUsername());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getGender());
            ps.setDate(6, (java.sql.Date) user.getBirthDate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps.execute();
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from usertable where username=? and password=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) user.getUsername());
            ps.setString(2,user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps.executeUpdate();
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        try{
            Statement createDbStatement = con.createStatement();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dbRequire="update usertable set username='"+user.getUsername()+"',password='"+user.getPassword()+"',mail='"+user.getEmail()+"',sex='"+user.getGender()+"',birth='"+simpleDateFormat.format(user.getBirthDate())+"' where id="+user.getId();
            createDbStatement.executeUpdate(dbRequire);
            System.out.println("update "+user.getId()+"success");
            return 1;
        }catch(Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        User user = null;
        String sqlQuery="select * from usertable where id=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setInt(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        User user = null;
        String sqlQuery="select * from usertable where username=? and password=?";
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

                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from usertable where username=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from userTtable where password=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from usertable where email=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1,email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from usertable where gender=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1,gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from usertable where birthdate=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setDate(1, (java.sql.Date) birthDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        List<User> listuser = null;
        String sqlQuery="select * from usertable";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));
                listuser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuser;
    }
}