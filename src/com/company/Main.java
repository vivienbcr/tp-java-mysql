package com.company;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            Acces a = new Acces("dupuis","ddd","azert","koko",12);



/*
    TEST DAO :::
 DAOAcces db = new DAOAcces();
            db.setUser("vivien","vivienbcr","azertyddd","intermitent",12);
            db.listUser();
            db.deleteUser(13);*/
        }
/*        catch(ClassNotFoundException e) {
            System.err.println("Driver non chargé !");  e.printStackTrace();
        }*/ catch(SQLException | ClassNotFoundException e) {
            // . . .
            System.err.println("drdrt !");  e.printStackTrace();
        }
    }
    }

