package src.com.freeit.applibrary.model;


import java.util.Scanner;

public class GenerateBook {

    private Scanner scanner = new Scanner(System.in);


    public Book bookGenerate() {
        Book book = new Book();

        System.out.println("Enter book title: ");
        String title = scanner.nextLine().trim();

        System.out.println("Enter author");
        String author = scanner.nextLine();

        GenreStyle genreStyle = getGenreStyle();

        System.out.println("Enter ISBN: ");
        String ISBN = scanner.nextLine().trim();

        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genreStyle);
        book.setISBN(ISBN);

        return book;
    }

    private GenreStyle getGenreStyle() {

        final String SHOW_GENRE =
                " 1   CLASSIC,\n" +
                        " 2  THRILLER,\n" +
                        " 3   FANTASY,\n" +
                        " 4   BIOGRAPHY,\n" +
                        " 5   SCIENCE_FICTION_STORY,\n" +
                        " 6   PLAY,\n" +
                        " 7   ADVENTURE,\n" +
                        " 8   ROMANCE\n";
        System.out.println(SHOW_GENRE + "Enter Genre using number :");
        int genreNumber = Integer.parseInt(scanner.nextLine().trim());
        GenreStyle name;
        switch (genreNumber) {
            case 1:
                name = GenreStyle.CLASSIC;
                break;
            case 2:
                name = GenreStyle.THRILLER;
                break;
            case 3:
                name = GenreStyle.FANTASY;
                break;
            case 4:
                name = GenreStyle.BIOGRAPHY;
                break;
            case 5:
                name = GenreStyle.SCIENCE_FICTION_STORY;
                break;
            case 6:
                name = GenreStyle.PLAY;
                break;
            case 7:
                name = GenreStyle.ADVENTURE;
                break;
            case 8:
                name = GenreStyle.ROMANCE;
                break;
            default:
                System.out.println("No genre will be used");
                name = GenreStyle.NO_GENRE;
                break;
        }
        return name;
    }
}
