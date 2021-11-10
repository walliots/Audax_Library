package dao;

import java.util.List;

import model.Library_Employee;

public interface Library_EmployeeDAO {
	
	public void create(Library_Employee library_employee);

	public void update(Library_Employee library_employee);

	public void delete(int Id);

	public Library_Employee read(int Id);

	public List<Library_Employee> ListAll();


}