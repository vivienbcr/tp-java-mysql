package com.company;

import java.sql.*;
import org.javatuples.Quintet;

public class Insert {
    public static void main(String[] args) {
        try {
            String strClassName = "com.mysql.jdbc.Driver";
            String dbName= "tp";
            String login= "root";
            String motdepasse= "azertyqsd";
            String strUrl = "jdbc:mysql://localhost:3306/" +  dbName +"?useSSL=false";


            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stAddUser = conn.createStatement();


            Quintet[] arr = new Quintet[4];

            Quintet<String, String, String, String, Integer> p0 = Quintet.with("Tom", "tomahawk","indien","Etudiant",22);
            arr[0]=p0;
            Quintet<String, String, String, String, Integer> p1 = Quintet.with("Pierre", "Pierrot","delalune","Prof",44);
            arr[1]=p1;
            Quintet<String, String, String, String, Integer> p2 = Quintet.with("Michel", "lamere","sonchat","Admin",69);
            arr[2]=p2;
            Quintet<String, String, String, String, Integer> p3 = Quintet.with("Robin", "Locksley","desbois","Etudiant",23);
            arr[3]=p3;


            for (int i = 0; i < arr.length; i++){
                System.out.println(arr[i].getValue0());
                String strInsert = "INSERT INTO Acces "
                        + "(prenom, login, password, statut,age) "
                        + "VALUES ('"+arr[i].getValue0()+"', '"+arr[i].getValue1()+"', '"+arr[i].getValue2()+"','"+arr[i].getValue3()+"',"+arr[i].getValue4()+");";
                stAddUser.executeUpdate(strInsert);
            }
            conn.close();
        }
/*        catch(ClassNotFoundException e) {
            System.err.println("Driver non chargé !");  e.printStackTrace();
        }*/ catch (SQLException e) {
            // . . .
            System.err.println("drdrt !");
            e.printStackTrace();

        }
    }
}
