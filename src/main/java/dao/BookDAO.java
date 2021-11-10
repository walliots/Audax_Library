package dao;

import java.util.List;

import model.Book;

public interface BookDAO {
	
	public void create(Book book);

	public void update(Book book);

	public void delete(int Id);

	public Book read(int Id);

	public List<Book> ListAll();

}