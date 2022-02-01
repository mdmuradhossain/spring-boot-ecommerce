package io.murad.ecommerce.service;



import io.murad.ecommerce.model.Book;

import java.util.List;

public interface BookService {
	List<Book> findAll ();
	
	Book findOne(Long id);
	
	List<Book> findByCategory(String category);
	
	List<Book> blurrySearch(String title);

	void save(Book book);

	void removeOne(long parseLong);
}
