package com.company;

import java.sql.*;

public class Delete {

    public static void main(String[] args) {

        try {
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName= "tp";
            String login= "root";
            String motdepasse= "azertyqsd";
            String strUrl = "jdbc:mysql://localhost:3306/" +  dbName +"?useSSL=false";

            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stAddUser = conn.createStatement();
            stAddUser.executeUpdate("delete from Acces where id = '6'");

            conn.close();
        }
        catch(ClassNotFoundException e) {
            System.err.println("Driver non chargé !");  e.printStackTrace();
        } catch(SQLException e) {
            System.err.println("Autre erreur !");  e.printStackTrace();
        }
    }

}
