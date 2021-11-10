package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.Book_Lending_RegisterDAO;
import model.Book_Lending_Register;
import model.util.JpaUtil;

public class Book_Lending_RegisterDaoImpl implements Book_Lending_RegisterDAO {

	private EntityManager em;
	private EntityTransaction et;

	/**
	 * Create and save the book lending register
	 * 
	 * @param book_lending_register
	 */
	@Override
	public void create(Book_Lending_Register book_lending_register) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(book_lending_register);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY SAVING BOOK LENDING REGISTER");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Update the book lending register
	 * 
	 * @param book_lending_register
	 */
	@Override
	public void update(Book_Lending_Register book_lending_register) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(book_lending_register);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY UPDATING BOOK LENDING REGISTER");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Delete the book lending register
	 * 
	 * @param Id to be insert
	 */
	@Override
	public void delete(int Id) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Book_Lending_Register.class, Id));
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY DELETING BOOK LENDING RESGISTER");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Search the book lending register
	 * 
	 * @param Id to be read and searched
	 */
	@Override
	public Book_Lending_Register read(int Id) {
		Book_Lending_Register book_lending_register = new Book_Lending_Register();
		try {
			this.em = JpaUtil.getEntityManager();
			book_lending_register = em.find(Book_Lending_Register.class, Id);

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY READING BOOK LENDING REGISTER");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}
		return book_lending_register;
	}

	/**
	 * This method Lists Book Lending Registers
	 */
	@Override
	public List<Book_Lending_Register> ListAll() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Book_Lending_Register e");
		List<Book_Lending_Register> listBookLendingRegister = query.getResultList();
		em.close();
		return listBookLendingRegister;
	}

}