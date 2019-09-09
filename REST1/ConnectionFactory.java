package com.metacube.REST1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**factory class used to creating the connection and returns the connection object
 * @author Rahul
 */
public class ConnectionFactory 
{

// configuration parameters
public static final String URL = "jdbc:mysql://localhost:3306/library";
public static final String USER = "root";
public static final String PASS = "root";

/**
 * Get a connection to database
 * @return Connection object
*/
public static Connection getConnection() 
{	
    try 
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    } catch (SQLException ex) 
    {
        throw new RuntimeException("Error connecting to the database", ex);
    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new AssertionError("class not found");
	}
}

}
