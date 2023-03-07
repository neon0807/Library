package com.skypro.library.dao;


import com.skypro.library.entity.Book;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BookDAOImpl implements BookDAO{

    private Connection connection;
    @Override
    public void insert(Book book) {
        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO library (nameBook, authorBook, yearBook, isbn) VALUES ((?), (?), (?), (?))")) {
            statement.setString(1, book.getNameBook());
            statement.setString(2, book.getAuthorBook());
            statement.setInt(3, book.getYearBook());
            statement.setString(4, book.getIsbn());

            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String nameBook, String authorBook, Integer yearBook) {
        try(PreparedStatement statement = connection.prepareStatement(
                "UPDATE library SET nameBook=(?), authorBook=(?), yearBook=(?)")) {

            statement.setString(1, nameBook);
            statement.setString(2, authorBook);
            statement.setInt(3, yearBook);

            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String isbn) {
        try(PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM library WHERE isbn=(?)")) {

            statement.setString(1, isbn);
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Book> readAll() {
        List <Book> bookList = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM library")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String nameBook = resultSet.getString("nameBook");
                String authorBook = resultSet.getString("authorBook");
                int yearBook = Integer.parseInt(resultSet.getString("yearBook"));
                String isbn = resultSet.getString("isbn");

                bookList.add(new Book(nameBook, authorBook, yearBook, isbn));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }




    @Override
    public Book readByISBN(String isbn) {
        Book book = new Book();

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM book WHERE isbn EQUALS(?)")) {

            statement.setString(1, isbn);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                book.setIsbn(resultSet.getString("isbn"));
                book.setNameBook(resultSet.getString("nameBook"));
                book.setAuthorBook(resultSet.getString("authorName"));
                book.setYearBook(Integer.parseInt(resultSet.getString("yearBook")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
