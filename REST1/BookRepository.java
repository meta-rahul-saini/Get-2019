package com.metacube.REST1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * this class has the functions to retrive the books and saves books in database
 * @author Rahul
 *
 */
public class BookRepository {

	
	/**returns list of books 
	 * @return
	 */
	public List<Book> getBooks()
	{
		
		List<Book> books = new ArrayList<Book>();
		String query = "select * from Book";

		Connection con = ConnectionFactory.getConnection();
		Book book = null;
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(query);

			// adding books in list 
			while(rs.next())
			{
				System.out.println("books: " + rs.getString(2));
				book = new Book();
				book.setBookId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setWriter(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPublishedYear(rs.getInt(5));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return books;
	}
	
	
	/**function to get books by title
	 * @param title
	 * @return
	 */
	public Book getBook(String title)
	{

		Connection con = ConnectionFactory.getConnection();
		String query = "select * from Book where title = '" + title + "';";
		Book book = null;
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next())
			{
				System.out.println("books: " + rs.getString(2));
				book = new Book();
				book.setBookId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setWriter(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPublishedYear(rs.getInt(5));
				return book;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return book;
	}
	
	
	/**function to add book in database
	 * @param book
	 */
	public void create(Book book) {
		Connection con = ConnectionFactory.getConnection();
		String query = "insert into Book values(null, ?, ?, ?, ? )";
		try {
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, book.getTitle());
			st.setString(2, book.getWriter());
			st.setString(3, book.getPublisher());
			st.setInt(4, book.getPublishedYear());
			System.out.println("going to create Book");
			st.executeUpdate();
		System.out.println("successfully created Book");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**function to update book by title and publishedyear
	 * @param title
	 * @param publishedYear
	 * @param book, book object containing updated data
	 * @return
	 */
	public Book update(String title, int publishedYear, Book book) {
		
		Connection con = ConnectionFactory.getConnection();
		String query = "update Book set title= ?, writer = ?, publisher = ?, publishedYear = ? where title = ? and publishedYear = ? ";
		try {
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, book.getTitle());
			st.setString(2, book.getWriter());
			st.setString(3, book.getPublisher());
			st.setInt(4, book.getPublishedYear());
			st.setString(5,  title);
			st.setInt(6, publishedYear);
			
			System.out.println("going to create Book");
			st.executeUpdate();
		System.out.println("successfully created Book");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;
		
	}

	/**delete book by book id
	 * @param id
	 */
	public void DeleteBook(int id) {
		
		Connection con = ConnectionFactory.getConnection();
		String query = "Delete from book where BookId = " + id ;
		try {
			Statement st = con.createStatement();
			System.out.println("going to create Book");
			st.execute(query);
		System.out.println("successfully deleted Book");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**function to get book by book id
	 * @param id
	 * @return
	 */
	public Book getBookById(int id) {
		
		Connection con = ConnectionFactory.getConnection();
		String query = "select *  from book where BookId = " + id ;
		try {
			Statement st = con.createStatement();
			
			Book book = null;
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next())
			{
				System.out.println("books: " + rs.getString(2));
				book = new Book();
				book.setBookId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setWriter(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPublishedYear(rs.getInt(5));
				return book;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**function to retrive all books
	 * @return
	 */
	public int DeleteAllBooks() {

		Connection con = ConnectionFactory.getConnection();
		String query = "delete from Book;";
		Statement st;
		try {
			st = con.createStatement();

			return st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
