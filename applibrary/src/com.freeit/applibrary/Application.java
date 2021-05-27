package applibrary;

import applibrary.dao.BookDao;
import applibrary.dao.BookDaoImpl;
import java.io.IOException;
import java.sql.SQLException;


import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        String option;

        do {

            System.out.println("MENU:");
            System.out.println("1 Show book catalog.");
            System.out.println("2 Add book.");
            System.out.println("3 Delete book.");
            System.out.println("4 Update book.");
            System.out.println("5 Quit.");
            System.out.println("Choose number option");
            option = scanner.nextLine();

            switch (option) {

                case "1":
                    library.getAllBooks();
                    break;
                case "2":
                    library.addBooks();
                    break;
                case "3":
                    library.deleteBooks();
                    break;
                case "4":
                    library.updateBooks();
                    break;
                case "5":
                    scanner.close();

            }
            while (!option.equals("5")) ;

        }
    }


}


