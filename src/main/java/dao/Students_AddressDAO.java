package dao;

import java.util.List;

import model.Students_Address;

public interface Students_AddressDAO {
	
	public void create(Students_Address students_address);

	public void update(Students_Address students_address);

	public void delete(int Id);

	public Students_Address read(int Id);

	public List<Students_Address> ListAll();

}
