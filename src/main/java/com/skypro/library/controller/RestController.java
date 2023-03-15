package com.skypro.library.controller;

import com.skypro.library.entity.Book;
import com.skypro.library.service.BookService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/skypro")
public class RestController {
    private BookService bookService;
    public RestController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/library")
    public List<Book> getBook() {
        return bookService.readAll();
    }

    @GetMapping("/library/{isbn}")
    public Book readByISBN(@PathVariable String isbn) {
        return bookService.readByISBN(isbn);
    }

    @PostMapping("/library")
    public Book addBook(@RequestBody Book book) {
        bookService.insert(book);
        return book;

    }

    @PutMapping("/library")
    public Book updateBook(@RequestBody Book book) {

        bookService.update(book.getNameBook(), book.getAuthorBook(), book.getYearBook(), book.getIsbn());
        return book;

    }

    @DeleteMapping("/library/{isbn}")
    public String deleteBook(@PathVariable String isbn) {

        bookService.delete(isbn);
        return "Book with isbn = " + isbn + " was deleted";

    }
}
