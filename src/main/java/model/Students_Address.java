package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS_ADDRESS")
public class Students_Address {

	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_STUDENTS_ADDRESS", referencedColumnName = "ID_STUDENTS")
	private int Id_Students_Address;
	
	@Column(name = "ZIP_CODE")
	private int Zip_Code;
	
	@Column(name = "ADDRESS")
	private String Adress;
	
	@Column(name = "HOUSE_NUMBER")
	private int House_Number;

	public int getId_Students_Address() {
		return Id_Students_Address;
	}

	public void setId_Students_Address(int id_Students_Address) {
		Id_Students_Address = id_Students_Address;
	}

	public int getZip_Code() {
		return Zip_Code;
	}

	public void setZip_Code(int zip_Code) {
		Zip_Code = zip_Code;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public int getHouse_Number() {
		return House_Number;
	}

	public void setHouse_Number(int house_Number) {
		House_Number = house_Number;
	}

}
