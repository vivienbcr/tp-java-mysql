package com.company;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            DAOAcces db = new DAOAcces();
            db.listUser();
            db.listUser();
            db.listUser();
            db.listUser();
        }
/*        catch(ClassNotFoundException e) {
            System.err.println("Driver non chargé !");  e.printStackTrace();
        }*/ catch(SQLException | ClassNotFoundException e) {
            // . . .
            System.err.println("drdrt !");  e.printStackTrace();
        }
    }
    }

