package com.company;

import java.sql.*;

public class DAOAcces {
    String strClassName = "com.mysql.jdbc.Driver";
    String dbName= "tp";
    String login= "root";
    String motdepasse= "azertyqsd";
    String strUrl = "jdbc:mysql://localhost:3306/" +  dbName + "?useSSL=false";
    Connection conn;
    Statement statement;

    public DAOAcces() throws SQLException, ClassNotFoundException {
        Class.forName(strClassName);
    }
    /**
     * setUser set new user into database
     * @param prenom user first name
     * @param login user login
     * @param password user password
     * @param status user status
     * @param age user age
     * @throws SQLException
     */
    public void setUser(String prenom, String login, String password, String status, Integer age) throws SQLException {
        connect();


        String strInsert = "INSERT INTO Acces "
                + "(prenom, login, password, statut,age) "
                + "VALUES ('"+prenom+"', '"+login+"', '"+password+"','"+status+"',"+age+");";
        statement.executeUpdate(strInsert);

        disconnect();
    }
    /**
     * deleteUser delete user for given ID
     * @param id user id
     * @throws SQLException
     */
    public void deleteUser(Integer id) throws SQLException {
    connect();
        statement.executeUpdate("delete from Acces where id = '"+id+"'");
    disconnect();
    }

    /**
     * listUser print list of user
     * @throws SQLException
     */
    public void listUser() throws SQLException {

        connect();

        ResultSet rsUsers = statement.executeQuery("select * from Acces");
        while(rsUsers.next()) {
            System.out.print("Id[" + rsUsers.getInt(1) + "]"
                    + rsUsers.getString(2)
                    + "[" + rsUsers.getString("statut") + "] "
                    + rsUsers.getInt("age") +"\n"); }
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
