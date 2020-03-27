package com.company;
import java.sql.*;
public class List {

    public static void main(String[] args) {

        try {
            /*String strClassName = "com.mysql.jdbc.Driver";
            String dbName= "tp";
            String login= "root";
            String motdepasse= "azertyqsd";
            String strUrl = "jdbc:mysql://localhost:3306/" +  dbName +"?useSSL=false";*/
            DAOAcces db = new DAOAcces();

        /*    Class.forName(strClassName);*/
/*            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stUsers = conn.createStatement();*/
            ResultSet rsUsers = db.statement.executeQuery("select * from Acces");
            while(rsUsers.next()) {
                System.out.print("Id[" + rsUsers.getInt(1) + "]"
                        + rsUsers.getString(2)
                        + "[" + rsUsers.getString("statut") + "] "
                        + rsUsers.getInt("age") +"\n"); }
            db.conn.close();
        }
        catch(ClassNotFoundException e) {
            System.err.println("Driver non chargé !");  e.printStackTrace();
        } catch(SQLException e) {
            System.err.println("Autre erreur !");  e.printStackTrace();
        }
    }
}
