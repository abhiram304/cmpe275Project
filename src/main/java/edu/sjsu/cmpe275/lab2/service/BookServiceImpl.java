package edu.sjsu.cmpe275.lab2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.sjsu.cmpe275.lab2.dao.BookDAO;
import edu.sjsu.cmpe275.lab2.model.Book;


@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;

	public Book findBookById(String id) {
		return bookDAO.findBookById(id);
	}

	public void saveBook(Book book) {
		bookDAO.saveBook(book);
	}

	public void updateBook(Book book) {
		bookDAO.updateBook(book);		
	}

	public void deleteBookById(String id) {
		bookDAO.deleteBookById(id);		
	}

	public List<Book> findAllBooks() {
		return bookDAO.findAllBooks();
	}

}
