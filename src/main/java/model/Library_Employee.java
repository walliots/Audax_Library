package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY_EMPLOYEE")
public class Library_Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIBRARY_EMPLOYEE")
	@SequenceGenerator(name = "LIBRARY_EMPLOYEE", sequenceName = "S_ID_EMPLOYEE", allocationSize = 1, initialValue = 100)
	private int Employee_Id;
	
	@Column(name = "EMPLOYEE_NAME")
	private String Employee_Name;

	public int getEmployee_Id() {
		return Employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
	}

	public String getEmployee_Name() {
		return Employee_Name;
	}

	public void setEmployee_Name(String employee_Name) {
		Employee_Name = employee_Name;
	}

}
