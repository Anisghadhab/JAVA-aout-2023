package com.anis.books.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.anis.books.models.Book;
import com.anis.books.services.BookService;

import jakarta.validation.Valid;

@Controller
public class ViewController {
	// import the bookService
	private final BookService bookService;
	public ViewController(BookService bookService) {
		this.bookService = bookService;
	}
	@GetMapping("/books")
	public String index(Model model) {
		// Grab all books from service
		
		List<Book> allBooks = bookService.allBooks();
		model.addAttribute("bookList",allBooks);
		return "books.jsp";
	}
	
	@GetMapping("/books/create")
	public String form(@ModelAttribute("book") Book book) {
		return "form.jsp";
	}
	@PostMapping("/books/create")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "form.jsp";
		} else
			bookService.createBook(book);
		return "redirect:/books";
	}
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	@PostMapping("/books/{id}")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else
			bookService.updateBook(book);
		return "redirect:/books";
	}
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("oneBook",book);
		return "oneBook.jsp";
	}
	@DeleteMapping("/books/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
}
