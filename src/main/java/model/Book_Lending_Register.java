package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BOOK_LENDING_REGISTER")
public class Book_Lending_Register {

	@Id
	@Column(name = "BOOK_LENDING_REGISTER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_LENDING_REGISTER")
	@SequenceGenerator(name = "BOOK_LENDING_REGISTER", sequenceName = "S_ID_BOOK_LENDING", allocationSize = 1, initialValue = 100)
	private int Book_Lending_register_id;

	@Column(name = "LENDING_DATE")
	@Temporal(TemporalType.DATE)
	private Date Lending_Date;

	@Column(name = "DEVOLUTION_DATE")
	@Temporal(TemporalType.DATE)
	private Date Devolution_Date;

	@Column(name = "STUDENT_BOOK_LENDING_ID")
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "BOOK_LENDING_REGISTER", joinColumns = {
			@JoinColumn(name = "STUDENT_BOOK_LENDING_ID") }, inverseJoinColumns = { @JoinColumn(name = "ID_STUDENTS") })
	private Set<Students> Student_Book_Lending_Id = new HashSet<>();

	@Column(name = "LIBRARY_EMPLOYEE_ID")
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "BOOK_LENDING_REGISTER", joinColumns = {
			@JoinColumn(name = "LIBRARY_EMPLOYEE_ID") }, inverseJoinColumns = { @JoinColumn(name = "EMPLOYEE_ID") })
	private Set<Library_Employee> Library_Employee_Id = new HashSet<>();

	@Column(name = "BOOK_ID_LENDING")
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "BOOK_LENDING_REGISTER", joinColumns = {
			@JoinColumn(name = "BOOK_ID_LENDING") }, inverseJoinColumns = { @JoinColumn(name = "BOOK_ID") })
	private Set<Book> Book_Id_Lending = new HashSet<>();

	public int getBook_Lending_register_id() {
		return Book_Lending_register_id;
	}

	public void setBook_Lending_register_id(int book_Lending_register_id) {
		Book_Lending_register_id = book_Lending_register_id;
	}

	public Date getLending_Date() {
		return Lending_Date;
	}

	public void setLending_Date(Date lending_Date) {
		Lending_Date = lending_Date;
	}

	public Date getDevolution_Date() {
		return Devolution_Date;
	}

	public void setDevolution_Date(Date devolution_Date) {
		Devolution_Date = devolution_Date;
	}

	public Set<Students> getStudent_Book_Lending_Id() {
		return Student_Book_Lending_Id;
	}

	public void setStudent_Book_Lending_Id(Set<Students> student_Book_Lending_Id) {
		Student_Book_Lending_Id = student_Book_Lending_Id;
	}

	public Set<Library_Employee> getLibrary_Employee_Id() {
		return Library_Employee_Id;
	}

	public void setLibrary_Employee_Id(Set<Library_Employee> library_Employee_Id) {
		Library_Employee_Id = library_Employee_Id;
	}

	public Set<Book> getBook_Id_Lending() {
		return Book_Id_Lending;
	}

	public void setBook_Id_Lending(Set<Book> book_Id_Lending) {
		Book_Id_Lending = book_Id_Lending;
	}

}
