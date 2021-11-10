package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.Library_EmployeeDAO;
import model.Library_Employee;
import model.util.JpaUtil;

public class Library_EmployeeDaoImpl implements Library_EmployeeDAO {

	private EntityManager em;
	private EntityTransaction et;

	/**
	 * Create and save the library employee
	 * 
	 * @param library_employee
	 */
	@Override
	public void create(Library_Employee library_employee) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(library_employee);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY SAVING LIBRARY EMPLOYEE");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Update the library employee
	 * 
	 * @param library_employee
	 */
	@Override
	public void update(Library_Employee library_employee) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(library_employee);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY UPDATING LIBRARY EMPLOYEE");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Delete the library employee 
	 * 
	 * @param Id to be insert
	 */
	@Override
	public void delete(int Id) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Library_Employee.class, Id));
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY DELETING LIBRARY EMPLOYEE");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Search the library employee
	 * 
	 * @param Id to be read and searched
	 */
	@Override
	public Library_Employee read(int Id) {
		Library_Employee library_employee = new Library_Employee();
		try {
			this.em = JpaUtil.getEntityManager();
			library_employee = em.find(Library_Employee.class, Id);

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY READING LIBRARY EMPLOYEE");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}
		return library_employee;

	
		
	}

	/**
     * This method Lists  Library Employees IDs
     */
	@Override
	public List<Library_Employee> ListAll() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Library_Employee e");
		List<Library_Employee> listLibraryEployee = query.getResultList();
		em.close();
		return listLibraryEployee;
	}

}
