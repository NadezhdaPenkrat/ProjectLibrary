package src.com.freeit.applibrary.dao;

import src.com.freeit.applibrary.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    List<Book> getAllBooks() throws SQLException;

    Book getBookById(long bookId) throws SQLException;

    void addBooks (Book bookToAdd) throws SQLException;

    void deleteBooks (long bookId) throws SQLException;

    void updateBooks (Book bookToUpdate) throws SQLException;
}
