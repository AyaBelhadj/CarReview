package com.example.carreviewv1;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
   /* String Url="jdbc:mysql://127.0.0.1/carreviewdatabase";
    String user="root";
    String password="";*/
    public static void main(String[] args) {


        System.out.println("Serveur!");

        try {
            int nb_clt=0;
            ServerSocket server=new ServerSocket(9001);
            System.out.println("en ecoute ...");
            while(nb_clt<3){
                Socket s=server.accept();
                System.out.println("client accepte");
                nb_clt++;
                Discussion disc=new Discussion(s);
                disc.start();

                //plusieur clients mais un seul  a la fois
              /* PrintWriter pw=new PrintWriter(s.getOutputStream());
               pw.println("envoyer votre id");
               pw.flush();
               BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
               String ligne= br.readLine();
               System.out.println(ligne);*/

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }





       /* String nom_driver="com.mysql.jdbc.Driver";
        try {
            Class.forName(nom_driver);
            System.out.println("driver charge");
            Main m=new Main();
            Connection con= DriverManager.getConnection(m.Url,m.user,m.password);
            System.out.println("connected");
            Statement st=con.createStatement();
            if (st!=null){
                String req="insert into user values('aya','aya2492001','female','Msaken')";
                int a=st.executeUpdate(req);
                if (a>0){
                    System.out.println("inserted");

                }
                else{
                    System.out.print("Echec");
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("erreur driver"+e.getMessage());
            //throw new RuntimeException(e);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("erreur connection"+e.getMessage());
        }*/
    }
}
