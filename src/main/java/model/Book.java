package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK")
	@SequenceGenerator(name = "BOOK", sequenceName = "S_ID_BOOK", allocationSize = 1, initialValue = 100)
	private int Book_Id;

	@Column(name = "TITLE")
	private String Title;

	@Column(name = "AUTOR")
	private String Autor;

	@Column(name = "LAUNCH_DATE")
	private Date Launch_Date;

	public int getBook_Id() {
		return Book_Id;
	}

	public void setBook_Id(int book_Id) {
		Book_Id = book_Id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public Date getLaunch_Date() {
		return Launch_Date;
	}

	public void setLaunch_Date(Date launch_Date) {
		Launch_Date = launch_Date;
	}

}
