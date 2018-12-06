package com.elu.canoo.library.controllers;

import com.elu.canoo.library.exceptions.BookNotFoundException;
import com.elu.canoo.library.models.Book;
import com.elu.canoo.library.repositories.BookRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    @GetMapping("/books/{id}")
    public Book getBook (@PathVariable String id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book newBook, @PathVariable String id) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setAuthor(newBook.getAuthor());
                    book.setTitle(newBook.getTitle());
                    book.setPublicationDate(newBook.getPublicationDate());
                    return bookRepository.save(book);
                }).orElseGet(() -> {
                    newBook.setId(id);
                    return bookRepository.save(newBook);
                });
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable("id") String id) {
        bookRepository.deleteById(id);
    }

    @GetMapping("/books/search")
    public List<Book> query(@RequestParam("q") String query) {
        return bookRepository.findByTitleContaining(query);
    }
}
