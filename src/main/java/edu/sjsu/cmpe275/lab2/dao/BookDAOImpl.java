package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sjsu.cmpe275.lab2.model.Book;


@Repository
public class BookDAOImpl extends AbstractDao<String, Book> implements BookDAO  {
	
	@Autowired
    SessionFactory sessionFactory;

	public Book findBookById(String id) {
		return findById(id);
	}

	public void saveBook(Book book) {
		save(book);		
	}

	public void updateBook(Book book) {
		update(book);		
	}

	public void deleteBookById(String id) {
		deleteById(id);
	}

	public List<Book> findAllBooks() {
		List<Book> list = findAll();
		return list;
	}

}
