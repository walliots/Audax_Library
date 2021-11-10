package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.impl.BookDaoImpl;
import dao.impl.Library_EmployeeDaoImpl;
import dao.impl.StudentsDaoImpl;
import dao.impl.Students_AddressDaoImpl;
import model.Book;
import model.Book_Lending_Register;
import model.Library_Employee;
import model.Students;
import model.Students_Address;
import model.util.JpaUtil;

public class Principal {
	/**
	 * 
	 * @author Walmir Pereira de Lima
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.close();

		// BOOK

		Book book = new Book();
		book.setAutor("Machado de Assis");
		book.setBook_Id(10);
		book.setTitle("Mémorias Póstumas de Brás Cubas");
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date date = dateFormat.parse("31-12-1891");
		book.setLaunch_Date(date);
		BookDaoImpl bookDaoimpl = new BookDaoImpl();
		bookDaoimpl.create(book);

		// STUDENTS

		Students student = new Students();
		student.setId_Students(0);
		student.setStudent_Name("João Fernando");
		student.setSex("mas");
		DateFormat dateFormat_Stu = new SimpleDateFormat("dd-mm-yyyy");
		Date date_Stu = dateFormat.parse("10-11-2021");
		student.setBirthday(date_Stu);
		StudentsDaoImpl studentDaoImpl = new StudentsDaoImpl();
		studentDaoImpl.update(student);

		// STUDENTS ADDRESS

		Students_Address studentsAddress = new Students_Address();
		studentsAddress.setZip_Code(55555333);
		studentsAddress.setAdress("Rua Quatro");
		studentsAddress.setHouse_Number(55);
		studentsAddress.setId_Students_Address(0);
		Students_AddressDaoImpl studentsDaoImpl = new Students_AddressDaoImpl();
		studentDaoImpl.delete(0);

		// LIBRARY EMPLOYEE

		Library_Employee libraryEmployee = new Library_Employee();
		libraryEmployee.setEmployee_Id(2);
		libraryEmployee.setEmployee_Name("Pedro Alves");
		Library_EmployeeDaoImpl libraryEmployeeDaoImpl = new Library_EmployeeDaoImpl();
		libraryEmployeeDaoImpl.read(0);

		// BOOK LENDING REGISTER

		Book_Lending_Register bookLendingRegister = new Book_Lending_Register();
		int[] id = { 10 };
		Set<Students> Student_Book_Lending_Id = new HashSet<>();
		for (int students : id) {
			Student_Book_Lending_Id.add(new Students());
		}

	}

}
