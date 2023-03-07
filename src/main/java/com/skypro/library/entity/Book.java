package com.skypro.library.entity;

public class Book {

    private String nameBook;
    private String authorBook;
    private Integer yearBook;
    private String isbn;

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
