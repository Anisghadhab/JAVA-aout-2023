package com.anis.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anis.books.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();

	// this method finds books with descriptions containing the search string
//	List<Book> findByDescriptionContaining(String search);
//
//	// this method counts how many titles contain a certain string
//	Long countByTitleContaining(String search);
//
//	// this method deletes a book that starts with a specific title
//	Long deleteByTitleStartingWith(String search);
}
