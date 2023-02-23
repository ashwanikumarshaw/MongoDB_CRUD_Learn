package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;

@RestController
public class BookController {

	@Autowired
	private BookRepo repo;

	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		repo.save(book);

		return "Added Successfully";
	}
	@PutMapping("/updateBook")
	public String updateBook(@RequestBody Book book) {
//		if id is same it will update the data
		repo.save(book);

		return "Update Successfully";
	}
	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {

		return repo.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repo.deleteById(id);

		return "Deleted Successfully";
	}

}
