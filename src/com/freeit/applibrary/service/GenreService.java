package src.com.freeit.applibrary.service;

import src.com.freeit.applibrary.dao.GenreDao;
import src.com.freeit.applibrary.dao.GenreDaoImpl;
import src.com.freeit.applibrary.model.Genre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreService {

    private GenreDao genreDao = new GenreDaoImpl();

    public List<Genre> fetchingAllGenres(){
        List<Genre>genresList = new ArrayList<>();

        try {
            genresList.addAll(genreDao.getListOfGenres());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return genresList;
    }

    public long getGenreId(String genreName) {
        long genreId = -1;

        try {
            genreId = genreDao.getGenreId(genreName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return genreId;
    }

    public void addGenreToDatabase (String genreName){
        try {
            genreDao.addGenreToDatabase(genreName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteGenreFromDatabase (String genreName){
        try {
            genreDao.deleteGenreFromDatabase(genreName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateGenreInDatabase (String genreName, String newGenreName){
        try {
            genreDao.updateGenreInDatabase(genreName, newGenreName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
