package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.Students_AddressDAO;
import model.Students;
import model.Students_Address;
import model.util.JpaUtil;

public class Students_AddressDaoImpl implements Students_AddressDAO {

	private EntityManager em;
	private EntityTransaction et;

	/**
	 * Create and save the Student Address
	 * 
	 * @param students_address
	 */
	@Override
	public void create(Students_Address students_address) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(students_address);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY SAVING STUDENT ADDRESS");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Update the Student Address
	 * 
	 * @param students_address
	 */
	@Override
	public void update(Students_Address students_address) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(students_address);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY UPDATING STUDENT ADDRESS");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Delete the Student Address
	 * 
	 * @param Id to be insert
	 */
	@Override
	public void delete(int Id) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Students_Address.class, Id));
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY DELETING STUDENT ADDRESS");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Search the Students Address
	 * 
	 * @param Id to be read and searched
	 */
	@Override
	public Students_Address read(int Id) {
		Students_Address students_address = new Students_Address();
		try {
			this.em = JpaUtil.getEntityManager();
			students_address = em.find(Students_Address.class, Id);

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY READING STUDENT ADDRESS");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}
		return students_address;
	}

	/**
	 * This method Lists Students Address
	 */
	@Override
	public List<Students_Address> ListAll() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Student e");
		List<Students_Address> listStudentAddress = query.getResultList();
		em.close();
		return listStudentAddress;
	}

}
