package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
	
	private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        DatabaseConnector db = new DatabaseConnector();
       
        String action ="";
        action = getAction();
        try {
        	do {
    	        switch (action) {
    	        case "create":
    	        	System.out.println("Please enter your name");
    	        	String forename = scan.nextLine();
    	        	System.out.println("Please enter your surname");
    	        	String surname = scan.nextLine();
    	        	db.createActor(forename, surname);
    	        	break;
    	        	
    	        case "read":
    	        	db.readAllActors();
    	        	break;
    	        	
    	        case "delete":
    	        	System.out.println("Please enter actor ID you want to remove");
    	        	int deleteID = scan.nextInt();
    	        	db.deleteActor(deleteID);
    	        	break;
    	        	
    	        case "update":
    	        	System.out.println("Please enter actor ID");
    	        	int newID = Integer.parseInt(scan.nextLine());
    	        	System.out.println("Please enter new name");
    	        	String newforename = scan.nextLine();
    	        	System.out.println("Please enter new surname");
    	        	String newsurname = scan.nextLine();
    	        	db.updateActor(newforename, newsurname, newID);
    	        	break;    	            	    
    	        
    	        default: System.out.println("No matching statement");
    	            	
    	        }
    	        action = getAction();
    	    }
            while (!action.contentEquals("exit")); {
            	System.out.println("bye");
            }
        }
        finally {
        	scan.close();
        	db.close();       	
        }
        
	        
        //db.readAllActors();
        //db.createActor("Geoff", "Rush");
        //db.updateActor("Cristina", "Lopez", 209);
        //db.deleteActor(209);
        //db.readAllActors();
    }
    
    private static String getAction() {
    	System.out.println("Please enter the CRUD (create, read, update, delete) method, or exit: ");
    	return scan.nextLine();
    }

}
