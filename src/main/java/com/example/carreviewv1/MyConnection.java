package com.example.carreviewv1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MyConnection {
    public static Connection connect(){

        Connection con=null;
        String nom_driver="com.mysql.jdbc.Driver";
        try {
            Class.forName(nom_driver);
            System.out.println("driver charge");
            String Url="jdbc:mysql://127.0.0.1/carreviewdatabase";
            String user="root";
            String password="";
            con= DriverManager.getConnection(Url,user,password);
            System.out.println("connected");
        }  catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("erreur driver"+e.getMessage());
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("erreur connection"+e.getMessage());
        }

        return con;
    }
}
