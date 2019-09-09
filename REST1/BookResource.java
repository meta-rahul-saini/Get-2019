package com.metacube.REST1;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("books")
public class BookResource {
	
    BookRepository repo = new BookRepository();			

  // 1. function to create a new book record
 	@POST
 	@Path("book")
 	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
 	public Book createBook(Book book)
 	{
 		repo.create(book);
 		return book;
 	}
 	
   //2. function to  Retrieve list of all books
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Book> getBooks()
	{
		return repo.getBooks();
	}
	
	//3. function to retrieve book by title
	@GET
	@Path("book/{title}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Book getBook(@PathParam("title") String title )
	{
		return repo.getBook(title);
	}
	
	

	//4. function to update book by title and published year
	@PUT
	@Path("{title}/{publishedYear}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Book update(@PathParam("title") String title,
			@PathParam("publishedYear") int publishedYear, Book book
			)
	{
		repo.update(title, publishedYear, book);
		return book;
	}
	
	//5. function to delete a book by bookID
	@DELETE
	@Path("book/{id}")
	public Book DeleteBook(@PathParam("id") int id )
	{
		Book b = repo.getBookById(id);
		repo.DeleteBook(id);
		return b;
	}
	
	//6. function to delete all books
	@DELETE
	@Path("all")
	public int DeleteBook()
	{
		return repo.DeleteAllBooks();
	}
	
}
