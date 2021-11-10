package dao;

import java.util.List;

import model.Book_Lending_Register;


public interface Book_Lending_RegisterDAO {
	
	public void create(Book_Lending_Register book_lending_register);

	public void update(Book_Lending_Register book_lending_register);

	public void delete(int Id);

	public Book_Lending_Register read(int Id);

	public List<Book_Lending_Register> ListAll();

}
