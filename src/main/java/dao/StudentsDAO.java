package dao;

import java.util.List;

import model.Students;

public interface StudentsDAO {

	public void create(Students students);

	public void update(Students students);

	public void delete(int Id);

	public Students read(int Id);

	public List<Students> ListAll();

}
