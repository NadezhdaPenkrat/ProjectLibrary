package src.com.freeit.applibrary.dao;

import src.com.freeit.applibrary.model.Genre;
import java.sql.SQLException;
import java.util.List;

public interface GenreDao {

    List<Genre> getListOfGenres() throws SQLException;

    long getGenreId(String genreName) throws SQLException;

    void addGenreToDatabase(String genreName) throws SQLException;

    void deleteGenreFromDatabase (String genreName) throws SQLException;

    void updateGenreInDatabase (String genreName, String newGenreName) throws SQLException;
}
