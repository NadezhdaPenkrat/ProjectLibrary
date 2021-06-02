package src.com.freeit.applibrary.service;


import src.com.freeit.applibrary.dao.AuthorDao;
import src.com.freeit.applibrary.dao.AuthorDaoImpl;
import src.com.freeit.applibrary.model.Author;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorService {

    private AuthorDao authorDao = new AuthorDaoImpl();

    public List<Author> fetchingAllAuthors(){
        List<Author> authorsList = new ArrayList<>();

        try {
            authorsList.addAll(authorDao.getAllAuthors());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return authorsList;
    }

    public long getAuthorId(String authorName) {
        long authorId = -1;

        try {
            authorId = authorDao.getAuthorId(authorName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return authorId;
    }

    public void addAuthorToDatabase (String authorName){
        try {
            authorDao.addAuthorToDatabase(authorName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteAuthorFromDatabase (String authorName){
        try {
            authorDao.deleteAuthorFromDatabase(authorName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateAuthorInDatabase (String authorName, String newAuthorName){
        try {
            authorDao.updateAuthorInDatabase(authorName, newAuthorName);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
