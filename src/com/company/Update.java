package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {


    public static void main(String[] args) {

        try {
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName= "tp";
            String login= "root";
            String motdepasse= "azertyqsd";
            String strUrl = "jdbc:mysql://localhost:3306/" +  dbName +"?useSSL=false";

            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stUsers = conn.createStatement();

            Statement stUpdateUser = conn.createStatement();
            stUpdateUser.executeUpdate("update Acces SET prenom = 'Vivien' where id = 1");


            conn.close();
        }
        catch(ClassNotFoundException e) {
            System.err.println("Driver non chargé !");  e.printStackTrace();
        } catch(SQLException e) {
            System.err.println("Autre erreur !");  e.printStackTrace();
        }
    }

}
