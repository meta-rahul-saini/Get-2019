import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**factory class used to creating the connection and returns the connection object
 * @author Rahul
 */
public class ConnectionFactory 
{

	// configuration parameters
public static final String URL = "jdbc:mysql://localhost:3306/storefrontdb";
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
        DriverManager.registerDriver(new Driver());
        return DriverManager.getConnection(URL, USER, PASS);
    } catch (SQLException ex) 
    {
        throw new RuntimeException("Error connecting to the database", ex);
    }
}

}
