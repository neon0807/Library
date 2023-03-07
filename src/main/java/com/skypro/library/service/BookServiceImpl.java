package com.skypro.library.service;

import com.skypro.library.dao.BookDAO;
import com.skypro.library.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{

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
    public void update(String nameBook, String authorBook, Integer yearBook) {
        bookDAO.update(nameBook,authorBook,yearBook);
    }

    @Override
    @Transactional
    public void delete(String isbn) {
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
        return bookDAO.readByISBN(isbn);
    }


}
