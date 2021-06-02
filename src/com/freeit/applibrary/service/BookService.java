package src.com.freeit.applibrary.service;


import src.com.freeit.applibrary.dao.BookDao;
import src.com.freeit.applibrary.dao.BookDaoImpl;
import src.com.freeit.applibrary.model.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookDao bookDao = new BookDaoImpl();

    public List<Book> fetchingAllBooks() {
        List<Book> booksList = new ArrayList<>();

        try {
            booksList.addAll(bookDao.getAllBooks());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return booksList;
    }

    public void addingBookToDatabase(Book bookToAdd){
        try {
            bookDao.addBooks(bookToAdd);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletingBookFromDatabaseById(long bookid) {
        try {
            bookDao.deleteBooks(bookid);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatingBookInDatabaseWithId(Book bookToUpdate) {
        try {
            bookDao.updateBooks(bookToUpdate);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
