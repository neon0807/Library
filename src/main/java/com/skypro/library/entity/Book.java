package com.skypro.library.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@EntityScan
@Table(name = "library")
public class Book {

    @Id
    @Column("isbn")
    private String isbn;
    @Column("nameBook")
    private String nameBook;
    @Column("authorBook")
    private String authorBook;
    @Column("yearBook")
    private Integer yearBook;

    public Book() {
    }

    public Book(String nameBook, String authorBook, Integer yearBook, String isbn) {
        this.nameBook = nameBook;
        this.authorBook = authorBook;
        this.yearBook = yearBook;
        this.isbn = isbn;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public Integer getYearBook() {
        return yearBook;
    }

    public void setYearBook(Integer yearBook) {
        this.yearBook = yearBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
