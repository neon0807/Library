package com.skypro.library.service;

import com.skypro.library.entity.Book;

import java.util.List;

public interface BookService {
    void insert(Book book);

    void update(String nameBook, String authorBook, Integer yearBook, String isbn);

    void delete(String isbn);

    List<Book> readAll();

    Book readByISBN(String isbn);
}
