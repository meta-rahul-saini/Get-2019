import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *this class contains the all the utility function to perform the given query, and task
 */
public class JDBC {

	/**Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user 
	 * which are in shipped state. Orders should be sorted by order date column in chronological order.
	 * @param user_id
	 * @return list of objects containing OrderInShippedState object which contains the data of each row
	 */
	public static List<OrdersInShippedState> getOrdersInShippedState(int user_id) 
	{
		// crreating a connection 
		Connection connection = ConnectionFactory.getConnection();

		try {

			// creating a statement vehicle 
			Statement stmt = connection.createStatement();

			// executing query
			ResultSet rs = stmt
					.executeQuery("select order_id, order_date, order_amount from user natural join storefrontdb.order where order_status=\"shipped\" and user_id = "
							+ user_id + " order by order_date;");

			List<OrdersInShippedState> list = new ArrayList<OrdersInShippedState>();

			while (rs.next()) {
				list.add(new OrdersInShippedState(rs.getInt(1), rs.getDate(2),
						rs.getFloat(3)));
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new AssertionError("not able to execute query");
		}
		finally{
			try
			{
			connection.close();
			}
			catch(SQLException e)
			{
				System.out.println();
			}
		}
	}

	/**Insert five or more images of a product using batch insert technique.
	 * @param imageList
	 * @return array containign status of weather image is inserted or not
	 */
	public static int[] insertImages(List<Image> imageList) {
		
		// creating a connection  object
		Connection connection = ConnectionFactory.getConnection();

		try {
			
			// creating a prepared statement vehicle 
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO image VALUES ( ?, ?, ?)");

			// adding batch to preparedStatement
			for (Image image : imageList) 
			{
				ps.setInt(1, image.getImage_id());
				ps.setString(2, image.getImage_title());
				ps.setInt(3, image.getProduct_id());
				ps.addBatch();
			}
			
			// executing  batch statement
			return ps.executeBatch();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new AssertionError("not able to execute query");
		}
	}

	/**Delete all those products which were not ordered by any Shopper in last 1 year.
	 * @return the number of products deleted.
	 */
	public static int deleteProductsWhichAreNotBoughtSinceLastOneYear() 
	{ 

		// creating a connection  object
		Connection connection = ConnectionFactory.getConnection();

		try {
			// creating a prepared statement object
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO image VALUES ( ?, ?, ?)");
			ps.execute("SET SQL_SAFE_UPDATES=0");
			
			// returns #rows updated
			int noOfRowsUpdated = ps
					.executeUpdate("update product set status = 0 where product_id not in (select product_id  from storefrontdb.order where order_date > DATE_SUB(NOW(), INTERVAL 1 YEAR))");
			ps.execute("SET SQL_SAFE_UPDATES=1");
			return noOfRowsUpdated;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new AssertionError("not able to execute query");
		}
	}

	/**Select and display the category title of all top parent categories sorted alphabetically and the 
	 * count of their child categories
	 * @return list containing the fetched data
	 */
	public static List<TitleAndCountOfTOPLevelCategory> getTitleAndCountOfTopParentCategory() 
	{
		// creating a connection  object
		Connection connection = ConnectionFactory.getConnection();
		try 
		{
			// creating a statement object
			Statement stmt = connection.createStatement();
			stmt.execute("drop view if exists childOfTopCategory;");
			stmt.execute("create view childOfTopCategory as select * from category where parent_category_id in (select category_id from category where parent_category_id is null); ");
		
			ResultSet rs = stmt
					.executeQuery("select category.category_name, count(category.category_name) as noOfChildCategory from category inner join childOfTopCategory on category.category_id = childOfTopCategory.parent_category_id group by category.category_name order by category_name; ");

			List<TitleAndCountOfTOPLevelCategory> list = new ArrayList<TitleAndCountOfTOPLevelCategory>();
			while (rs.next()) {
				list.add(new TitleAndCountOfTOPLevelCategory(rs.getString(1),
						rs.getInt(2)));
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new AssertionError("not able to execute query");
		}
	}
}
