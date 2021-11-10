package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.StudentsDAO;
import model.Students;
import model.util.JpaUtil;

public class StudentsDaoImpl implements StudentsDAO {

	private EntityManager em;
	private EntityTransaction et;

	/**
	 * Create and save the Student
	 * 
	 * @param students
	 */
	@Override
	public void create(Students students) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(students);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY SAVING STUDENT");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Update the Student
	 * 
	 * @param students
	 */
	@Override
	public void update(Students students) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(students);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY UPDATING STUDENT");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Delete the Student
	 * 
	 * @param Id to be insert
	 */
	@Override
	public void delete(int Id) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Students.class, Id));
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY DELETING STUDENT");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Search the student
	 * 
	 * @param Id to be read and searched
	 */
	@Override
	public Students read(int Id) {
		Students students = new Students();
		try {
			this.em = JpaUtil.getEntityManager();
			students = em.find(Students.class, Id);

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY READING STUDENT");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}
		return students;
	}

	/**
	 * This method Lists Students
	 */
	@Override
	public List<Students> ListAll() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Student e");
		List<Students> listStudent = query.getResultList();
		em.close();
		return listStudent;

	}

}