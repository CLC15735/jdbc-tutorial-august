package com.qa.main;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {
        DatabaseConnector db = new DatabaseConnector();
        //db.readAllActors();
        //db.createActor("Geoff", "Rush");
        //db.updateActor("Cristina", "Lopez", 209);
        //db.deleteActor(209);
        db.readAllActors();
    }

}
