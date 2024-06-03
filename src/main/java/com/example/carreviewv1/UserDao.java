package com.example.carreviewv1;

import java.sql.*;

public class UserDao {
    Connection con=null;
    Statement st=null;
    public UserDao() {
        con=MyConnection.connect();
        if (con!=null){
            try {
                st= con.createStatement();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
                //throw new RuntimeException(e);
            }
        }

    }
    public int insert (String uname,String psswrd,String gender,String loc){
        String req="insert into User values (?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(req);
            ps.setString(1,uname);
            ps.setString(2,psswrd);
            ps.setString(3,gender);
            ps.setString(4,loc);
            return ps.executeUpdate();
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            return 0;
        }



    }
    public ResultSet login(String uname,String psswrd){
        String req="select * from user where Uname =? and Password =?";
        PreparedStatement ps= null;
        try {
            ps = con.prepareStatement(req);
            ps.setString(1,uname);
            ps.setString(2,psswrd);
            //int a= ps.executeUpdate();
            //ResultSet rs= st.executeQuery("select * from user where Uname ="+uname+"and Password ="+psswrd);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
           // throw new RuntimeException(e);
            System.out.println(e.getMessage());
            return null;

        }

    }

    public ResultSet select(String req3)  {

        try {
            //st.executeUpdate(req3);
            return st.executeQuery(req3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
