package com.skypro.library.controller;

import com.skypro.library.entity.Book;
import com.skypro.library.service.BookService;
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

    @GetMapping("/employee")
    public List<Book> getEmployee() {
        return bookService.readAll();
    }

    @GetMapping("/book/{isbn}")
    public Book readByISBN(@PathVariable String isbn) {
        return bookService.readByISBN(isbn);
    }

    @PostMapping("/employee")
    public Book addBook(@RequestBody Book book) {
        bookService.insert(book);
        return book;

    }

    @PutMapping("/employee")
    public Book updateBook(@RequestBody Book book) {

        bookService.update(book.getNameBook(), book.getAuthorBook(), book.getYearBook());
        return book;

    }

    @DeleteMapping("/employee/{isbn}")
    public String deleteBook(@PathVariable String isbn) {

        bookService.delete(isbn);
        return "Employee with id = " + isbn + " was deleted";

    }
}
