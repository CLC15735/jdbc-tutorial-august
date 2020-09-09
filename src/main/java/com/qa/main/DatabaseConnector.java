package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.utils.DatabaseConfiguration;

public class DatabaseConnector {
    private Connection connection;

    private Statement statement;

    public DatabaseConnector() throws SQLException {
        connection = DriverManager.getConnection(DatabaseConfiguration.URL, DatabaseConfiguration.USER,
                DatabaseConfiguration.PASSWORD);
    }

    public void createActor(String forename, String surname) throws SQLException {
    	this.statement = connection.createStatement();
        statement.executeUpdate(String.format("INSERT INTO actor (`first_name`, `last_name`)" + " VALUES ('%s', '%s')",
                forename, surname));
    }

    public void readAllActors() throws SQLException {
        String sql = "SELECT * FROM actor";
        this.statement = connection.createStatement();
        ResultSet results = this.statement.executeQuery(sql);

        while (results.next()) {
            System.out.println(String.format("%s %s %s", results.getString("first_name"), results.getString("last_name"), results.getString("actor_id")));
        }
    }

    public void updateActor(String forename, String surname, int ID) throws SQLException {
    	this.statement = connection.createStatement();
    	String sql = "UPDATE actor SET first_name=" + "'"+ forename + "'" + ", last_name=" + "'"+ surname + "'" + " WHERE actor_id=" + ID +";";
    	statement.executeUpdate(sql);
    }

    public void deleteActor(int ID) throws SQLException {
    	this.statement = connection.createStatement();
    	String sql = "DELETE FROM actor where actor_id=" + "'"+ ID + "'";
    	statement.executeUpdate(sql);
    }

}
