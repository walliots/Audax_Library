package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.BookDAO;
import model.Book;
import model.util.JpaUtil;

public class BookDaoImpl implements BookDAO {

	private EntityManager em;
	private EntityTransaction et;

	/**
	 * Create and save the Book
	 * 
	 * @param book
	 */
	@Override
	public void create(Book book) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(book);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY SAVING BOOK");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Update the Book
	 * 
	 * @param book
	 */
	@Override
	public void update(Book book) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(book);
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY UPDATING BOOK");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Delete the Book
	 * 
	 * @param Id to be insert
	 */
	@Override
	public void delete(int Id) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Book.class, Id));
			et.commit();

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY DELETING BOOK");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}

	}

	/**
	 * Search the Book
	 * 
	 * @param Id to be read and searched
	 */
	@Override
	public Book read(int Id) {
		Book book = new Book();
		try {
			this.em = JpaUtil.getEntityManager();
			book = em.find(Book.class, Id);

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("ERROR BY READING BOOK");

		} finally {
			if (em.isOpen()) {
				em.close();

			}
		}
		return book;
	}

	/**
	 * This method Lists Books
	 */
	@Override
	public List<Book> ListAll() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Book e");
		List<Book> listBook = query.getResultList();
		em.close();
		return listBook;
	}

}
