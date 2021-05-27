package applibrary.dao;

import applibrary.DataSourceUtil;
import applibrary.model.Genre;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoImpl implements GenreDao {


    private DataSourceUtil dataSourceUtil = new DataSourceUtil();


    public List<Genre> getListOfGenres() throws SQLException {
        Connection connection = dataSourceUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement
                ("select id, name from genre");
        ResultSet resultSet = statement.executeQuery();

        List<Genre> genresList = new ArrayList<>();

        while(resultSet.next()){
            Genre genre = new Genre();
            genre.setId(resultSet.getLong("id"));
            genre.setName(resultSet.getString("name"));
            genresList.add(genre);
        }

        dataSourceUtil.closeConnection();
        return genresList;
    }


    public long getGenreId(String genreName) throws SQLException {
        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery
                (String.format
                        ("select id from `genre` where name = '%s'", genreName));

        long genreId = -1;

        while (resultSet.next()) {
           genreId = resultSet.getLong("id");
        }
        dataSourceUtil.closeConnection();

        return genreId;
    }


    public void addGenreToDatabase(String genreName) throws SQLException {
        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate
                (String.format
                        ("insert into `genre` (name) value ('%s')", genreName));

        dataSourceUtil.closeConnection();
    }


    public void deleteGenreFromDatabase (String genreName) throws SQLException {
        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate
                (String.format
                        ("delete from `genre` where name='%s'", genreName));

        dataSourceUtil.closeConnection();
    }


    public void updateGenreInDatabase (String genreName, String newGenreName) throws SQLException {
        Connection connection = dataSourceUtil.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate
                (String.format
                        ("update `genre` set name = '%s' where name ='%s'", newGenreName, genreName));

        dataSourceUtil.closeConnection();
    }
}

