package com.company;

import org.javatuples.Pair;

import java.lang.reflect.Type;
import java.sql.*;

public class DAOAcces {
    String strClassName = "com.mysql.jdbc.Driver";
    String dbName = "tp";
    String login = "root";
    String motdepasse = "azertyqsd";
    String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
    Connection conn;
    Statement statement;


    public DAOAcces() throws SQLException, ClassNotFoundException {
        Class.forName(strClassName);
    }

    /**
     * updateUserValue update given user property
     *
     * @param property property in db
     * @param value    value for this property
     * @throws SQLException
     */
    public Integer updateUserValue(String property, String value, Long uid) throws SQLException {
        connect();
        statement.executeUpdate("update Acces SET " + property + " = '" + value + "' where id = " + uid + "");
        disconnect();
        // TODO: Return affected row
        return 1;
    }


    /**
     * setUser set new user into database
     *
     * @param prenom   user first name
     * @param login    user login
     * @param password user password
     * @param status   user status
     * @param age      user age
     * @throws SQLException
     */
    public Pair setUser(String prenom, String login, String password, String status, Integer age) throws SQLException {
        connect();

        String strInsert = "INSERT INTO Acces "
                + "(prenom, login, password, statut,age) "
                + "VALUES ('" + prenom + "', '" + login + "', '" + password + "','" + status + "'," + age + ");";

        int affectedRows = statement.executeUpdate(strInsert,Statement.RETURN_GENERATED_KEYS);

        if (affectedRows == 0) {
            disconnect();
            throw new SQLException("Creating user failed, no rows affected.");
        }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                Long uid = generatedKeys.getLong(1);
/*                System.out.println(generatedKeys.getLong(1));*/
                disconnect();
                return new Pair(affectedRows,uid);
            }
            else {
                disconnect();
                throw new SQLException("Creating user failed, no ID obtained.");
            } }





}

    /**
     * deleteUser delete user for given ID
     *
     * @param id user id
     * @throws SQLException
     */
    public void deleteUser(Integer id) throws SQLException {
        connect();
        statement.executeUpdate("delete from Acces where id = '" + id + "'");
        disconnect();
    }

    /**
     * listUser print list of user
     *
     * @throws SQLException
     */
    public void listUser() throws SQLException {

        connect();

        ResultSet rsUsers = statement.executeQuery("select * from Acces");
        while (rsUsers.next()) {
            System.out.print("Id[" + rsUsers.getInt(1) + "]"
                    + rsUsers.getString(2)
                    + "[" + rsUsers.getString("statut") + "] "
                    + rsUsers.getInt("age") + "\n");
        }
        disconnect();
    }

    /*
     * connect open new connection with database
     */
    private void connect() throws SQLException {
        conn = DriverManager.getConnection(strUrl, login, motdepasse);
        statement = conn.createStatement();
    }

    /*
     * disconnect close database connexion
     */
    private void disconnect() throws SQLException {
        conn.close();
    }

}
