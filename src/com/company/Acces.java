package com.company;

import org.javatuples.Pair;

import java.sql.SQLException;
import java.util.ArrayList;

public class Acces {
    String prenom;
    String login;
    String password;
    String status;
    Integer age;
    Long id;

    public Acces(String prenom, String login, String password, String status, Integer age) throws SQLException, ClassNotFoundException {
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.status = status;
        this.age = age;
        DAOAcces db = new DAOAcces();
        Pair res = db.setUser(this.prenom, this.login, this.password, this.status, this.age);
        this.id = (Long) res.getValue1();
        System.out.println(res);
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws SQLException, ClassNotFoundException {
        DAOAcces db = new DAOAcces();
        db.updateUserValue("prenom", prenom, this.id);
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws SQLException, ClassNotFoundException {
        DAOAcces db = new DAOAcces();
        db.updateUserValue("login", login, this.id);
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws SQLException, ClassNotFoundException {
        DAOAcces db = new DAOAcces();
        db.updateUserValue("password", password, this.id);
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) throws SQLException, ClassNotFoundException {
        DAOAcces db = new DAOAcces();
        db.updateUserValue("status", status, this.id);
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) throws SQLException, ClassNotFoundException {
        DAOAcces db = new DAOAcces();
        String a = Integer.toString(age);
        db.updateUserValue("age", a, this.id);
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) throws SQLException, ClassNotFoundException {
        DAOAcces db = new DAOAcces();
        String i = Long.toString(id);
        db.updateUserValue("id", i, this.id);
        this.id = id;
    }

}





