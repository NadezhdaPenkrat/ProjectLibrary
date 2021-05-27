package applibrary.dao;

import applibrary.DataSourceUtil;
import applibrary.DatabaseOperations;
import applibrary.model.GenreStyle;
import applibrary.model.Book;

import applibrary.util.Parser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private final  DataSourceUtil dataSourceUtil = new DataSourceUtil();
    private final String baseSQLStatement = "select b.id, " +
            "b.title, a.name, g.name, b.ISBN from books b " +
            "left join author a on b.author_id = a.id left join genre g on b.genre_id = g.id";


    public List<Book> getAllBooks() throws SQLException {

        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(baseSQLStatement);

        return createBooks(resultSet, connection);
    }

    public Book getBookById(long bookId) throws SQLException {

        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery
                (baseSQLStatement + String.format(" where b.id=%d", bookId));

        return createBooks(resultSet, connection).get(0);
    }

    private List<Book> createBooks(ResultSet resultSet, Connection connection) throws SQLException {

        List<Book> bookList = new ArrayList<>();

        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getLong("b.id"));
            book.setTitle(resultSet.getString("b.title"));
            book.setAuthor(resultSet.getString("a.name"));
            book.setGenre(Genre.valueOf(resultSet.getString("g.name").toUpperCase()));
            book.setISBN(resultSet.getString("b.ISBN"));
            bookList.add(book);
        }

        dataSourceUtil.closeConnection();
        return bookList;
    }

    public void addBooks(Book bookToAdd) throws SQLException {
        Connection connection = dataSourceUtil.getConnection();
        PreparedStatement statement = connection
                .prepareStatement("insert into `books` (title, author_id, genre_id, ISBN) values (?, ?, ?, ?);");
        statement.setString(1, bookToAdd.getTitle());
        statement.setLong(2, new DatabaseOperations().getAuthorId(bookToAdd.getAuthor()));
        statement.setLong(3, new DatabaseOperations().getGenreId(new Parser()
                .parseGenreNameByGenreName(bookToAdd.getGenre())));
        statement.setString(4, bookToAdd.getISBN());

        statement.executeUpdate();

        dataSourceUtil.closeConnection();
    }

    public void deleteBooks(long bookId) throws SQLException {
        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate(String.format("delete from `books` where id=%d", bookId));

        dataSourceUtil.closeConnection();
    }

    public void updateBooks(Book bookToUpdate) throws SQLException {
            Connection connection = dataSourceUtil.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("update `books` set title = ?, author_id = ?, genre_id = ?, ISBN = ? where id = ?");
            statement.setString(1, bookToUpdate.getTitle());
            statement.setLong(2, new DatabaseOperations().getAuthorId
                    (bookToUpdate.getAuthor()));
            statement.setLong(3, new DatabaseOperations().getGenreId
                    (new Parser().parseGenreNameByGenreName(bookToUpdate.getGenre())));
            statement.setString(4, bookToUpdate.getISBN());
            statement.setLong(5, bookToUpdate.getId());

            statement.executeUpdate();

        dataSourceUtil.closeConnection();
    }
}
