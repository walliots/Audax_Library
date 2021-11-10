package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "STUDENTS")
public class Students {

	@Id
	@Column(name = "STUDENTS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTS")
	@SequenceGenerator(name = "STUDENTS", sequenceName = "S_ID_STUDENTS", allocationSize = 1, initialValue = 100)
	private int Id_Students;

	@Column(name = "STUDENT_NAME")
	private String Student_Name;

	@Column(name = "SEX")
	private String Sex;

	@Column(name = "BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Date Birthday;

	public int getId_Students() {
		return Id_Students;
	}

	public void setId_Students(int id_Students) {
		Id_Students = id_Students;
	}

	public String getStudent_Name() {
		return Student_Name;
	}

	public void setStudent_Name(String student_Name) {
		Student_Name = student_Name;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

}
