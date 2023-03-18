package com.skypro.library.service;

import com.skypro.library.dao.BookDAO;
import com.skypro.library.entity.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;
    public BookServiceImpl(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }


    @Override
    @Transactional
    public void insert(Book book) {
        bookDAO.insert(book);
    }

    @Override
    @Transactional
    public void update(String nameBook, String authorBook, Integer yearBook, String isbn) {
        if (!isValide(isbn) || nameBook == null || authorBook == null || yearBook <= 0){
            throw new RuntimeException();
        }
        bookDAO.update(nameBook,authorBook,yearBook, isbn);
    }

    @Override
    @Transactional
    public void delete(String isbn) {
        if (!isValide(isbn)){
            throw new RuntimeException();
        }
        bookDAO.delete(isbn);

    }

    @Override
    @Transactional
    public List<Book> readAll() {
        return bookDAO.readAll();
    }

    @Override
    @Transactional
    public Book readByISBN(String isbn) {
        if (!isvalide(isbn)){
            throw new RuntimeException();
        }
        return bookDAO.readByISBN(isbn);
    }



}
