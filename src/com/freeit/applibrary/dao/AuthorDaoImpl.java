package src.com.freeit.applibrary.dao;

import src.com.freeit.applibrary.model.Author;
import src.com.freeit.applibrary.DataSourceUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private DataSourceUtil dataSourceUtil = new DataSourceUtil();

    public List<Author> getAllAuthors() throws SQLException {

        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery
                ("select id, name from author");

        List<Author> authorsList = new ArrayList<>();

        while (resultSet.next()){
            Author author = new Author();
            author.setId(resultSet.getLong("id"));
            author.setName(resultSet.getString("name"));
            authorsList.add(author);
        }

        dataSourceUtil.closeConnection();
        return authorsList;
    }

    public long getAuthorId (String authorName) throws SQLException {

        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery
                (String.format
                        ("select id from `author` where name = '%s'", authorName));

        long authorId = -1;

        while (resultSet.next()) {
           authorId = resultSet.getLong("id");
        }
        dataSourceUtil.closeConnection();

        return authorId;
    }

    public void addAuthorToDatabase (String authorName) throws SQLException {
        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate
                (String.format
                        ("insert into `author` (name) value ('%s')", authorName));

        dataSourceUtil.closeConnection();
    }

    public void deleteAuthorFromDatabase (String authorName) throws SQLException {
        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate
                (String.format
                        ("delete from `author` where name='%s'", authorName));

        dataSourceUtil.closeConnection();
    }

    public void updateAuthorInDatabase (String authorName, String newAuthorName) throws SQLException {
        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate
                (String.format
                        ("update `author` set name = '%s' where name ='%s'", newAuthorName, authorName));

        dataSourceUtil.closeConnection();
    }
}
