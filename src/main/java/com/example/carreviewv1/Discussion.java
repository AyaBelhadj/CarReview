package com.example.carreviewv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Discussion extends Thread{
    Socket s;

    public Discussion(Socket s) {
        this.s = s;
    }
    public void run(){
        PrintWriter pw= null;
        try {
            pw = new PrintWriter(s.getOutputStream());
            pw.println("envoyer votre id");
            pw.flush();
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String ligne= br.readLine();
            System.out.println(ligne);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
