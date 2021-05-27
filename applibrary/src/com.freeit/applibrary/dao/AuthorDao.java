package applibrary.dao;

import applibrary.model.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {

    List<Author> getAllAuthors() throws SQLException;

    long getAuthorId (String authorName) throws SQLException;

    void addAuthorToDatabase (String authorName) throws SQLException;

    void deleteAuthorFromDatabase (String authorName) throws SQLException;

    void updateAuthorInDatabase (String authorName, String newAuthorName) throws SQLException;
}
