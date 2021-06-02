package src.com.freeit.applibrary;

import src.com.freeit.applibrary.model.Book;
import src.com.freeit.applibrary.model.GenerateBook;
import src.com.freeit.applibrary.service.AuthorService;
import src.com.freeit.applibrary.service.BookService;
import src.com.freeit.applibrary.service.GenreService;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DbCommands {

    private final BookService bookService = new BookService();

    public void getAllBooks(){
        System.out.println("EVERY BOOK IN THE LIBRARY: ");
        bookService.fetchingAllBooks().forEach(System.out::println);
    }

    public void addBooks () {
        Book bookToAdd = new GenerateBook().bookGenerate();
        addBookToDatabase(bookToAdd);
    }

    public void addBookToDatabase (Book bookToAdd)
    {
        List<Book> books = bookService.fetchingAllBooks();

        if (checkTitle(bookToAdd.getTitle())){
            System.out.print(" book exists in the catalog  ");
            Book bookFromDatabase = books.stream()
                    .filter(element -> element.getTitle().equals(bookToAdd.getTitle()))
                    .findFirst()
                    .get();

            System.out.println(bookFromDatabase);
        } else {
            bookService.addingBookToDatabase(bookToAdd);
            System.out.println(" added.");
        }
    }

    public void deleteBooks (){
        Scanner scanner = new Scanner(System.in);

        long bookId = -1;

        System.out.println(" set book's id: ");

        try {
            bookId = Long.parseLong(scanner.nextLine().trim());
        }catch (NumberFormatException e) {
            System.out.println(" not a number id!");
        }

        if (checkID(bookId)) {
            bookService.deletingBookFromDatabaseById(bookId);
            System.out.println(" deleted book .");
        } else {
            System.out.println(" in the database with such ID  there is no book  .");
        }
    }

    public void updateBooks() {
        Scanner scanner = new Scanner(System.in);

        long bookId = -1;

        Book bookToUpdate;

        System.out.println(" set book's id: ");
        try {
            bookId = Long.parseLong(scanner.nextLine().trim());
        }catch (NumberFormatException e) {
            System.out.println(" not a number id!");
        }

        if (checkID(bookId)) {
            bookToUpdate = new GenerateBook().bookGenerate();
            bookToUpdate.setId(bookId);
            bookService.updatingBookInDatabaseWithId(bookToUpdate);
            System.out.println(" updated.");
        } else {
            System.out.println(" in the database with such ID  there is no book  .");
        }
    }

    public long getAuthorId (String authorName){
        AuthorService authorService = new AuthorService();
        long authorId = authorService.getAuthorId(authorName);

        if(authorId < 0) {
            authorService.addAuthorToDatabase(authorName);
            authorId = authorService.getAuthorId(authorName);
        }
        return authorId;
    }

    public long getGenreId (String genreName) {
        GenreService genreService = new GenreService();
        long genreId = genreService.getGenreId(genreName);

        if (genreId < 0) {
            genreService.addGenreToDatabase(genreName);
            genreId = genreService.getGenreId(genreName);
        }
        return genreId;
    }

    private boolean checkID(long bookId) {
        return bookService.fetchingAllBooks()
                .stream()
                .map(Book::getId)
                .collect(Collectors.toList())
                .contains(bookId);
    }

    private boolean checkTitle (String bookTitle){
        return bookService.fetchingAllBooks()
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList())
                .contains(bookTitle);

    }
}