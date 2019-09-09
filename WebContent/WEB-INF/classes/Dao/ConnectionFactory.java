package Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * we use factory class to create connection
 */
public class ConnectionFactory 
{

//	 configuration parameters
public static final String URL = "jdbc:mysql://localhost:3306/ead";
public static final String USER = "root";
public static final String PASS = "root";

/**
 * Get a connection to database
 * @return Connection object
 * @throws ClassNotFoundException 
 * @throws IOException 
 * @throws SQLException 
*/
public static Connection getConnection()
{	

    System.out.println("7777777777");
	    	System.out.println("url " + URL);
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				

		         return DriverManager.getConnection(URL, USER, PASS);
		    
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
}

}
