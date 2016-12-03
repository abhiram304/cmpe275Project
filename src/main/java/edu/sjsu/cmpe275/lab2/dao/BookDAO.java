package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import edu.sjsu.cmpe275.lab2.model.Book;


public interface BookDAO {

		public abstract Book findBookById(String id);

		public abstract void saveBook(Book book);
		
		public abstract void updateBook(Book book);
		
		public abstract void deleteBookById(String id);
		
		public abstract List<Book> findAllBooks();

}
