package com.skypro.library.dao;


import com.skypro.library.entity.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class BookDAOImpl implements BookDAO{

    private final JdbcTemplate template;

    public BookDAOImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void insert(Book book) {
        template.update("SELECT INTO library VALUES(?,?,?,?)",
                book.getNameBook(), book.getAuthorBook(), book.getYearBook(), book.getIsbn());
    }

    @Override
    public void update(String nameBook, String authorBook, Integer yearBook, String isbn) {
        template.update("SELECT INTO library VALUES(?,?,?,?)",
                nameBook, authorBook, yearBook, isbn);
    }

    @Override
    public void delete(String isbn) {
        template.update("DELETE FROM * librarry WHERE isbn = ?");
    }

    @Override
    public List<Book> readAll() {
        List <Book> bookList = new ArrayList<>();
        return template.query("SELECT * FROM library",
                new BeanPropertyRowMapper(Book.class));
    }

    @Override
    public Book readByISBN(String isbn) {
        return template.query("SELECT * FROM library WHERE isbn == ?",
                new Object[]{isbn},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }
}
