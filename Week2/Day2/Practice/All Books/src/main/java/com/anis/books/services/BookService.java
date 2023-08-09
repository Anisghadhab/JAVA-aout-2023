package com.anis.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anis.books.models.Book;
import com.anis.books.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
 // delete a book
 	public void deleteBook(Long id) {
 		bookRepository.deleteById(id);
 	}
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}


 	// update a book
 	public Book oldUpdateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
         Optional<Book> optionalBook = bookRepository.findById(id);

         if (optionalBook.isPresent()) {
             Book existingBook = optionalBook.get();

             // Update the fields with new data
             existingBook.setTitle(title);
             existingBook.setDescription(desc);
             existingBook.setLanguage(lang);
             existingBook.setNumberOfPages(numOfPages);

             // ... Update other fields as needed

             // Save the updated book back to the database using JpaRepository's save method
             return bookRepository.save(existingBook);
         } else {
             // Book with the provided ID not found
             return null;
         }
 	}


}