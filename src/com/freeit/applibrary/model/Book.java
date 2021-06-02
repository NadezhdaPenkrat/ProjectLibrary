package src.com.freeit.applibrary.model;

import java.util.Objects;

public class Book {

    long id;
    String title;
    String author;
    GenreStyle genre;
    String ISBN;

    public Book() {
    }

    public Book(long id, String title, String author, GenreStyle genre, String ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ISBN = ISBN;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && genre == book.genre
                && Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, genre, ISBN);
    }

    @Override
    public String toString() {
        return "id: \n" + id +
                ", title: \"" + title +
                ", author:\n " + author +
                ", genre: \n " + genre +
                ", ISBN:\n " + ISBN;
    }
}
